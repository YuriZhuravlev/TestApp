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
import com.zhuravlev.recyclerviewexample.ui.BaseViewModel
import com.zhuravlev.recyclerviewexample.ui.main.recycler_view.MainAdapter

class MainFragment : Fragment() {
    private lateinit var viewModel: BaseViewModel
    private lateinit var mRecyclerView: RecyclerView
    val mObserverData = Observer<Data>() {
        mRecyclerView.adapter = MainAdapter(it)
    }

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        activity!!.title = getString(R.string.category)
        val v = inflater.inflate(R.layout.fragment_base, container, false)
        mRecyclerView = v.findViewById(R.id.base_recycler_view)
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = activity?.run {
            ViewModelProvider(this)[BaseViewModel::class.java]
        } ?: throw Exception("Invalid Activity")
        viewModel.getData().observe(viewLifecycleOwner, mObserverData)
    }

}