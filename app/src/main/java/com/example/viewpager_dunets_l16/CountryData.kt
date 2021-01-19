package com.example.viewpager_dunets_l16

class CountryData {

    companion object {
        val countries = listOf(
            Country("Ukraine", "Kyiv", 41_703_000, 603_548.00),
            Country("USA", "Washington, D.C.", 328_239_523, 9_833_520.00),
            Country("Japan", "Tokyo", 125_710_000,337_975.00),
            Country("Uganda", "Kampala", 42_729_036, 241_038.00)
        )
    }
}

data class Country(
    val name: String,
    val capital: String,
    val population: Int,
    val area: Double
)