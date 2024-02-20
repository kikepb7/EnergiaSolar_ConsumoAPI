package com.enriquepalmadev.energiasolar_consumoapi.data.model

data class RemoteResult(
    val page: Int,
    val results: List<DtoResult>,
    val total_pages: Int,
    val total_results: Int
)

data class DtoResult(
    val model: String,
    val image: String,
    val nominalPower: Int,
    val price: Double
)

data class Panel(
    val id: Int,
    val brand: String,
    val model: String,
    val image: String,
    val price: Float,
    val nominalPower: Int
)