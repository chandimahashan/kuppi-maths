package com.example.cuppimaths

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomePastPapersClickEnglishOrSinhalaFragment : Fragment() {
    private lateinit var adapter: HomePastpapersClickCardAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home_past_papers_click_english_or_sinhala, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        requireActivity().title = "Past papers"
        adapter = HomePastpapersClickCardAdapter()
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        return view
    }

}
