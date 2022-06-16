package com.example.retcorapi

import retrofit2.Response
import retrofit2.http.GET

interface TodosInterface {
    @GET("todos")
    suspend fun getData() : Response<Todos>
}