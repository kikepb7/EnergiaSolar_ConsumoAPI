package com.enriquepalmadev.energiasolar_consumoapi.data.model

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
    val generationCapacity: Int,
    val image: String,
    val description: String
)

data class Profile(
    val id: Long,
    val name: String,
    val email: String,
    val image: String
)

data class Report(
    val content: String,
    val registrationDate: String,
    val serialReport: String,
    val user: Long? = null
)

data class ReportPOST(
    @SerializedName("serialReport")
    val serialReport: String,
    @SerializedName("registrationDate")
    val registrationDate: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("user")
    val user: Long? = null
)

data class ErrorResponse(
    val message: String
)