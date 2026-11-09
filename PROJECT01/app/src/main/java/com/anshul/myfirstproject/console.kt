package com.anshul.myfirstproject

fun main(args: Array<String>) {

    print("What is your name : ")

    var name : String = readLine()!!

    print("What is yout age: ")

    var age: Int = readLine()!!.toInt()

    println("My name is $name and my age is " + age)


}