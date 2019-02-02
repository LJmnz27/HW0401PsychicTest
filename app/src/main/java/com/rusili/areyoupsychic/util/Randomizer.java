package com.rusili.areyoupsychic.util;

import android.support.annotation.NonNull;

import com.rusili.areyoupsychic.ui.ChoiceFragment;

import java.util.Arrays;
import java.util.Random;

public class Randomizer {
    private final Random randomizer = new Random();

    public int getCorrectChoice(int numOfChoices) {
        return randomizer.nextInt(numOfChoices - 1);
    }

    @NonNull
    public String[] getFourChoices(@NonNull String[] allUrls,
                                   int numOfChoices) {
        final String[] fourUrls = new String[numOfChoices];

        for (int i = 0; i < numOfChoices; i++) {
            final int index = randomizer.nextInt(allUrls.length - 1);
            fourUrls[i] = allUrls[index];
        }

        return fourUrls;
    }
}
