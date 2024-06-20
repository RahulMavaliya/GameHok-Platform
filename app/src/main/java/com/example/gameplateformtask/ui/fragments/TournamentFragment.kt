package com.example.gameplateformtask.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.gameplateformtask.R
import com.example.gameplateformtask.adapter.TournamentsAdapter
import com.example.gameplateformtask.databinding.FragmentTournamentDetailsBinding
import com.example.gameplateformtask.model.Tournaments
import com.google.android.material.tabs.TabLayoutMediator


class TournamentDetailsFragment : Fragment() {
    private var _binding: FragmentTournamentDetailsBinding? = null
    private val binding
        get() = _binding!!

    private lateinit var tournamentsAdapter: TournamentsAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTournamentDetailsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewPager.adapter = ScreenSlidePagerAdapter(this)


        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Overview"
                1 -> "Players"
                2 -> "Rules"
                3 -> "Standings"
                else -> null
            }
        }.attach()

        val tournamentsList = mutableListOf(
            Tournaments("PUBG Tournament By Red Bull"),
            Tournaments("PUBG Tournament By Red Bull"),
            Tournaments("PUBG Tournament By Red Bull"),
        )

        tournamentsAdapter = TournamentsAdapter(requireContext(),tournamentsList)
        val adapter = tournamentsAdapter
        binding.rvTournaments.setHasFixedSize(true)
        binding.rvTournaments.adapter = adapter
        binding.rvTournaments.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

    }

    private inner class ScreenSlidePagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> OverviewFragment()
                // Here we will add other sections like Players Rules Standings
                else -> OverviewFragment()
            }
        }

        override fun getItemCount(): Int = 4        // Kyonki total 4 hn
    }

}