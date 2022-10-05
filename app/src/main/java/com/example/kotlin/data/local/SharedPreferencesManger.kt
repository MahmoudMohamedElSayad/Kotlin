package com.example.kotlin.data.local

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import com.example.kotlin.data.model.getUserLoginDataResponce.Data
import com.google.gson.Gson

class SharedPreferencesManger {
    companion object SharedPreferencesManger {
        var sharedPreferences: SharedPreferences? = null
        var USER_DATA = "USER_DATA"
        var REMEMBER_ME = "REMEMBER_ME"
        var USER_PASSWORD = "USER_PASSWORD"
        var USER_TOKEN = "USER_TOKEN"
        var CLIENT = "CLIENT"
        var TABPOSION = "TABPOSION"
        var GOOGLECHECK = "GOOGLECHECK"
        var USER_FireBase_TOKEN = "USER_FIREBASE_TOKEN"
        fun setSharedPreferences(activity: Activity) {
            if (sharedPreferences == null) {
                 sharedPreferences =
                    activity.getSharedPreferences(
                        "Sofra", Context.MODE_PRIVATE
                    )
            }
        }
        fun clean(activity: Activity?) {
            if (activity != null) {
                setSharedPreferences(
                    activity
                )
            }
            if ( sharedPreferences != null) {
                val editor: SharedPreferences.Editor =
                    sharedPreferences!!.edit()
                editor.clear()
                editor.commit()
            }
        }
        fun SaveData(activity: Activity?, data_Key: String?, data_Value: String?) {
            if (activity != null) {
                setSharedPreferences(
                    activity
                )
            }
            if (sharedPreferences != null) {
                val editor: SharedPreferences.Editor =
                     sharedPreferences!!.edit()
                editor.putString(data_Key, data_Value)
                editor.commit()
            } else {
                if (activity != null) {
                    setSharedPreferences(
                        activity
                    )
                }
            }
        }
        fun SaveData(activity: Activity?, data_Key: String?, data_Value: Data?) {
            if (activity != null) {
                setSharedPreferences(
                    activity
                )
            }
            if (sharedPreferences != null) {
                val editor: SharedPreferences.Editor =
                    sharedPreferences!!.edit()
                val gson = Gson()
                val StringData = gson.toJson(data_Value)
                editor.putString(data_Key, StringData)
                editor.commit()
            }
        }
        fun SaveData(activity: Activity?, data_Key: String?, data_Value: Boolean) {
            if (activity != null) {
                setSharedPreferences(
                    activity
                )
            }
            if (sharedPreferences != null) {
                val editor: SharedPreferences.Editor =
                    sharedPreferences!!.edit()
                editor.putBoolean(data_Key, data_Value)
                editor.commit()
            } else {
                if (activity != null) {
                    setSharedPreferences(
                        activity
                    )
                }
            }
        }
        fun LoadLanguage(activity: Activity?, data_Key: String): String? {
            if (activity != null) {
                setSharedPreferences(
                    activity
                )
            }

            return sharedPreferences?.getString(
                data_Key,
                "ar"
            )
        }
    }


}