package com.example.premierleaguefixture

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.premierleaguefixture.databinding.FragmentListOfMatchesBinding
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListOfMatches : Fragment() {
    private lateinit var binding: FragmentListOfMatchesBinding
    private lateinit var matchAdapter: MatchAdapter
    private lateinit var recyclerView: RecyclerView

    private var isGridLayoutManager = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListOfMatchesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnChangeView.setOnClickListener {
           isGridLayoutManager = !isGridLayoutManager
            if(isGridLayoutManager){
                recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
            } else {
                recyclerView.layoutManager = LinearLayoutManager(requireContext())
            }
        }

        val retrofit = Retrofit.Builder()
            .baseUrl("https://fixturedownload.com/feed/json/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val aPIRetrofit = retrofit.create(APIRetrofit::class.java)

        aPIRetrofit.getMatches().enqueue(object : Callback<List<MatchDetails>> {
            override fun onResponse(call: Call<List<MatchDetails>>, response: Response<List<MatchDetails>>) {
                if (response.isSuccessful) {
                    val matches = response.body()

                    matchAdapter = MatchAdapter()
                    matchAdapter.setItem(matches!!)

                    recyclerView = binding.recyclerView

                    recyclerView.layoutManager = LinearLayoutManager(requireContext())

                    recyclerView.adapter = matchAdapter
                } else {
                    Log.d("MyL","Ошибка: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<List<MatchDetails>>, t: Throwable) {
                Log.d("MyL","Ошибка сети: ${t.message}")
            }
        })

    }
    }