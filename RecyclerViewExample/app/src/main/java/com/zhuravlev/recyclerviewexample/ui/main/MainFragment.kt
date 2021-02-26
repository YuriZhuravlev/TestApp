package com.zhuravlev.recyclerviewexample.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.zhuravlev.recyclerviewexample.R
import com.zhuravlev.recyclerviewexample.model.Data
import com.zhuravlev.recyclerviewexample.ui.main.recycler_view.MainAdapter

class MainFragment : Fragment() {
    private lateinit var mRecyclerView: RecyclerView
    val mObserverData = Observer<Data>() {
        mRecyclerView.adapter = MainAdapter(it)
    }

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val v = inflater.inflate(R.layout.fragment_main, container, false)
        mRecyclerView = v.findViewById(R.id.main_recycler_view)
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getData().observe(viewLifecycleOwner, mObserverData)
    }

}