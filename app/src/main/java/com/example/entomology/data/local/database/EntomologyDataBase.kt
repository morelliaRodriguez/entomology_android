package com.example.entomology.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.entomology.data.local.dao.CountInsectDao
import com.example.entomology.data.local.dao.InsectDao
import com.example.entomology.data.local.entity.ModelCountInsectEntity
import com.example.entomology.data.local.entity.ModelInsectEntity

@Database(
    entities = [ModelInsectEntity::class, ModelCountInsectEntity::class],
    version = 1)
abstract class EntomologyDataBase : RoomDatabase(){

    abstract fun getInsectDao(): InsectDao
    abstract fun getCountInsectDao(): CountInsectDao

}