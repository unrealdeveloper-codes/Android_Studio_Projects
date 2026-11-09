package com.anshul.section21part4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.FragmentManager

class FirstFragment : Fragment() {

    lateinit var name : EditText
    lateinit var password : EditText
    lateinit var button : Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_first, container, false)

        name = view.findViewById(R.id.name)
        password = view.findViewById(R.id.password)
        button = view.findViewById(R.id.sgininbutton)

        button.setOnClickListener {
            val nameText = name.text.toString()
            val passwordText = password.text.toString()



            val secondFragmentManager : FragmentManager = requireActivity().supportFragmentManager
            val secondFragmentTransaction = secondFragmentManager.beginTransaction()
            val secondFragment = SecondFragment()
            val bundle = Bundle()
            bundle.putString("name", nameText)
            bundle.putString("password", passwordText)
            secondFragment.arguments = bundle
            secondFragmentTransaction.replace(R.id.frame, secondFragment)
            secondFragmentTransaction.commit()

        }


        // Inflate the layout for this fragment
        return view
    }


}