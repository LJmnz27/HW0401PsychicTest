package com.rusili.areyoupsychic.db.model;

import android.support.annotation.NonNull;

public class Guess {
    public static final String USER_KEY = "user";
    public static final String CORRECT_KEY = "correct";

    private String user;
    private boolean correct;

    public Guess(@NonNull String user,
                 boolean correct) {
        this.user = user;
        this.correct = correct;
    }

    @NonNull
    public String getUser() {
        return user;
    }

    public boolean isCorrect() {
        return correct;
    }
}
