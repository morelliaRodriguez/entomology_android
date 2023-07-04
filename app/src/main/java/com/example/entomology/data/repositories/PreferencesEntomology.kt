package com.example.entomology.data.repositories

import android.content.Context
import com.example.entomology.domain.repositories.IEntomologyPreferences
import com.example.entomology.utils.Constants.EMPTY_STRING
import com.example.entomology.utils.Constants.SHARED_NAME
import com.example.entomology.utils.Constants.SHARED_USER_NAME
import com.example.entomology.utils.Constants.SHARES_PHOTO_URL
import javax.inject.Inject

class PreferencesEntomology @Inject constructor(
    context : Context
) : IEntomologyPreferences{

    private val sharedPreferences = context.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE)

    override fun saveEntomology(name: String, photoUrl: String){
        sharedPreferences.edit().putString(SHARED_USER_NAME, name).apply()
        sharedPreferences.edit().putString(SHARES_PHOTO_URL,photoUrl).apply()
    }
    override fun getEntomology(): ArrayList<String> {
        val user = arrayListOf<String>()
        user.add(sharedPreferences.getString(SHARED_USER_NAME, EMPTY_STRING).toString())
        user.add(sharedPreferences.getString(SHARES_PHOTO_URL, EMPTY_STRING).toString())
        return user
    }

}