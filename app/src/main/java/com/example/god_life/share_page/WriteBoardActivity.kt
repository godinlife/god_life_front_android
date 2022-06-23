package com.example.god_life.share_page

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.god_life.databinding.ActivityBoardDetailBinding
import com.example.god_life.databinding.ActivityWriteBoardBinding

class WriteBoardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWriteBoardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWriteBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }
    private fun initView(){
        val category1 = arrayOf("Aesthetics","등등")
        val category2 = arrayOf("2차 카테고리","등등")
        val adapter1 = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, category1)
        val adapter2 = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, category2)

        binding.writeBoardSpinner1.adapter = adapter1
        binding.writeBoardSpinner2.adapter = adapter2

        binding.writeBoardClose.setOnClickListener{onBackPressed()}
    }
}