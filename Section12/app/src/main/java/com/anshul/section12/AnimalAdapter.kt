package com.anshul.section12


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class AnimalAdapter(
    val context: Context,
    private val nameList: ArrayList<String>,
    private val imageList: ArrayList<Int>) : BaseAdapter() {



    override fun getCount(): Int {
        return nameList.size

    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }



    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view : View = convertView?: LayoutInflater.from(parent?.context).
        inflate(R.layout.custom_layout,parent,false)

        val animalName = view.findViewById<TextView>(R.id.textView)
        val animalImage = view.findViewById<ImageView>(R.id.image)


        animalName.text = nameList[position]
        animalImage.setImageResource(imageList[position])

        return view
    }
}