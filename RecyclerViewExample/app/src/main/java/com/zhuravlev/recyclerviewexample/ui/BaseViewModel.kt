package com.zhuravlev.recyclerviewexample.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zhuravlev.recyclerviewexample.model.Data
import com.zhuravlev.recyclerviewexample.storage.getStorage

class BaseViewModel : ViewModel() {
    private val mData: MutableLiveData<Data> by lazy {
        MutableLiveData()
    }
    private val mError: MutableLiveData<Boolean> by lazy {
        MutableLiveData(false)
    }

    init {
        getStorage().getData(onSuccess = {
            showData(it)
        }, onFailed = {
            showError()
        }, onError = {
            showError()
        })
    }

    fun getData(): MutableLiveData<Data> {
        return mData
    }

    fun getError(): MutableLiveData<Boolean> {
        return mError
    }

    private fun showError() {
        mError.postValue(true)
    }

    private fun showData(data: Data) {
        mError.postValue(false)
        mData.postValue(data)
    }
}