package com.example.challenge_android_w3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.challenge_android_w3.databinding.SignupScreenBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: SignupScreenBinding
    private lateinit var viewModel: SignupViewModel
    private lateinit var dataStore: DataStore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.signup_screen)
        viewModel= ViewModelProvider(this).get(SignupViewModel::class.java)
        dataStore = DataStore(this)

        binding.loginTextBtn.setOnClickListener{
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
        binding.btnSignup.setOnClickListener{
            val email = binding.signupEmail.text.toString().trim()
            val password = binding.signupPass.text.toString().trim()
            viewModel.checkEmailAndPassword(email, password)
        }
        listenerSuccessEvent()
        listenerFailureEvent()

    }

    private fun listenerSuccessEvent(){
        viewModel.isSuccessEvent.observe(this){ isSuccess->
            if(isSuccess){
                val intent= Intent(this, LoginActivity::class.java)
                CoroutineScope(Dispatchers.IO).launch {
                    dataStore.changeDataUser(
                        binding.signupName.text.toString().trim(),
                        binding.signupEmail.text.toString().trim(),
                        binding.signupPass.text.toString().trim()
                    )
                }
                startActivity(intent)
            }
        }
    }
    private fun listenerFailureEvent(){
        viewModel.isFailureEvent.observe(this){err ->
            AppToast(this).showMsg(err)
        }
    }


}