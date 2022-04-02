package com.example.w2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Login_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val login = findViewById<Button>(R.id.buttonLogin)
        login.setOnClickListener {
            val edt_mail = findViewById<EditText>(R.id.inputEmail)
            val edt_password = findViewById<EditText>(R.id.inputPass)
            val mail = edt_mail.text.toString().trim()
            val password = edt_password.text.toString().trim()
            val intent = Intent(this,Profile_Activity::class.java)
            val bundle = Bundle()
            if (mail == "ronandol@gmail.com" && password == "123456"){

            bundle.putString("mail_key",mail)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }

    override fun onStart() {
        super.onStart()
    }
}