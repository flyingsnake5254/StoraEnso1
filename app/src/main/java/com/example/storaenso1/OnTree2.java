package com.example.storaenso1;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

public class OnTree2 extends AppCompatActivity implements SensorEventListener {

    SensorManager sensorManager;
    Sensor Asensor , Gsensor , Msensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_tree1);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);


        Asensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        Gsensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        Msensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);


        sensorManager.registerListener(this, Asensor , sensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, Gsensor , sensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, Msensor , sensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}