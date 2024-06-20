package com.example.gameplateformtask.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gameplateformtask.databinding.ItemTournamentBinding
import com.example.gameplateformtask.model.Tournaments

class TournamentsAdapter(
    val context: Context,
    val tournamentsList:MutableList<Tournaments>
):
    RecyclerView.Adapter<TournamentsAdapter.TournamentsViewHolder>(){
    var onItemClick: (() -> Unit)? = null
    class TournamentsViewHolder(val binding: ItemTournamentBinding, context: Context):
        RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TournamentsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemTournamentBinding.inflate(layoutInflater, parent, false)

        return TournamentsViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(holder: TournamentsViewHolder, position: Int) {
        val tournaments = tournamentsList[position]
        holder.binding.tvTournamentTitle.text = tournaments.title

        holder.binding.cvTournaments.setOnClickListener{
            onItemClick?.invoke()
        }
    }

    override fun getItemCount(): Int {
        return tournamentsList.size
    }


}