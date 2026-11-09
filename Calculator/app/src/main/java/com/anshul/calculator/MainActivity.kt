package com.anshul.calculator

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.anshul.calculator.databinding.ActivityMainBinding
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {


    lateinit var  mainBinding : ActivityMainBinding
    var number : String? = null

    var firstNum : Double = 0.0
    var lastNum : Double = 0.0

    var status : String? = null
    var operator : Boolean = false

    val myFormatter = DecimalFormat("######.######")

    var history : String = ""
    var currentResult : String = ""

    var dotControl : Boolean = true
    var buttonEqualControl : Boolean = false

    lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        mainBinding.ResultTextView.text = ""
        mainBinding.toptextview.text = "0"

        mainBinding.zero.setOnClickListener {
            onClickedNumber("0")
        }

        mainBinding.one.setOnClickListener {
            onClickedNumber("1")
        }

        mainBinding.two.setOnClickListener {
            onClickedNumber("2")
        }

        mainBinding.three.setOnClickListener {
            onClickedNumber("3")
        }

        mainBinding.four.setOnClickListener {
            onClickedNumber("4")
        }

        mainBinding.five.setOnClickListener {
            onClickedNumber("5")
        }

        mainBinding.six.setOnClickListener {
            onClickedNumber("6")
        }

        mainBinding.seven.setOnClickListener {
            onClickedNumber("7")
        }

        mainBinding.eight.setOnClickListener {
            onClickedNumber("8")
        }

        mainBinding.nine.setOnClickListener {
            onClickedNumber("9")
        }

        mainBinding.doublezero.setOnClickListener {
            onClickedNumber("00")
        }

        mainBinding.point.setOnClickListener {
            if(dotControl) {
                number = if (number == null) {
                    "0."
                }else if(buttonEqualControl) {

                    if (mainBinding.toptextview.text.toString().contains(".")) {
                        mainBinding.toptextview.text.toString()
                    }else {
                        mainBinding.toptextview.text.toString().plus(".")
                    }

                }else {
                    "$number."
                }
                mainBinding.toptextview.text = number
            }

            dotControl = false
        }

        mainBinding.plus.setOnClickListener {

            history = mainBinding.ResultTextView.text.toString()
            currentResult = mainBinding.toptextview.text.toString()
            mainBinding.ResultTextView.text = history.plus(currentResult).plus("+")

            if (operator){

                when(status){
                    "multiply" -> multiply()
                    "divide" -> divide()
                    "modulus" -> modulus()
                    "minus" -> minus()
                    "plus" -> plus()
                    else -> firstNum = mainBinding.toptextview.text.toString().toDouble()
                }
            }

            status = "plus"
            operator = false
            number = null
            dotControl = true


        }

        mainBinding.minus.setOnClickListener {

            history = mainBinding.ResultTextView.text.toString()
            currentResult = mainBinding.toptextview.text.toString()
            mainBinding.ResultTextView.text = history.plus(currentResult).plus("-")

            if (operator){

                when(status){
                    "multiply" -> multiply()
                    "divide" -> divide()
                    "modulus" -> modulus()
                    "minus" -> minus()
                    "plus" -> plus()
                    else -> firstNum = mainBinding.toptextview.text.toString().toDouble()
                }
            }

            status = "minus"
            operator = false
            number = null
            dotControl = true



        }

        mainBinding.multiply.setOnClickListener {

            history = mainBinding.ResultTextView.text.toString()
            currentResult = mainBinding.toptextview.text.toString()
            mainBinding.ResultTextView.text = history.plus(currentResult).plus("*")

            if (operator){

                when(status){
                    "multiply" -> multiply()
                    "divide" -> divide()
                    "modulus" -> modulus()
                    "minus" -> minus()
                    "plus" -> plus()
                    else -> firstNum = mainBinding.toptextview.text.toString().toDouble()
                }
            }

            status = "multiply"
            operator = false
            number = null
            dotControl = true


        }

        mainBinding.div.setOnClickListener {

            history = mainBinding.ResultTextView.text.toString()
            currentResult = mainBinding.toptextview.text.toString()
            mainBinding.ResultTextView.text = history.plus(currentResult).plus("/")

            if (operator){

                when(status){
                    "multiply" -> multiply()
                    "divide" -> divide()
                    "modulus" -> modulus()
                    "minus" -> minus()
                    "plus" -> plus()
                    else -> firstNum = mainBinding.toptextview.text.toString().toDouble()
                }
            }

            status = "divide"
            operator = false
            number = null
            dotControl = true



        }

        mainBinding.modulus.setOnClickListener {

            history = mainBinding.ResultTextView.text.toString()
            currentResult = mainBinding.toptextview.text.toString()
            mainBinding.ResultTextView.text = history.plus(currentResult).plus("%")

            if (operator){

                when(status){
                    "multiply" -> multiply()
                    "divide" -> divide()
                    "modulus" -> modulus()
                    "minus" -> minus()
                    "plus" -> plus()
                    else -> firstNum = mainBinding.toptextview.text.toString().toDouble()
                }
            }

            status = "modulus"
            operator = false
            number = null
            dotControl = true

        }

        mainBinding.AC.setOnClickListener {

            onButtonACClicked()

        }

        mainBinding.Del.setOnClickListener {

            number?.let {
                if (it.length == 1){
                    onButtonACClicked()
                }
                else {
                    number = it.substring(0, it.length - 1)
                    mainBinding.toptextview.text = number
                    dotControl = !number!!.contains(".")
                }
            }

        }

        mainBinding.equal.setOnClickListener {

            history = mainBinding.ResultTextView.text.toString()
            currentResult = mainBinding.toptextview.text.toString()


            if (operator){

                when(status){
                    "multiply" -> multiply()
                    "divide" -> divide()
                    "modulus" -> modulus()
                    "minus" -> minus()
                    "plus" -> plus()
                    else -> firstNum = mainBinding.toptextview.text.toString().toDouble()
                }
                mainBinding.ResultTextView.text = history.plus(currentResult).plus("=").plus(mainBinding.toptextview.text.toString()).plus(" , ")
                mainBinding.toptextview.text = myFormatter.format(firstNum)
            }
            operator = false
            dotControl = true
            buttonEqualControl = true

        }

        //materialToolBar
        mainBinding.toolbar.setOnMenuItemClickListener {items->

            when(items.itemId){

                R.id.setting_items -> {
                    val intent = Intent(this, SettingActivity::class.java)
                    startActivity(intent)
                    return@setOnMenuItemClickListener true
                }
                else -> return@setOnMenuItemClickListener false
            }
        }

    }

    fun onButtonACClicked(){

        number = null
        firstNum = 0.0
        lastNum = 0.0
        status = null
        operator = false
        currentResult = ""
        mainBinding.toptextview.text = "0"
        mainBinding.ResultTextView.text = ""
        dotControl = true
        buttonEqualControl = false

    }

    fun onClickedNumber(clickedNumber : String){

        if(number == null){
            number = clickedNumber
        }else if(buttonEqualControl){
            number = if (dotControl){
                clickedNumber
            }else{
                mainBinding.toptextview.text.toString().plus(clickedNumber)
            }
            firstNum = number?.toDouble() ?:0.0
            lastNum = 0.0
            status = null
            mainBinding.ResultTextView.text = ""

        }else{
            number += clickedNumber
        }

        mainBinding.toptextview.text = number
        operator = true
        buttonEqualControl = false

    }

    fun plus(){
        lastNum = mainBinding.toptextview.text.toString().toDouble()
        firstNum += lastNum
        val formattedResult = myFormatter.format(firstNum)
        mainBinding.ResultTextView.text = formattedResult
        mainBinding.toptextview.text = formattedResult
    }

    fun minus(){
        lastNum = mainBinding.toptextview.text.toString().toDouble()
        firstNum -= lastNum
        val formattedResult = myFormatter.format(firstNum)
        mainBinding.ResultTextView.text = formattedResult
        mainBinding.toptextview.text = formattedResult
    }

    fun multiply(){

        lastNum = mainBinding.toptextview.text.toString().toDouble()
        firstNum *= lastNum
        val formattedResult = myFormatter.format(firstNum)
        mainBinding.ResultTextView.text = formattedResult
        mainBinding.toptextview.text = formattedResult
    }

    fun divide(){
        lastNum = mainBinding.toptextview.text.toString().toDouble()

        if (lastNum == 0.0){
            Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
            return
        }

        firstNum /= lastNum
        val formattedResult = myFormatter.format(firstNum)
        mainBinding.ResultTextView.text = formattedResult
        mainBinding.toptextview.text = formattedResult


    }

    fun modulus() {
        lastNum = mainBinding.toptextview.text.toString().toDouble()
        firstNum %= lastNum
        val formattedResult = myFormatter.format(firstNum)
        mainBinding.ResultTextView.text = formattedResult
        mainBinding.toptextview.text = formattedResult
    }

    override fun onResume() {
        super.onResume()

        sharedPreferences = this.getSharedPreferences("Dark Mode", MODE_PRIVATE)
        val isDarkMode = sharedPreferences.getBoolean("switch", false)
        if (isDarkMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

    }

    override fun onPause() {
        super.onPause()
        sharedPreferences = this.getSharedPreferences("calculations", MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        val history = mainBinding.ResultTextView.text.toString()
        val resultToSave = mainBinding.toptextview.text.toString()
        val statusToSave = status
        val operatorToSave = operator
        val numberToSave = number
        val dotControlToSave = dotControl
        val buttonEqualControlToSave = buttonEqualControl
        val firstNumToSave = firstNum.toString()
        val lastNumToSave = lastNum.toString()

        editor.putString("history", history)
        editor.putString("currentResult", currentResult)
        editor.putString("status", statusToSave)
        editor.putBoolean("operator", operatorToSave)
        editor.putString("number", numberToSave)
        editor.putBoolean("dotControl", dotControlToSave)
        editor.putBoolean("buttonEqualControl", buttonEqualControlToSave)
        editor.putString("firstNum", firstNumToSave)
        editor.putString("lastNum", lastNumToSave)
        editor.putString("result",resultToSave)

        editor.apply()

    }

    override fun onStart() {

        super.onStart()

        sharedPreferences = this.getSharedPreferences("calculations", MODE_PRIVATE)

        mainBinding.toptextview.text = sharedPreferences.getString("result", "0")
        mainBinding.ResultTextView.text = sharedPreferences.getString("history", "")

        status = sharedPreferences.getString("status", null)
        operator = sharedPreferences.getBoolean("operator", false)
        number = sharedPreferences.getString("number", null)
        dotControl = sharedPreferences.getBoolean("dotControl", true)
        buttonEqualControl = sharedPreferences.getBoolean("buttonEqualControl", false)
        firstNum = sharedPreferences.getString("firstNum", "0.0")?.toDouble() ?: 0.0
        lastNum = sharedPreferences.getString("lastNum", "0.0")?.toDouble() ?: 0.0


    }

}

