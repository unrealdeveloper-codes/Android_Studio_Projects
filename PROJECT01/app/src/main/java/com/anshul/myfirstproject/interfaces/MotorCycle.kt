package com.anshul.myfirstproject.interfaces

class MotorCycle : CanGo , CanStop {

    override val name: String
        get() = "farrier"

    override fun stop() {
        println("vehicle can stop")
    }


}