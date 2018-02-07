package com.dafian.android.dfibrinogen.config;

/**
 * @author Dafian on 2/7/18
 */

public class Constants {

    private static final String IP_SIGNAL = "onesignal.com";
    //    private static final String IP_ADDRESS = "192.168.3.8"; // Local
//    private static final String IP_ADDRESS = "192.168.100.16:3000"; // Local
        private static final String IP_ADDRESS = "dfibrinogen-api.herokuapp.com"; // Heroku

    public static final String URL_SIGNAL = "https://" + IP_SIGNAL + "/api/v1/";
    public static final String URL_REST = "http://" + IP_ADDRESS + "/";
    public static final String URL_IMAGE = "http://" + IP_ADDRESS + "/image/";

    public static final String APP_ID = "436c36bb-f900-496b-b3ee-245728b029b7";
    public static final String REST_KEY = "Basic ZTM5YWJlNGQtOWEyOC00OTY2LWJiNzUtYzBiNWY3ZGUxY2Qz";
}
