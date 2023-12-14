package com.example.temanbicara.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    suspend fun addUser(user: User)
//
//    @Query("SELECT * FROM user_table ORDER BY id ASC")
//    fun readAllData(): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(user: User):Long

//    @Query("SELECT * FROM user_table WHERE email = :email AND password = :password")
//    fun login(email: String, password: String): LiveData<User>

    @Query("SELECT * FROM user_table WHERE email = :email")
    fun getUserByEmail(email: String): LiveData<User>

}