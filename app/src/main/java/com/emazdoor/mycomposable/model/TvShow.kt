package com.emazdoor.mycomposable.model

import java.io.Serializable

data class TvShow(
    val id: Int,
    val name: String,
    val year: Int,
    val rating : Double,
    val imageId : String,
    val overview : String
) : Serializable