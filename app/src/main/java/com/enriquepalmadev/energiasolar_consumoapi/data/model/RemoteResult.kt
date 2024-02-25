package com.enriquepalmadev.energiasolar_consumoapi.data.model

import androidx.navigation.NavHostController
import com.google.gson.annotations.SerializedName


data class LoginCredentials(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String
)

data class UserResponse(
    @SerializedName("id") val id: String?,
    @SerializedName("error") val error: String?
)

data class Project(
    val id: Long,
    val name: String,
    val address: String,
    val generationCapacity: Int
)

data class ErrorResponse(
    val message: String
)






/*data class RemoteResult(
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

data class ProjectUser(
    val name: NavHostController,
    val address: String,
    val generationCapacity: Int
)

data class Panel(
    val id: Int,
    val brand: String,
    val model: String,
    val image: String,
    val price: Float,
    val nominalPower: Int
)*/
