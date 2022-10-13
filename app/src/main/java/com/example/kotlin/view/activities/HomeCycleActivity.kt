package com.example.kotlin.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.kotlin.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home_cycle.*


class HomeCycleActivity : BaseActivity() {
    var isInorderDetails: Boolean=false
    private var navController: NavController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_cycle)
        val navHostFragment=supportFragmentManager.findFragmentById(R.id.home_activity_fragment_normal)
        navController=navHostFragment!!.findNavController()
        nav_view.setupWithNavController(navController!!)
        setupButtomNavMenu(navController!!)
        navController!!.addOnDestinationChangedListener { _, destination, _ ->
            if(destination.id == R.id.ordersDetailsFragment) {
                if (isInorderDetails){
                    navController!!.navigate(R.id.homeFragment)
                    isInorderDetails=false
                }
                Log.d("d", "wwwwwwwwwwwwww")

            } else {

            }
        }
//        BottomNavigationView.OnNavigationItemSelectedListener { item ->
//            when(item.itemId) {
//                R.id.homeFragment -> {
//                    Log.d("d", "wwwwwwwwwwwwww")
//                    navController!!.navigate(R.id.homeFragment)
//                    // Respond to navigation item 1 click
//                    true
//                }
//                R.id.notificationsFragment2 -> {
//                    Log.d("d", "wwwwwwwwwwwwww3")
//                    // Respond to navigation item 2 click
//                    true
//                }
//                else -> false
//            }
//        }
//        nav_view.setOnNavigationItemReselectedListener { item ->
//            when(item.itemId) {
//                R.id.homeFragment -> {
//                    navController!!.navigate(R.id.homeFragment)
//                    Log.d("d", "wwwwwwwwwwwwww2")
//
//                    // Respond to navigation item 1 reselection
//                }
//                R.id.notificationsFragment2 -> {
//                    Log.d("d", "wwwwwwwwwwwwww4")
//                    // Respond to navigation item 2 reselection
//                }
//            }
//        }

//        nav_view.setOnItemSelectedListener {
//            navController!!.popBackStack()
//            when (it.itemId) {
//                R.id.homeFragment -> {
//                    Log.d("d", "wwwwwwwwwwwwww")
//                    navController!!.navigate(R.id.homeFragment)
//
//                }
//                R.id.notificationsFragment2 -> {
//                    Log.d("d", "wwwwwwwwwwwwww11111")
//
//                    navController!!.navigate(R.id.notificationsFragment2)
//
//                }
//                R.id.ordersFragment -> {
//                    Log.d("d", "wwwwwwwwwwwwww2222222222222")
//                    Log.d("d", item.itemId.toString())
//
//                    navController!!.navigate(R.id.ordersFragment)
//
//
//                }
//                R.id.moreFragment->{
//                    Log.d("d", "wwwwwwwwwwwwww3333333333333")
//
//                    navController!!.navigate(R.id.moreFragment)
//
//                }
//            }
//        }
    }

        private fun setupButtomNavMenu(navController:NavController){
        nav_view?.let {
            NavigationUI.setupWithNavController(it,navController)
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController=Navigation.findNavController(this,R.id.home_activity_fragment_normal)
        val navigated =NavigationUI.onNavDestinationSelected(item,navController)
        return navigated||super.onOptionsItemSelected(item)
    }

}