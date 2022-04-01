package com.example.challenge_android_w3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.challenge_android_w3.databinding.LoginScreenBinding

class LoginActivity :AppCompatActivity() {
    private lateinit var binding :LoginScreenBinding
    private lateinit var viewModel: LoginViewModel
    private var appToast: AppToast = AppToast(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.login_screen)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.signupTextBtn.setOnClickListener{
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
        binding.loginBtn.setOnClickListener{
            val userNameVal = binding.inputEmail.editText?.text?.trim().toString()
            val passwordVal = binding.inputPass.editText?.text?.trim().toString()
            viewModel.checkEmailAndPassword(userNameVal,passwordVal)

        }
        listenerFailureEvent()
        listenerSuccessEvent()
    }
    private fun listenerSuccessEvent(){
        viewModel.isSuccessEvent.observe(this){ isSuccess ->
            if(isSuccess){
                if(checkDataStore()) {
                    appToast.showMsg("Đăng nhập thành công!")

                    val intent: Intent = Intent(this, ProfileActivity::class.java)
                    val userEmailVal = binding.inputEmail.editText?.text?.trim().toString()
                    intent.putExtra("useremail", userEmailVal)
                    startActivity(intent)
                }
                else {
                    appToast.showMsg("Sai email hoặc password!")
                }
            }
        }
    }

    private fun listenerFailureEvent(){
        viewModel.isFailureEvent.observe(this){ err ->
            appToast.showMsg(err)
        }
    }

    private fun checkDataStore(): Boolean {
        val userNameValInput = binding.inputEmail.editText?.text?.trim().toString()
        val passwordValInput = binding.inputPass.editText?.text?.trim().toString()
        val userNameValDataStore = DataStore.USER_EMAIL_KEY
        val passwordValDataStore = DataStore.USER_PASS_KEY
        if (userNameValInput == userNameValDataStore && passwordValInput == passwordValDataStore) return true
        return false
    }
}