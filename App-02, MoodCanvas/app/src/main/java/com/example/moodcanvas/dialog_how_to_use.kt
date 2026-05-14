package com.example.moodcanvas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class dialog_how_to_use : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_how_to_use)

        val close = findViewById<Button>(R.id.close)

        close.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}