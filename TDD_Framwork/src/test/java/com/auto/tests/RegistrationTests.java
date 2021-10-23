package com.auto.tests;

import com.auto.test.pages.HomePage;
import com.auto.test.pages.RegistrationPage;
import com.framework.core.component.DataProviderUtils;
import com.framework.core.helper.Hookes;


import org.testng.annotations.Test;

public class RegistrationTests extends Hookes
{
    @Test(dataProvider = "ExcelDataProvider", dataProviderClass = DataProviderUtils.class)
    public void registerUserUsingRandomData(String UserName, String Password, String FirstName, String LastName) throws Exception {
        System.out.println(UserName + FirstName + LastName + LastName);
        HomePage homePage = new HomePage();
        homePage.clickOnSignIn();

        RegistrationPage registrationPage = homePage.createAnAccountAs(UserName);
        registrationPage.registerUserAs(UserName,Password,FirstName,LastName);
        Thread.sleep(4000);
    }
}