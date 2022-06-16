package com.example.retcorapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TodosInstance {
    val baseUrl="https://jsonplaceholder.typicode.com/"
    private  var todosInterface:TodosInterface?=null
    fun getInsance():TodosInterface{
        if(todosInterface==null) {
            todosInterface = Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(TodosInterface::class.java)
        }
        return todosInterface!!
    }
}