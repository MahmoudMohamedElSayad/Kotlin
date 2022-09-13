package com.example.kotlin.view.activities
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.view.fragments.BaseFragment

open class BaseActivity : AppCompatActivity() {
    var languageToLoad = ""
    var baseFragment: BaseFragment? = null
    override fun onBackPressed() {
        baseFragment?.onBack()
    }
    //​
    fun superBackPressed() {
        super.onBackPressed()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }
}