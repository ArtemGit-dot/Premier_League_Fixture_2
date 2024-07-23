package com.example.premierleaguefixture

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.time.LocalDate

class MatchesAPI {
    private suspend fun fetchData(): List<MatchDetails>{
        delay(1000L)
        return listOf(
        //    MatchDetails(1, 1, "LocalDate.now()", "Brentford Community Stadium", "Brentford","Arsenal", null, 2, 0),
        //    MatchDetails(2, 2, "LocalDate.now()", "Brentford Community Stadium", "Brentford","Arsenal", null, 3,4),
          //  MatchDetails(3, 4, "LocalDate.now()", "Brentford Community Stadium", "Brentford","Arsenal", null, 3, 5),
        )
    }

    fun getData(): Flow<List<MatchDetails>> {
        return flow{
            emit (fetchData())
        }

    }
}