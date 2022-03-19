package com.example.challenge_w1

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.signup_screen)

        val button = findViewById<Button>(R.id.button_signup)

        button.setOnClickListener{
            var intent:Intent = Intent(this,LoginActivity::class.java)

            this.startActivity(intent)
        }
    }
}