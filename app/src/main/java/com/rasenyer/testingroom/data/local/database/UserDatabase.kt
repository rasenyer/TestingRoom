package com.rasenyer.testingroom.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rasenyer.testingroom.data.local.dao.UserDao
import com.rasenyer.testingroom.data.local.model.User

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

}