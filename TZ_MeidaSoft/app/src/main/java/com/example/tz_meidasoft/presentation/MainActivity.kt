package com.example.tz_meidasoft.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.ContextMenu
import android.view.View
import com.example.tz_meidasoft.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()

        Handler(Looper.myLooper()!!).postDelayed(Runnable{
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }, 3000)

    }


}