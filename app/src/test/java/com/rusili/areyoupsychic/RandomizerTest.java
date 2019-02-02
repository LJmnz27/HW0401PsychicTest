package com.rusili.areyoupsychic;

import com.rusili.areyoupsychic.util.Randomizer;

import org.junit.Test;

public class RandomizerTest {

    // TODO: finish tests
    @Test
    public void test(){
        Randomizer randomizer = new Randomizer();
        int numOfChoices = 4;

        String[] testUrls = new String[]{"hi", "hi2", "hi3", "hi4", "hi5"};
        randomizer.getFourChoices(testUrls, numOfChoices);
    }
}
