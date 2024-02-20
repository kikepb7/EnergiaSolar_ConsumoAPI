package com.enriquepalmadev.energiasolar_consumoapi.data

import com.enriquepalmadev.energiasolar_consumoapi.data.model.DtoResult
import com.enriquepalmadev.energiasolar_consumoapi.data.model.Panel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    @GET("paneles/mostrar")
    suspend fun panelsList(
//        @Query("token") token: String,
    ): List<Panel>

    @GET("paneles/resumen")
    suspend fun dtoList(
    ): List<DtoResult>
}

object RetrofitServiceFactory {

    fun makeRetrofitService(): RetrofitService =
        Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(RetrofitService::class.java)
}