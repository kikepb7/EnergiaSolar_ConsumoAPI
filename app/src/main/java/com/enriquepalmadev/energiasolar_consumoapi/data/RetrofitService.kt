package com.enriquepalmadev.energiasolar_consumoapi.data

import com.enriquepalmadev.energiasolar_consumoapi.data.model.LoginCredentials
import com.enriquepalmadev.energiasolar_consumoapi.data.model.Profile
import com.enriquepalmadev.energiasolar_consumoapi.data.model.Project
import com.enriquepalmadev.energiasolar_consumoapi.data.model.Report
import com.enriquepalmadev.energiasolar_consumoapi.data.model.ReportPOST
import com.enriquepalmadev.energiasolar_consumoapi.data.model.UserResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RetrofitService {
    @POST("/login")
    suspend fun loginUser(@Body credentials: LoginCredentials): UserResponse

    @GET("/proyectos/{userId}")
    suspend fun getProjects(@Path("userId") userId: Long): List<Project>

    @GET("/usuario/{userId}")
    suspend fun getUser(@Path("userId") userId: Long): Profile

    @GET("/reportes/{userId}")
    suspend fun getReports(@Path("userId") userId: Long): List<Report>
    @DELETE("/reporte/{reportId}")
    suspend fun removeReport(@Path("reportId") reportId: Long)

    @GET("/proyecto/{projectId}")
    suspend fun getProject(@Path("projectId") projectId: Long): Project

    @POST("/reportes/registrar/{userId}")
    suspend fun createReport(@Path("userId") userId: Long, @Body report: ReportPOST): Response<ReportPOST>
}

object RetrofitServiceFactory {

    fun makeRetrofitService(): RetrofitService =
        Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(RetrofitService::class.java)
}