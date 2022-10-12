package com.example.kotlin.view.fragments.homeCycle
import android.os.Bundle
import android.service.autofill.UserData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import butterknife.ButterKnife
import com.example.kotlin.R
import com.example.kotlin.data.local.SharedPreferencesManger.SharedPreferencesManger.LoadUserData
import com.example.kotlin.databinding.FragmentHomeBinding
import com.example.kotlin.view.fragments.BaseFragment

class HomeFragment : BaseFragment() {
    private lateinit var binding: FragmentHomeBinding
    lateinit var root:View
    private var userData: UserData?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        root = binding.root
        getUserData()
        initData(root)
        return root
    }

    private fun getUserData() {
        userData=LoadUserData(requireActivity())

    }

    private fun initData(root: View) {
       binding.calculateBtu.setOnClickListener {
            val bundle = Bundle()
//            Navigation.findNavController(root).navigate(R.id.ordersDetailsFragment,bundle)
           root.findNavController().navigate(R.id.ordersDetailsFragment)
        }
    }

    override fun onBack() {
        requireActivity().finish()
    }
}