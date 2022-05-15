package com.example.storaenso1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class OnTree1 extends AppCompatActivity  {

    SensorManager sensorManager;
    Sensor Asensor , Gsensor , Msensor;
    double v1 , v2 , v3;
    boolean success;
    RelativeLayout b1 , b2;
    boolean b1Die , b2Die;
    SensorEventListener sensorEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_tree1);
        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent.sensor.equals(Asensor)){
                    v1 = sensorEvent.values[0];
                    v2 = sensorEvent.values[1];
                    v3 = sensorEvent.values[2];
                    if(v1 > 5){
                        System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCC");
                        b1.setVisibility(View.INVISIBLE);
                        b1Die = true;
                    }
                    else if((v1 < -5) && b1Die){
                        sensorManager.unregisterListener((SensorEventListener) this);
                        b2.setVisibility(View.INVISIBLE);
                        b2Die = true;
                    }


                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    if(b1Die && b2Die){
                        System.out.println("(((((((((");
                        Intent intent = new Intent(OnTree1.this , BirdGameFinish.class);
                        startActivity(intent);
                        System.out.println("((DDDDDDDDDDDDDDDDDDDDDDDDDDDDDD((");
                        overridePendingTransition(R.anim.fade_in , R.anim.fade_out);
                        finish();
                    }
                }
            }
        }).start();

        b1 = (RelativeLayout) findViewById(R.id.bird1);
        b2 = (RelativeLayout) findViewById(R.id.bird2);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);


        Asensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        Gsensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        Msensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);


        sensorManager.registerListener(sensorEventListener, Asensor , sensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(sensorEventListener, Gsensor , sensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(sensorEventListener, Msensor , sensorManager.SENSOR_DELAY_NORMAL);



    }



    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("555555555555555555555555555555");
        sensorManager.unregisterListener((SensorEventListener) this);
    }
}