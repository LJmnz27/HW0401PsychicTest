package com.rusili.areyoupsychic.network.model;

import android.support.annotation.NonNull;

public class DogResponse {
    private String[] message;

    @NonNull
    public String[] getBreedUrls() {
        return message;
    }
}
