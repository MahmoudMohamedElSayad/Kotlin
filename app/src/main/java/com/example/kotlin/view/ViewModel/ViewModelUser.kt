package com.example.kotlin.view.ViewModel

import android.app.Activity
import android.content.Intent
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin.R
import com.example.kotlin.data.local.SharedPreferencesManger.SharedPreferencesManger.REMEMBER_ME
import com.example.kotlin.data.local.SharedPreferencesManger.SharedPreferencesManger.SaveData
import com.example.kotlin.data.local.SharedPreferencesManger.SharedPreferencesManger.USER_DATA
import com.example.kotlin.data.local.SharedPreferencesManger.SharedPreferencesManger.USER_PASSWORD
import com.example.kotlin.data.local.SharedPreferencesManger.SharedPreferencesManger.USER_TOKEN
import com.example.kotlin.data.model.getUserLoginDataResponce.GetUserLoginDataResponce
import com.example.kotlin.data.local.SharedPreferencesManger.SharedPreferencesManger.clean
import com.example.kotlin.utils.HelperMethods
import com.example.kotlin.utils.HelperMethods.HelperMethods.dismissProgressDialog
import com.example.kotlin.utils.HelperMethods.HelperMethods.progressDialog
import com.example.kotlin.utils.HelperMethods.HelperMethods.showCookieMsg
import com.example.kotlin.utils.HelperMethods.HelperMethods.showProgressDialog
import com.example.kotlin.utils.InternetState.InternetState.isConnected
import com.example.kotlin.utils.ToastCreator.ToastCreator.onCreateErrorToast
import com.example.kotlin.utils.interfaces.TryAgainOncall
import com.example.kotlin.view.activities.UserCycleActivity
import org.aviran.cookiebar2.CookieBar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class ViewModelUser : ViewModel() {
    var TAG = "ViewModelUser_ERROR"
    var generalLoginResponse = MutableLiveData<GetUserLoginDataResponce>()
    fun makeGetUserLoginDataResponce(): MutableLiveData<GetUserLoginDataResponce>? {
        return generalLoginResponse
    }
    fun setGetUserLoginDataResponce(
        activity: Activity,
        method: Call<GetUserLoginDataResponce>,
        password: String?,
        remember: Boolean,
        type: String,
        tryAgainOncall: TryAgainOncall?,
        message: String?
    ) {
        if (isConnected(activity)) {
            if (progressDialog == null) {
                if (type == "update_data" || type =="rejester"|| type==("newPassword")
                ) {
                    HelperMethods.showProgressDialog(activity, activity.getString(R.string.wait))
                }
            } else {
                if (progressDialog!!.isShowing()) {
                    HelperMethods.showProgressDialog(activity, activity.getString(R.string.wait));
                }
            }
            method.enqueue(object : Callback<GetUserLoginDataResponce?> {
                override fun onResponse(
                    call: Call<GetUserLoginDataResponce?>,
                    response: Response<GetUserLoginDataResponce?>
                ) {
                    if (response.body() != null) {
                        try {
                            if (response.body()!!.status == "success") {
                                clean(activity)
                                SaveData(activity, USER_PASSWORD, password)
                                SaveData(activity, USER_DATA, response.body()!!.data)
                                SaveData(activity, REMEMBER_ME, remember)
                                SaveData(activity, USER_TOKEN, response.body()!!.data.token)
                                dismissProgressDialog()
                                if (type=="update_data") {
//                                    val dialog = DialogDone()
//                                    dialog.showDialog(activity, message)
                                } else {
                                }
                                generalLoginResponse.postValue(response.body())
                            } else {
                                onCreateErrorToast(activity, activity.getString(R.string.error));
                                Log.d(TAG, "onResponse: " + response.body()!!.message)
                                dismissProgressDialog()
                                if (type=="splash") {
                                    clean(activity)
                                    val ii = Intent(activity, UserCycleActivity::class.java)
                                    activity.startActivity(ii)
                                    activity.finish()
                                } else {
                                    showCookieMsg(
                                        activity.getString(R.string.warning),
                                        response.body()!!.message,
                                        activity,
                                        R.color.red2,
                                        CookieBar.TOP
                                    )
                                }
                            }
                        } catch (e: Exception) {
                            Log.d(TAG, "onResponse: " + e.message)
                            onCreateErrorToast(activity, activity.getString(R.string.error))
                        }
                    } else {
                        dismissProgressDialog()
                    }
                }

                override fun onFailure(call: Call<GetUserLoginDataResponce?>, t: Throwable) {
                    dismissProgressDialog()
//                    onCreateErrorToast(activity, activity.getString(R.string.error));
                    Log.d("error", "" + t.message)
                    generalLoginResponse.postValue(null)
                    tryAgainOncall!!.tryAgainCall("")
                }
            })
        } else {
            try {
                showCookieMsg(
                    activity.getString(R.string.warning),
                    activity.getString(R.string.error_inter_net),
                    activity,
                    R.color.red2,
                    CookieBar.TOP
                )
            } catch (e: Exception) {
                Log.d(TAG, "onResponse: " + e.message)
            }
        }
    }

}