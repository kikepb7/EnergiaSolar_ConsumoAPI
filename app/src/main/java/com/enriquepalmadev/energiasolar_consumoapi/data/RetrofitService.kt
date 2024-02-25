package com.enriquepalmadev.energiasolar_consumoapi.data

import com.enriquepalmadev.energiasolar_consumoapi.data.model.LoginCredentials
import com.enriquepalmadev.energiasolar_consumoapi.data.model.Project
import com.enriquepalmadev.energiasolar_consumoapi.data.model.UserResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RetrofitService {

    @POST("/login")
    suspend fun loginUser(@Body credentials: LoginCredentials): UserResponse

    @GET("proyectos/{userId}")
    suspend fun getProjects(@Path("userId") userId: Long): List<Project>

/*




    @GET("paneles/mostrar")
    suspend fun panelsList(
//        @Query("token") token: String,0
    ): List<Panel>

    @GET("paneles/resumen")
    suspend fun dtoList(
    ): List<DtoResult>

    *//*@GET("usuario/{id}")
    suspend fun obtainUser(
        @Path("id") id: Long
    ): Response<User>*/

}

object RetrofitServiceFactory {

    fun makeRetrofitService(): RetrofitService =
        Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(RetrofitService::class.java)
}