package com.example.challenge_w1

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class LoginActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.login_screen)

        val button = findViewById<Button>(R.id.button_login)

        val bundle = Bundle()

        val inputEmail = findViewById<TextInputEditText>(R.id.input_email)
        val inputPassword = findViewById<TextInputEditText>(R.id.input_password)


        button.setOnClickListener{
            bundle.putString("EMAIL", inputEmail.text.toString())
            bundle.putString("PASSWORD",inputPassword.text.toString())
            var intent: Intent = Intent(this,ProfileActivity::class.java)
            intent.putExtras(bundle)
            this.startActivity(intent)
        }
    }
}