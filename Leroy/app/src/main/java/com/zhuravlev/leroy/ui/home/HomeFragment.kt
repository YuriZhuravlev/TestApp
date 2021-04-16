package com.zhuravlev.leroy.ui.home

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.zhuravlev.leroy.MainActivity
import com.zhuravlev.leroy.R
import com.zhuravlev.leroy.ui.home.goods.GoodsAdapter

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onAttach(activity: Activity) {
        (activity as MainActivity).switchToolbar(true)
        super.onAttach(activity)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val items1: RecyclerView = root.findViewById(R.id.recycler_items1)
        val items2: RecyclerView = root.findViewById(R.id.recycler_items2)
        homeViewModel.listGoods1.observe(viewLifecycleOwner, Observer {
            items1.adapter = GoodsAdapter(it)
        })
        homeViewModel.listGoods2.observe(viewLifecycleOwner, Observer {
            items2.adapter = GoodsAdapter(it)
        })
        return root
    }
}