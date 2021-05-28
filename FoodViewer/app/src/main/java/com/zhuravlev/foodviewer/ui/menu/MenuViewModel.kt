package com.zhuravlev.foodviewer.ui.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zhuravlev.foodviewer.repository.category.UseCaseCategories
import com.zhuravlev.foodviewer.repository.dish.UseCaseDishes
import com.zhuravlev.foodviewer.repository.location.UseCaseLocation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor() : ViewModel() {
    @Inject
    lateinit var useCaseDishes: UseCaseDishes
    @Inject
    lateinit var useCaseLocation: UseCaseLocation
    @Inject
    lateinit var useCaseCategories: UseCaseCategories

    private val _text = MutableLiveData<String>().apply {
        value = "This is menu Fragment"
    }
    val text: LiveData<String> = _text
}