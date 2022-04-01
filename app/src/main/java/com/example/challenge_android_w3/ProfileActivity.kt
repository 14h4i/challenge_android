package com.example.challenge_android_w3

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.challenge_android_w3.databinding.ProfileScreenBinding
import com.example.challenge_android_w3.models.User

class ProfileActivity :AppCompatActivity() {
    private lateinit var binding: ProfileScreenBinding
    private lateinit var viewModel: ProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.profile_screen)
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        binding.user =
            User(DataStore.USER_NAME_KEY, DataStore.USER_EMAIL_KEY, DataStore.USER_PHONE_KEY)
        binding.editBtn.setOnClickListener() {
            openDialog()
        }
        binding.txtName.setOnClickListener() {
            openDialog()
        }
        binding.txtMail.setOnClickListener() {
            openDialog()
        }
        binding.txtPhone.setOnClickListener() {
            openDialog()
        }
        val intent = intent
        val email = intent.getStringExtra("useremail")

        binding.txtMail.text = email
        binding.txtName.text= DataStore.USER_NAME_KEY
        binding.txtPhone.text =DataStore.USER_PHONE_KEY

    }

    private fun openDialog() {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.dialog, null)
        val edtName = mDialogView.findViewById<EditText>(R.id.edtName)
        val edtMail = mDialogView.findViewById<EditText>(R.id.edtMail)
        val edtPhone = mDialogView.findViewById<EditText>(R.id.edtPhone)
        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
            .setPositiveButton("Summit", DialogInterface.OnClickListener { _, _ ->
                viewModel.checkEmail(edtMail.text.toString())
                listenerSuccessEvent(
                    edtName.text.toString(),
                    edtMail.text.toString(),
                    edtPhone.text.toString()
                )
                listenerErrorEvent()
                binding.txtName.text = edtName.text
                binding.txtMail.text = edtMail.text
                binding.txtPhone.text = edtPhone.text
            })
        mBuilder.show()
    }

    private fun listenerSuccessEvent(name: String, email: String, phone: String) {
        viewModel.isSuccessEvent.observe(this) { isSuccess ->
            if (isSuccess) {
                binding.user = User(name, email, phone)
            }
        }
        DataStore.USER_EMAIL_KEY = email
        DataStore.USER_NAME_KEY = name
        DataStore.USER_PHONE_KEY = phone

    }

    private fun listenerErrorEvent() {
        viewModel.isFailureEvent.observe(this) {
            AppToast(this).showMsg(it)
        }
    }
}
