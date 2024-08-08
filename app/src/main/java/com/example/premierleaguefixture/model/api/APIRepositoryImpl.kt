package com.example.premierleaguefixture.model.api

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.premierleaguefixture.model.data.MatchDetails
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIRepositoryImpl : APIRepository {

    //Создание инстанции Retrofit
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://fixturedownload.com/feed/json/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    //Имплементация интерфейса APIRetrofit:
    private val apiRetrofit = retrofit.create(APIRetrofit::class.java)

        //Запрос на получение данных
     override fun getMatchesAPI(): LiveData<List<MatchDetails>> {

         val matchesLiveData = MutableLiveData<List<MatchDetails>>()

             apiRetrofit.getMatches().enqueue(object : Callback<List<MatchDetails>> {
                 override fun onResponse(
                     call: Call<List<MatchDetails>>,
                     response: Response<List<MatchDetails>>
                 ) {
                     if (response.isSuccessful) {
                         matchesLiveData.value = response.body()

                     } else {
                         Log.d("MyL", "Ошибка: ${response.errorBody()?.string()}")
                     }
                 }

                 override fun onFailure(call: Call<List<MatchDetails>>, t: Throwable) {
                     Log.d("MyL", "Ошибка сети: ${t.message}")
                 }
             })
         return matchesLiveData
         }
     }
