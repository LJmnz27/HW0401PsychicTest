package com.rusili.areyoupsychic.db.model;

import android.support.annotation.NonNull;

public class Guess {
    private String category;
    private boolean correct;

    public Guess(@NonNull String category,
                 boolean correct) {
        this.category = category;
        this.correct = correct;
    }

    @NonNull
    public String getCategory() {
        return category;
    }

    public boolean getCorrect() {
        return correct;
    }
}
