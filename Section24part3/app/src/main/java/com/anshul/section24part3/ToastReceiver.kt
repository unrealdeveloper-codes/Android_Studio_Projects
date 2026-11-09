package com.anshul.section24part3

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class ToastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        val messageText = intent?.getStringExtra("toastMessage")

        Toast.makeText(context, messageText, Toast.LENGTH_SHORT).show()
    }

}