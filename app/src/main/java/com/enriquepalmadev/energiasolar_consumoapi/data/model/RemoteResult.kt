package com.enriquepalmadev.energiasolar_consumoapi.data.model

import com.google.gson.annotations.SerializedName

data class RemoteResult(
    val page: Int,
    val results: List<DtoResult>,
    val total_pages: Int,
    val total_results: Int
)

data class DtoResult(
    val model: String? = null,
    val image: String? = null,
    val nominalPower: Int? = null,
    val price: Double? = null
)

data class UserResponse(
    val name: String? = null,
    val email: String? = null,
    val password: String? = null,
)

data class ProjectUser(
    val name: String? = null,
    val address: String? = null,
    val generationCapacity: Int? = null
)

data class Panel(
    val id: Int,
    val brand: String,
    val model: String,
    val image: String,
    val price: Float,
    val nominalPower: Int
)