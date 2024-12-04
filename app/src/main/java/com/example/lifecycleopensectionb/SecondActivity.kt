package com.example.lifecycleopensectionb

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.log

class SecondActivity: AppCompatActivity() {

    private lateinit var lifeCycleTextView: TextView

    companion object {
        private const val TAG = "SecondActivityLifeCycle"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        lifeCycleTextView = findViewById(R.id.secondtextView)
        val backButton: Button = findViewById(R.id.backButton)

        backButton.setOnClickListener {
            finish() //Close SecondActivity and return to MainActivity
        }

        logandDisplay("onCreate")

        }

    override fun onStart() {
        super.onStart()
        logandDisplay("onStart")
    }

    override fun onResume() {
        super.onResume()
        logandDisplay("onResume")
    }

    override fun onPause() {
        super.onPause()
        logandDisplay("onPause")
    }

    override fun onStop() {
        super.onStop()
        logandDisplay("onStop")
    }

    override fun onRestart() {
        super.onRestart()
        logandDisplay("onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        logandDisplay("onDestroy")
    }

    private fun logandDisplay(activityState: String) {

        Log.d(TAG, activityState)
        lifeCycleTextView.append("$activityState\n")



    }
}
