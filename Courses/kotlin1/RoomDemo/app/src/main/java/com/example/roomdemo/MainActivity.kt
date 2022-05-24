package com.example.roomdemo


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdemo.db.UserEntity
import com.google.android.material.divider.MaterialDividerItemDecoration.VERTICAL


class MainActivity : AppCompatActivity(), RecyclerViewAdapter.RowClickListener {

    lateinit var recyclerViewAdapter: RecyclerViewAdapter
    lateinit var viewModel: MainActivityViewModel
    lateinit var saveButton: Button
    lateinit var nameInput: TextView
    lateinit var emailInput: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameInput = findViewById<TextView>(R.id.nameInput)
        emailInput = findViewById<TextView>(R.id.emailInput)
        saveButton = findViewById<Button>(R.id.saveButton)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerViewAdapter = RecyclerViewAdapter(this)


        val divider = DividerItemDecoration(applicationContext, VERTICAL)
        recyclerView.addItemDecoration(divider)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getAllUserObservers().observe(this, Observer {
            recyclerViewAdapter.setListData(ArrayList(it))
            recyclerViewAdapter.notifyDataSetChanged()
        })
        saveButton.setOnClickListener {
            val name = nameInput.text.toString()
            val email = emailInput.text.toString()

            if (saveButton.text.equals("Save")) {
                val user = UserEntity(0, name, email)
                viewModel.insertUserInfo(user)
            } else {
                val user =
                    UserEntity(nameInput.getTag(nameInput.id).toString().toInt(), name, email)
                viewModel.updateUserInfo(user)
                saveButton.text = "Save"
                Log.d("TEST_OF_LOADING_DATA", "dgfhgh")
            }
            nameInput.text = ""
            emailInput.text = ""


        }

    }


    override fun onDeleteUserClickListener(user: UserEntity) {
        viewModel.deleteUserInfo(user)
    }

    override fun onItemClickListener(user: UserEntity) {
        nameInput.text = user.name
        emailInput.text = user.email
        nameInput.setTag(nameInput.id, user.id)
        saveButton.text = "Update"
    }
}
//https://www.youtube.com/watch?v=aK9tOipNm0o&t=0s
//https://www.youtube.com/watch?v=WHfOErTraTk - about warnings
//org.gradle.warning.mode=all - for searching warning
//org.gradle.warning.mode=fail - for searching warning