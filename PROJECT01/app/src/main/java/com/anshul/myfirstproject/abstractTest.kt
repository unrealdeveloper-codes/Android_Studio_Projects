package com.anshul.myfirstproject

fun main(args: Array<String>) {

    var car = Car(2022)
    car.speed = 300

    println("Name : ${car.vehicleName("ferrari")} \n" +
            "Type : ${car.vehicleType("e_car")} \n" +
            "Model : ${car.model} \n" +
            "Speed : ${car.speed} " )


}