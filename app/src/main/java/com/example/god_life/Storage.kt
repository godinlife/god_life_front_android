package com.example.god_life

import android.content.Context
import androidx.appcompat.app.AppCompatActivity

class Storage(var context: Context) {
    companion object{
        const val PATH = "storage"
    }

    private val preference = context.getSharedPreferences(PATH, AppCompatActivity.MODE_PRIVATE)
    private val editPreference = preference.edit()

    fun loadData(){

    }
    fun setLoginInfo(){

    }
}