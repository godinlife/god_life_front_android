package com.example.god_life

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.god_life.databinding.ActivityLoginBinding
import java.util.regex.Pattern


class LoginActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding
    var pattern: Pattern = Patterns.EMAIL_ADDRESS

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListener()


    }
    private fun initListener(){
        binding.loginBtn.setOnClickListener{
            if(checkForm()){
                Network().login(binding.loginId.text.toString(),binding.loginPw.text.toString()){
//                    if(){
                        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
//                        this@LoginActivity.finish()
//                    }
                }
            }
        }
        binding.loginForget.setOnClickListener{

        }
        binding.loginSignup.setOnClickListener{
            startActivity(Intent(this@LoginActivity, SignupActivity::class.java))
        }
    }
    private fun checkForm():Boolean{
        if(binding.loginId.text.isBlank() || binding.loginPw.text.isBlank()){
            Toast.makeText(this@LoginActivity, getString(R.string.login_fail_blank),Toast.LENGTH_SHORT).show()
            return false
        }else if(!pattern.matcher(binding.loginId.text).matches()){
            Toast.makeText(this@LoginActivity, getString(R.string.login_fail_email),Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}
