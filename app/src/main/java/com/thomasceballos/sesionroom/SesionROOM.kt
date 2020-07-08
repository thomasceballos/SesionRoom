package com.thomasceballos.sesionroom

import android.app.Application
import androidx.room.Room
import com.thomasceballos.sesionroom.model.DeudorDataBase

class SesionROOM : Application() {

    companion object{
        lateinit var database: DeudorDataBase
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            this,
            DeudorDataBase::class.java,
            "misdeudores_db"
        ).allowMainThreadQueries()
            .build()
    }
}