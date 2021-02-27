package com.zhuravlev.recyclerviewexample.storage.net

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val SERVER_URL = "https://rsttur.ru/api/"
private val retrofit = Retrofit.Builder()
        .baseUrl(SERVER_URL)
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .build()
private var api: TurApi? = null

fun getApiService(): TurApi {
    if (api == null) {
        api = retrofit.create(TurApi::class.java)
    }
    return api!!
}