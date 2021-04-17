package com.zhuravlev.leroy.ui.lists

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zhuravlev.leroy.repository.Categories
import com.zhuravlev.leroy.repository.Repository

class ListsViewModel : ViewModel() {

    private val _data = MutableLiveData<Categories>()

    private var _category: String? = null
    val data: LiveData<Categories> = _data

    fun setCategory(category: String) {
        _category = category
        _data.apply {
            this.postValue(Repository.getCategoriesByName(category))
        }
    }
}