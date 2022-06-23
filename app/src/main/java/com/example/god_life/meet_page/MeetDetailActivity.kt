package com.example.god_life.meet_page

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.god_life.HomeFragment
import com.example.god_life.R
import com.example.god_life.add_page.AddFragment
import com.example.god_life.databinding.ActivityBoardDetailBinding
import com.example.god_life.databinding.ActivityMeetDetailBinding
import com.example.god_life.databinding.RowBoardDetailCommentBinding
import com.example.god_life.databinding.RowBoardDetailImageBinding
import com.example.god_life.setting_page.SettingFragment
import com.example.god_life.share_page.*
import com.google.android.material.tabs.TabLayout

class MeetDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMeetDetailBinding

    private lateinit var meetInfoFragment: MeetDetailInfoFragment
    private lateinit var boardFragment: ShareBoardFragment
    private lateinit var pictureFragment: PictureFragment
    private lateinit var chatFragment: ChatFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMeetDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        meetInfoFragment = MeetDetailInfoFragment()
        boardFragment = ShareBoardFragment()
        pictureFragment = PictureFragment()
        chatFragment = ChatFragment()
        initView()
    }


    private fun initView(){
        changeFragment(meetInfoFragment)
        binding.meetDetailAddButton.visibility = View.GONE

        binding.meetDetailAddButton.setOnClickListener{
            startActivity(Intent(applicationContext, WriteBoardActivity::class.java))
        }
        binding.tbMeetDetailClose.setOnClickListener{onBackPressed()}
        binding.tbMeetDetail.addOnTabSelectedListener(
            object: TabLayout.OnTabSelectedListener {
                override fun onTabReselected(tab: TabLayout.Tab?) {
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                }

                override fun onTabSelected(tab: TabLayout.Tab?) {
                    when (tab!!.position) {
                        0 -> {
                            changeFragment(meetInfoFragment)
                            binding.meetDetailAddButton.visibility = View.GONE
                        }
                        1 -> {changeFragment(boardFragment)
                            binding.meetDetailAddButton.visibility = View.VISIBLE
                        }
                        2 -> {changeFragment(pictureFragment)
                            binding.meetDetailAddButton.visibility = View.VISIBLE
                        }
                        3 -> {
                            changeFragment(chatFragment)
                            binding.meetDetailAddButton.visibility = View.GONE
                        }
                    }
                }
            }
        )
    }

    private fun changeFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.meetDetailFrame, fragment)
        transaction.commit()
    }
}
