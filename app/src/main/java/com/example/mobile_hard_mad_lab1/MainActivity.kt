package com.example.mobile_hard_mad_lab1

import android.os.Bundle
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge(navigationBarStyle = SystemBarStyle.light(1, 1))

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}