package com.shruti.colorlist

object SingletonObject {
    init {
        println("in singleton init")
    }
    val sharedPrefs: SharedPreferenceClass=SharedPreferenceClass()
}