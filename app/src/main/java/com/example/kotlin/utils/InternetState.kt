package com.example.kotlin.utils

import android.content.Context
import android.net.ConnectivityManager
import java.lang.NullPointerException

class InternetState {
    companion object InternetState {
        var cm: ConnectivityManager?=null
        fun isConnected(context: Context): Boolean {
            try {
                cm =
                    context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            } catch (e: NullPointerException) {
            }
            val activeNetwork = cm!!.activeNetworkInfo
            return activeNetwork != null && activeNetwork.isConnectedOrConnecting
        }
    }
}