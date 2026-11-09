package com.anshul.section12

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class CountryAdapter(
    private val countryNameList: ArrayList<String>,
    private val countryDetailsList: ArrayList<String>,
    private val imageList: ArrayList<Int>,
    private val context: Context) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    class CountryViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {

        val textViewCountryName : TextView = itemView.findViewById(R.id.countryname)
        val textViewCountryDetails : TextView = itemView.findViewById(R.id.textviewdetails)
        val imageView : CircleImageView = itemView.findViewById(R.id.profile_image)
        val cardView : CardView = itemView.findViewById(R.id.cardViewid)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle_view_card_design,parent,false)
        return CountryViewHolder(view)

    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        if (position < countryNameList.size && position < countryDetailsList.size && position < imageList.size) {
            holder.textViewCountryName.text = countryNameList[position]
            holder.textViewCountryDetails.text = countryDetailsList[position]
            holder.imageView.setImageResource(imageList[position])
            holder.cardView.setOnClickListener {
                Toast.makeText(context, "You selected ${countryNameList[position]}", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun getItemCount(): Int {
        return countryNameList.size

    }

}