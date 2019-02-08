package com.rusili.areyoupsychic;

import com.rusili.areyoupsychic.db.model.Guess;
import com.rusili.areyoupsychic.util.GuessCalculator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GuessCalculatorTest {

    @Test
    public void GivenListOfGuessesSize5_WhencalculateGuessHistoryIsCalled_ThenReturnCorrectPercentage() {
        // Given
        final String user = "user";
        final GuessCalculator testSubject = new GuessCalculator();
        final List<Guess> guessList = new ArrayList<>(Arrays.asList(
                new Guess(user, true),
                new Guess(user, true),
                new Guess(user, false),
                new Guess(user, false),
                new Guess(user, true)
        ));

        // When
        final double percent = testSubject.getPercentCorrect(guessList);

        // Then
        assertEquals(percent, 60.0, 0.001);
    }

    @Test
    public void GivenEmptyListOfGuesses_WhencalculateGuessHistoryIsCalled_ThenReturnCorrectPercentage() {
        // Given
        final String user = "user";
        final GuessCalculator testSubject = new GuessCalculator();
        final List<Guess> guessList = new ArrayList<>();

        // When
        final double percent = testSubject.getPercentCorrect(guessList);

        // Then
        assertEquals(percent, 0, 0.001);
    }
}
