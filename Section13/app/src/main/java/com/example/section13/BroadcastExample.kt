package com.example.section13

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BroadcastExample : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        val isOnAirplane : Boolean = intent!!.getBooleanExtra("state", false)
        if(isOnAirplane)
            Toast.makeText(context,"The device airplane mode is ON",Toast.LENGTH_LONG).show()
        else
        Toast.makeText(context,"The device airplane mode is OFF",Toast.LENGTH_LONG).show()
    }
}