package com.anshul.section20part3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment

class DialogFragment : DialogFragment() {

    lateinit var name : EditText
    lateinit var age : EditText
    lateinit var cancel : Button
    lateinit var ok : Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_dialog, container, false)

        name = view.findViewById(R.id.name)
        age = view.findViewById(R.id.age)
        cancel = view.findViewById(R.id.cancel)
        ok = view.findViewById(R.id.ok)

        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)

        cancel.setOnClickListener {
            dialog?.dismiss()
        }

        ok.setOnClickListener {

            val userName = name.text.toString()
            val userAge = age.text.toString()

            val mainActivity = activity as MainActivity

            mainActivity.getUserData(userName, userAge)

            dialog?.dismiss()
        }

        // Inflate the layout for this fragment
        return view
    }

}