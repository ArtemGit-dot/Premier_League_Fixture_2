package com.example.premierleaguefixture

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.premierleaguefixture.databinding.FragmentMatchInformationBinding

class MatchInformation : Fragment() {
private lateinit var binding: FragmentMatchInformationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMatchInformationBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //binding.MatchNumber.text = "Match Number: ${matchDetails.matchNumber}"
        //binding.RoundNumber.text = "Round Number: ${matchDetails.roundNumber}"
        //binding.DateUtc.text = "Date Utc: ${matchDetails.dateUtc}"
        //binding.Location.text = "Location: ${matchDetails.location}"
        //binding.HomeTeam.text = "Home Team: ${matchDetails.homeTeam}"
        //binding.AwayTeam.text = "Away Team: ${matchDetails.awayTeam}"
        //binding.Group.text = "Group: ${matchDetails.group}"
        //binding.HomeTeamScore.text = "Home Team Score: ${matchDetails.homeTeamScore}"
        //binding.AwayTeamScore.text = "Away Team Score: ${matchDetails.awayTeamScore}"
        }
    }
