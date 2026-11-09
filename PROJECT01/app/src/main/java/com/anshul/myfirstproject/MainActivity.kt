package com.anshul.myfirstproject

import android.graphics.Color
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.AdapterViewAnimator
import android.widget.ArrayAdapter
import android.widget.Button
//import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
//import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() , AdapterView.OnItemClickListener{

//    //Edit Text
//    //lateinit var textview : TextView
//    lateinit var buttom : Button
//    lateinit var name : EditText
//    lateinit var result: TextView

//    //check Box
//    lateinit var male : CheckBox
//    lateinit var female : CheckBox
//    lateinit var question : TextView

//    //radiobutton
//    lateinit var rbutton1 : RadioButton
//    lateinit var rbutton2 : RadioButton
//    lateinit var rbutton3 : RadioButton
//    lateinit var change : Button
//    lateinit var layout : ConstraintLayout
//    lateinit var rGroup : RadioGroup


    //toggle button
    lateinit var image : ImageView
    lateinit var trogglebutton : ToggleButton
    lateinit var result : TextView

//    //spinner
//    lateinit var spinner : Spinner
//    lateinit var result : TextView

    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


//            //spinner
//        setContentView(R.layout.spinner)
//
//        spinner = findViewById(R.id.spinner)
//        result = findViewById(R.id.result)
//
//
//        val arrayAdapter = ArrayAdapter.createFromResource(
//            this@MainActivity,
//            R.array.countries,
//            android.R.layout.simple_spinner_item
//        )
//
//        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//
//        spinner.adapter = arrayAdapter
//
//
//        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(parentView: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                // When an item is selected, update the result TextView with the selected item
//                val selectedItem = parentView?.getItemAtPosition(position).toString()
//                result.text = selectedItem
//            }
//
//            override fun onNothingSelected(parentView: AdapterView<*>?) {
//                // Handle case when nothing is selected, if necessary
//                result.text = "No selection"
//            }
//        }



        //toggle button
        setContentView(R.layout.trogglebutton)

        image = findViewById(R.id.imageandroidstudio)
        trogglebutton = findViewById(R.id.imageOnOff)
        result = findViewById(R.id.imagevisibleornot)


        trogglebutton.setOnCheckedChangeListener { compoundButton , isChecked ->

            if (isChecked){
                image.isVisible = false
               // image.visibility = View.INVISIBLE
                result.text = "The image is invisible"

            }else{
                image.isVisible = true
                result.text = "The image is visible"
            }

        }

//        //radio button
//        setContentView(R.layout.radiobutton)
//
//        rbutton1 = findViewById(R.id.redbutton)
//        rbutton2 = findViewById(R.id.yellowbutton)
//        rbutton3 = findViewById(R.id.blackbutton)
//        change = findViewById(R.id.changebutton)
//        layout = findViewById(R.id.layout)
//        rGroup = findViewById(R.id.radiogroup)
//
//        change.setOnClickListener {
//
//            if(rbutton1.isChecked){
//                layout.setBackgroundColor(Color.RED)
//                rbutton2.isChecked = false
//                rbutton3.isChecked = false
//            }else if(rbutton2.isChecked){
//                layout.setBackgroundColor(Color.YELLOW)
//                rbutton1.isChecked = false
//                rbutton3.isChecked = false
//            }else if(rbutton3.isChecked){
//                layout.setBackgroundColor(Color.BLACK)
//                rbutton1.isChecked = false
//                rbutton2.isChecked = false
//            }
//        }



//        //Edit Text
//        setContentView(R.layout.edittext)
//
//        buttom = findViewById(R.id.button2)
//        result = findViewById(R.id.result)
//        name = findViewById(R.id.name)
//
//        buttom.setOnClickListener {
//
//            var username: String = name.text.toString()
//            result.text = username
//        }

//
//        //check Box
//        setContentView(R.layout.check_box)
//
//        male = findViewById(R.id.male)
//        female = findViewById(R.id.female)
//        question = findViewById(R.id.gender)
//
//        male.setOnClickListener {
//
//            if (male.isChecked) {
//                question.text = "Your gender is male"
//                female.isChecked = false
//            } else {
//                question.text = "What is your gender?"
//            }
//        }
//
//        female.setOnClickListener {
//
//            if (female.isChecked) {
//                question.text = "Your gender is female"
//                male.isChecked = false
//            } else {
//                question.text = "What is your gender?"
//            }
    }

    override fun onItemClick(
        parent: AdapterView<*>?,
        view: View?,
        position: Int,
        id: Long
    ) {
        TODO("Not yet implemented")
    }


}





