package com.example.god_life.share_page

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.god_life.R
import com.example.god_life.databinding.FragmentPictureBinding
import com.example.god_life.databinding.FragmentShareBoardBinding
import com.example.god_life.databinding.RowPictureBinding
import com.example.god_life.databinding.RowShareBoardBinding
import com.example.god_life.meet_page.MeetCategoryAdapter

class PictureFragment : Fragment() {
    private lateinit var binding: FragmentPictureBinding
    private lateinit var adapter: PictureAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPictureBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        initRecyclerView()
    }
    private fun initRecyclerView(){

        binding.rvPicture.layoutManager = GridLayoutManager(requireContext(),3)
        adapter = PictureAdapter()
        binding.rvPicture.adapter = adapter

        adapter.setData(arrayListOf(
            "https://picsum.photos/200/300","https://picsum.photos/300/300","https://picsum.photos/400/300","https://picsum.photos/200/100","https://picsum.photos/200/500","https://picsum.photos/200/700"
        ))
    }
}
class PictureAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val data: ArrayList<String> = arrayListOf()

    fun setData(data:ArrayList<String>){
        val prev = this.data.size
        this.data.clear()
        notifyItemRangeRemoved(0, prev)

        this.data.addAll(data)
        notifyItemRangeInserted(0, data.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PictureViewHolder(
            RowPictureBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            ))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PictureViewHolder).bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}
class PictureViewHolder(private val binding: RowPictureBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(data :String){
        Glide.with(binding.root).load(data).placeholder(R.drawable.ic_launcher_foreground).into(binding.rowPicture)
    }
}
