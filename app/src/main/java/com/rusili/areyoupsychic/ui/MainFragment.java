package com.rusili.areyoupsychic.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

import com.rusili.areyoupsychic.ChoiceNavigator;
import com.rusili.areyoupsychic.R;

public class MainFragment extends Fragment {
    private ChoiceNavigator navigator;

    @NonNull
    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        navigator = (ChoiceNavigator) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final Spinner breedSpinner = view.findViewById(R.id.fragment_main_spinner);
        final Button submitButton = view.findViewById(R.id.fragment_main_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String selectedBreed = String.valueOf(breedSpinner.getSelectedItem());

                navigator.toChoiceFragment(selectedBreed);
            }
        });
    }
}
