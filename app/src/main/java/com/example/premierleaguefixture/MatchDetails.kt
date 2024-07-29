package com.example.premierleaguefixture

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.time.LocalDate
import java.util.Date

@Entity(tableName = "matchDetails")
data class MatchDetails(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @SerializedName("MatchNumber")
    val matchNumber : Int,
    @SerializedName("RoundNumber")
    val roundNumber : Int,
    @SerializedName("DateUtc")
    val dateUtc: String,
    @SerializedName("Location")
    val location : String,
    @SerializedName("HomeTeam")
    val homeTeam : String,
    @SerializedName("AwayTeam")
    val awayTeam : String,
    @SerializedName("Group")
    val group : String?,
    @SerializedName("HomeTeamScore")
    val homeTeamScore : Int?,
    @SerializedName("AwayTeamScore")
    val awayTeamScore : Int?
)
