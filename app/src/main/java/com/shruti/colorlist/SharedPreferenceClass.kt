package com.shruti.colorlist

import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceClass {
     var sharedPrefs : SharedPreferences?= null
     var editor : SharedPreferences.Editor? = null
    fun initPreference(context: Context){
        if (sharedPrefs== null){
            sharedPrefs = context.getSharedPreferences(context.resources.getString(R.string.app_name),Context.MODE_PRIVATE)
            editor = sharedPrefs?.edit()
        }
    }
    fun saveString(key : String,value :String){
        editor?.putString(key,value)
        editor?.commit()
    }
    fun getString(name: String): String{
     return sharedPrefs?.getString(name ,"")?:""
    }
    fun clear(){
        editor?.commit()
        editor?.clear()
    }
}