package com.zhuravlev.foodviewer.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.zhuravlev.foodviewer.databinding.FragmentMenuBinding
import com.zhuravlev.foodviewer.ui.common.CustomToolbarFragment
import com.zhuravlev.foodviewer.ui.menu.dishes.DishAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MenuFragment : CustomToolbarFragment() {

    private val menuViewModel: MenuViewModel by viewModels()
    private var _binding: FragmentMenuBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)

        val menuDishes = _binding!!.menuDishes
        val dishAdapter = DishAdapter()
        menuDishes.adapter = dishAdapter

        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                menuViewModel.dishesList.collect {
                    dishAdapter.updateAdapter(it)
                }
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}