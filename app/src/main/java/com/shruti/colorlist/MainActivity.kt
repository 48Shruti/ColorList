package com.shruti.colorlist

import android.app.Dialog
import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.shruti.colorlist.databinding.ActivityMainBinding
import com.shruti.colorlist.databinding.CustomDialogBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var sharedPreference : SharedPreferences
    lateinit var editor : SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
       SingletonObject.sharedPrefs.initPreference(this)
        sharedPreference = getSharedPreferences(resources.getString(R.string.app_name),Context.MODE_PRIVATE)
        editor = sharedPreference.edit()
        binding.mainactivity = this
        binding.show = true
    }

 fun ButtonClick(){
     print("Click Dialog")
     var dialog = Dialog(this)
     var dialogBinding = CustomDialogBinding.inflate(layoutInflater)
     dialog.setContentView(dialogBinding.root)
     dialog.show()
 }
}