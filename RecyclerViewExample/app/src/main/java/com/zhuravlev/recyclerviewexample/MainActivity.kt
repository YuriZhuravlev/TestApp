package com.zhuravlev.recyclerviewexample

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.zhuravlev.recyclerviewexample.ui.main.MainFragment

class MainActivity : AppCompatActivity() {
    var titleView: TextView? = null
    var backButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.getDefaultNightMode())
        super.onCreate(savedInstanceState)
        instance = this
        setContentView(R.layout.activity_main)
        titleView = findViewById(R.id.toolbar_title)
        backButton = findViewById(R.id.toolbar_back_button)
        backButton!!.setOnClickListener {
            onBackPressed()
        }
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        instance = null
    }

    companion object {
        var instance: AppCompatActivity? = null
    }
}