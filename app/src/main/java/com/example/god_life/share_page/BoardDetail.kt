package com.example.god_life.share_page

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.god_life.*
import com.example.god_life.HomeHotViewHolder
import com.example.god_life.databinding.*

class BoardDetail : AppCompatActivity() {
    private lateinit var binding:ActivityBoardDetailBinding
    private lateinit var imgAdapter: ImgAdapter
    private lateinit var commentAdapter: CommentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBoardDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initView()
        initRecyclerView()
    }
    private fun initView(){
        binding.boardDetailTitle.text = "글 제목"
        binding.boardDetailText.text = "글 본문"
        binding.boardDetailLikeSum.text = "123"
        binding.boardDetailCommentSum.text = "321"
        binding.boardDetailCommentSumUnder.text = "321"
        Glide.with(applicationContext).load("https://picsum.photos/200/100").placeholder(R.drawable.ic_launcher_foreground).into(binding.boardDetailProfile)

        Glide.with(applicationContext).load("https://png.pngtree.com/png-clipart/20191120/original/pngtree-red-heart-icon-isolated-png-image_5045156.jpg")
            .placeholder(R.drawable.ic_launcher_foreground).into(binding.boardDetailLike)



        binding.boardDetailClose.setOnClickListener{onBackPressed()}
    }
    private fun initRecyclerView(){
        binding.rvDetailBoardImage.layoutManager = LinearLayoutManager(applicationContext,
            LinearLayoutManager.HORIZONTAL,false)
        imgAdapter = ImgAdapter()
        binding.rvDetailBoardImage.adapter = imgAdapter

        imgAdapter.setData(arrayListOf("https://picsum.photos/200/300","https://picsum.photos/300/300","https://picsum.photos/400/300","https://picsum.photos/200/100","https://picsum.photos/200/500","https://picsum.photos/200/700"
        ))

        binding.rvDetailBoardComment.layoutManager = LinearLayoutManager(applicationContext)

        commentAdapter = CommentAdapter()
        binding.rvDetailBoardComment.adapter = commentAdapter
        binding.rvDetailBoardComment.addItemDecoration(DividerItemDecoration(applicationContext,1))

        commentAdapter.setData(arrayListOf(
        CommentData("user name","https://picsum.photos/200/300","2022 hecathon","2022-06-22" ),
        CommentData("user name","https://picsum.photos/200/300","2022 hecathon","2022-06-22" ),
        CommentData("user name","https://picsum.photos/200/300","2022 hecathon","2022-06-22" ),
        CommentData("user name","https://picsum.photos/200/300","2022 hecathon","2022-06-22" ),
        CommentData("user name","https://picsum.photos/200/300","2022 hecathon","2022-06-22" )
        ))

    }
}

class ImgAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val data: ArrayList<String> = arrayListOf()

    fun setData(data:ArrayList<String>){
        val prev = this.data.size
        this.data.clear()
        notifyItemRangeRemoved(0, prev)

        this.data.addAll(data)
        notifyItemRangeInserted(0, data.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ImgViewHolder(
            RowBoardDetailImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            ))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ImgViewHolder).bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}

class CommentAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val data: ArrayList<CommentData> = arrayListOf()

    fun setData(data:ArrayList<CommentData>){
        val prev = this.data.size
        this.data.clear()
        notifyItemRangeRemoved(0, prev)

        this.data.addAll(data)
        notifyItemRangeInserted(0, data.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CommentViewHolder(
            RowBoardDetailCommentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            ))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CommentViewHolder).bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}


class ImgViewHolder(private val binding: RowBoardDetailImageBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(data:String){
        Glide.with(binding.root).load(data).placeholder(R.drawable.ic_launcher_foreground).into(binding.rowBoardDetailImage)

        binding.root.setOnClickListener{
//            onClickListener?.let { it(data.id,data.name,data.term) }
        }
    }
}

class CommentViewHolder(private val binding: RowBoardDetailCommentBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(data:CommentData){
        Glide.with(binding.root).load(data.image).placeholder(R.drawable.ic_launcher_foreground).into(binding.rowBoardDetailCommentProfile)
        binding.rowBoardDetailCommentName.text = data.name
        binding.rowBoardDetailCommentDate.text = data.date
        binding.rowBoardDetailCommentText.text = data.text
    }
}

data class CommentData(
    var name:String,
    var image:String,
    var text:String,
    var date:String
)