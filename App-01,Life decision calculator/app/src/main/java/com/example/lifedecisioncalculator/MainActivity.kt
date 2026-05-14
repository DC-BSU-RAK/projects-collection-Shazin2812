package com.example.lifedecisioncalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val result = findViewById<TextView>(R.id.result)

        var funScore = 0
        var costScore = 0
        var timeScore = 0
        var riskScore = 0

        // Fun
        findViewById<Button>(R.id.fun1).setOnClickListener { funScore = 1 }
        findViewById<Button>(R.id.fun2).setOnClickListener { funScore = 2 }
        findViewById<Button>(R.id.fun3).setOnClickListener { funScore = 3 }

        // Cost
        findViewById<Button>(R.id.cost1).setOnClickListener { costScore = 1 }
        findViewById<Button>(R.id.cost2).setOnClickListener { costScore = 2 }
        findViewById<Button>(R.id.cost3).setOnClickListener { costScore = 3 }

        // Time
        findViewById<Button>(R.id.time1).setOnClickListener { timeScore = 1 }
        findViewById<Button>(R.id.time2).setOnClickListener { timeScore = 2 }
        findViewById<Button>(R.id.time3).setOnClickListener { timeScore = 3 }

        // Risk
        findViewById<Button>(R.id.risk1).setOnClickListener { riskScore = 1 }
        findViewById<Button>(R.id.risk2).setOnClickListener { riskScore = 2 }
        findViewById<Button>(R.id.risk3).setOnClickListener { riskScore = 3 }

        // Calculate
        findViewById<Button>(R.id.CalculatorDecision).setOnClickListener {

            if (funScore == 0 || costScore == 0 || timeScore == 0 || riskScore == 0) {
                result.text = "Please select all options"
                return@setOnClickListener
            }

            val total = funScore + costScore + timeScore + riskScore

            val decision = when {
                total >= 10 -> "Good choice ✅"
                total >= 7 -> "Think again 🤔"
                else -> "It is a bad choice ❌"
            }

            result.text = "Score: $total / 12\nDecision: $decision"
        }

        // Info
        findViewById<Button>(R.id.info).setOnClickListener {
            Toast.makeText(
                this,
                "This app helps you decide by rating Fun, Cost, Time, and Risk from 1 to 3.",
                Toast.LENGTH_LONG
            ).show()
        }

        // ✅ CLEAR BUTTON
        findViewById<Button>(R.id.clear).setOnClickListener {

            funScore = 0
            costScore = 0
            timeScore = 0
            riskScore = 0

            result.text = "Result Thinking"

            Toast.makeText(this, "Cleared", Toast.LENGTH_SHORT).show()
        }
    }
}