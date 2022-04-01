package com.example.challenge_android_w3

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore


class DataStore (val context:Context) {
    private val Context.dataUser : DataStore<Preferences> by preferencesDataStore("user_key")

    companion object{
        var USER_NAME_KEY = toString()
        var USER_EMAIL_KEY = toString()
        var USER_PASS_KEY = toString()
        var USER_PHONE_KEY = toString()

    }

    suspend fun changeDataUser(name: String, email: String, pass: String){
        context.dataUser.edit {
            USER_NAME_KEY = name
            USER_EMAIL_KEY = email
            USER_PASS_KEY = pass
            USER_PHONE_KEY = "0375559***"
        }
    }
}