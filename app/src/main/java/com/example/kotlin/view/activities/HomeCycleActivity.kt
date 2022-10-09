package com.example.kotlin.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.kotlin.R
import kotlinx.android.synthetic.main.activity_home_cycle.*


class HomeCycleActivity : BaseActivity() {
    private var navController: NavController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_cycle)
        val navHostFragmentWorker =
            supportFragmentManager.findFragmentById(R.id.home_activity_fragment_normal) as NavHostFragment?
        setupWithNavController(nav_view, navHostFragmentWorker!!.navController)
        navController = findNavController(this, R.id.home_activity_fragment_normal)
//        setupButtomNavMenu(navController!!)

    }
    private fun setupButtomNavMenu(navController:NavController){
        nav_view?.let {
            NavigationUI.setupWithNavController(it,navController)
        }
    }
////    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        val navController=Navigation.findNavController(this,R.id.home_activity_fragment_normal)
////        val navigated =NavigationUI.onNavDestinationSelected(item!!,navController)
////        return navigated||super.onOptionsItemSelected(item)
////    }

}