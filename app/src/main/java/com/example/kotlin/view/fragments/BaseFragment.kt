package com.example.kotlin.view.fragments

import android.content.Context
import android.content.res.Configuration
import androidx.fragment.app.Fragment
import com.example.kotlin.view.activities.BaseActivity
import com.example.kotlin.view.activities.BaseActivity.HelperMethods.languageToLoad
import com.example.kotlin.view.activities.HomeCycleActivity
import java.lang.Exception
import java.util.*

open class BaseFragment : Fragment() {
    var homeCycleActivity: HomeCycleActivity? = null
    private val activity: Context? = null
    var baseActivity: BaseActivity? = null
    open fun setUpActivity() {
        baseActivity = getActivity() as BaseActivity?
        baseActivity!!.baseFragment = this
        try {
            homeCycleActivity = getActivity() as HomeCycleActivity?
        } catch (e: Exception) {
        }
    }
    open fun onBack() {
        baseActivity!!.superBackPressed()
    }
    override fun onStart() {
        super.onStart()
        setUpActivity()
    }
    open fun refreshLanguage() {
        // your language
        val locale = Locale(languageToLoad)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        requireActivity().resources.updateConfiguration(
            config,
            requireActivity().resources.displayMetrics
        )
    }

    override fun onAttach(context: Context) {
        val locale = Locale(languageToLoad)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        super.onAttach(context)
        refreshLanguage()
    }
}