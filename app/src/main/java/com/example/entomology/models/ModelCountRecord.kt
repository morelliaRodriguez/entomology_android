package com.example.entomology.models

data class ModelCountRecord(
    val insectType:String,
    val geoLocation:String,
    val comment: String,
    var count: Int
)
fun setInsectType(modelInsect: ModelInsect){

}
fun setGeoLocation(modelGeoLocation: ModelGeoLocation){

}
fun addComment(comment: String){

}