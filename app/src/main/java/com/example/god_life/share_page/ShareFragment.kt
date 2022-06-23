package com.example.god_life.share_page

import android.content.Intent
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
import com.example.god_life.setting_page.SettingFragment
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayout

class ShareFragment() : Fragment() {
    private lateinit var binding:FragmentShareBinding
    private lateinit var boardFragment: ShareBoardFragment
    private lateinit var pictureFragment: PictureFragment
    private lateinit var chatFragment: ChatFragment

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


        boardFragment = ShareBoardFragment()
        pictureFragment = PictureFragment()
        chatFragment = ChatFragment()

        initView()
    }
    private fun initView(){
        changeFragment(boardFragment)
        binding.dailyAddButton.setOnClickListener{
            startActivity(Intent(context, WriteBoardActivity::class.java))
        }
        binding.tbShare.addOnTabSelectedListener(
            object: TabLayout.OnTabSelectedListener {
                override fun onTabReselected(tab: TabLayout.Tab?) {
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                }

                override fun onTabSelected(tab: TabLayout.Tab?) {
                    when (tab!!.position) {
                        0 -> {changeFragment(boardFragment)
                        binding.dailyAddButton.visibility = View.VISIBLE
                    }
                        1 -> {changeFragment(pictureFragment)
                        binding.dailyAddButton.visibility = View.VISIBLE
                    }
                        2 -> {
                            changeFragment(chatFragment)
                            binding.dailyAddButton.visibility = View.GONE
                        }
                    }
                }
            }
        )
    }

    private fun changeFragment(fragment: Fragment) {
        val transaction = fragmentManager?.beginTransaction()
        transaction?.replace(R.id.shareFrame, fragment)
        transaction?.commit()
    }
}
