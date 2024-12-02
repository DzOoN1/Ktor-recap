package com.example.ktor_recap.customClasses

import kotlinx.serialization.Serializable

@Serializable
data class Note(
    var id: String,
    var title: String,
    var numberOfPages: String
)
