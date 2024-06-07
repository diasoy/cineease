package com.example.cineease.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cineease.R
import com.example.cineease.data.SnackItem

class ListSnackAdapter(private val listSnack: ArrayList<SnackItem>) : RecyclerView.Adapter<ListSnackAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: SnackItem)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_snack, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val snack = listSnack[position]
        holder.imgPhoto.setImageResource(snack.image)
        holder.tvName.text = snack.name
        holder.tvDescription.text = snack.description

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listSnack[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listSnack.size
}
