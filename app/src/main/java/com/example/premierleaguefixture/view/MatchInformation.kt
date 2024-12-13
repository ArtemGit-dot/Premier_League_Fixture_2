package com.example.premierleaguefixture.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.example.premierleaguefixture.databinding.FragmentMatchInformationBinding
import com.example.premierleaguefixture.model.data.MatchDetails
import com.example.premierleaguefixture.viewmodel.MainFragmentViewModel

class MatchInformation : Fragment() {
    private lateinit var binding: FragmentMatchInformationBinding
    lateinit var mViewModel: MainFragmentViewModel
    lateinit var matchesList: List<MatchDetails>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMatchInformationBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var resultPosition: Int

        mViewModel = ViewModelProvider(
            this,
        )[MainFragmentViewModel::class.java]

        mViewModel.matches.observe(viewLifecycleOwner, Observer { matches ->
            matchesList = matches
        })

        mViewModel.position.observe(viewLifecycleOwner, Observer {result ->
            resultPosition = result
            binding.MatchNumber.text = "Match Number: ${matchesList[resultPosition].matchNumber}"
        })

           // binding.MatchNumber.text = "Match Number: ${matchesList[resultPosition].matchNumber}"
            //binding.RoundNumber.text = "Round Number: ${matchesList[result].roundNumber}"
            //binding.DateUtc.text = "Date Utc: ${matchesList[result].dateUtc}"
            //binding.Location.text = "Location: ${matchesList[result].location}"
            //binding.HomeTeam.text = "Home Team: ${matchesList[result].homeTeam}"
           // binding.AwayTeam.text = "Away Team: ${matchesList[result].awayTeam}"
            //binding.Group.text = "Group: ${matchesList[result].group}"
           // binding.HomeTeamScore.text = "Home Team Score: ${matchesList[result].homeTeamScore}"
           // binding.AwayTeamScore.text = "Away Team Score: ${matchesList[result].awayTeamScore}"

    }
}
