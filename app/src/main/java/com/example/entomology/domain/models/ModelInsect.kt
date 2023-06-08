package com.example.entomology.domain.models

import com.example.entomology.data.local.entity.ModelInsectEntity

data class ModelInsect(
    val id:Int = 0,
    val speciesName:String = "",
    val urlPhoto: String = "",
    val moreInfoUrl: String?
    )
fun ModelInsectEntity.toDomainModelInsect() = ModelInsect(id = id, speciesName = name,
    urlPhoto = urlPhoto, moreInfoUrl = moreInfoUrl)
