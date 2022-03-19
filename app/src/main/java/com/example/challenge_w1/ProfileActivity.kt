package com.example.challenge_w1

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.profile_screen)

        val info = findViewById<TextView>(R.id.info)

        val bundle =intent.extras

        var email=""
        var password=""


        bundle?.let {
            email= bundle.getString("EMAIL").toString()
            password =bundle.getString("PASSWORD").toString()
        }
        info.text=email+"  "+password

    }
}