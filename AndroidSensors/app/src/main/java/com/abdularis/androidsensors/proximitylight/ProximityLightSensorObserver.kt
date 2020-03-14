package com.abdularis.androidsensors.proximitylight

import android.hardware.Sensor
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class ProximityLightSensorObserver(
    private val sensorManager: SensorManager,
    private val sensorEventListener: SensorEventListener
): LifecycleObserver {
    private val proximitySensor: Sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)
    private val lightSensor: Sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public fun registerListener() {
        sensorManager.registerListener(sensorEventListener, proximitySensor, SensorManager.SENSOR_DELAY_UI)
        sensorManager.registerListener(sensorEventListener, lightSensor, SensorManager.SENSOR_DELAY_UI)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public fun unregisterListener() {
        sensorManager.unregisterListener(sensorEventListener)
    }
}