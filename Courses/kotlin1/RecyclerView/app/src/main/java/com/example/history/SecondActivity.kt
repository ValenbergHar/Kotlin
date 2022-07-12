package com.example.history

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.history.firebase.ItemPart
import com.google.firebase.database.*

class SecondActivity : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerViewAdapter? = null

    private lateinit var dbRef: DatabaseReference
    private lateinit var itemPartList: ArrayList<ItemPart>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        layoutManager = LinearLayoutManager(this)
        val recyclerView = findViewById<RecyclerView>(R.id.recycleView)
        recyclerView.layoutManager = layoutManager


        recyclerView.adapter = adapter

        itemPartList = arrayListOf()
        getItemPartData()

        // onItemClickListener
        adapter!!.setOnItemClickListener(object : RecyclerViewAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                Toast.makeText(this@SecondActivity, "Item $position", Toast.LENGTH_LONG).show()
            }
        })

    }

    private fun getItemPartData() {
        dbRef = FirebaseDatabase.getInstance().getReference("polack")
        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (itemSnapshot in snapshot.children) {
                        val item = itemSnapshot.getValue(ItemPart::class.java)
                        itemPartList.add(item!!)
                    }
                    adapter = RecyclerViewAdapter(itemPartList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}
//https://www.youtube.com/watch?v=UCddGYMQJCo

// onItemClickListener https://www.youtube.com/watch?v=dB9JOsVx-yY