package com.framework.core.helper;

import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;

public class ExtentManager
{

   private static ExtentReports suiteReport;
   public static synchronized ExtentReports getReports()  {
    if(suiteReport==null)
    {
       // Configs.initilizeEnvironmentProperties();
        String extentReportPath = Configs.testResourceFolder + "test-reports";
       // String extentReportPath = "C://work//test-Reports";
        extentReportPath = StringHelper.generateFolderPath(extentReportPath);
        File f = new File(extentReportPath);
        if (!f.isDirectory()) {
            f.mkdirs();
        }
        suiteReport = new ExtentReports(extentReportPath + "//TestResults.html");
        suiteReport.flush();
    }

       return suiteReport;
   }

   /* public static void main(String [] args) throws Exception {
            getReports();
        }*/
}
