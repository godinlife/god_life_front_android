package com.example.god_life.share_page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.god_life.*
import com.example.god_life.databinding.FragmentShareBinding
import com.example.god_life.databinding.RowHomeFindBinding
import com.example.god_life.databinding.RowHomeHotBinding
import com.example.god_life.databinding.RowShareBoardBinding
import com.google.android.material.appbar.AppBarLayout

class ShareFragment(val abMain: AppBarLayout) : Fragment() {
    private lateinit var binding:FragmentShareBinding
    private lateinit var adapter: ShareBoardAdapater

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentShareBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
    }
    private fun initRecyclerView(){
        binding.rvShareBoard.layoutManager = LinearLayoutManager(requireContext())
        adapter = ShareBoardAdapater()
        binding.rvShareBoard.adapter = adapter

        adapter.setData(arrayListOf(
            ShareBoardData("https://picsum.photos/200/300","안내 근무자",7,"subtitle","texttexttexttexttexttexttexttexttexttexttexttext\ntext\ntext\ntext",
                "https://picsum.photos/200/300","https://picsum.photos/200/300",null,false,1397,237,"2022-06-22 17:00"),
            ShareBoardData("https://picsum.photos/200/300","안내 근무자",7,"fqwefqwrfasdfasdf","sdfasdfjasofijsafdasfsdadfois",
                "https://picsum.photos/200/300",null, null,true,1397,237,"2022-06-22 17:00"),
            ShareBoardData("https://picsum.photos/200/300","안내 근무자",7,"fqwefqwrfasdfasdf","sdfasdfjasofijsafdasfsdadfois",
                null, null, null,false,1397,237,"2022-06-22 17:00"),
            ShareBoardData("https://picsum.photos/200/300","안내 근무자",7,"fqwefqwrfasdfasdf","sdfasdfjasofijsafdasfsdadfois",
                "https://picsum.photos/200/300","https://picsum.photos/200/300","https://picsum.photos/200/300",false,1397,237,"2022-06-22 17:00"),
            ShareBoardData("https://picsum.photos/200/300","안내 근무자",7,"fqwefqwrfasdfasdf","sdfasdfjasofijsafdasfsdadfois",
                "https://picsum.photos/200/300","https://picsum.photos/200/300","https://picsum.photos/200/300",false,1397,237,"2022-06-22 17:00"),
        ))
    }
}

class ShareBoardAdapater : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val data: ArrayList<ShareBoardData> = arrayListOf()

    fun setData(data:ArrayList<ShareBoardData>){
        val prev = this.data.size
        this.data.clear()
        notifyItemRangeRemoved(0, prev)

        this.data.addAll(data)
        notifyItemRangeInserted(0, data.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ShareBoardViewHolder(
            RowShareBoardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            ))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ShareBoardViewHolder).bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
class ShareBoardViewHolder(private val binding: RowShareBoardBinding):RecyclerView.ViewHolder(binding.root) {
    fun bind(data :ShareBoardData){
        Glide.with(binding.root).load(data.profile).placeholder(R.drawable.ic_launcher_foreground).into(binding.rowShareBoardProfile)
        binding.rowShareBoardName.text = data.name
        binding.rowShareBoardLevel.text = "갓생레벨 ${data.level}"
        binding.rowShareBoardSubtitle.text = data.subTitle
        binding.rowShareBoardText.text = data.text
        binding.rowShareBoardLikeSum.text = data.likeSum.toString()
        binding.rowShareBoardCommentSum.text = data.commentSum.toString()
        binding.rowShareBoardDate.text = data.date

        if(data.image1 == null){
            binding.rowShareBoardImage1.visibility = View.GONE
            binding.rowShareBoardImage2.visibility = View.GONE
            binding.rowShareBoardImage3.visibility = View.GONE
        }else if(data.image2 == null){
            binding.rowShareBoardImage1.visibility = View.VISIBLE
            binding.rowShareBoardImage2.visibility = View.GONE
            binding.rowShareBoardImage3.visibility = View.GONE
            Glide.with(binding.root).load(data.image1).placeholder(R.drawable.ic_launcher_foreground).into(binding.rowShareBoardImage1)
        }else if(data.image3 == null){
            binding.rowShareBoardImage1.visibility = View.VISIBLE
            binding.rowShareBoardImage2.visibility = View.VISIBLE
            binding.rowShareBoardImage3.visibility = View.GONE
            Glide.with(binding.root).load(data.image1).placeholder(R.drawable.ic_launcher_foreground).into(binding.rowShareBoardImage1)
            Glide.with(binding.root).load(data.image2).placeholder(R.drawable.ic_launcher_foreground).into(binding.rowShareBoardImage2)

        }else{
            binding.rowShareBoardImage1.visibility = View.VISIBLE
            binding.rowShareBoardImage2.visibility = View.VISIBLE
            binding.rowShareBoardImage3.visibility = View.VISIBLE
            Glide.with(binding.root).load(data.image1).placeholder(R.drawable.ic_launcher_foreground).into(binding.rowShareBoardImage1)
            Glide.with(binding.root).load(data.image2).placeholder(R.drawable.ic_launcher_foreground).into(binding.rowShareBoardImage2)
            Glide.with(binding.root).load(data.image3).placeholder(R.drawable.ic_launcher_foreground).into(binding.rowShareBoardImage3)

        }
        if(data.isLike){
            Glide.with(binding.root).load("https://png.pngtree.com/png-clipart/20191120/original/pngtree-red-heart-icon-isolated-png-image_5045156.jpg")
                .placeholder(R.drawable.ic_launcher_foreground).into(binding.rowShareBoardLike)
        }else{
            Glide.with(binding.root).load("https://w7.pngwing.com/pngs/287/612/png-transparent-computer-icons-heart-heart-line-love-heart-black-thumbnail.png")
                .placeholder(R.drawable.ic_launcher_foreground).into(binding.rowShareBoardLike)
        }

    }

}
data class ShareBoardData(
    var profile:String,
    var name:String,
    var level:Int,
    var subTitle:String,
    var text:String,
    var image1:String?,
    var image2:String?,
    var image3:String?,
    var isLike:Boolean,
    var likeSum:Int,
    var commentSum:Int,
    var date:String
)