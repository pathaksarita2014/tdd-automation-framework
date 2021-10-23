package com.framework.core.helper;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyLoader
{
    public static Properties _prop;

    //Loading the Properties from file and return
    public Properties loadPropertyFile(String envName) throws Exception
    {
        File propertyFile = new File(System.getProperty("user.dir")
                + "//src//test//resources//configs//" + "staging.properties");
        _prop= new Properties();
        _prop.load(new FileInputStream(propertyFile));
        return _prop;
    }

    //Getting the properties using "getProperty" Once the properties are loaded
    public String fetchProperty(String propertyName) throws Exception
    {
       // loadPropertyFile(System.getProperty("envName")); //load property file
        loadPropertyFile("staging"); //load property file
        String value= _prop.getProperty(propertyName); //Get Property
        return value;
    }

}

