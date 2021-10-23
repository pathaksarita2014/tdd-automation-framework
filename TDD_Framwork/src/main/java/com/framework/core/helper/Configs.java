package com.framework.core.helper;

public class Configs {
    public static String AppUrl;
    public static String takeScreenShot;
    public static Long defaultwaitTime;
    public static Long longtwaitTime;
    public static Long mediumwaitTime;
    public static Long shortwaitTime;
    public static String ifLoggingEnabled;
    public static String browser;
    public static String testResourceFolder;

    public static void initilizeEnvironmentProperties() throws Exception {
        PropertyLoader propObj = new PropertyLoader();
        AppUrl = propObj.fetchProperty("App.Url");
        takeScreenShot = propObj.fetchProperty("App.TakeScreenshot");
        /*
         * defaultwaitTime = Long.valueOf(propObj.fetchProperty("App.DefaultWaitTime"));
         * longtwaitTime = Long.valueOf(propObj.fetchProperty("App.LongWaitTime"));
         * mediumwaitTime = Long.valueOf(propObj.fetchProperty("App.MediumWaitTime"));
         * shortwaitTime = Long.valueOf(propObj.fetchProperty("App.ShortWaitTime"));
         */
        ifLoggingEnabled = propObj.fetchProperty("App.GenerateLogs");
        browser = propObj.fetchProperty("App.Browser");
        testResourceFolder = propObj.fetchProperty("App.TestResourceFolder");
    }
}