package com.example.god_life.meet_page

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.god_life.R
import com.example.god_life.databinding.*
import com.google.android.material.appbar.AppBarLayout

class MeetFragment(val abMain: AppBarLayout) : Fragment() {
    private lateinit var binding:FragmentMeetBinding
    private lateinit var categoryAdapter: MeetCategoryAdapter
    private lateinit var classAdapter: MeetClassAdapter
    private var categoryLimit:Boolean = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentMeetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
    }

    private fun initRecyclerView(){
        binding.rvMeetCategory.layoutManager = GridLayoutManager(requireContext(),4)
        categoryAdapter = MeetCategoryAdapter()
        binding.rvMeetCategory.adapter = categoryAdapter
        binding.rvMeetCategory.setOnTouchListener(null)

        categoryAdapter.setData(arrayListOf(
            MeetCategoryData(R.color.black_A200, "사교/모임"),
            MeetCategoryData(R.color.black_A500, "운동"),
            MeetCategoryData(R.color.black_A700, "연애/결혼"),
            MeetCategoryData(R.color.colorOnPrimary, "E-스포츠"),
            MeetCategoryData(R.color.colorSecondaryVariant, "미술"),
            MeetCategoryData(R.color.purple_500, "반려동물"),
            MeetCategoryData(R.color.gray_700, "독서활동"),
            MeetCategoryData(R.color.purple_700, "외국어 공부"),
            MeetCategoryData(R.color.white_200, "문화생활"),
            MeetCategoryData(R.color.colorPrimaryVariant, "악기"),
        ))

        binding.meetCategoryButton.setOnClickListener{
//            categoryLimit = !categoryLimit
//            categoryAdapter.limitData(categoryLimit)
        }
        binding.rvMeetClass.layoutManager = LinearLayoutManager(requireContext())
        classAdapter = MeetClassAdapter()
        binding.rvMeetClass.adapter = classAdapter

        classAdapter.setData(arrayListOf(
            MeetClassData(R.color.black_A700, "미슐랭 가이드",7,false,true,"https://picsum.photos/200/300","일주일에 한 번, 야외에서 수채화",17, "서울 송파구"),
            MeetClassData(R.color.black_A700, "미슐랭 가이드",7,true,false,"https://picsum.photos/200/300","일주일에 한 번, 야외에서 수채화",17, "서울 송파구"),
            MeetClassData(R.color.black_A700, "미슐랭 가이드",6,false,true,"https://picsum.photos/200/300","일주일에 한 번, 야외에서 수채화",17, "서울 송파구"),
            MeetClassData(R.color.black_A700, "미슐랭 가이드",3,false,true,"https://picsum.photos/200/300","일주일에 한 번, 야외에서 수채화",17, "서울 송파구"),
            MeetClassData(R.color.black_A700, "미슐랭 가이드",1,false,true,"https://picsum.photos/200/300","일주일에 한 번, 야외에서 수채화",17, "서울 송파구"),
            MeetClassData(R.color.black_A700, "미슐랭 가이드",7,false,true,"https://picsum.photos/200/300","일주일에 한 번, 야외에서 수채화",17, "서울 송파구"),
        ))
    }
}

class MeetCategoryAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val data: ArrayList<MeetCategoryData> = arrayListOf()
    companion object {
        val LIMIT: Int = 8
    }

    fun setData(data:ArrayList<MeetCategoryData>){
        val prev = this.data.size
        this.data.clear()
        notifyItemRangeRemoved(0, prev)

        this.data.addAll(data)
        notifyItemRangeInserted(0, LIMIT)
    }
    fun limitData(isLimit:Boolean){
        if(isLimit){
            notifyItemRangeRemoved(LIMIT, data.size-LIMIT)
        }else{
            notifyItemRangeInserted(LIMIT, data.size)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MeetCategoryViewHolder(
            RowMeetCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            ))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MeetCategoryViewHolder).bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}

class MeetClassAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val data: ArrayList<MeetClassData> = arrayListOf()

    fun setData(data:ArrayList<MeetClassData>){
        val prev = this.data.size
        this.data.clear()
        notifyItemRangeRemoved(0, prev)

        this.data.addAll(data)
        notifyItemRangeInserted(0, data.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MeetClassViewHolder(
            RowMeetClassBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            ))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MeetClassViewHolder).bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}

class MeetCategoryViewHolder(private val binding: RowMeetCategoryBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(data: MeetCategoryData){
        binding.rowMeetCategoryImage.setImageResource(data.image)
        binding.rowMeetCategoryName.text = data.name
    }
}
class MeetClassViewHolder(private val binding: RowMeetClassBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(data: MeetClassData){

        binding.rowMeetClassCategory.setImageResource(data.categoryImage)
        binding.rowMeetClassName.text = data.name
        binding.rowMeetClassLevel.text = "갓생레벨${data.level}"
        Glide.with(binding.root).load(data.image).placeholder(R.drawable.ic_launcher_foreground).into(binding.rowMeetClassImage)
        binding.rowMeetClassText.text = data.text
        binding.rowMeetClassNumber.text = "${data.number}명"
        binding.rowMeetClassLocate.text = data.locate

        if(data.isHot){
            binding.rowMeetClassHot.visibility = View.VISIBLE
            binding.rowMeetClassNew.visibility = View.GONE
        }
        else if(data.isNew){
            binding.rowMeetClassHot.visibility = View.GONE
            binding.rowMeetClassNew.visibility = View.VISIBLE
        }
        else{
            binding.rowMeetClassHot.visibility = View.GONE
            binding.rowMeetClassNew.visibility = View.GONE
        }

        levelColor(data.level)

        binding.root.setOnClickListener{
//            onClickListener?.let { it(data.id,data.name,data.term) }
        }
    }

    private fun levelColor(level:Int){
        binding.rowMeetClassLevel.setTextColor(
            when {
                level < 3 -> Color.YELLOW
                level < 5 -> Color.CYAN
                level < 7 -> Color.GREEN
                else -> Color.RED
            }
        )
    }
}


data class MeetCategoryData(
    var image:Int,
    var name:String
)
data class MeetClassData(
    var categoryImage:Int,
    var name:String,
    var level:Int,
    var isNew:Boolean,
    var isHot:Boolean,
    var image:String,
    var text:String,
    var number:Int,
    var locate:String
)