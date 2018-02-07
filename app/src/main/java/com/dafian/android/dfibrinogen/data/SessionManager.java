package com.dafian.android.dfibrinogen.data;

import android.content.SharedPreferences;

import com.dafian.android.dfibrinogen.data.entity.UserProfile;

/**
 * @author Dafian on 2/7/18
 */

public class SessionManager {

    private final SharedPreferences preferences;

    private static final String IS_LOGIN = "is_login";

    private static final String USER_ID = "user_id";
    private static final String USERNAME = "username";
    private static final String FULL_NAME = "full_name";

    public SessionManager(SharedPreferences preferences) {
        this.preferences = preferences;
    }

    public void setUserLogin() {

        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(IS_LOGIN, true);
        editor.apply();
    }

    public Boolean isUserLogin() {
        return preferences.getBoolean(IS_LOGIN, false);
    }

    public void saveUser(UserProfile user) {

        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(USER_ID, user.getId());
        editor.putString(USERNAME, user.getUsername());
        editor.putString(FULL_NAME, user.getFullName());
        editor.apply();
    }

    public UserProfile getUser() {

        UserProfile user = new UserProfile();
        user.setId(preferences.getInt(USER_ID, 0));
        user.setUsername(preferences.getString(USERNAME, ""));
        user.setFullName(preferences.getString(FULL_NAME, ""));
        return user;
    }

    public void logOut() {

        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(IS_LOGIN);
        editor.remove(USER_ID);
        editor.remove(USERNAME);
        editor.apply();
    }
}
