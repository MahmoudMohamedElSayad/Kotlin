package com.example.kotlin.view.fragments

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.kotlin.view.activities.BaseActivity
import com.example.kotlin.view.activities.HomeCycleActivity
open class BaseFragment : Fragment() {
    var homeCycleActivity: HomeCycleActivity? = null
    private val activity: Context? = null
    fun setUpActivity() {
        baseActivity = activity as BaseActivity?
        baseActivity!!.baseFragment = this
        try {
            homeCycleActivity = activity as HomeCycleActivity?
        } catch (e: Exception) {
        }
    }
    var baseActivity: BaseActivity? = null
    fun onBack() {
        baseActivity?.superBackPressed()
    }
    override fun onStart() {
        super.onStart()
        setUpActivity()
    }

}