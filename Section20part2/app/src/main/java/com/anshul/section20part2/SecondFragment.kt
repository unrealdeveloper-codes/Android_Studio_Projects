package com.anshul.section20part2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView


class SecondFragment : Fragment() {

    lateinit var imageView: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_secondfragment, container, false)

        imageView = view.findViewById(R.id.imageView)

        val position = arguments?.getInt("position")

        when(position){
            0 -> imageView.setImageResource(R.drawable.indore)
            1 -> imageView.setImageResource(R.drawable.bhopal)
            2 -> imageView.setImageResource(R.drawable.agra)
            3 -> imageView.setImageResource(R.drawable.mumbai)
            4 -> imageView.setImageResource(R.drawable.rajasthan)
            5 -> imageView.setImageResource(R.drawable.delhi)
            else -> imageView.setImageResource(R.drawable.indore)
        }

        // Inflate the layout for this fragment
        return view
    }


}