package com.example.god_life

import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.god_life.databinding.FragmentHomeBinding
import com.example.god_life.databinding.RowHomeFindBinding
import com.example.god_life.databinding.RowHomeHotBinding
import com.google.android.material.appbar.AppBarLayout

class HomeFragment() : Fragment() {
    private lateinit var binding:FragmentHomeBinding
    private lateinit var hotAdapter: HomeAdapter
    private lateinit var findAdapter: HomeAdapter
    private var findIsAll:Boolean = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initToolbar()
        initListener()
        initRecyclerView()
    }
    private fun initToolbar(){
    }

    private fun initListener(){
        toggleFindLocate()
        binding.homeFindAll.setOnClickListener{
            toggleFindLocate()
        }
        binding.homeFindLocal.setOnClickListener{
            toggleFindLocate()
        }
    }
    private fun initRecyclerView(){
        binding.rvHomeHot.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        hotAdapter = HomeAdapter(true)
        binding.rvHomeHot.adapter = hotAdapter

        hotAdapter.setData(arrayListOf(
            HomeProfile(1,"https://picsum.photos/200/300","노지혜","서울 송파구",null,"스트릿 댄스, 카페공부"),
            HomeProfile(1,"https://picsum.photos/200/700","NO:ZE","서울 강남구",null,"스트릿 댄스, 집밥"),
            HomeProfile(1,"https://picsum.photos/700/200","로버트 다우니 주니어","미국 뉴욕주",null,"연기, 홈파티"),
            HomeProfile(1,"https://picsum.photos/200/300","노지혜","서울 송파구",null,"스트릿 댄스, 카페공부"),
        ))


        binding.rvHomeFind.layoutManager = LinearLayoutManager(requireContext())
        findAdapter = HomeAdapter(false)
        binding.rvHomeFind.adapter = findAdapter

        findAdapter.setData(arrayListOf(
            HomeProfile(1,"https://picsum.photos/200/300","김종국",null,7,"웨이트 트레이닝, 음악감상"),
            HomeProfile(1,"https://picsum.photos/200/800","김종국",null,2,"웨이트 트레이닝, 음악감상"),
            HomeProfile(1,"https://picsum.photos/800/300","김종국",null,3,"웨이트 트레이닝, 음악감상"),
            HomeProfile(1,"https://picsum.photos/200/300","김종국",null,4,"웨이트 트레이닝, 음악감상"),
            HomeProfile(1,"https://picsum.photos/200/300","김종국",null,7,"웨이트 트레이닝, 음악감상"),
            HomeProfile(1,"https://picsum.photos/200/300","김종국",null,7,"웨이트 트레이닝, 음악감상"),
        ))
    }

    private fun toggleFindLocate(){
        if(findIsAll){
            binding.homeFindAll.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            binding.homeFindLocal.setTextColor(ContextCompat.getColor(requireContext(), R.color.colorPrimary))
            binding.homeFindAll.paintFlags =  0
            binding.homeFindLocal.paintFlags = Paint.UNDERLINE_TEXT_FLAG

        }else{
            binding.homeFindAll.setTextColor(ContextCompat.getColor(requireContext(), R.color.colorPrimary))
            binding.homeFindLocal.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            binding.homeFindAll.paintFlags =  Paint.UNDERLINE_TEXT_FLAG
            binding.homeFindLocal.paintFlags =  0
        }
        findIsAll != findIsAll
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
    fun bind(data:HomeProfile){
        Glide.with(binding.root).load(data.image).placeholder(R.drawable.ic_launcher_foreground).into(binding.rowHotImage)
        binding.rowHotName.text = data.name
        binding.rowHotLocate.text = data.locate
        binding.rowHotCategory.text = data.category

        binding.root.setOnClickListener{
//            onClickListener?.let { it(data.id,data.name,data.term) }
        }
    }
}

class HomeFindViewHolder(private val binding: RowHomeFindBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(data:HomeProfile){
        Glide.with(binding.root).load(data.image).placeholder(R.drawable.ic_launcher_foreground).into(binding.rowFindImage)
        binding.rowFindName.text = data.name
        binding.rowFindLevel.text = "갓생레벨 ${data.level}"
        binding.rowFindCategory.text = data.category

        if (data.level != null) {
            levelColor(data.level!!)
        }

        binding.root.setOnClickListener{
//            onClickListener?.let { it(data.id,data.name,data.term) }
        }
    }
    private fun levelColor(level:Int){
        binding.rowFindLevel.setTextColor(
            when {
                level < 3 -> Color.YELLOW
                level < 5 -> Color.CYAN
                level < 7 -> Color.GREEN
                else -> Color.RED
            }
        )
    }
}

data class HomeProfile(
    var id:Int,
    var image:String,
    var name:String,
    var locate:String?,
    var level: Int?,
    var category: String
)
