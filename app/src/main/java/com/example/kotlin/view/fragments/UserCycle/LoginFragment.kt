package com.example.kotlin.view.fragments.UserCycle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import com.example.kotlin.R
import com.example.kotlin.view.fragments.BaseFragment
import com.google.android.material.textfield.TextInputEditText

class LoginFragment : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var root=inflater.inflate(R.layout.fragment_login, container, false) as View
        return root
    }
    override fun onBack() {
        requireActivity().finish()
    }

}