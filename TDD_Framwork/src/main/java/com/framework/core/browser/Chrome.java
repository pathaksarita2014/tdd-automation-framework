package com.framework.core.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Chrome extends BrowserBase
{
    private ChromeOptions option;

    // Set default options for Chrome
    @Override
    public void setDefaultOptions()
    {
        option = new ChromeOptions();
        option.addArguments("--start-maximized");
        option.setAcceptInsecureCerts(true);
        //option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
        //option.addArguments("--disable infobar");
    }

    //Building the browser
    @Override
    public WebDriver buildWebDriver()
    {
        setDefaultOptions();
       /* System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
                + "//src//test//resources//binaries//" + "chromedriver.exe");*/

        System.setProperty("webdriver.chrome.driver","C:\\Users\\patha\\Downloads\\chromedriver_win32 (1)\\" +
                "chromedriver.exe");
        WebDriver driver= new ChromeDriver(option);
        driver.manage().deleteAllCookies(); //make sure all cookies are deleted
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS); //setting the implicit time

        return driver;
    }

}

