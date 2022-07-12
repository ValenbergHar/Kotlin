package com.example.history

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.history.firebase.ItemPart

class RecyclerViewAdapter(private val itemList: ArrayList<ItemPart>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    //onItemClickListener
    private  var currentItemPos: Int =0
    private lateinit var mListener: onItemClickListener



    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }


    // onItemClickListener

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v, mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentItem = itemList[position]
        holder.itemTitle.text = currentItem.itemTitle
        holder.itemDate.text = currentItem.itemDate
        holder.itemDetail.text = currentItem.itemDetail
        holder.itemImage.setImageResource(images[position])

    }

    override fun getItemCount(): Int {
        return itemList.size
    }


    inner class ViewHolder(itemView: View, listener: onItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemDate: TextView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemDate = itemView.findViewById(R.id.itemDate)
            itemDetail = itemView.findViewById(R.id.itemDetail)

            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}