package com.rasenyer.testingroom.data.local.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.rasenyer.testingroom.data.local.database.UserDatabase
import com.rasenyer.testingroom.data.local.model.User
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class UserDaoTest {

    private lateinit var userDao: UserDao
    private lateinit var userDatabase: UserDatabase

    @Before
    fun createDatabase() {

        val context = ApplicationProvider.getApplicationContext<Context>()
        userDatabase = Room.inMemoryDatabaseBuilder(context, UserDatabase::class.java).build()
        userDao = userDatabase.userDao()

    }

    @After
    @Throws(IOException::class)
    fun closeDatabase() {

        userDatabase.close()

    }

    @Test
    @Throws(Exception::class)
    fun insertUser() {

        val user = User(id = 1, name = "Jorge", email = "rasenyer@gmail.com", password = "abc456", phone = 123456789, country = "Ecuador")
        userDao.insertUser(user)

        val getAllUsers = userDao.getAllUsers()
        assertThat(getAllUsers).contains(user)

    }

    @Test
    @Throws(Exception::class)
    fun updateUser() {

        val user = User(id = 1, name = "Jorge", email = "rasenyer@gmail.com", password = "abc456", phone = 123456789, country = "Ecuador")
        userDao.insertUser(user)

        val userUpdated = User(id = 1, name = "Jorge Sanaguaray", email = "rasenyer@gmail.com", password = "abc456", phone = 123456789, country = "Ecuador")
        userDao.updateUser(userUpdated)

        assertThat(user).isNotEqualTo(userUpdated)

    }

    @Test
    @Throws(Exception::class)
    fun deleteUser() {

        val user = User(id = 1, name = "Jorge", email = "rasenyer@gmail.com", password = "abc456", phone = 123456789, country = "Ecuador")
        userDao.insertUser(user)
        userDao.deleteUser(user)

        val getAllUsers = userDao.getAllUsers()
        assertThat(getAllUsers).doesNotContain(user)

    }

    @Test
    @Throws(Exception::class)
    fun deleteAllUsers() {

        val user1 = User(id = 1, name = "Darwin", email = "darwin@gmail.com", password = "abc456", phone = 123456789, country = "Ecuador")
        userDao.insertUser(user1)

        val user2 = User(id = 2, name = "Jorge", email = "rasenyer@gmail.com", password = "abc456", phone = 123456789, country = "Ecuador")
        userDao.insertUser(user2)

        val user3 = User(id = 3, name = "Fabian", email = "fabian@gmail.com", password = "abc456", phone = 123456789, country = "Ecuador")
        userDao.insertUser(user3)

        userDao.deleteAllUsers()

        val getAllUsers = userDao.getAllUsers()
        assertThat(getAllUsers).isEmpty()

    }

    @Test
    @Throws(Exception::class)
    fun getAllUsers() {

        val user1 = User(id = 1, name = "Darwin", email = "darwin@gmail.com", password = "abc456", phone = 123456789, country = "Ecuador")
        userDao.insertUser(user1)

        val user2 = User(id = 2, name = "Jorge", email = "rasenyer@gmail.com", password = "abc456", phone = 123456789, country = "Ecuador")
        userDao.insertUser(user2)

        val user3 = User(id = 3, name = "Fabian", email = "fabian@gmail.com", password = "abc456", phone = 123456789, country = "Ecuador")
        userDao.insertUser(user3)

        val getAllUsers = userDao.getAllUsers()
        assertThat(getAllUsers).isNotEmpty()

    }

    @Test
    @Throws(Exception::class)
    fun searchByName() {

        val user1 = User(id = 1, name = "Darwin", email = "darwin@gmail.com", password = "abc456", phone = 123456789, country = "Ecuador")
        userDao.insertUser(user1)

        val user2 = User(id = 2, name = "Jorge", email = "rasenyer@gmail.com", password = "abc456", phone = 123456789, country = "Ecuador")
        userDao.insertUser(user2)

        val user3 = User(id = 3, name = "Fabian", email = "fabian@gmail.com", password = "abc456", phone = 123456789, country = "Ecuador")
        userDao.insertUser(user3)

        val searchByName = userDao.searchByName(name = "Darwin")
        assertThat(searchByName).isNotEmpty()

    }

}