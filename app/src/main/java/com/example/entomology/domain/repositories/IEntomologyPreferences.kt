package com.example.entomology.domain.repositories

interface IEntomologyPreferences {

    fun saveEntomology(name: String, photoUrl: String)

    fun getEntomology() : ArrayList<String>
}