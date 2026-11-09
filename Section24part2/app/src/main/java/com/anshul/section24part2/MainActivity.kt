package com.anshul.section24part2


import android.app.AlarmManager
import android.Manifest
import android.app.PendingIntent
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.anshul.section24part2.databinding.ActivityMainBinding
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import java.util.Calendar

class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        requestNotificationPermission()

        val calender = Calendar.getInstance()
        val currentHour = calender.get(Calendar.HOUR_OF_DAY)
        val currentMinute = calender.get(Calendar.MINUTE)

        binding.Notificationbutton.setOnClickListener {

            val timePicker = MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_12H)
                .setHour(currentHour)
                .setMinute(currentMinute)
                .setTitleText("Select Notification Time")
                .build()

            timePicker.show(supportFragmentManager, "1")

            timePicker.addOnPositiveButtonClickListener {

                calender.set(Calendar.HOUR_OF_DAY,timePicker.hour)
                calender.set(Calendar.MINUTE,timePicker.minute)
                calender.set(Calendar.SECOND,0)
                calender.set(Calendar.MILLISECOND,0)

                val intent = Intent(applicationContext, NotificationReceiver::class.java)

                val pendingIntent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    PendingIntent.getBroadcast(applicationContext
                        ,100
                        ,intent
                        , PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
                }else{
                    PendingIntent.getBroadcast(applicationContext
                        ,100
                        ,intent
                        , PendingIntent.FLAG_UPDATE_CURRENT)
                }

                val alarmManager : AlarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
                alarmManager.setInexactRepeating(
                    AlarmManager.RTC_WAKEUP,
                    calender.timeInMillis,
                    AlarmManager.INTERVAL_DAY,
                    pendingIntent)

                Toast.makeText(this, "The Alarm is set", Toast.LENGTH_SHORT).show()

            }
        }
    }
    private fun requestNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                101
            )
        }
    }
}

