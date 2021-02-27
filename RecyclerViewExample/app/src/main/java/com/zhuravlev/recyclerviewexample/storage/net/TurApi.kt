package com.zhuravlev.recyclerviewexample.storage.net

import com.zhuravlev.recyclerviewexample.model.TurResponse
import retrofit2.Response
import retrofit2.http.GET

interface TurApi {
    @GET("base-app/map")
    suspend fun getList(): Response<TurResponse>
}