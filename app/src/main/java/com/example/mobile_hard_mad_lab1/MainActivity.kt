package com.example.mobile_hard_mad_lab1

import android.graphics.Insets
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.marginBottom
import androidx.core.view.marginEnd
import androidx.core.view.marginStart
import androidx.core.view.marginTop

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fixMargins()
    }

    @RequiresApi(Build.VERSION_CODES.R)
    private fun fixMargins(){
        window.decorView.rootView.setOnApplyWindowInsetsListener{v, insets ->
            val systemInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            val logo = findViewById<ImageView>(R.id.logoImageView)
            val logIn = findViewById<TextView>(R.id.logInTextView)
            val haveAnAccount = findViewById<TextView>(R.id.haveAccountTextView)

            addTopMargin(logo, systemInsets)
            addBottomMargin(logIn, systemInsets)
            addBottomMargin(haveAnAccount, systemInsets)

            insets
        }
    }

    @RequiresApi(Build.VERSION_CODES.R)
    private fun addTopMargin(view: View, insets: Insets) {
        val params = view.layoutParams as ViewGroup.MarginLayoutParams
        params.setMargins(view.marginStart, view.marginTop + insets.top, view.marginEnd, view.marginBottom)
    }

    @RequiresApi(Build.VERSION_CODES.R)
    private fun addBottomMargin(view: View, insets: Insets) {
        val params = view.layoutParams as ViewGroup.MarginLayoutParams
        params.setMargins(view.marginStart, view.marginTop, view.marginEnd, view.marginBottom + insets.bottom)
    }
}