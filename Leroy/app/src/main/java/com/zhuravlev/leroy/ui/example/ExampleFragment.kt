package com.zhuravlev.leroy.ui.example

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.zhuravlev.leroy.R
import com.zhuravlev.leroy.ui.simple.SimpleFragment

class ExampleFragment : SimpleFragment() {

    private lateinit var exampleViewModel: ExampleViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        exampleViewModel =
            ViewModelProvider(this).get(ExampleViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_example, container, false)
        val textView: TextView = root.findViewById(R.id.text_example)
        exampleViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}