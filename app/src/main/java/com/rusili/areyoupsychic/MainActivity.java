package com.rusili.areyoupsychic;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rusili.areyoupsychic.ui.ChoiceFragment;
import com.rusili.areyoupsychic.ui.MainFragment;
import com.rusili.areyoupsychic.ui.ResultFragment;

public class MainActivity extends AppCompatActivity implements ChoiceNavigator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reset();
    }

    @Override
    public void toChoiceFragment(@NonNull String selectedBreed) {
        final Fragment choiceFragment = ChoiceFragment.newInstance(selectedBreed);
        inflateFragment(choiceFragment);
    }

    @Override
    public void toResultFragment(boolean guess) {
        final Fragment resultFragment = ResultFragment.newInstance(guess);
        inflateFragment(resultFragment);
    }

    @Override
    public void reset() {
        final Fragment mainFragment = MainFragment.newInstance();
        inflateFragment(mainFragment);
    }

    private void inflateFragment(@NonNull Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_main_fragment_container, fragment)
                .commit();
    }
}
