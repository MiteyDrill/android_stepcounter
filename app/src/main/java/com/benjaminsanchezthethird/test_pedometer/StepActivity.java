package com.benjaminsanchezthethird.test_pedometer;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.Toast;

/*Manages step changes*/

public class StepActivity extends Activity implements SensorEventListener {

    private long steps;

    StepActivity(){
        this.steps = 0;
    }

    SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
    Sensor sSensor= sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy){

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;
        float[] values = event.values;
        int value = -1;

        if (values.length > 0) {
            value = (int) values[0];
        }


        if (sensor.getType() == Sensor.TYPE_STEP_DETECTOR) {
            steps++;

//            Toast.makeText(this, Long.toString(steps), Toast.LENGTH_SHORT).show();
        }


    }

    public long getSteps() {
        return steps;
    }
}