package com.example.kotlin.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
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
        val menu: Menu = nav_view.menu
        menu.add(Menu.NONE, R.id.homeFragment, Menu.NONE, R.string.hawayat)
            .setIcon(R.drawable.hawayat_selector)
        menu.add(Menu.NONE, R.id.notificationsFragment2, Menu.NONE, R.string.notifications)
            .setIcon(R.drawable.notification_selector)
        menu.add(Menu.NONE, R.id.ordersFragment, Menu.NONE, R.string.orders)
            .setIcon(R.drawable.order_selector)
        menu.add(Menu.NONE, R.id.moreFragment, Menu.NONE, R.string.more)
            .setIcon(R.drawable.more_selector)
        nav_view.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.homeFragment -> {
                    navController!!.navigate(R.id.homeFragment)
                    return@setOnNavigationItemReselectedListener
                }
                R.id.notificationsFragment2 -> {
                    navController!!.navigate(R.id.notificationsFragment2)
                    return@setOnNavigationItemReselectedListener
                }
                R.id.ordersFragment -> {
                    navController!!.navigate(R.id.ordersFragment)
                    return@setOnNavigationItemReselectedListener

                }
                R.id.moreFragment->{
                    navController!!.navigate(R.id.moreFragment)
                    return@setOnNavigationItemReselectedListener
                }
            }
        }
    }
    private fun setupButtomNavMenu(navController:NavController){
        nav_view?.let {
            NavigationUI.setupWithNavController(it,navController)
        }
    }
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        val navController=Navigation.findNavController(this,R.id.home_activity_fragment_normal)
//        val navigated =NavigationUI.onNavDestinationSelected(item,navController)
//        return navigated||super.onOptionsItemSelected(item)
//    }

}