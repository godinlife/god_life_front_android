package com.example.god_life.share_page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.god_life.HomeFindViewHolder
import com.example.god_life.HomeHotViewHolder
import com.example.god_life.HomeProfile
import com.example.god_life.R
import com.example.god_life.databinding.FragmentShareBinding
import com.example.god_life.databinding.RowHomeFindBinding
import com.example.god_life.databinding.RowHomeHotBinding
import com.google.android.material.appbar.AppBarLayout

class ShareFragment(val abMain: AppBarLayout) : Fragment() {
    private lateinit var binding:FragmentShareBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initRecyclerView()


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentShareBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun initRecyclerView(){

    }
}
//class ShareAdapater : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//    private val data: ArrayList<ShareCategory> = arrayListOf()
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        return HomeFindViewHolder(
//            RowHomeFindBinding.inflate(
//                LayoutInflater.from(parent.context),
//                parent, false
//            ))
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        if(isHot)
//            (holder as HomeHotViewHolder).bind(data[position])
//        else
//            (holder as HomeFindViewHolder).bind(data[position])
//    }
//
//    override fun getItemCount(): Int {
//        return data.size
//    }
//}
//class HomeHotViewHolder(private val binding: RowSHomeHotBinding): RecyclerView.ViewHolder(binding.root) {
//
//}
//data class ShareCategory(
//    var image:Int,
//    var name:String
//)