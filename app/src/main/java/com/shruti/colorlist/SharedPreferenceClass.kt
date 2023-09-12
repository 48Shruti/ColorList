package com.shruti.colorlist

import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceClass {
    var sharedPrefs: SharedPreferences? = null
    var editor: SharedPreferences.Editor? = null
    fun initPreference(context: Context) {
        if (sharedPrefs == null) {
            sharedPrefs = context.getSharedPreferences(
                context.resources.getString(R.string.app_name),
                Context.MODE_PRIVATE
            )
            editor = sharedPrefs?.edit()
        }
    }

    fun saveString(key: String, value: String) {
        editor?.putString(key, value)
        editor?.commit()
        editor?.apply()
    }

    fun getString(name: String): String {
        return sharedPrefs?.getString(name, "#ffffff") ?: "#ffffff"
    }

    fun saveInt(key: String, value: Int) {
        editor?.putInt(key, value)
        editor?.commit()
        editor?.apply()
    }

    fun getInt(name: String): Int {
        return sharedPrefs?.getInt(name, 0) ?: 0
    }

    fun clearData() {
        editor?.clear()
        editor?.commit()
        editor?.apply()
    }
}