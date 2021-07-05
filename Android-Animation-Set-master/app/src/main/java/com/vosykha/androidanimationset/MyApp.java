package com.vosykha.androidanimationset;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/*******************************************************************
    Created by Zed, Mai & Kaiwin
    Time:28/06/2021
    Email address:5951071041@st.utc2.edu.vn
 *******************************************************************/


public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
