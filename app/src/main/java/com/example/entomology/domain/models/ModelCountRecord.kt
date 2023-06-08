package com.example.entomology.domain.models

import com.example.entomology.data.local.entity.ModelCountInsectEntity


data class ModelCountRecord(
    val id :Int,
    val idInsectType: Int,
    val comment: String,
    var count: Int,
    var lat: Double,
    var lng: Double
)

fun ModelCountInsectEntity.toDomainModelCountInsect() = ModelCountRecord(id = id, idInsectType = idInsect,
    comment = comment, count = count, lat = lat, lng = lng)