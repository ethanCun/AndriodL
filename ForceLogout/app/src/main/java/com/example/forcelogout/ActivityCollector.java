package com.example.forcelogout;


import android.app.Activity;

import java.util.ArrayList;

public class ActivityCollector {

    private static ArrayList<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity){

        activities.add(activity);
    }

    public static void removeActivity(Activity activity){

        activities.remove(activity);
    }

    //关闭所有activity
    public static void finishAll(){

        for (int i = 0; i < activities.size(); i++) {

            Activity activityi = activities.get(i);

            if (!activityi.isFinishing()){
                activityi.finish();
            }
        }

        activities.clear();
    }

}
