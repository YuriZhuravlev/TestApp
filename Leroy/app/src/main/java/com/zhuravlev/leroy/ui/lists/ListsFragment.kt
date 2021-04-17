package com.zhuravlev.leroy.ui.lists

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.zhuravlev.leroy.R
import com.zhuravlev.leroy.repository.Categories
import com.zhuravlev.leroy.ui.lists.adapter.ListsAdapter
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
        listsViewModel.setCategory(category)
        val root = inflater.inflate(R.layout.fragment_lists, container, false)
        val expandableListView: ExpandableListView = root.findViewById(R.id.expandable_list)
        expandableListView.setOnChildClickListener(childClickListener)
        expandableListView.setOnGroupClickListener(groupClickListener)

        listsViewModel.data.observe(viewLifecycleOwner, {
            context?.let { context ->
                val adapter =
                    ListsAdapter(context, it, Categories.GROUP_FROM[0], Categories.CHILD_FROM[0])
                expandableListView.setAdapter(adapter)
            }
        })
        return root
    }

    private val childClickListener = object :
        ExpandableListView.OnChildClickListener {
        override fun onChildClick(
            parent: ExpandableListView?,
            v: View?,
            groupPosition: Int,
            childPosition: Int,
            id: Long
        ): Boolean {
            listsViewModel.data.value?.let {
                val from = Categories.CHILD_FROM[0]
                val text: String = it.child[groupPosition][childPosition][from] ?: ""
                Toast.makeText(
                    context,
                    "Click $text",
                    Toast.LENGTH_SHORT
                ).show()
            }
            return true
        }
    }

    private val groupClickListener = object :
        ExpandableListView.OnGroupClickListener {
        var expandPosition = -1
        override fun onGroupClick(
            parent: ExpandableListView?,
            v: View?,
            groupPosition: Int,
            id: Long
        ): Boolean {
            requireNotNull(parent) { "parent null" }
            if (expandPosition != -1) {
                if (expandPosition == groupPosition) {
                    parent.collapseGroup(groupPosition)
                    expandPosition = -1
                    return true
                } else {
                    parent.collapseGroup(expandPosition)
                }
            }
            expandPosition = groupPosition
            parent.expandGroup(groupPosition, true)
            return true
        }
    }
}