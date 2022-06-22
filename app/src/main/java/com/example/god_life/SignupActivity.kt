package com.example.god_life

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.god_life.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListener()

    }
    fun initListener(){
        binding.tbSignupBack.setOnClickListener{
            onBackPressed()
        }
        binding.signupEmailCheck.setOnClickListener{
            Toast.makeText(this,"이메일 인증 클릭",Toast.LENGTH_SHORT).show()
        }
        binding.signupPhoneCheck.setOnClickListener{
            Toast.makeText(this,"폰 인증 클릭",Toast.LENGTH_SHORT).show()
        }
        binding.signupAllAgree.setOnCheckedChangeListener{ _, checked:Boolean ->
            if(checked){
                binding.signupAgree1.isChecked = true
                binding.signupAgree2.isChecked = true
                binding.signupAgree3.isChecked = true
            }
        }
        binding.signupAgree1.setOnCheckedChangeListener{ _, checked:Boolean ->
            if(!checked)
                binding.signupAllAgree.isChecked = false
        }
        binding.signupAgree2.setOnCheckedChangeListener{ _, checked:Boolean ->
            if(!checked)
                binding.signupAllAgree.isChecked = false
        }
        binding.signupAgree3.setOnCheckedChangeListener{ _, checked:Boolean ->
            if(!checked)
                binding.signupAllAgree.isChecked = false
        }
        binding.signupAgreeView1.setOnClickListener{
            Toast.makeText(this,"동의서 보기",Toast.LENGTH_SHORT).show()
        }
        binding.signupAgreeView2.setOnClickListener{
            Toast.makeText(this,"동의서 보기",Toast.LENGTH_SHORT).show()
        }
        binding.signupAgreeView3.setOnClickListener{
            Toast.makeText(this,"동의서 보기",Toast.LENGTH_SHORT).show()
        }
        binding.signupNext.setOnClickListener{
            Toast.makeText(this,"다음",Toast.LENGTH_SHORT).show()
        }
    }
}