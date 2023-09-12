package com.shruti.colorlist

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ListAdapter() : BaseAdapter() {
    var item : Int = 0
    var color1:String ="#ffffff"
    var color2:String = "#ffffff"
    fun updateView(item : Int , color1 : String,color2 : String){
        this.color1 = color1
        this.color2 = color2
        this.item = item
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return item
    }

    override fun getItem(p0: Int): Any {
       return 1
    }

    override fun getItemId(p0: Int): Long {
        return 1L
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
      var view = LayoutInflater.from(p2?.context).inflate(R.layout.item_view,p2,false)
        var itemColor = view.findViewById<TextView>(R.id.itemcolor)
        if (p0%2 ==0){
            itemColor.setBackgroundColor(Color.parseColor(color1))
            itemColor.setText(color1)
        }else{
            itemColor.setBackgroundColor(Color.parseColor(color2))
            itemColor.setText(color2)
        }
        return view
    }
}