package com.example.proy_final_moviles_2021

import android.app.Application
import com.example.proy_final_moviles_2021.database.DatabaseManager

open class MyAplication: Application() {
    override fun onCreate(){
        DatabaseManager.instance.initializeDb(applicationContext)
        super.onCreate()
    }
}