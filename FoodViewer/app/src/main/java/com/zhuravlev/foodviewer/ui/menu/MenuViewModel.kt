package com.zhuravlev.foodviewer.ui.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zhuravlev.foodviewer.model.Banner
import com.zhuravlev.foodviewer.model.Category
import com.zhuravlev.foodviewer.model.Dish
import com.zhuravlev.foodviewer.model.Location
import com.zhuravlev.foodviewer.repository.category.UseCaseCategories
import com.zhuravlev.foodviewer.repository.category.getCategories
import com.zhuravlev.foodviewer.repository.dish.UseCaseDishes
import com.zhuravlev.foodviewer.repository.location.UseCaseLocation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    val useCaseDishes: UseCaseDishes,
    val useCaseLocation: UseCaseLocation,
    val useCaseCategories: UseCaseCategories
) : ViewModel() {

    private val _dishesList = MutableStateFlow<List<Dish>>(
        listOf()
    )
    val dishesList: StateFlow<List<Dish>> = _dishesList

    private val _locationList = MutableStateFlow<List<Location>>(
        listOf()
    )
    val locationList: StateFlow<List<Location>> = _locationList
    private val _categoryList = MutableStateFlow<List<Category>>(
        listOf()
    )
    val categoryList: StateFlow<List<Category>> = _categoryList

    // TODO
    private val _bannerList = MutableStateFlow<List<Banner>>(
        listOf()
    )
    val bannerList: StateFlow<List<Banner>> = _bannerList

    init {
        updateDishes()

        backgroundSingleTask {
            useCaseLocation.getAllLocations()?.let {
                _locationList.emit(it)
            }
        }

        // TODO Banner
//        backgroundTask {
//            useCaseDishes.getDishes()?.let {
//                _dishesList.emit(it)
//            }
//        }

        backgroundSingleTask {
            _dishesList.collect {
                it?.let {
                    _categoryList.emit(it.getCategories())
                }
            }
        }
    }

    private fun backgroundSingleTask(task: suspend () -> Unit) =
        viewModelScope.launch(Dispatchers.IO) { task() }


    private fun updateDishes() {
        backgroundSingleTask {
            useCaseDishes.getDishes()?.let {
                _dishesList.emit(it)
            }
        }
    }

    fun selectedLocation(position: Int) {
        backgroundSingleTask {
            if (useCaseLocation.setLocation(locationList.value[position])) {
                updateDishes()
            }
        }
    }

}