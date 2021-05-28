package com.zhuravlev.foodviewer.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.widget.AppCompatSpinner
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.zhuravlev.foodviewer.R
import com.zhuravlev.foodviewer.databinding.FragmentMenuBinding
import com.zhuravlev.foodviewer.ui.common.CustomToolbarFragment
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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        spinner = _binding!!.root.findViewById(R.id.location_spinner)

        val menuDishes = _binding!!.menuDishes
        val dishAdapter = DishAdapter()
        menuDishes.adapter = dishAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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
        launchTask {
            menuViewModel.dishesList.collect {
                dishAdapter.updateAdapter(it)
            }
        }

        launchTask {
            menuViewModel.locationList.collect {
                spinner.adapter = locationAdapter(requireContext(), it)
            }
        }

        return binding.root
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