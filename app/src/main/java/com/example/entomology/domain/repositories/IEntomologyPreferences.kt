package com.example.entomology.domain.repositories

interface IEntomologyPreferences {

    fun saveEntomology(name: String, photoUrl: String) : Boolean

    fun getEntomology() : ArrayList<String>
}