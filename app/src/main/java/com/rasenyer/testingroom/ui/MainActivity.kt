package com.rasenyer.testingroom.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.rasenyer.testingroom.R
import com.rasenyer.testingroom.data.local.database.UserDatabase

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userDatabase = Room.databaseBuilder(applicationContext, UserDatabase::class.java, "UserDatabase").build()

    }

}