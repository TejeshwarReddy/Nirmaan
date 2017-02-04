package bphc.com.nirmaan.app;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by tejeshwar on 2/2/17.
 */

public class LoginPrefs {

    private static SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences(Constants.PACKAGE_NAME, 0);
    }

    public static long getSuccessPref(Context context) {
        return getPrefs(context).getLong(Constants.login_success, -1);
    }

    public static long getPrivilagePref(Context context) {
        return getPrefs(context).getLong(Constants.login_privilege,-1);
    }

    public static String getNamePref(Context context) {
        return getPrefs(context).getString(Constants.login_name, "");
    }

    public static String getPasswordPref(Context context) {
        return getPrefs(context).getString(Constants.login_password, "");
    }

    public static void setPrefs(Context context, String name, String password, long success, long privilage) {
        // perform validation etc..
        getPrefs(context).edit().putString(Constants.login_name, name).apply();
        getPrefs(context).edit().putString(Constants.login_password, password).apply();
        getPrefs(context).edit().putLong(Constants.login_success, success).apply();
        getPrefs(context).edit().putLong(Constants.login_privilege, privilage).apply();
    }
}
