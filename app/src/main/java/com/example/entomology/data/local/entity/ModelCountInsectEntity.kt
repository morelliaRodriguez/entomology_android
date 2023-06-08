package com.example.entomology.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "count_insect",
        foreignKeys = [
            ForeignKey(entity = ModelInsectEntity::class, parentColumns = ["id"], childColumns = ["id_insect"])
        ])
data class ModelCountInsectEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") val id : Int,
    @ColumnInfo(name = "id_insect") val idInsect: Int,
    @ColumnInfo(name = "comment") val comment : String,
    @ColumnInfo(name = "count") val count : Int,
    @ColumnInfo(name = "lat") val lat : Double,
    @ColumnInfo(name = "lng") val lng : Double
)
