package com.passit;

import android.app.Application;

/**
 * Created by muthukrishnan on 23/05/15.
 */
public class PassitApplication extends Application {

    private static PassitApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;
    }

    public static Application getApplication() {
        return  mInstance;
    }
}
