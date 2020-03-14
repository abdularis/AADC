package com.abdularis.androidsensors.proximitylight

import android.content.Context
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.graphics.ColorUtils
import com.abdularis.androidsensors.R
import kotlinx.android.synthetic.main.activity_proximity_light_sensor.*

class ProximityLightSensorActivity : AppCompatActivity(), SensorEventListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_proximity_light_sensor)

        val sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val observer =
            ProximityLightSensorObserver(
                sensorManager,
                this
            )
        lifecycle.addObserver(observer)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    override fun onSensorChanged(event: SensorEvent?) {
        event?.let {
            if (it.sensor.type == Sensor.TYPE_PROXIMITY) {
                tvProximity.text = it.values[0].toString()
            } else if (it.sensor.type == Sensor.TYPE_LIGHT) {
                tvLight.text = it.values[0].toString()
                val light = it.values[0] / 1000
                window.decorView.setBackgroundColor(darkenColor(light))
            }
        }
    }

    private fun darkenColor(value: Float): Int {
        val hsl = FloatArray(3)
        ColorUtils.colorToHSL(Color.WHITE, hsl)
        hsl[2] -= value
        hsl[2] = Math.max(0f, hsl[2].coerceAtMost(1f))
        return ColorUtils.HSLToColor(hsl)
    }
}
