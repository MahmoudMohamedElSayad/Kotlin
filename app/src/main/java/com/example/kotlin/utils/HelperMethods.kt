package com.example.kotlin.utils

import android.app.Activity
import android.app.ProgressDialog
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import coil.load
import coil.transform.CircleCropTransformation
import com.example.kotlin.R
import com.example.kotlin.utils.interfaces.TryAgainOncall
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.aviran.cookiebar2.CookieBar
import java.io.File
import java.lang.Exception

class HelperMethods {
    companion object HelperMethods {
        lateinit var progressDialog: ProgressDialog

        //this method to load image from url
        fun onLoadImageFromUrl2(imageView: ImageView?, URl: String?) {
            imageView?.load(URl) {
                crossfade(true)
                crossfade(1000)
                transformations(CircleCropTransformation())
            }
            fun showNoInternetDialogDialog(
                activity: Activity,
                tryAgainOncall: TryAgainOncall,
                type: String?
            ) {
                try {
                    val alertDialog: AlertDialog = AlertDialog.Builder(activity).create()
                    alertDialog.setTitle(activity.getString(R.string.warning))
                    alertDialog.setMessage(activity.getString(R.string.error_inter_net))
                    alertDialog.setCancelable(true)
                    alertDialog.setButton(
                        AlertDialog.BUTTON_POSITIVE, activity.getString(R.string.try_again)
                    ) { dialog, which ->
                        tryAgainOncall.tryAgainCall(type)
                    }
                    alertDialog.setButton(
                        AlertDialog.BUTTON_NEGATIVE, activity.getString(R.string.cancel)
                    ) { dialog, which -> alertDialog.dismiss() }
                    alertDialog.show()
                } catch (e: Exception) {
                }
            }

        }

        fun replaceFragmentWithAnimationAndBundle(
            getChildFragmentManager: FragmentManager,
            id: Int,
            fragment: Fragment,
            fromWhere: String,
            bundle: Bundle?
        ) {
            val transaction = getChildFragmentManager.beginTransaction()
            if (fromWhere == "l") {
                transaction.setCustomAnimations(
                    R.anim.slide_in_left,
                    R.anim.slide_out_right
                )
            }
            if (fromWhere == "r") {
                transaction.setCustomAnimations(
                    R.anim.enter_from_right,
                    R.anim.exit_to_left
                )
            }
            if (fromWhere == "t") {
                transaction.setCustomAnimations(R.anim.slide_out_down, R.anim.slide_in_down)
            }
            if (fromWhere == "b") {
                transaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_up)
            }
            fragment.arguments = bundle
            transaction.replace(id, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        fun showTextError(errorMessage: String?, layoutParent: View, textErrorLayout: TextView) {
            layoutParent.visibility = View.VISIBLE
            textErrorLayout.text = errorMessage
        }

        fun replaceFragmentWithAnimationWithoutBundle(
            getChildFragmentManager: FragmentManager,
            id: Int,
            fragment: Fragment?,
            fromWhere: String
        ) {
            val transaction = getChildFragmentManager.beginTransaction()
            if (fromWhere === "l") {
                transaction.setCustomAnimations(
                    R.anim.slide_in_left,
                    R.anim.slide_out_right
                )
            }
            if (fromWhere === "r") {
                transaction.setCustomAnimations(
                    R.anim.enter_from_right,
                    R.anim.exit_to_left
                )
            }
            if (fromWhere === "t") {
                transaction.setCustomAnimations(R.anim.slide_out_down, R.anim.slide_in_down)
            }
            if (fromWhere === "b") {
                transaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_up)
            }
            transaction.replace(id, fragment!!)
            transaction.addToBackStack(null)
            transaction.commit()

//            }
//        }
        }
        fun replaceFragment(
            getChildFragmentManager: FragmentManager,
            id: Int,
            fragment: Fragment?
        ) {
            val transaction = getChildFragmentManager.beginTransaction()
            transaction.replace(id, fragment!!)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        fun showCookieMsg(
            title: String?,
            msg: String?,
            activity: Activity?,
            color: Int,
            popUpPosition: Int
        ) {
            CookieBar.build(activity)
                .setTitle(title)
                .setMessage(msg)
                .setBackgroundColor(color)
                .setCookiePosition(popUpPosition)
                .setDuration(4000)
                .show()
        }


        fun convertToRequestBody(part: String): RequestBody? {
            return try {
                if (part != "") {
                    RequestBody.create("multipart/form-data".toMediaTypeOrNull(), part)
                } else {
                    null
                }
            } catch (e: Exception) {
                null
            }
        }

        fun disappearKeypad(activity: Activity, v: View?) {
            try {
                if (v != null) {
                    val imm =
                        activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(v.windowToken, 0)
                }
            } catch (e: Exception) {
            }
        }

        private fun convertFileToMultipart(pathImageFile: String, key: String):
                MultipartBody.Part {
            var multiParts: ArrayList<MultipartBody.Part> = ArrayList<MultipartBody.Part>()

            // 1. Create File using image url (String)
            val file = File(pathImageFile)
            // 2. Create requestBody by using multipart/form-data MediaType from file
            val requestFile: RequestBody = RequestBody.create(
                "*/*".toMediaTypeOrNull(), file
            )
            // 3. Finally, Create MultipartBody using MultipartBody.Part.createFormData
            val body: MultipartBody.Part = MultipartBody.Part.createFormData(
                key, file.name.trim(), requestFile
            )
            multiParts.add(body)
            return body
        }
        fun showProgressDialog(activity: Activity, title: String?) {
            try {
                progressDialog =
                    ProgressDialog(activity)
                progressDialog.setMessage(title)
                progressDialog.setIndeterminate(
                    false
                )
                progressDialog.setCancelable(false)
                progressDialog.show()
            } catch (e: Exception) {
            }
        }

        fun dismissProgressDialog() {
            try {
                progressDialog.dismiss()
            } catch (e: Exception) {
            }
        }
    }
    ////the rate function App
    fun rateApp(context: Context) {
        val appPackageName = context.packageName
        try {
            context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")))
        } catch (e: ActivityNotFoundException) {
            context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")))
        }
    }

}