package com.example.kotlin.utils

import android.app.Activity
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.kotlin.R

class ToastCreator {
    companion object ToastCreator {
        fun onCreateErrorToast(activity: Activity, toastTitle: String?) {
            val inflater = activity.layoutInflater
            val layoutId: Int = R.layout.toast_error
            val layout = inflater.inflate(
                layoutId,
                activity.findViewById<View>(R.id.toast_layout_root) as ViewGroup
            )
            val text = layout.findViewById<TextView>(R.id.toast_tv_text)
            text.text = toastTitle
            val toast = Toast(activity)
            toast.setGravity(Gravity.CENTER_VERTICAL or Gravity.BOTTOM, 0, 100)
            toast.duration = Toast.LENGTH_LONG
            toast.setView(layout)
            toast.show()
        }
    }
}