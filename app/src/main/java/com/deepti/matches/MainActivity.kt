package com.deepti.matches

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.deepti.matches.application_card.ApplicationCardActivity

class MainActivity : AppCompatActivity() {

    private val splashTimeOut:Long=3000 // 3 sec

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Handler().postDelayed({
            startActivity(Intent(this,ApplicationCardActivity::class.java))
            finish()
        }, splashTimeOut)
    }
}
