package com.example.god_life

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import com.example.god_life.databinding.ActivitySignupBinding
import java.util.regex.Pattern

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
            if(checkEmail()){
                Toast.makeText(this,"이메일 인증 클릭",Toast.LENGTH_SHORT).show()
            }
        }
        binding.signupPhoneCheck.setOnClickListener{
            if(checkPhone()) {
                Toast.makeText(this, "폰 인증 클릭", Toast.LENGTH_SHORT).show()
            }
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
            if(checkForm()){
                Toast.makeText(this,"다음",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun checkForm():Boolean{

        //TODO : 이메일체크, 인증번호 체크
        if(binding.signupPw.text.isBlank() || binding.signupPwCheck.text.isBlank()
            || binding.signupName.text.isBlank() || binding.signupPhone.text.isBlank()
            || binding.signupPhoneCheckNumber.text.isBlank() || binding.signupBirth.text.isBlank()
            || !(binding.signupMan.isChecked || binding.signupMan.isChecked)){
            Toast.makeText(this,"항목을 모두 입력해주세요",Toast.LENGTH_SHORT).show()
        } else if(binding.signupPw.text.toString() != binding.signupPwCheck.text.toString()){
            Toast.makeText(this,"비밀번호를 확인해주세요",Toast.LENGTH_SHORT).show()
        } else if(!binding.signupAgree1.isChecked || !binding.signupAgree2.isChecked){
            Toast.makeText(this,"이용 약관 및 개인정보 취급방침에 동의해주세요",Toast.LENGTH_SHORT).show()
        } else if(!checkEmail() || !checkPhone()){
            return false
        } else if(binding.signupBirth.text.toString().length != 8 || !binding.signupBirth.text.toString().isDigitsOnly()){
            Toast.makeText(this,"생년월일을 확인해주세요",Toast.LENGTH_SHORT).show()
        } else{
            return true
        }
        return false
    }
    private fun checkEmail(): Boolean {
        if(!Patterns.EMAIL_ADDRESS.matcher(binding.signupEmail.text).matches()){
            Toast.makeText(this,"이메일을 확인해주세요",Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
    private fun checkPhone():Boolean{
        if(!Patterns.PHONE.matcher(binding.signupPhone.text).matches()){
            Toast.makeText(this,"휴대폰번호를 확인해주세요",Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}