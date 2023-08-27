package com.shruti.colorlist

import android.app.Dialog
import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.shruti.colorlist.databinding.ActivityMainBinding
import com.shruti.colorlist.databinding.CustomDialogBinding
import com.github.dhaval2404.colorpicker.ColorPickerDialog
import com.github.dhaval2404.colorpicker.model.ColorShape

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
    fun buttonClick(){
     print("Click Dialog")
     var dialog = Dialog(this)
     var dialogBinding = CustomDialogBinding.inflate(layoutInflater)
     dialog.setContentView(dialogBinding.root)
        dialogBinding.etcolorfirst.setOnClickListener{
            ColorPickerDialog
                .Builder(this)        				// Pass Activity Instance
                .setTitle("Pick Theme")           	// Default "Choose Color"
                .setColorShape(ColorShape.SQAURE)   // Default ColorShape.CIRCLE
                .setDefaultColor(R.color.white)     // Pass Default Color
                .setColorListener { color, colorHex ->
                    // Handle Color Selection
                    System.out.println("color $color colorHex $colorHex")
                }
        }
     dialog.show()
 }
    fun save(){}
}