package com.example.entomology.aplication.repository

import android.app.Application

class EntomologyApplication : Application() {

    companion object{
        lateinit var sharedPreferences: PreferencesEntomology
    }

    override fun onCreate() {
        super.onCreate()
        sharedPreferences = PreferencesEntomology(applicationContext)
    }
}