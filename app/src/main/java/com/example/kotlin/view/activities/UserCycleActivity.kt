package com.example.kotlin.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin.R
import com.example.kotlin.utils.HelperMethods.HelperMethods.replaceFragment
import com.example.kotlin.view.fragments.UserCycle.LoginFragment

class UserCycleActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_cycle)
        replaceFragment(supportFragmentManager, R.id.user_frame, LoginFragment())
    }
}