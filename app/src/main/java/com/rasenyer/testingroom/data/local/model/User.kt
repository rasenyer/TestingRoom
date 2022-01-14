package com.rasenyer.testingroom.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(

    @PrimaryKey val id: Int,
    val name: String?,
    val email: String?,
    val password: String,
    val phone: Int,
    val country: String?

)
