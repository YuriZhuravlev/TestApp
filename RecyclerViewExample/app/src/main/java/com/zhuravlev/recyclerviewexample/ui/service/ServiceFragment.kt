package com.zhuravlev.recyclerviewexample.ui.service

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.zhuravlev.recyclerviewexample.R
import com.zhuravlev.recyclerviewexample.ui.BaseViewModel
import com.zhuravlev.recyclerviewexample.ui.main.recycler_view.ServiceAdapter

class ServiceFragment(val type: String) : Fragment() {
    private lateinit var viewModel: BaseViewModel
    private lateinit var mRecyclerView: RecyclerView

    companion object {
        fun newInstance(type: String) = ServiceFragment(type)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        activity!!.title = getString(R.string.objects)
//        (activity as MainActivity).supportActionBar?.setHomeButtonEnabled(true)
//        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val v = inflater.inflate(R.layout.fragment_base, container, false)
        mRecyclerView = v.findViewById(R.id.base_recycler_view)
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = activity?.run {
            ViewModelProvider(this)[BaseViewModel::class.java]
        } ?: throw Exception("Invalid Activity")
        mRecyclerView.adapter = ServiceAdapter(viewModel.getServices(type))
    }
}