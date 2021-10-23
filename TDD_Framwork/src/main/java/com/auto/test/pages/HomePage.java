package com.auto.test.pages;

import com.framework.core.component.WebComponents;

public class HomePage extends WebComponents
{
    static String pageName=HomePage.class.getSimpleName();

    public HomePage()
    {
        super(pageName);
    }

    public LoginPage clickOnSignIn() throws Exception
    {
        clickElement("btn_SignIn");
        return new LoginPage();
    }

    public String getCustomerName(String element) throws Exception
    {
        String text= getElementText(element);
        return text;
    }

    public void EnterEmailForRegistration(String email) throws Exception{
        typeInto("tbx_EmailCreate",email);
    }

    public void ClickCreateAnAccount() throws Exception{
        clickElement("btn_CreateAnAccount");
    }


    public RegistrationPage createAnAccountAs(String email) throws Exception{
        EnterEmailForRegistration(email);
        ClickCreateAnAccount();
        return new RegistrationPage();
    }

    public void clickOnSelectedItem(String element)
    {
        try
        {
            clickElement(element);

        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println(element + " is clicked");
        }
    }

    public void clickOnItem()
    {
        try
        {
            clickElement("btn_Item");
            System.out.println("btn_Item is clicked");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("btn_Item not clicked");
        }
    }

    public void mouseHoverOnElement(String element)
    {
        try
        {
            MouseHoverElement(element);
            System.out.println("MouseHoverElement is clicked");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("MouseHoverElement not clicked");
        }
    }

    public void switchWindowAndcickElement(String element)
    {
        try
        {
            SelectWindow(element);
            System.out.println("MouseHoverElement is clicked");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("MouseHoverElement not clicked");
        }
    }

    public String getSuccessMassage(String element) throws Exception
    {
        String text= getElementText(element);
        return text;
    }
}
