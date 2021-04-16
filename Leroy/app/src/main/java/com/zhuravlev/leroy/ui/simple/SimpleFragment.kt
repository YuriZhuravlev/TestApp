package com.zhuravlev.leroy.ui.simple

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.zhuravlev.leroy.MainActivity

open class SimpleFragment : Fragment() {
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        (activity as MainActivity).switchToolbar(false)
        super.onActivityCreated(savedInstanceState)
    }
}