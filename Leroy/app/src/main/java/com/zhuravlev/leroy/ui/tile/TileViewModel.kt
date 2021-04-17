package com.zhuravlev.leroy.ui.tile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zhuravlev.leroy.model.Catalog

class TileViewModel : ViewModel() {
    private val _listCatalog = MutableLiveData<List<Catalog>>().apply {
        this.postValue(Catalog.getTile())
    }
    val listCatalog: LiveData<List<Catalog>> = _listCatalog
}