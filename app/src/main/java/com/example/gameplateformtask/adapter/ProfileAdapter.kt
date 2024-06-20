package com.example.gameplateformtask.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gameplateformtask.databinding.ItemPeopleToFollowBinding
import com.example.gameplateformtask.model.Profile

class ProfileAdapter(
    val context: Context,
    val profileList:MutableList<Profile>
):
    RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>(){

    class ProfileViewHolder(val binding: ItemPeopleToFollowBinding, context: Context):
        RecyclerView.ViewHolder(binding.root){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemPeopleToFollowBinding.inflate(layoutInflater, parent, false)

        return ProfileViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        val profile = profileList[position]
        holder.binding.ivProfilePic.setImageResource(profile.profilePic)
        holder.binding.tvUsername.text = profile.username
    }

    override fun getItemCount(): Int {
        return profileList.size
    }


}