package com.enriquepalmadev.energiasolar_consumoapi.data

import com.enriquepalmadev.energiasolar_consumoapi.data.model.DtoResult
import com.enriquepalmadev.energiasolar_consumoapi.data.model.Panel
import com.enriquepalmadev.energiasolar_consumoapi.data.model.ProjectUser
import com.enriquepalmadev.energiasolar_consumoapi.data.model.User
import com.enriquepalmadev.energiasolar_consumoapi.data.model.UserResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RetrofitService {

    @FormUrlEncoded
    @POST("/login")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<UserResponse>

    @GET("paneles/mostrar")
    suspend fun panelsList(
//        @Query("token") token: String,0
    ): List<Panel>

    @GET("paneles/resumen")
    suspend fun dtoList(
    ): List<DtoResult>

    @GET("proyectos/2")
    suspend fun projectsUserList(
    ): List<ProjectUser>

    @GET("usuario/{id}")
    suspend fun obtainUser(
        @Path("id") id: Long
    ): Response<User>
}

object RetrofitServiceFactory {

    fun makeRetrofitService(): RetrofitService =
        Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(RetrofitService::class.java)
}