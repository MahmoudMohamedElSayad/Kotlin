package com.example.kotlin.view.fragments.userCycle

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import com.example.kotlin.R
import com.example.kotlin.data.api.ApiClient.ApiClient.getApiClient
import com.example.kotlin.data.model.getUserLoginDataResponce.GetUserLoginDataResponce
import com.example.kotlin.databinding.FragmentLoginBinding
import com.example.kotlin.utils.HelperMethods.HelperMethods.showTextError
import com.example.kotlin.utils.interfaces.TryAgainOncall
import com.example.kotlin.view.ViewModel.ViewModelUser
import com.example.kotlin.view.activities.HomeCycleActivity
import com.example.kotlin.view.fragments.BaseFragment
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.FirebaseApp
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Call

class LoginFragment : BaseFragment(), TryAgainOncall {
    private lateinit var binding: FragmentLoginBinding
    private var viewModelUser: ViewModelUser? = null
    private val TAG: String = "LoginFragment"
    private lateinit var mobilePhone: String
    private lateinit var password: String
    private lateinit var mobileToken: String
    var root: View? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        root = binding!!.root
        onclick()
        FirebaseApp.initializeApp(requireContext())
        initListener()
        GlobalScope.launch {
            Log.d(TAG, "zzzz ${Thread.currentThread().name}")
            printText("dsadsadsadsa")
        }
        return root
    }

    private fun initListener() {
        viewModelUser = ViewModelProviders.of(this)[ViewModelUser::class.java]
        viewModelUser!!.makeGetUserLoginDataResponce()!!
            .observe(viewLifecycleOwner, { response ->
                if (response != null) {
                    if (response.status == "success") {
//                        onCallfireBase(
//                            response.data.id.toString() + "",
//                            response.data.token
//                        )
                        val ii = Intent(activity, HomeCycleActivity::class.java)
                        requireActivity().startActivity(ii)
                        requireActivity().finish()
                        binding.spinKit1.visibility = View.GONE
                    } else {
                    }
                } else {
                }
            })
    }

    private fun onCallfireBase(id: String, token: String) {
        FirebaseApp.initializeApp(requireContext())
        val refreshedToken: Task<String> = FirebaseMessaging.getInstance().token
        FirebaseMessaging.getInstance().token
            .addOnCompleteListener(object : OnCompleteListener<String?> {
                override fun onComplete(task: Task<String?>) {
                    if (!task.isSuccessful) {
                        Log.w(TAG, "Fetching FCM registration token failed", task.getException())
                        return
                    }
                    // Get new FCM registration token
                    mobileToken = task.result.toString()
                    Log.d("$TAG Tokenzzzz", mobileToken)
                }
            })

    }

    private fun onclick() {
        binding.fragmentLoginEnterBtu.setOnClickListener {
//            onValidation()
            onCall()

        }
    }

    private fun onCall() {
        mobilePhone = binding.fragmentLoginEmailEdit.text.toString()
        password = binding.fragmentLoginPasswordEdit.text.toString()
        var clientCall: Call<GetUserLoginDataResponce> = getApiClient().login(mobilePhone, password)
        viewModelUser!!.setGetUserLoginDataResponce(
            requireActivity()!!,
            clientCall,
            password,
            true,
            "login",
            this,
            ""
        )


    }

    private fun onValidation() {
        if (checkEmpty(
                binding.fragmentLoginEmailEdit,
                "empty",
                "من فضلك أدخل رقم التلفون",
                binding.fragmentLoginError1Layout,
                binding.fragmentLoginError1
            )
        ) {
            return
        }
        if (binding.fragmentLoginEmailEdit.text.toString().length < 6 || binding.fragmentLoginEmailEdit.text!!.startsWith(
                "05"
            )
        ) {
            checkEmpty(
                binding.fragmentLoginEmailEdit,
                "",
                getString(R.string.invalid_phone),
                binding.fragmentLoginError1Layout,
                binding.fragmentLoginError1
            )
        }

    }

    override fun onBack() {
        requireActivity().finish()
    }

    private fun checkEmpty(
        fragmentLoginEdit: EditText,
        empty: String,
        messageError: String,
        fragmentLoginErrorLayout: View,
        fragmentLoginError: TextView
    ): Boolean {
        if (empty == "empty") {
            return if (fragmentLoginEdit.text.trim().isEmpty()) {
                showTextError(messageError, fragmentLoginErrorLayout, fragmentLoginError)
                true
            } else {
                fragmentLoginErrorLayout.visibility = View.GONE
                false
            }
        } else {
            showTextError(messageError, fragmentLoginErrorLayout, fragmentLoginError)
        }
        return false
    }

    override fun tryAgainCall(type: String?) {
        TODO("Not yet implemented")
    }

    suspend fun printText(myText: String) {
        delay(1000)
        Log.d(TAG, myText)
    }
}