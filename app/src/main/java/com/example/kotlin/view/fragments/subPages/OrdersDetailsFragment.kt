package com.example.kotlin.view.fragments.subPages

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.kotlin.R
import com.example.kotlin.view.fragments.BaseFragment

class OrdersDetailsFragment : BaseFragment() {
    var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        navController =
            Navigation.findNavController(requireActivity()!!, R.id.home_activity_fragment_normal)
        setUpActivity()
        homeCycleActivity!!.isInorderDetails=true
        return inflater.inflate(R.layout.fragment_orders_details, container, false)
    }

    override fun onResume() {
        super.onResume()

    }
    override fun onDestroyView() {
        super.onDestroyView()
    }
}