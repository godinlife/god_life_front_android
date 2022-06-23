package com.example.god_life.setting_page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.god_life.R
import com.example.god_life.databinding.FragmentSettingBinding
import com.google.android.material.appbar.AppBarLayout

class SettingFragment(val abMain: AppBarLayout) : Fragment() {
    private lateinit var binding:FragmentSettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initRecyclerView()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentSettingBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun initRecyclerView(){

    }
}