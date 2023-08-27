package com.shruti.colorlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class ListAdapter(var item: ArrayList<Student>) : BaseAdapter() {
    override fun getCount(): Int {
        return item.size
    }

    override fun getItem(p0: Int): Any {
       return 1
    }

    override fun getItemId(p0: Int): Long {
        return 1L
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
      var view = LayoutInflater.from(p2?.context).inflate(R.layout.)
    }
}