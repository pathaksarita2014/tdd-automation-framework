package com.auto.test.pages.OrangeCRMSanitySuite;

import com.auto.test.pages.OrderPage;
import com.framework.core.component.WebComponents;

public class ValidateRegisterUserPage extends WebComponents
{

    static String  pageName=ValidateRegisterUserPage.class.getSimpleName();
    public ValidateRegisterUserPage()
    {
        super(pageName);
    }

    public void enterUserName(String email) throws Exception
    {
        typeInto("tbx_UserName",email);
    }

    public void enterPassword(String password) throws Exception
    {
        typeInto("tbx_Password",password);
    }

    public void clickLogin(String btnElement) throws Exception
    {
        clickElement(btnElement);
    }

    public void loginAS(String userName,String password,String btnElement) throws Exception
    {
        System.out.println("loginAS is :" + userName + password);
        enterUserName(userName);
        enterPassword(password);
         clickLogin(btnElement);
    }

    public void clickPMIManu(String btnElement) throws Exception
    {
        clickElement(btnElement);
    }
}
