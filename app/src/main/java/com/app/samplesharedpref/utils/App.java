package com.app.samplesharedpref.utils;

import android.app.Application;

/**
 * Created by Fariz Ramadhan.
 * website : https://farizdotid.com/
 * github : https://github.com/farizdotid
 * linkedin : https://www.linkedin.com/in/farizramadhan/
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        SharedPrefManager.getInstance(this);
    }
}