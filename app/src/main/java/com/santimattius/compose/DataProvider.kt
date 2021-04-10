package com.santimattius.compose

object DataProvider {

    val programmers = (1..10).map {
        Programmer(
            id = it,
            name = "Santiago Mattiauda",
            languages = "Kotlin, Swift, Dart"
        )
    }
}

data class Programmer(
    val id: Int,
    val name: String,
    val languages: String
)