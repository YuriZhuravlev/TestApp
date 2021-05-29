package com.zhuravlev.foodviewer.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.appcompat.widget.AppCompatSpinner
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zhuravlev.foodviewer.R
import com.zhuravlev.foodviewer.databinding.FragmentMenuBinding
import com.zhuravlev.foodviewer.model.Category
import com.zhuravlev.foodviewer.ui.common.CustomToolbarFragment
import com.zhuravlev.foodviewer.ui.menu.banner.BannerAdapter
import com.zhuravlev.foodviewer.ui.menu.category.CategoryAdapter
import com.zhuravlev.foodviewer.ui.menu.dishes.DishAdapter
import com.zhuravlev.foodviewer.ui.menu.spinner.locationAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MenuFragment : CustomToolbarFragment() {

    private val menuViewModel: MenuViewModel by viewModels()
    private var _binding: FragmentMenuBinding? = null
    private lateinit var spinner: AppCompatSpinner

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val spinnerListener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(
            parent: AdapterView<*>?,
            view: View?,
            position: Int,
            id: Long
        ) {
            menuViewModel.selectedLocation(position)
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)

        locationInit()
        menuInit()
        bannerInit()

        return binding.root
    }

    private fun bannerInit() {
        val adapter = BannerAdapter()
        val recycler = _binding!!.menuBanner
        recycler.adapter = adapter

        launchTask {
            menuViewModel.bannerList.collect {
                it?.let {
                    adapter.updateAdapter(it)
                }
            }
        }
    }

    private fun menuInit() {
        val categoryRecycler = _binding!!.menuCategory
        val dishRecycler = _binding!!.menuDishes
        val categoryAdapter = CategoryAdapter()
        val dishAdapter = DishAdapter()

        categoryRecycler.adapter = categoryAdapter
        dishRecycler.adapter = dishAdapter

        // Установка взаимодействия между категориями и текущим элементом списка меню TODO надо будет вынести хотя бы в ViewModel
        var currentCategory = Category.PIZZA

        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        dishRecycler.layoutManager = layoutManager
        dishRecycler.addOnScrollListener(object: RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                currentCategory = dishAdapter.getCategory(layoutManager.findFirstVisibleItemPosition())
                categoryAdapter.setSelectCategory(currentCategory)
                super.onScrollStateChanged(recyclerView, newState)
            }
        })
        launchTask {
            categoryAdapter.selectedFlow.collect {
                it?.let {
                    if (it != currentCategory) {
                        layoutManager.scrollToPositionWithOffset(dishAdapter.getPosition(it) , 0)
                    }
                }
            }
        }
        // /////////////////////

        launchTask {
            menuViewModel.dishesList.collect {
                dishAdapter.updateAdapter(it)
            }
        }
        launchTask {
            menuViewModel.categoryList.collect {
                categoryAdapter.updateAdapter(it)
            }
        }
    }

    private fun locationInit() {
        spinner = _binding!!.root.findViewById(R.id.location_spinner)

        launchTask {
            menuViewModel.locationList.collect {
                if (!it.isNullOrEmpty()) {
                    spinner.onItemSelectedListener = null
                    spinner.adapter = locationAdapter(requireContext(), it)
                    var select = 0
                    for (i: Int in 0..(it.lastIndex)) {
                        if (it[i].selected) {
                            select = i
                            break
                        }
                    }
                    spinner.setSelection(select)
                    spinner.onItemSelectedListener = spinnerListener
                }
            }
        }
    }

    private fun launchTask(task: suspend () -> Unit) {
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                task()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}