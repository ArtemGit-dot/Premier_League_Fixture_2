package com.example.premierleaguefixture

import android.util.Log
import kotlin.math.absoluteValue

class FootballMatch (var Goals1 : Int = 0, var Goals2 : Int = 0) {

    fun setGoals (goals1: Int, goals2: Int){
        Goals1 = goals1
        Goals2 = goals2
    }

        fun main(){
            val matches = Array(10){
                FootballMatch((0..5).random(), (0..5).random())
            }

            for (match in matches) {
                Log.d("MyTag", "${match.Goals1}-${match.Goals2}")
            }

            val matchesWithoutDraw = matches.filter { it.Goals1!=it.Goals2 }.toTypedArray()

            Log.d("MyTag", "Матчи без ничьи:")

            for (match in matchesWithoutDraw) {
                Log.d("MyTag", "${match.Goals1}-${match.Goals2}")
            }

            val maxGoalDifferenceMatches = matchesWithoutDraw.associateBy {
                (it.Goals1 - it.Goals2).absoluteValue
            }.values.toSet()

            Log.d("MyTag", "Матчи с максимальным разрывом в голах:")

            maxGoalDifferenceMatches.forEach { match ->
                Log.d("MyTag", "${match.Goals1} - ${match.Goals2}")
            }
        }
}