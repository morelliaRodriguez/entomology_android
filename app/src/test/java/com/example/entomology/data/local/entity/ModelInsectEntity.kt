package com.example.entomology.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "insect")
data class ModelInsectEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") val id : Int,
    @ColumnInfo(name = "species_name") val name: String,
    @ColumnInfo(name = "url_photo") val urlPhoto : String,
    @ColumnInfo(name = "more_info_url") val moreInfoUrl : String
)
