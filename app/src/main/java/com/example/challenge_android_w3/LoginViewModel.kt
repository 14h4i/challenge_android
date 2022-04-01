package com.example.challenge_android_w3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel :ViewModel() {
    private var _isSuccessEvent: MutableLiveData<Boolean> = MutableLiveData()
    val isSuccessEvent : LiveData<Boolean>
        get()= _isSuccessEvent

    private var _isFailureEvent:MutableLiveData<String> = MutableLiveData()
    val isFailureEvent :LiveData<String>
        get()= _isFailureEvent

    fun checkEmailAndPassword (email:String,password:String){
        val isValidEmail= isValidEmail(email)
        val isValidPassword= isValidPassword(password)
        if(!isValidEmail){
            _isFailureEvent.postValue("Email không hợp lệ!")
            return
        }
        if(!isValidPassword){
            _isFailureEvent.postValue("Password không hợp lệ!")
            return
        }
        return _isSuccessEvent.postValue(true)
    }

    private fun isValidEmail(email: String):Boolean{
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidPassword(password: String):Boolean{
        return password.length in 6..12
    }
}