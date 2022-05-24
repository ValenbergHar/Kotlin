package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter() : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    private var titles = arrayOf(
        "Ch. 1",
        "Ch. 2",
        "Ch. 3",
        "Ch. 4",
        "Ch. 5",
        "Ch. 6",
        "Ch. 7",
        "Ch. 8",
        "Ch. 9",
        "Ch. 10",
        "Ch. 11",
    )
    private var details = arrayOf(
        "Ch. 1",
        "Ch. 2",
        "Ch. 3",
        "Ch. 4",
        "Ch. 5",
        "Ch. 6",
        "Ch. 7",
        "Ch. 8",
        "Ch. 9",
        "Ch. 10",
        "Ch. 11",
    )
    private var images = arrayOf(
        R.drawable.iii,
        R.drawable.iii,
        R.drawable.iii,
        R.drawable.iii,
        R.drawable.iii,
        R.drawable.iii,
        R.drawable.iii,
        R.drawable.iii,
        R.drawable.iii,
        R.drawable.iii,
        R.drawable.iii
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {
        holder.itemTitle.text = titles[position]
        holder.itemDetail.text = details[position]
        holder.itemImage.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return titles.size
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detail)
        }

    }

}