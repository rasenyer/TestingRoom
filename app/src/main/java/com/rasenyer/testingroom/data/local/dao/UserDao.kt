package com.rasenyer.testingroom.data.local.dao

import androidx.room.*
import com.rasenyer.testingroom.data.local.model.User

@Dao
interface UserDao {

    @Insert
    fun insertUser(user: User)

    @Update
    fun updateUser(user: User)

    @Delete
    fun deleteUser(user: User)

    @Query("DELETE FROM user_table")
    fun deleteAllUsers()

    @Query("SELECT * FROM user_table")
    fun getAllUsers(): List<User>

    @Query("SELECT * FROM user_table WHERE name LIKE :name")
    fun searchByName(name: String?): List<User>

}