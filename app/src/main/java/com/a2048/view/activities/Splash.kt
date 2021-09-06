package com.a2048.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.a2048.R

/**
 * A launcher splash screen activity
 */
class Splash : AppCompatActivity() {

    var timer  = object :CountDownTimer(2000,100){
        override fun onTick(millisUntilFinished: Long) {
        }
        override fun onFinish() {
            val intent = Intent(this@Splash, LaunchGameActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        timer.start()
    }
}