package com.zhuravlev.foodviewer.ui.common

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.zhuravlev.foodviewer.MainActivity

open class DefaultFragment : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (activity as MainActivity).switchToolbar()
        super.onViewCreated(view, savedInstanceState)
    }
}