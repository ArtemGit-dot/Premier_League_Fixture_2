package com.example.premierleaguefixture.model.api

import androidx.lifecycle.LiveData
import com.example.premierleaguefixture.model.data.MatchDetails

interface APIRepository {

    fun getMatchesAPI(): LiveData<List<MatchDetails>>
}