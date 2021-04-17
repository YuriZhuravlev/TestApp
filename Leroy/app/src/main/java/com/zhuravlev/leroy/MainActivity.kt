package com.zhuravlev.leroy

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var navController: NavController
    lateinit var appBarConfiguration: AppBarConfiguration

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
            } else {
                simpleToolbar.visibility = View.GONE
                collapsingToolbarLayout.visibility = View.VISIBLE
                activeSearchToolbar = true
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar)
        simpleToolbar = findViewById(R.id.simple_toolbar)

        navController = findNavController(R.id.nav_host_fragment)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_list,
                R.id.navigation_shop,
                R.id.navigation_profile,
                R.id.navigation_basket
            )
        )
        setSupportActionBar(simpleToolbar)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }
}