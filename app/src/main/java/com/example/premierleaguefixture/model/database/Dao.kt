package com.example.premierleaguefixture.model.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.premierleaguefixture.model.data.MatchDetails
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {

    @Insert
    fun addMatch(matchDetails: MatchDetails)

    @Query("SELECT * FROM matchDetails")
    fun getAllMatches() : Flow<List<MatchDetails>>

    @Query("DELETE FROM matchDetails")
    fun deleteAllMatches()
}