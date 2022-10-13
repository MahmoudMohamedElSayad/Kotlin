package com.example.kotlin.view.fragments.homeCycle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import com.example.kotlin.R
import com.example.kotlin.databinding.FragmentHomeBinding
import com.example.kotlin.databinding.FragmentMoreBinding
import com.example.kotlin.view.fragments.BaseFragment
class MoreFragment : BaseFragment() {
    var navController: NavController? = null
    private lateinit var binding:FragmentMoreBinding
    lateinit var root:View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        navController = findNavController(requireActivity()!!, R.id.home_activity_fragment_normal)

        binding = FragmentMoreBinding.inflate(inflater, container, false)
        root = binding.root
        initData(root)
        return root
    }

    private fun initData(root: View) {
        binding.calculateBtu.setOnClickListener {
            val bundle = Bundle()
//            Navigation.findNavController(root).navigate(R.id.ordersDetailsFragment,bundle)
          navController!!.navigate(R.id.ordersDetailsFragment)
        }

    }

    override fun onBack() {
        super.onBack()
    }
}