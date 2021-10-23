package com.auto.test.pages;

import com.framework.core.component.WebComponents;

public class RegistrationPage extends WebComponents
{
    static String PageName = RegistrationPage.class.getSimpleName();

    public RegistrationPage()
    {
        super(PageName);
    }

    public void enterEmailAddress(String email) throws Exception {
        typeInto("tbx_Email", email);
    }

    public void enterPassword(String password) throws Exception {
        typeInto("tbx_Password", password);
    }

    public void enterFirstName(String firstName) throws Exception{
        typeInto("tbx_FirstName", firstName);
    }

    public void enterLastName(String lastName) throws Exception{
        typeInto("tbx_LastName", lastName);
    }

    public void registerUserAs(String email, String password, String firstName, String lastName) throws Exception {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmailAddress(email);
        enterPassword(password);
    }

}