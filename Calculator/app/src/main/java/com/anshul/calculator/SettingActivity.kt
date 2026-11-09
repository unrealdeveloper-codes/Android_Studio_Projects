package com.anshul.calculator

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.anshul.calculator.databinding.ActivityChangeDarkThemeBinding
import androidx.core.content.edit

class SettingActivity : AppCompatActivity() {

    lateinit var switchBinding: ActivityChangeDarkThemeBinding
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        switchBinding = ActivityChangeDarkThemeBinding.inflate(layoutInflater)
        val view = switchBinding.root
        setContentView(view)


        switchBinding.toolbar2.setNavigationOnClickListener {
            finish()
        }

        switchBinding.SwitchKey.setOnCheckedChangeListener { buttonView, isChecked ->

            sharedPreferences = this.getSharedPreferences("Dark Mode", MODE_PRIVATE)
            val editor = sharedPreferences.edit()

            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                editor.putBoolean("Dark", true)

            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                editor.putBoolean("Dark", false)
            }

            editor.apply()

        }

    }

    override fun onResume() {
        super.onResume()

        sharedPreferences = this.getSharedPreferences("Dark Mode", MODE_PRIVATE)
        val isDarkMode = sharedPreferences.getBoolean("Dark", false)
        switchBinding.SwitchKey.isChecked = isDarkMode

    }
}