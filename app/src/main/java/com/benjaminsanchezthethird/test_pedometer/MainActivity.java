package com.benjaminsanchezthethird.test_pedometer;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private long steps;

    TextView step_view;
    TextView cal_view;
    TextView mile_view;

    SensorManager sensorManager;
    Sensor sSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*variables*/
        steps = 0;

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);

        step_view = (TextView) findViewById(R.id.num_counter);
        cal_view = (TextView) findViewById(R.id.num_calories);
        mile_view = (TextView) findViewById(R.id.num_miles);

        //Todo: If data found in save then set text to that data

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();

        sensorManager.registerListener(this, sSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

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

            //ToDo Create a function that calls updates
            String s = Long.toString(steps);
//            String c = Float.toString(getCalories(steps));
//            String m = Float.toString(getMiles(steps));

            //Todo Update default text to show 'calories'
            //Todo Make calories show to the 2nd decimal place
            String c = String.format(Locale.getDefault(), "Calories: %.2f", getCalories(steps));
            String m = String.format(Locale.getDefault(), "Miles: %.2f", getMiles(steps));

            step_view.setText(s); //sets step text
            cal_view.setText(c); //sets calorie text
            mile_view.setText(m); //sets miles text
        }


    }


    //calculations
    public float getCalories(long s){
        //ToDo convert long to float
        //ToDo change calorie count by setting weight in app

        return (float) (s*0.037);
    }

    public float getMiles(long s){
        //information for later
        //height 5.7
        //step length = 2.34 ft
        //miles/steplength = 2262

        if(s == 0){
            return 0;
        } else {
            float ns = (float) s;
            return (ns / 2262);
        }
    }
}
