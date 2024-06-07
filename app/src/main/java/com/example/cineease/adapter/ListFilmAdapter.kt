package com.example.cineease.adapter

import com.example.cineease.data.Film
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cineease.DetailFilm
import com.example.cineease.R

class ListFilmAdapter(private val listFilm: ArrayList<Film>) :
    RecyclerView.Adapter<ListFilmAdapter.ListViewHolder>() {

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_film, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listFilm.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val film = listFilm[position]
        holder.tvName.text = film.judul
        holder.imgPhoto.setImageResource(film.poster)

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailFilm::class.java)
            intent.putExtra("EXTRA_FILM", film)
            it.context.startActivity(intent)
        }
    }
}