package com.anshul.section23part4

import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import java.util.ArrayList
import java.util.Locale

class MainActivity : AppCompatActivity() {

    lateinit var resultText : TextView
    lateinit var mic : ImageButton

    lateinit var activityResultLauncher : ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        resultText = findViewById(R.id.result)
        mic = findViewById(R.id.mic)

        activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult(),
            ActivityResultCallback { result ->

                val resultCode = result.resultCode
                val data = result.data
                if(resultCode == RESULT_OK && data != null){
                    val speechResult : ArrayList<String> = data.
                    getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS) as ArrayList<String>

                    resultText.text = speechResult[0]
                }

            })

        mic.setOnClickListener {

            convertSpeech()

        }
    }

    fun convertSpeech(){

        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,Locale.getDefault())
        startActivityForResult(intent,1)
        activityResultLauncher.launch(intent)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == 1 && resultCode == RESULT_OK && data != null){

            val speechResult : ArrayList<String> = data.
            getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)  as ArrayList<String>

            resultText.text = speechResult[0]

        }
    }
}