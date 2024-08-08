package com.example.premierleaguefixture.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.premierleaguefixture.model.database.MainDataBase
import com.example.premierleaguefixture.model.api.APIRepository
import com.example.premierleaguefixture.model.api.APIRepositoryImpl
import com.example.premierleaguefixture.model.data.MatchDetails

class MainFragmentViewModel() : ViewModel() {

    val matchRepository : APIRepository = APIRepositoryImpl()

    val matches: LiveData<List<MatchDetails>> = matchRepository.getMatchesAPI()
    val position = MutableLiveData<Int>()


    fun createDB(context: Context, matches: List<MatchDetails>){
        val db = MainDataBase.createDateBase(context)
Thread{
        for (i in matches.indices) {
            MainDataBase.getDataBase()?.matchDao()?.addMatch(matches[i])}
        }
    }
    }
