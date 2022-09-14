package com.example.kotlin.view.fragments.HomeCycle

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.runtime.mutableStateListOf
import com.example.kotlin.R
import com.example.kotlin.view.fragments.BaseFragment
import java.sql.DriverManager.println
import java.util.*

class HomeFragment : Fragment() {
    private var root: View? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_home, container, false)
        main()
        return root

    }

    private fun main() {
        var list= mutableStateListOf<String>()
        list[0]="ali"
        list[1]="noor"
        Log.d("sddddd", "$list")
    }
}