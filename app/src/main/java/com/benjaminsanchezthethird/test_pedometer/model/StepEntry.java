package com.benjaminsanchezthethird.test_pedometer.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class StepEntry{

    private Date date;
    private float steps;

//    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
//    Date date = new Date();
//    System.out.println(dateFormat.format(date));

    StepEntry(){
        date = new Date();
        steps = 0;
    }

    StepEntry(Date date, Float steps){
        this.date = date;
        this.steps = steps;
    }

    public void updateSteps(float steps){
        this.steps = steps;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getSteps() {
        return steps;
    }

    public void setSteps(float steps) {
        this.steps = steps;
    }


}
