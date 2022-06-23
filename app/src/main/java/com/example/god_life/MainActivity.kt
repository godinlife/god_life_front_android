package com.example.god_life

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.god_life.add_page.AddFragment
import com.example.god_life.databinding.ActivityMainBinding
import com.example.god_life.meet_page.MeetFragment
import com.example.god_life.setting_page.SettingFragment
import com.example.god_life.share_page.ShareFragment
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    private lateinit var homeFragment: HomeFragment
    private lateinit var shareFragment: ShareFragment
    private lateinit var settingFragment: SettingFragment
    private lateinit var addFragment: AddFragment
    private lateinit var meetFragment: MeetFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        homeFragment = HomeFragment(binding.abMain)
        shareFragment = ShareFragment(binding.abMain)
        settingFragment = SettingFragment(binding.abMain)
        addFragment = AddFragment(binding.abMain)
        meetFragment = MeetFragment(binding.abMain)

        binding.abMain
        initView()

    }


    private fun initView(){
        changeFragment(homeFragment)
        binding.mainNavigation.setScrollPosition(2,0f,true)

        binding.mainNavigation.addOnTabSelectedListener(
            object: TabLayout.OnTabSelectedListener {
                override fun onTabReselected(tab: TabLayout.Tab?) {
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                }

                override fun onTabSelected(tab: TabLayout.Tab?) {
                    when (tab!!.position) {
                        0 -> changeFragment(shareFragment)
                        1 -> changeFragment(meetFragment)
                        3 -> changeFragment(addFragment)
                        4 -> changeFragment(settingFragment)
                    }
                }
            }
        )
        binding.mnHome.setOnClickListener{
            changeFragment(homeFragment)
            binding.mainNavigation.setScrollPosition(2,0f,true)
        }
        binding.tbMainBack.setOnClickListener{
            onBackPressed()
        }
    }


    private fun changeFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.mainFrame, fragment)
        transaction.commit()

    }
}