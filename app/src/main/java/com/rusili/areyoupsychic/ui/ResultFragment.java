package com.rusili.areyoupsychic.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.rusili.areyoupsychic.ChoiceNavigator;
import com.rusili.areyoupsychic.R;

public class ResultFragment extends Fragment {
    private ChoiceNavigator navigator;

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
    public void onAttach(Context context) {
        super.onAttach(context);
        navigator = (ChoiceNavigator) context;
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
        return inflater.inflate(R.layout.fragment_result, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setViews(view);
        setOnClickListeners(view);
    }

    private void setViews(@NonNull View view) {
        if (guess) {
            showCorrect(view);
        } else {
            showIncorrect(view);
        }
    }

    private void setOnClickListeners(@NonNull View view) {
        view.findViewById(R.id.fragment_result_try_again).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigator.reset();
            }
        });
    }

    private void showCorrect(@NonNull View view) {
        view.findViewById(R.id.fragment_result_text_correct).setVisibility(View.VISIBLE);
        view.findViewById(R.id.fragment_result_image_correct).setVisibility(View.VISIBLE);
    }

    private void showIncorrect(@NonNull View view) {
        view.findViewById(R.id.fragment_result_text_incorrect).setVisibility(View.VISIBLE);
        view.findViewById(R.id.fragment_result_image_incorrect).setVisibility(View.VISIBLE);
    }
}
