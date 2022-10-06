package com.example.kotlin.view.fragments.UserCycle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import butterknife.ButterKnife
import com.example.kotlin.R
import com.example.kotlin.databinding.FragmentHomeBinding
import com.example.kotlin.databinding.FragmentLoginBinding
import com.example.kotlin.view.fragments.BaseFragment
import com.google.android.material.textfield.TextInputEditText

class LoginFragment : BaseFragment() {
    private lateinit var binding: FragmentLoginBinding
    var root:View?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        root = binding!!.root
        onclick()
        return root
    }

    private fun onclick() {
        binding.fragmentLoginEnterBtu.setOnClickListener{

        }
    }

    override fun onBack() {

        requireActivity().finish()
    }


}