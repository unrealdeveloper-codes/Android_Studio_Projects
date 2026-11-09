package com.anshul.section21part2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {

    lateinit var weight: EditText
    lateinit var height: EditText
    lateinit var calculate: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        weight = findViewById(R.id.weight)
        height = findViewById(R.id.height)
        calculate = findViewById(R.id.calculate)


        calculate.setOnClickListener {

            val weight = weight.text.toString().toFloat()
            val height = height.text.toString().toFloat()

            val firstFragment: FragmentManager = supportFragmentManager
            val fragmentTransaction = firstFragment.beginTransaction()
            val fragment = FirstFragment()
            val bundle = Bundle()
            bundle.putFloat("weight", weight)
            bundle.putFloat("height", height)
            fragment.arguments = bundle
            fragmentTransaction.replace(R.id.frameLayout, fragment)
            fragmentTransaction.commit()

        }

    }
}


