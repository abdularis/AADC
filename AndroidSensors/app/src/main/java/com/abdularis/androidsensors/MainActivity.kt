package com.abdularis.androidsensors

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abdularis.androidsensors.proximitylight.ProximityLightSensorActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSensorsList.setOnClickListener {
            startActivity(Intent(this@MainActivity, SensorListActivity::class.java))
        }

        btnProximityLight.setOnClickListener {
            startActivity(Intent(this@MainActivity, ProximityLightSensorActivity::class.java))
        }
    }
}
