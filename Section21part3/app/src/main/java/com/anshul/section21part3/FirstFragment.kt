package com.anshul.section21part3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText


class FirstFragment : Fragment() {

    lateinit var name : EditText
    lateinit var password : EditText
    lateinit var save : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        name = view.findViewById(R.id.nametext)
        password = view.findViewById(R.id.passwordtext)
        save = view.findViewById(R.id.save)

        save.setOnClickListener {
            val nameText = name.text.toString()
            val passwordText = password.text.toString()

            val mainActivity = activity as MainActivity
            mainActivity.personName.text = nameText
            mainActivity.password.text = passwordText

        }

        // Inflate the layout for this fragment
        return view
    }


}