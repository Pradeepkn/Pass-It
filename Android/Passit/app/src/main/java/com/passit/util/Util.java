package com.passit.util;

import com.passit.PassitApplication;

/**
 * Created by muthukrishnan on 23/05/15.
 */
public class Util {

    public static String getString(int id) {
        return PassitApplication.getApplication().getResources().getString(id);
    }
}
