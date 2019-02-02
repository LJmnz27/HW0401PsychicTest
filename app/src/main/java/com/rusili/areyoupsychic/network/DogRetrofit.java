package com.rusili.areyoupsychic.network;

import android.support.annotation.NonNull;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DogRetrofit {
    private static final String BASE_URL_DOG_CEO = "https://dog.ceo";
    private static Retrofit retrofit = null;

    @NonNull
    public static Retrofit getInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL_DOG_CEO)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
