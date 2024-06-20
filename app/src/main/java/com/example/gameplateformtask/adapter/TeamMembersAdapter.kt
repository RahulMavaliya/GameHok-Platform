package com.example.gameplateformtask.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gameplateformtask.R
import com.example.gameplateformtask.model.TeamMember

class TeamMembersAdapter(private val teamMembers: List<TeamMember>) : RecyclerView.Adapter<TeamMembersAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val memberNameTextView: TextView = itemView.findViewById(R.id.memberNameTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_team_member, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val member = teamMembers[position]
        val memberDetails = "${position + 1}. ${member.name}"
        holder.memberNameTextView.text = memberDetails
    }


    override fun getItemCount(): Int {
        return teamMembers.size
    }
}


