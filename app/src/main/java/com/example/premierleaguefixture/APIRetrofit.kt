package com.example.premierleaguefixture

import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET

interface APIRetrofit {
    @GET("epl-2024")
 fun getMatches() : Call<List<MatchDetails>>
}