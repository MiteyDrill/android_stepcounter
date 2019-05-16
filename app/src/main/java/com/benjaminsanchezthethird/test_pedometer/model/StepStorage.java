package com.benjaminsanchezthethird.test_pedometer.model;

import android.content.Context;
import android.widget.Toast;

import java.util.Date;
import java.util.ArrayList;

public class StepStorage {

    ArrayList<StepEntry> list;

    //if old storage is found set it as current
    public StepStorage(ArrayList<StepEntry> st){
        list.addAll(st);
    }

    public StepStorage(){
        list = new ArrayList<StepEntry>();
    }

    public void addEntry(Float entry){

        if(list.size() > 0){
            list.get(list.size()).setSteps(entry);
        } else {
            Date d = new Date();
            StepEntry e = new StepEntry(d, entry);
            list.add(e);
        }
    }

    public void updateEntry(float steps){

        Date tempDate = new Date();

        //retrieves latest entry of list and compares that entries date to today's date
        //Todo Get this to work
//        if(list.get(list.size()-1).getDate() == tempDate){
//            //Todo make this less confusing
//
//            //sets steps of latest entry to the steps of the new entry
//            list.get(list.size()-1).setSteps(steps);
//        }

        list.get(list.size()-1).setSteps(steps);
    }

    public Float getTodaysSteps(Context context){

        Float num = list.get(list.size()-1).getSteps();

        Toast.makeText(context, String.valueOf(num), Toast.LENGTH_LONG).show();
        return list.get(list.size()-1).getSteps();
    }


}
