package com.rusili.areyoupsychic.util;

import android.support.annotation.NonNull;

import com.rusili.areyoupsychic.db.model.Guess;

import java.util.List;

public class GuessCalculator {
    private static final int ONE_HUNDRED = 100;

    public double getPercentCorrect(@NonNull final List<Guess> guessList) {
        double correctGuesses = 0.0;
        double totalGuesses = guessList.size();

        // First time playing. No guesses saved yet.
        if (totalGuesses == 0){
            return 0;
        }

        for (int i = 0; i < totalGuesses; i++) {
            if (guessList.get(i).isCorrect()) {
                correctGuesses++;
            }
        }

        return (correctGuesses / totalGuesses) * ONE_HUNDRED;
    }
}
