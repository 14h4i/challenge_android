package com.example.challenge_android_w3

import android.content.Context
import android.widget.Toast

class AppToast (val context: Context) {

     fun showMsg(msg:String){
        Toast.makeText( context,msg, Toast.LENGTH_SHORT).show()
    }
}