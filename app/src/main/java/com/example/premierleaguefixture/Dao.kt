package com.example.premierleaguefixture

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {

    @Insert
    fun addMatch(matchDetails: MatchDetails)

    @Query("SELECT * FROM matchDetails")
    fun getAllMatches() : Flow<List<MatchDetails>>
}