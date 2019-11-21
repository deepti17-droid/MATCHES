package com.deepti.matches.network

import com.deepti.matches.model.CandidateList
import retrofit2.Call
import retrofit2.http.GET

interface BackEndApi {

    @GET("?results=10")
    fun candidateList(): Call<CandidateList>
}

