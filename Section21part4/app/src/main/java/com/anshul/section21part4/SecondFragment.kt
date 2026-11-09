package com.anshul.section21part4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class SecondFragment : Fragment() {

    lateinit var name : TextView
    lateinit var password : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_second, container, false)

        name = view.findViewById(R.id.nameresult)
        password = view.findViewById(R.id.passwordresult)

        val textName = arguments?.getString("name")
        val textPassword = arguments?.getString("password")

        name.text = "Hello $textName"
        password.text = "Your password is $textPassword"



        // Inflate the layout for this fragment
        return  view
    }


}