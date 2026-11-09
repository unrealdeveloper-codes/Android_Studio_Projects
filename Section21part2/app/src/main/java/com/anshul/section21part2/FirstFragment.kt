package com.anshul.section21part2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class FirstFragment : Fragment() {

    lateinit var result : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_blank, container, false)

        result = view.findViewById(R.id.result)

        val weight = arguments?.getFloat("weight")
        val height = arguments?.getFloat("height")

        val bmi = (weight!! * 10000) / (height!! * height).toDouble()

        result.text = "Your BMI is $bmi"



        // Inflate the layout for this fragment
        return view
    }


}