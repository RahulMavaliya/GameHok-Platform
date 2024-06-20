package com.example.gameplateformtask.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.gameplateformtask.R
import com.example.gameplateformtask.adapter.TeamMembersAdapter
import com.example.gameplateformtask.databinding.FragmentGamesBinding
import com.example.gameplateformtask.model.TeamMember
import com.google.android.material.textfield.TextInputEditText


class GamesFragment : Fragment() {
    private var _binding: FragmentGamesBinding? = null
    private val binding get() = _binding!!

    private val teamMembersList = mutableListOf<TeamMember>()
    private val teamMembersAdapter = TeamMembersAdapter(teamMembersList)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGamesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Load GIF into the ImageView using Glide
        Glide.with(this)
            .asGif()
            .load("https://media.giphy.com/media/v1.Y2lkPTc5MGI3NjExYmtuYjBqNDBmdGhpeTZieHA2ZGJtNW56N3ljYW9mMW5teHpwa3FxbiZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/2xnExL5vkIJC8vLw5y/giphy.gif") // Replace with your actual GIF resource or URL
            .into(binding.gameBannerImage)

        // Set up RecyclerView
        binding.teamMembersRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = teamMembersAdapter
        }

        // Initialize addMemberButton and memberNameEditText
        val addMemberButton = binding.addMemberButton
        val memberNameEditText = binding.memberNameEditText

        // When a new member is added, add it to the list and notify adapter
        addMemberButton.setOnClickListener {
            val memberName = memberNameEditText.text.toString()
            if (memberName.isNotEmpty() && teamMembersList.size < 5) {
                val newMember = TeamMember((teamMembersList.size + 1), memberName)
                teamMembersList.add(newMember)
                teamMembersAdapter.notifyDataSetChanged()
                // Clear EditText after adding member
                memberNameEditText.text = null

                // Set background color of the CardView
                binding.teamMembersCard.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.card_background))

            } else {
                // Show a message that maximum team members reached
                Toast.makeText(requireContext(), "Maximum team members reached (5)", Toast.LENGTH_SHORT).show()
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}