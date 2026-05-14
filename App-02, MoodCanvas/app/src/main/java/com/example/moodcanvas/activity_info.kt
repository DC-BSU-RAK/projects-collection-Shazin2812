package com.example.moodcanvas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class activity_info : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val backHome = findViewById<Button>(R.id.backtohome)

        backHome.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}