package com.auto.tests;

import com.auto.test.pages.OrangeCRMSanitySuite.ValidateRegisterUserPage;
import com.framework.core.helper.Hookes;
import org.testng.annotations.Test;

//---Sanity Test Suite for ORANGE CRM portal 9th March
public class OrangeCRMSanitySuiteTest extends Hookes
{
    @Test
    public void validateRegisterUser() throws Exception {
        ValidateRegisterUserPage validateRegisterUserPage= new ValidateRegisterUserPage();
        validateRegisterUserPage.loginAS("Admin","admin123","btn_LogIn");
        validateRegisterUserPage.clickPMIManu("btn_PMIMenu");
    }

    public void validateEmployeeInfo()
    {

    }

    public void validateSearchFunctionality()
    {

    }

    public void validateTimeSheetfunctionality()
    {

    }
}
