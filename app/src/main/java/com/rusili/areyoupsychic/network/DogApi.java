package com.rusili.areyoupsychic.network;

import com.rusili.areyoupsychic.network.model.DogResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Example:
 * https://dog.ceo/api/breed/corgi/images
 */
public interface DogApi {
    String SPECIFIC_BREED_IMAGES = "api/breed/{breed}/images";

    @GET(SPECIFIC_BREED_IMAGES)
    Call<DogResponse> getBreedImages(@Path("breed") final String breed);
}
