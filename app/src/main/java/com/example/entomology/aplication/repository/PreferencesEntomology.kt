package com.example.entomology.aplication.repository

import android.content.Context

class PreferencesEntomology (val context: Context){

    val SHARED_NAME = "More"
    val SHARED_USER_NAME = "Morellia"
    val SHARES_PHOTO_URL = ""

    val sharedPreferences = context.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE)

    fun saveName(name: String){
        sharedPreferences.edit().putString(SHARED_USER_NAME, name).apply()
    }

    fun savePhotoUrl(photoUrl: String){
        sharedPreferences.edit().putString(SHARES_PHOTO_URL,photoUrl).apply()
    }
    fun getName(): String{
        return sharedPreferences.getString(SHARED_USER_NAME, "")!!
    }
    fun getPhotoUrl(): String{
        return sharedPreferences.getString(SHARES_PHOTO_URL,"")!!
    }

}