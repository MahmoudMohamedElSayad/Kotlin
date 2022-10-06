package com.example.kotlin.view.fragments.homeCycle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import butterknife.ButterKnife
import com.example.kotlin.R
import com.example.kotlin.databinding.FragmentHomeBinding
import com.example.kotlin.view.fragments.BaseFragment

class HomeFragment : BaseFragment() {
    private lateinit var binding: FragmentHomeBinding
    lateinit var root:View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        root = binding.root
        ButterKnife.bind(this, root)
        initData(root)
        return root
    }

    private fun initData(root: View) {
       binding.calculateBtu.setOnClickListener {
            val bundle = Bundle()
            Navigation.findNavController(root).navigate(R.id.moreFragment,bundle)
        }
    }

    override fun onBack() {
        requireActivity().finish()
    }
}