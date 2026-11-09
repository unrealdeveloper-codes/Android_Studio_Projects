package com.anshul.section24

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.anshul.section24.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Use descriptive channel id
    private val channelId = "counter_notification_channel"

    lateinit var binding: ActivityMainBinding
    var counter = 0

    // Launcher for the POST_NOTIFICATIONS permission request.
    private lateinit var notificationPermissionLauncher: ActivityResultLauncher<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


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
            .setAutoCancel(true)

        val notificationManagerCompat = NotificationManagerCompat.from(this)

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {

            notificationPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)


            return
        }
        notificationManagerCompat.notify(1, builder.build())
    }
}
