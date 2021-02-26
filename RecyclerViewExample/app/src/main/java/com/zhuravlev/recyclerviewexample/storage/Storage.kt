package com.zhuravlev.recyclerviewexample.storage

import com.zhuravlev.recyclerviewexample.model.Data
import com.zhuravlev.recyclerviewexample.storage.net.getApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

private var storage: Storage? = null

fun getStorage(): Storage {
    if (storage == null) {
        storage = Storage()
    }
    return storage!!
}

class Storage {
    private val mApiService = getApiService()

    // TODO add room
    fun getResponse(onSuccess: (Data) -> Unit, onFailed: () -> Unit, onError: () -> Unit = {}) {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response = mApiService.getList()
                if (response.isSuccessful && response.body() != null && response.body()!!.data != null) {
                    MainScope().launch { onSuccess(response.body()!!.data!!) }
                } else {
                    MainScope().launch { onFailed() }
                }
            } catch (e: Exception) {
                MainScope().launch { onError() }
                print(e.printStackTrace())
            }
        }
    }
}