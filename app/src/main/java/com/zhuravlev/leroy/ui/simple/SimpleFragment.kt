package com.zhuravlev.leroy.ui.simple

import android.app.Activity
import androidx.fragment.app.Fragment
import com.zhuravlev.leroy.MainActivity

open class SimpleFragment : Fragment() {
    override fun onAttach(activity: Activity) {
        (activity as MainActivity).switchToolbar(false)
        super.onAttach(activity)
    }
}