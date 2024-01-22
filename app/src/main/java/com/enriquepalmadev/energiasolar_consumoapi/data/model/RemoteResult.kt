package com.enriquepalmadev.energiasolar_consumoapi.data.model

data class RemoteResult(
    val page: Int,
    val results: List<Panel>,
    val total_pages: Int,
    val total_results: Int
)

data class Panel(
    val id: Int,
    val brand: String,
    val price: Float,
    val nominalPower: Float
)