package com.example.expandablerecyclerview.model

data class LanguageData(
    val title: String,
    val logo: Int,
    val message: String,
    var expandable: Boolean = false
)