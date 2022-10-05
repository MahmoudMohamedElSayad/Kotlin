package com.example.kotlin.view.fragments.HomeCycle

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import butterknife.ButterKnife
import com.example.kotlin.R
import com.example.kotlin.view.fragments.BaseFragment

class HomeFragment : BaseFragment() {
    lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false) as View
        ButterKnife.bind(this, root)
        initData(root)


        return root

    }

    private fun initData(root: View) {
        val ageEditText = root.findViewById<EditText>(R.id.date_birth_edit)
        val ageNowTextView = root.findViewById<TextView>(R.id.show_result_tv)
        val calculateBtu = root.findViewById<Button>(R.id.calculate_btu)
        calculateBtu.setOnClickListener {
            Navigation.findNavController(root).navigate(R.id.moreFragment)
        }
    }


}