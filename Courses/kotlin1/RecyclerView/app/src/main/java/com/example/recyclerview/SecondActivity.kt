package com.example.recyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SecondActivity : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerViewAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        layoutManager = LinearLayoutManager(this)
        val recyclerView = findViewById<RecyclerView>(R.id.recycleView)
        recyclerView.layoutManager = layoutManager

        adapter = RecyclerViewAdapter()
        recyclerView.adapter = adapter

        // onItemClickListener
        adapter!!.setOnItemClickListener(object : RecyclerViewAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                Toast.makeText(this@SecondActivity, "Item $position", Toast.LENGTH_LONG).show()
            }
        })

    }
}
//https://www.youtube.com/watch?v=UCddGYMQJCo

// onItemClickListener https://www.youtube.com/watch?v=dB9JOsVx-yY