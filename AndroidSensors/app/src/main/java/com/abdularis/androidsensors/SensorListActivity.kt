package com.abdularis.androidsensors

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sensor_list.*


class SensorListActivity : AppCompatActivity() {

    private lateinit var sensorManager: SensorManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensor_list)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        val sensors = sensorManager.getSensorList(Sensor.TYPE_ALL)

        val sensorsText = StringBuilder()
        sensors.asSequence()
            .map { it.name }
            .forEach {
                sensorsText.appendln(it)
            }

        tvSensors.text = sensorsText.toString()
    }
}
