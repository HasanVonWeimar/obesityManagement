package com.example.android.obesityuae.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shaheen on 9/22/2018.
 */

public class ServiceBuilder {
    //192.168.1.101
    //192.168.1.102
    //192.168.43.165
    private static final String URL = "Http://192.168.43.165:9000/";

    private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create());
    private static Retrofit retrofit = builder.build();

    public static <S> S buildService(Class <S> serviceType){
        return retrofit.create(serviceType);
    }
}
