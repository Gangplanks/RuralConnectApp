package com.gangplank.ruralconnect.service;

import com.gangplank.ruralconnect.api.response.SchemeFilterResponse;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.Headers;
import retrofit.http.POST;


public interface SchemeService {

    @FormUrlEncoded
    @POST("schemes/filter")
    Call<List<SchemeFilterResponse>> getFilteredSchemes(@Field("beneficiaries") String beneficiaries, @Field("age_eligible") String ageEligible,
                                    @Field("income_eligible") String incomeEligible, @Field("community_eligible") String communityEligible);
    
}