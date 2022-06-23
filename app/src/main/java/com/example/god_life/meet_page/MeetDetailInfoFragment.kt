package com.example.god_life.meet_page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.god_life.R
import com.example.god_life.databinding.FragmentMeetDetailInfoBinding
import com.example.god_life.databinding.FragmentPictureBinding
import com.example.god_life.databinding.RowMeetDetailInfoBinding
import com.example.god_life.databinding.RowPictureBinding
import com.example.god_life.share_page.ImgAdapter
import com.example.god_life.share_page.PictureAdapter

class MeetDetailInfoFragment : Fragment() {
    private lateinit var binding: FragmentMeetDetailInfoBinding
    private lateinit var adapter: MeetInfoAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMeetDetailInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        initRecyclerView()
    }
    private fun initRecyclerView(){
        Glide.with(binding.root).load("https://picsum.photos/200/300").placeholder(R.drawable.ic_launcher_foreground).into(binding.meetDetailInfoImage)

        binding.rvmeetDetailInfo.layoutManager = LinearLayoutManager(requireContext())
        adapter = MeetInfoAdapter()
        binding.rvmeetDetailInfo.adapter = adapter

        adapter.setData(arrayListOf(
            MeetInfoMember("suadee",true, "https://picsum.photos/200/300", "열정 열정 열정"),
            MeetInfoMember("suadee",true, "https://picsum.photos/200/300", "열정 열정 열정"),
            MeetInfoMember("suadee",false, "https://picsum.photos/200/300", "열정 열정 열정"),
            MeetInfoMember("suadee",false, "https://picsum.photos/200/300", "열정 열정 열정"),
            MeetInfoMember("suadee",false, "https://picsum.photos/200/300", "열정 열정 열정"),
        ))
    }
}

class MeetInfoAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val data: ArrayList<MeetInfoMember> = arrayListOf()

    fun setData(data:ArrayList<MeetInfoMember>){
        val prev = this.data.size
        this.data.clear()
        notifyItemRangeRemoved(0, prev)

        this.data.addAll(data)
        notifyItemRangeInserted(0, data.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MeetInfoViewHolder(
            RowMeetDetailInfoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            ))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MeetInfoViewHolder).bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}
class MeetInfoViewHolder(private val binding: RowMeetDetailInfoBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(data :MeetInfoMember){
//        Glide.with(binding.root).load(data).placeholder(R.drawable.ic_launcher_foreground).into(binding.rowPicture)
    }
}
data class MeetInfoMember(
    var name:String,
    var isAdmin:Boolean,
    var profile:String,
    var text:String
)