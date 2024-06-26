package com.example.cineease.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cineease.R
import com.example.cineease.data.Drink
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DrinkAdapter(private val listDrink: ArrayList<Drink>) : RecyclerView.Adapter<DrinkAdapter.ListViewHolder>() {

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvPrice: TextView = itemView.findViewById(R.id.tv_item_price)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_drink, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val drink = listDrink[position]

        Glide.with(holder.itemView.context)
            .load(drink.image)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)

        holder.tvName.text = drink.name
        holder.tvPrice.text = drink.price
    }

    override fun getItemCount(): Int {
        return listDrink.size
    }
}