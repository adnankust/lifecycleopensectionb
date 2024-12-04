package com.example.lifecycleopensectionb

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var lifecycleTextView: TextView
    companion object {
        private const val TAG = "MainActivityLifeCycle"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        lifecycleTextView = findViewById(R.id.lifecycleTextView)
        val navigateButton: Button = findViewById(R.id.navigateButton)

        navigateButton.setOnClickListener {
            startActivity(Intent(this,SecondActivity::class.java))
        }

        logAndDisplay("onCreate")
    }

    override fun onStart() {
        super.onStart()
        logAndDisplay("onStart")
    }

    override fun onResume() {
        super.onResume()
        logAndDisplay("onResume")
    }

    override fun onPause() {
        super.onPause()
        logAndDisplay("onPause")
    }

    override fun onStop() {
        super.onStop()
        logAndDisplay("onStop")
    }

    override fun onRestart() {
        super.onRestart()
        logAndDisplay("onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        logAndDisplay("onDestory")
    }



    private fun logAndDisplay(activityName: String) {

        Log.d(TAG, activityName)
        lifecycleTextView.append("$activityName\n")
    }


}