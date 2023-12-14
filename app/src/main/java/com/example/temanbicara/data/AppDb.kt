package com.example.temanbicara.data

import android.app.Application
import androidx.room.Room

class AppDb: Application() {
    companion object{
        lateinit var database: UserDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, UserDatabase::class.java, "my-database").build()
    }
}