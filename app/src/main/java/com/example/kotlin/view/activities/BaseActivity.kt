package com.example.kotlin.view.activities
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.data.local.SharedPreferencesManger.SharedPreferencesManger.LoadLanguage
import com.example.kotlin.view.fragments.BaseFragment
import java.util.*

open class BaseActivity : AppCompatActivity() {
    companion object HelperMethods {
        var languageToLoad = ""
    }

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
        val languageCode: String = LoadLanguage(this, "LANGUAGE")!!
        if (languageCode != "") {
             languageToLoad = languageCode
        } else if (languageToLoad== "") {
             languageToLoad = LoadLanguage(this, "LANGUAGE")!!
//            setFireBaseToken()
            if ( languageToLoad == null || languageToLoad.isEmpty() || languageToLoad.equals(
                    "",
                    ignoreCase = true
                )
            ) {
                languageToLoad = "ar"
                val locale = Locale(languageToLoad)
                Locale.setDefault(locale)
                val config = Configuration()
                config.locale = locale
                this.resources.updateConfiguration(config, this.resources.displayMetrics)
            }
        }

    }
}