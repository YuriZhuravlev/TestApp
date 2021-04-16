package com.zhuravlev.leroy.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zhuravlev.leroy.model.Good
import com.zhuravlev.leroy.repository.Repository

class HomeViewModel : ViewModel() {
    companion object {
        var load = false
        private val _listGoods1 = MutableLiveData<List<Good>>()
        private val _listGoods2 = MutableLiveData<List<Good>>()
    }

    val listGoods1: LiveData<List<Good>> = _listGoods1
    val listGoods2: LiveData<List<Good>> = _listGoods2

    init {
        if (!load) {
            Repository.getList(20) {
                _listGoods1.postValue(it)
            }
            Repository.getList(15) {
                _listGoods2.postValue(it)
            }
            load = true
        }
    }
}