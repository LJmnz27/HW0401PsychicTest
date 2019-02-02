package com.rusili.areyoupsychic.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.rusili.areyoupsychic.R;
import com.rusili.areyoupsychic.network.DogApi;
import com.rusili.areyoupsychic.network.DogRetrofit;
import com.rusili.areyoupsychic.network.model.DogResponse;
import com.squareup.picasso.Picasso;

import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ChoiceFragment extends Fragment {
    private static final String TAG = ChoiceFragment.class.getSimpleName();
    private static final String BUNDLE_TAG = "choiceFragmentBundle";

    private final ImageView[] imageViews = new ImageView[4];

    @NonNull
    public static ChoiceFragment newInstance(@NonNull String selectedBreed) {
        final ChoiceFragment choiceFragment = new ChoiceFragment();

        final Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_TAG, selectedBreed);

        choiceFragment.setArguments(bundle);
        return choiceFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() == null || !getArguments().containsKey(BUNDLE_TAG)) {
            Toast.makeText(getContext(), R.string.error_oops, Toast.LENGTH_SHORT).show();
            return;
        }

        final Retrofit retrofit = DogRetrofit.getInstance();
        final DogApi api = retrofit.create(DogApi.class);

        final String breed = getArguments().getString(BUNDLE_TAG);
        Log.d(BUNDLE_TAG, breed);
        api.getBreedImages(breed).enqueue(new Callback<DogResponse>() {
            @Override
            public void onResponse(Call<DogResponse> call, Response<DogResponse> response) {
                handleResponse(response);
            }

            @Override
            public void onFailure(Call<DogResponse> call, Throwable t) {
                Log.e(TAG, t.getMessage());
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_choice, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imageViews[0] = view.findViewById(R.id.fragment_choice_image_1);
        imageViews[1] = view.findViewById(R.id.fragment_choice_image_2);
        imageViews[2] = view.findViewById(R.id.fragment_choice_image_3);
        imageViews[3] = view.findViewById(R.id.fragment_choice_image_4);
    }

    private void handleResponse(@NonNull Response<DogResponse> response) {
        if (response.body() != null) {
            final DogResponse dogUrls = response.body();
            final String[] breedUrls = Arrays.copyOfRange(dogUrls.getBreedUrls(), 0, 4);

            displayDogs(breedUrls);
        }
    }

    private void displayDogs(@NonNull String[] breedUrls) {
        for (int i = 0; i < 4; i++) {
            Picasso.get().load(breedUrls[i])
                    .fit().centerCrop()
                    .error(R.drawable.ic_error_outline_black_24dp)
                    .into(imageViews[i]);
        }
    }
}
