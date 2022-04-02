package com.example.w2

import android.app.Dialog
import android.content.ContentValues.TAG
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class Profile_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val intent = Intent()
        val bundle = intent.extras
        bundle?.let {
            val mail = bundle.getString("mail_key")
            val Display_Mail = findViewById<TextView>(R.id.mail_ID)
            Display_Mail.text = "$mail"
        }

        val fullName = findViewById<Button>(R.id.edt_fullname)
        val mail = findViewById<Button>(R.id.edt_mail)
        val phone = findViewById<Button>(R.id.edt_phone)
        // Click full name
        fullName.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.apply {
                val inflater = layoutInflater
                val dialogLayout = inflater.inflate(R.layout.dialog_edit, null)

                builder.setView(dialogLayout)
                setMessage("Edit Infomation")
                setPositiveButton("OK"){ dialog, _ ->
                    Log.e(TAG,"hello")
                    Toast.makeText(this@Profile_Activity, "yes clicked", Toast.LENGTH_SHORT).show()
                    val editName  = dialogLayout.findViewById<EditText>(R.id.edit_name).text.toString()
                    val editMail  = dialogLayout.findViewById<EditText>(R.id.edit_mail).text.toString()
                    val editPhone  = dialogLayout.findViewById<EditText>(R.id.edit_phone).text.toString()

                    val name = findViewById<TextView>(R.id.name_ID)
                    name.text = "${editName}"
                    val mail = findViewById<TextView>(R.id.mail_ID)
                    mail.text = "${editMail}"
                    val phone = findViewById<TextView>(R.id.phone_ID)
                    phone.text = "${editPhone}"
                    dialog.dismiss()
                }
                setNegativeButton("CANCEL"){dialog, _ ->
                    dialog.dismiss()
                }
            }
            builder.show()
        }
        // Click mail
        mail.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.apply {
                val inflater = layoutInflater
                val dialogLayout = inflater.inflate(R.layout.dialog_edit, null)

                builder.setView(dialogLayout)
                setMessage("Edit Infomation")
                setPositiveButton("OK"){ dialog, _ ->
                    Log.e(TAG,"hello")
                    Toast.makeText(this@Profile_Activity, "yes clicked", Toast.LENGTH_SHORT).show()
                    val editName  = dialogLayout.findViewById<EditText>(R.id.edit_name).text.toString()
                    val editMail  = dialogLayout.findViewById<EditText>(R.id.edit_mail).text.toString()
                    val editPhone  = dialogLayout.findViewById<EditText>(R.id.edit_phone).text.toString()

                    val name = findViewById<TextView>(R.id.name_ID)
                    name.text = "${editName}"
                    val mail = findViewById<TextView>(R.id.mail_ID)
                    mail.text = "${editMail}"
                    val phone = findViewById<TextView>(R.id.phone_ID)
                    phone.text = "${editPhone}"
                    dialog.dismiss()
                }
                setNegativeButton("CANCEL"){dialog, _ ->
                    dialog.dismiss()
                }
            }
            builder.show()
        }
        // click phone
        phone.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.apply {
                val inflater = layoutInflater
                val dialogLayout = inflater.inflate(R.layout.dialog_edit, null)

                builder.setView(dialogLayout)
                setMessage("Edit Infomation")
                setPositiveButton("OK"){ dialog, _ ->
                    Log.e(TAG,"hello")
                    Toast.makeText(this@Profile_Activity, "yes clicked", Toast.LENGTH_SHORT).show()
                    val editName  = dialogLayout.findViewById<EditText>(R.id.edit_name).text.toString()
                    val editMail  = dialogLayout.findViewById<EditText>(R.id.edit_mail).text.toString()
                    val editPhone  = dialogLayout.findViewById<EditText>(R.id.edit_phone).text.toString()

                    val name = findViewById<TextView>(R.id.name_ID)
                    name.text = "${editName}"
                    val mail = findViewById<TextView>(R.id.mail_ID)
                    mail.text = "${editMail}"
                    val phone = findViewById<TextView>(R.id.phone_ID)
                    phone.text = "${editPhone}"
                    dialog.dismiss()
                }
                setNegativeButton("CANCEL"){dialog, _ ->
                    dialog.dismiss()
                }
            }
            builder.show()
        }
    }
}