package com.example.gameplateformtask.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gameplateformtask.databinding.ItemGameBinding
import com.example.gameplateformtask.model.Games

class GamesAdapter(
    val context: Context,
    val gamesList:MutableList<Games>
):
    RecyclerView.Adapter<GamesAdapter.GamesViewHolder>(){
    var onItemClick: (() -> Unit)? = null
    class GamesViewHolder(val binding: ItemGameBinding, context: Context):
        RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemGameBinding.inflate(layoutInflater, parent, false)

        return GamesViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(holder: GamesViewHolder, position: Int) {
        val games = gamesList[position]
        holder.binding.ivGameImage.setImageResource(games.ImageResId)
        holder.binding.tvGameName.text = games.title
        holder.binding.cvGames.setOnClickListener{
            onItemClick?.invoke()
        }
    }

    override fun getItemCount(): Int {
        return gamesList.size
    }


}