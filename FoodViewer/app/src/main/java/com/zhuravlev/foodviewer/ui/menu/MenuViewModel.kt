package com.zhuravlev.foodviewer.ui.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zhuravlev.foodviewer.model.Dish
import com.zhuravlev.foodviewer.repository.category.UseCaseCategories
import com.zhuravlev.foodviewer.repository.dish.UseCaseDishes
import com.zhuravlev.foodviewer.repository.location.UseCaseLocation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    val useCaseDishes: UseCaseDishes,
    val useCaseLocation: UseCaseLocation,
    val useCaseCategories: UseCaseCategories
) : ViewModel() {
    init {
        CoroutineScope(viewModelScope.coroutineContext + Dispatchers.IO).launch {
            _dishesList.emit(useCaseDishes.getDishes())
        }
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is menu Fragment"
    }
    val text: LiveData<String> = _text

    private val _dishesList = MutableStateFlow<List<Dish>>(
        listOf()
    )
    val dishesList: StateFlow<List<Dish>> = _dishesList
}