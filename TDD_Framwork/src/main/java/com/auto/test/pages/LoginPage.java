package com.auto.test.pages;

import com.framework.core.component.WebComponents;

public class LoginPage extends WebComponents {

    static String pageName=LoginPage.class.getSimpleName();

    public LoginPage()
    {
        super(pageName);
    }

    public void enterEmailAddress(String email) throws Exception
    {
        typeInto("tbx_EmailAddress",email);
    }

    public void enterPassword(String password) throws Exception
    {
        typeInto("tbx_Password",password);
    }

    public OrderPage clickSignIn() throws Exception
    {
        clickElement("btn_SignIn");
        return new OrderPage();
    }

    public OrderPage loginAS(String userName,String password) throws Exception
    {
        System.out.println("loginAS is :" + userName + password);
        enterEmailAddress(userName);
        enterPassword(password);
        return clickSignIn();
    }
}
