package com.example.kotlin.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.kotlin.R

class HomeCycleActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_cycle)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.home_activity_fragment_normal) as NavHostFragment
        val navController = navHostFragment.navController
    }
}