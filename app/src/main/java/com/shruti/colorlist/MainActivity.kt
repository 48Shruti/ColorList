package com.shruti.colorlist

import android.app.Dialog
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.core.graphics.toColor
import com.shruti.colorlist.databinding.ActivityMainBinding
import com.shruti.colorlist.databinding.CustomDialogBinding
import com.github.dhaval2404.colorpicker.ColorPickerDialog
import com.github.dhaval2404.colorpicker.model.ColorShape

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var dialog: Dialog
    lateinit var dialogBinding: CustomDialogBinding
    lateinit var listAdapter: ListAdapter
    var number = 0
    var color1: String = ""
    var color2: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        SingletonObject.sharedPrefs.initPreference(this)
        number = SingletonObject.sharedPrefs.getInt("itemCount") ?: 0
        color1 = SingletonObject.sharedPrefs.getString("color1") ?: "#ffffff"
        color2 = SingletonObject.sharedPrefs.getString("color2") ?: "#ffffff"
        listAdapter = ListAdapter()
        listAdapter.updateView(color1 =color1, color2 = color2, item = number)
        binding.listview.adapter = listAdapter
        binding.mainactivity = this
        binding.show = true


    }

    fun buttonClick() {
        print("Click Dialog")
        dialog = Dialog(this)
        dialogBinding = CustomDialogBinding.inflate(layoutInflater)
        dialogBinding.colorFirst = color1
        dialogBinding.colorSecond = color2
        dialogBinding.etnumber.setText(number.toString())
        dialogBinding.mainActivity = this
        //   dialogBinding.etcolorfirst.setText(SingletonObject.sharedPrefs.getString("color1"))
        // dialogBinding.etcolorsecond.setText(SingletonObject.sharedPrefs.getString("color2"))
        dialog.setContentView(dialogBinding.root)
        dialog.getWindow()?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.show()
    }

    fun save() {
        //validations
        if (dialogBinding.colorFirst?.isEmpty() == true) {
            dialogBinding.tvcolorfirst.error = "Enter color1"
        } else if (dialogBinding.colorSecond?.isEmpty() == true) {
            dialogBinding.tvcolorsecond.error = "Enter color2"
        } else if (dialogBinding.etnumber.text.isEmpty()) {
            dialogBinding.etnumber.error = "Enter number"
        } else {
            SingletonObject.sharedPrefs.saveString("color1", dialogBinding.colorFirst ?: "")
            SingletonObject.sharedPrefs.saveString("color2", dialogBinding.colorSecond ?: "")
            SingletonObject.sharedPrefs.saveInt(
                "itemCount",
                dialogBinding.etnumber.text.toString().toInt()
            )
            color1 = SingletonObject.sharedPrefs.getString("color1")
            color2 = SingletonObject.sharedPrefs.getString("color2")
            number = SingletonObject.sharedPrefs.getInt("itemCount")
            listAdapter.updateView(color1 =color1, color2 = color2, item = number)
            listAdapter.notifyDataSetChanged()
            dialog.dismiss()
        }
    }

    fun saveColor(type: Int) {
        ColorPickerDialog
            .Builder(this)                        // Pass Activity Instance
            .setTitle("Pick Theme")            // Default "Choose Color"
            .setColorShape(ColorShape.SQAURE)   // Default ColorShape.CIRCLE
            .setDefaultColor(R.color.white)     // Pass Default Color
            .setColorListener { color, colorHex ->
                System.out.println(color)
                if (type == 1) {
                    dialogBinding.colorFirst = colorHex
                } else {
                    dialogBinding.colorSecond = colorHex
                }
            }
            .show()
    }
    fun clearData(){
        SingletonObject.sharedPrefs.clearData()
        color1 = SingletonObject.sharedPrefs.getString("color1")
        color2 = SingletonObject.sharedPrefs.getString("color2")
        number = SingletonObject.sharedPrefs.getInt("itemCount")
        listAdapter.updateView(color1 =color1, color2 = color2, item = number)
    }
}


