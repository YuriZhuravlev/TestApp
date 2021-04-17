package com.zhuravlev.leroy.ui.lists.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.zhuravlev.leroy.R
import com.zhuravlev.leroy.repository.Categories

class ListsAdapter(
    private val context: Context,
    private val categories: Categories,
    private val groupFrom: String,
    private val childFrom: String
) : BaseExpandableListAdapter() {
    override fun getGroupCount(): Int = categories.group.size

    override fun getChildrenCount(groupPosition: Int): Int = categories.child[groupPosition].size

    override fun getGroup(groupPosition: Int): Any = categories.group[groupPosition]

    override fun getChild(groupPosition: Int, childPosition: Int): Any =
        categories.child[groupPosition][childPosition]

    override fun getGroupId(groupPosition: Int): Long = groupPosition.toLong()

    override fun getChildId(groupPosition: Int, childPosition: Int): Long = childPosition.toLong()

    override fun hasStableIds(): Boolean = true

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val view: View = convertView
            ?: (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(
                R.layout.item_group,
                null
            )

        val textView: TextView = view.findViewById(R.id.item_group_text)
        textView.text = categories.group[groupPosition][groupFrom]

        return view
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val view: View = convertView
            ?: (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(
                R.layout.item_child,
                null
            )

        val textView: TextView = view.findViewById(R.id.item_child_text)
        textView.text = categories.child[groupPosition][childPosition][childFrom]

        return view
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean = true
}