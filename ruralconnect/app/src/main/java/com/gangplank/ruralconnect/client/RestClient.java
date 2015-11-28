package com.gangplank.ruralconnect.client;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

import static com.gangplank.ruralconnect.util.Constants.BASE_URL;

public class RestClient {

    private static Retrofit retrofit;

    private static void createRestClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Retrofit getInstance() {
        if(retrofit == null) {
            createRestClient();
        }
        return retrofit;
    }
}
