package com.anshul.section24part3

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.anshul.section24part3.databinding.ActivityMainBinding
import kotlin.jvm.java


class MainActivity : AppCompatActivity() {

    private val channelId = "counter_channel"

    var counter = 0
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.Notificationbutton.setOnClickListener {
            counter++
            binding.Notificationbutton.text = counter.toString()

            // Send a notification every 5th click.
            if (counter % 5 == 0) {
                sendNotification()
            }
        }
    }


    fun sendNotification() {


        val intent = Intent(this, MainActivity::class.java)

        val pendingIntent = PendingIntent.getActivity(
            this, 0, intent, PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT)

        //largeIcon
        val icon : Bitmap = BitmapFactory.decodeResource(resources, R.drawable.androidimage)
        val text : String = resources.getString(R.string.bigText)


        //Action Button Toast Message
        val actionIntent = Intent(this, ToastReceiver::class.java)
        actionIntent.putExtra("toastMessage", "Toast Message")

        val actionPendingIntent = PendingIntent.getBroadcast(
            this, 0, actionIntent, PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT)

        //Action Button Dismiss
        val dismissIntent = Intent(this, DismissReceive::class.java)

        val dismissPendingIntent = PendingIntent.getBroadcast(
            this, 0, dismissIntent, PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT)


        val builder = NotificationCompat.Builder(this, channelId)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelName = "Counter Notifications"
            val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT)
            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }


        builder.setSmallIcon(R.drawable.baseline_notifications_active_24)
            .setContentTitle("Notification")
            .setContentText("Notification text function")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .addAction(R.drawable.baseline_notifications_active_24, "Toast", actionPendingIntent)
            .addAction(R.drawable.baseline_notifications_active_24, "Dismiss", dismissPendingIntent)
            .setLargeIcon(icon)
            .setStyle(NotificationCompat.BigTextStyle().bigText(text))
//          .setStyle(NotificationCompat.BigPictureStyle().bigPicture(icon))
            .setAutoCancel(true)

        val notificationManagerCompat = NotificationManagerCompat.from(this)

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.POST_NOTIFICATIONS), 0)

            return
        }
        notificationManagerCompat.notify(1, builder.build())

    }
}