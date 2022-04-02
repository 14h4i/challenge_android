package com.team12.android_challenge_w4.common

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import com.team12.android_challenge_w4.R
import com.team12.android_challenge_w4.databinding.DialogEditInfoBinding


class EditDialog(context: Context, private val title: String, private val hint: String, private val initData:String) :
    AlertDialog(context) {
    private lateinit var binding: DialogEditInfoBinding
    private lateinit var editDialogCallback: EditDialogCallback

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.dialog_edit_info,
            null,
            false
        )
        setContentView(binding.root)


        binding.apply {
            tvDialogTitle.text = title
            edtBase.setText(initData)
            edtBase.hint = hint
            btnCancel.setOnClickListener {
                dismiss()
            }
            btnConfirm.setOnClickListener {
                editDialogCallback.onConfirmClicked(edtBase.text.toString())
                dismiss()
            }
        }
    }

    fun setEditDialogCallback(editDialogCallback: EditDialogCallback) {
        this.editDialogCallback = editDialogCallback
    }

    interface EditDialogCallback {
        fun onConfirmClicked(data: String)
    }
}