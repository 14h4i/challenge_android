package com.example.challenge_android_w3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignupViewModel :ViewModel() {
    private var _isSuccessEvent: MutableLiveData<Boolean> = MutableLiveData()
    val isSuccessEvent: LiveData<Boolean>
        get() = _isSuccessEvent

    private var _isFailureEvent: MutableLiveData<String> = MutableLiveData()
    val isFailureEvent: LiveData<String>
        get() = _isFailureEvent

    fun checkEmailAndPassword(email: String, password: String) {
        val isValidEmail = isEmailValid(email)
        if (!isValidEmail) {
            _isFailureEvent.postValue("Email không hợp lệ!")
            return
        }
        val isValidPassword = isPasswordValid(password)
        if (!isValidPassword) {
            _isFailureEvent.postValue("Password không hợp lệ!")
            return
        }
        _isSuccessEvent.postValue(true)
    }
    private fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    private fun isPasswordValid(password: String): Boolean {
        return password.length in 6..12
    }
}