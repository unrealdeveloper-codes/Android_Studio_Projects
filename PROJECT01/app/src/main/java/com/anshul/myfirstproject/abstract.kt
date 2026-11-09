package com.anshul.myfirstproject

abstract class Vehicle{

    abstract fun vehicleName (name : String) : String

    fun vehicleType(type:String): String{

        return type
    }

    abstract var model : Int

    var speed : Int? = null


}