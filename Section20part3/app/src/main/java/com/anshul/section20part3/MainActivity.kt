package com.anshul.section20part3

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {

    lateinit var textViewname : TextView
    lateinit var textViewage : TextView

    lateinit var showDialogBox : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        textViewname = findViewById(R.id.textviewname)
        textViewage = findViewById(R.id.textViewage)
        showDialogBox = findViewById(R.id.showDialogBox)

        showDialogBox.setOnClickListener {
            val dialogFragmentManager : FragmentManager = supportFragmentManager
            val dialogFragment = DialogFragment()
            dialogFragment.isCancelable = false
            dialogFragment.show(dialogFragmentManager, "dialog")

        }


    }

    fun getUserData(userName : String, userAge : String){
        textViewname.text = "Hello $userName"
        textViewage.text = "Your Age is $userAge"
    }

}
