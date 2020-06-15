package com.hellodiffa.cabaca.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hellodiffa.cabaca.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun onDestroy() {
        super.onDestroy()
        finish()
    }
}