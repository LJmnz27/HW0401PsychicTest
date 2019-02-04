package com.rusili.areyoupsychic.db.model;

import android.support.annotation.NonNull;

public class Guess {
    public static final String USER_KEY = "user";
    public static final String CATEGORY_KEY = "category";
    public static final String CORRECT_KEY = "correct";

    private String user;
    private String category;
    private boolean correct;

    public Guess(@NonNull String user,
                 @NonNull String category,
                 boolean correct) {
        this.user = user;
        this.category = category;
        this.correct = correct;
    }

    @NonNull
    public String getUser() {
        return user;
    }

    @NonNull
    public String getCategory() {
        return category;
    }

    public boolean isCorrect() {
        return correct;
    }
}
