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
import com.rusili.areyoupsychic.util.Randomizer;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ResultFragment extends Fragment {
    private static final String TAG = ResultFragment.class.getSimpleName();
    private static final String BUNDLE_TAG = "resultFragmentBundle";

    private boolean guess;

    @NonNull
    public static ResultFragment newInstance(boolean guess) {
        final ResultFragment result = new ResultFragment();

        final Bundle bundle = new Bundle();
        bundle.putBoolean(BUNDLE_TAG, guess);

        result.setArguments(bundle);
        return result;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() == null || !getArguments().containsKey(BUNDLE_TAG)) {
            Toast.makeText(getContext(), R.string.error_oops, Toast.LENGTH_SHORT).show();
            return;
        }

        guess = getArguments().getBoolean(BUNDLE_TAG);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_choice, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
