package com.emazdoor.mycomposable.model

import java.io.Serializable

data class HomeModel(
    val type: String,
    val id: String,
    val title: String,
    val artist: String,
    val safeForWork: Boolean,
    val thumbnailUrl: String,
    val amount: String,
    val currency: String
) : Serializable