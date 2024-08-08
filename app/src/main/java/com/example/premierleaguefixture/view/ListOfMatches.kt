package com.example.premierleaguefixture.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.premierleaguefixture.R
import com.example.premierleaguefixture.databinding.FragmentListOfMatchesBinding
import com.example.premierleaguefixture.model.data.MatchDetails
import com.example.premierleaguefixture.viewmodel.MainFragmentViewModel

class ListOfMatches : Fragment(), MatchAdapter.Listener {
    private lateinit var binding: FragmentListOfMatchesBinding
    private lateinit var matchAdapter: MatchAdapter
    private lateinit var recyclerView: RecyclerView

    private var isGridLayoutManager = false

    lateinit var matchesList: List<MatchDetails>

    lateinit var mViewModel : MainFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListOfMatchesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel = ViewModelProvider(
            this,
        )[MainFragmentViewModel :: class.java]

        binding.btnChangeView.setOnClickListener {
           isGridLayoutManager = !isGridLayoutManager
            if(isGridLayoutManager){
                recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
            } else {
                recyclerView.layoutManager = LinearLayoutManager(requireContext())
            }
        }

                        matchAdapter = MatchAdapter(this)

                        mViewModel.matches.observe(viewLifecycleOwner, Observer {matches ->
                            matchAdapter.setItem(matches)
                            mViewModel.createDB(requireContext(), matches)
                            matchesList = matches
                        })
                        recyclerView = binding.recyclerView

                        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        

                        recyclerView.adapter = matchAdapter

        }

    override fun onClick(position: Int) {
        Log.d("ada", "нажали на $position")
        (activity as MainActivity).navController.navigate(R.id.action_listOfMatches_to_matchInformation)

        mViewModel.position.value = position
    }

}
