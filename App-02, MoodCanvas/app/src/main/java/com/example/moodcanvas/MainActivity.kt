package com.example.moodcanvas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var currentMood: TextView
    private lateinit var speed: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        currentMood = findViewById(R.id.Currentmood)
        speed = findViewById(R.id.speed)

        val changePreferences = findViewById<Button>(R.id.Changepreferences)
        val howToUse = findViewById<Button>(R.id.howtouse)
        val info = findViewById<Button>(R.id.info)

        changePreferences.setOnClickListener {
            startActivity(Intent(this, activity_preferences::class.java))
        }

        howToUse.setOnClickListener {
            startActivity(Intent(this, dialog_how_to_use::class.java))
        }

        info.setOnClickListener {
            startActivity(Intent(this, activity_info::class.java))
        }
    }

    override fun onResume() {
        super.onResume()

        val sharedPref = getSharedPreferences("MoodCanvasPrefs", MODE_PRIVATE)

        val savedMood = sharedPref.getString("selectedMood", "Calm")
        val savedSpeed = sharedPref.getString("selectedSpeed", "Medium")

        currentMood.text = savedMood
        speed.text = savedSpeed
    }
}