package com.dafian.android.dfibrinogen.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author Dafian on 2/7/18
 */

public class Helper {

    private static final String PREF_NAME = "dfibrinogen_pref";

    public static SharedPreferences getDefaultPreferences(Context context) {
        return context.getSharedPreferences(PREF_NAME, 0);
    }
}
