package com.example.god_life.meet_page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.god_life.HomeFindViewHolder
import com.example.god_life.HomeProfile
import com.example.god_life.R
import com.example.god_life.databinding.FragmentMeetBinding
import com.example.god_life.databinding.RowHomeFindBinding
import com.example.god_life.databinding.RowHomeHotBinding
import com.google.android.material.appbar.AppBarLayout

class MeetFragment(val abMain: AppBarLayout) : Fragment() {
    private lateinit var binding:FragmentMeetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initRecyclerView()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentMeetBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun initRecyclerView(){

    }
}

class HomeAdapter(private val isHot:Boolean): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val data: ArrayList<HomeProfile> = arrayListOf()

    fun setData(data:ArrayList<HomeProfile>){
        val prev = this.data.size
        this.data.clear()
        notifyItemRangeRemoved(0, prev)

        this.data.addAll(data)
        notifyItemRangeInserted(0, data.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if(isHot) HomeHotViewHolder(
            RowHomeHotBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            ))
        else HomeFindViewHolder(
            RowHomeFindBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            ))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(isHot)
            (holder as HomeHotViewHolder).bind(data[position])
        else
            (holder as HomeFindViewHolder).bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
class HomeHotViewHolder(private val binding: RowHomeHotBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(data: HomeProfile){
        Glide.with(binding.root).load(data.image).placeholder(R.drawable.ic_launcher_foreground).into(binding.rowHotImage)
        binding.rowHotName.text = data.name
        binding.rowHotLocate.text = data.locate
        binding.rowHotCategory.text = data.category

        binding.root.setOnClickListener{
//            onClickListener?.let { it(data.id,data.name,data.term) }
        }
    }
}