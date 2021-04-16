package com.zhuravlev.leroy

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var collapsingToolbarLayout: CollapsingToolbarLayout
    lateinit var searchToolbar: Toolbar
    lateinit var simpleToolbar: Toolbar
    var activeSearchToolbar: Boolean = true

    fun switchToolbar(searchToolbar: Boolean = false) {
        if (activeSearchToolbar != searchToolbar) {
            if (activeSearchToolbar) {
                collapsingToolbarLayout.visibility = View.GONE
                simpleToolbar.visibility = View.VISIBLE
                activeSearchToolbar = false
                simpleToolbar.title = this.searchToolbar.title
                setSupportActionBar(simpleToolbar)
            } else {
                simpleToolbar.visibility = View.GONE
                collapsingToolbarLayout.visibility = View.VISIBLE
                activeSearchToolbar = true
                setSupportActionBar(this.searchToolbar)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar)
        searchToolbar = findViewById(R.id.search_toolbar)
        simpleToolbar = findViewById(R.id.simple_toolbar)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_list,
                R.id.navigation_shop,
                R.id.navigation_profile,
                R.id.navigation_basket
            )
        )
        setSupportActionBar(searchToolbar)
        //switchToolbar(activeSearchToolbar)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}