package com.zhuravlev.leroy.ui.lists

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zhuravlev.leroy.repository.Categories

class ListsViewModel : ViewModel() {

    private val _data = MutableLiveData<Categories>().apply {
        this.postValue(Categories())
    }

    val data: LiveData<Categories> = _data
}