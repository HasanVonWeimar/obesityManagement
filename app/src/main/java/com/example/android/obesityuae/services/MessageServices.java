package com.example.android.obesityuae.services;

import com.example.android.obesityuae.Person;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by shaheen on 9/22/2018.
 */

public interface MessageServices {
    @POST("Patients")
    Call<Person> createPatient(@Body Person patientID);
}
