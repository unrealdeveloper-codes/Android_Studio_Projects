package com.anshul.section24part3

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationManagerCompat

class DismissReceive : BroadcastReceiver() {


    override fun onReceive(context: Context?, intent: Intent?) {

        context?.let {

            val notificationManager = NotificationManagerCompat.from(it)
            notificationManager.cancel(1)
        }


    }
}