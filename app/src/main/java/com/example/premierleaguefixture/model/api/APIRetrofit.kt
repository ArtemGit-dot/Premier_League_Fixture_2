package com.example.premierleaguefixture.model.api

import com.example.premierleaguefixture.model.data.MatchDetails
import retrofit2.Call
import retrofit2.http.GET

interface APIRetrofit {
    @GET("epl-2024")
 fun getMatches() : Call<List<MatchDetails>>
}