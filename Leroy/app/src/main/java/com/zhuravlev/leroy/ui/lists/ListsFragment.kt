package com.zhuravlev.leroy.ui.lists

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import android.widget.SimpleExpandableListAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.zhuravlev.leroy.R
import com.zhuravlev.leroy.repository.Categories
import com.zhuravlev.leroy.ui.simple.SimpleFragment


class ListsFragment : SimpleFragment() {
    private lateinit var listsViewModel: ListsViewModel
    private lateinit var category: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (arguments != null) {
            category = requireArguments().getString("category")!!
            (activity as AppCompatActivity).supportActionBar?.title = category
        }

        listsViewModel = ViewModelProvider(this).get(ListsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_lists, container, false)
        val expandableListView: ExpandableListView = root.findViewById(R.id.expandable_list)

        listsViewModel.data.observe(viewLifecycleOwner, {
            val groupTo = intArrayOf(android.R.id.text1)
            val childTo = intArrayOf(android.R.id.text1)
            val adapter = SimpleExpandableListAdapter(
                context,
                it.group,
                android.R.layout.simple_expandable_list_item_1,
                Categories.GROUP_FROM.toTypedArray(),
                groupTo,
                it.child,
                android.R.layout.simple_list_item_1,
                Categories.CHILD_FROM,
                childTo
            )
            expandableListView.setAdapter(adapter)
        })
        return root
    }
}