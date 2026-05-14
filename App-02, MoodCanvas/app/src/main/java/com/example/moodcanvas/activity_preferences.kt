package com.example.moodcanvas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity

class activity_preferences : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferences)

        val calm = findViewById<RadioButton>(R.id.clam)
        val dream = findViewById<RadioButton>(R.id.dream)
        val energy = findViewById<RadioButton>(R.id.energy)
        val focus = findViewById<RadioButton>(R.id.focus)

        val slow = findViewById<RadioButton>(R.id.slow)
        val medium = findViewById<RadioButton>(R.id.medium)
        val fast = findViewById<RadioButton>(R.id.fast)

        val savePreferences = findViewById<Button>(R.id.save)
        val back = findViewById<Button>(R.id.back)

        val sharedPref = getSharedPreferences("MoodCanvasPrefs", MODE_PRIVATE)

        savePreferences.setOnClickListener {
            var selectedMood = "Calm"
            var selectedSpeed = "Medium"

            if (calm.isChecked) selectedMood = "Calm"
            if (dream.isChecked) selectedMood = "Dream"
            if (energy.isChecked) selectedMood = "Energy"
            if (focus.isChecked) selectedMood = "Focus"

            if (slow.isChecked) selectedSpeed = "Slow"
            if (medium.isChecked) selectedSpeed = "Medium"
            if (fast.isChecked) selectedSpeed = "Fast"

            sharedPref.edit()
                .putString("selectedMood", selectedMood)
                .putString("selectedSpeed", selectedSpeed)
                .apply()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}