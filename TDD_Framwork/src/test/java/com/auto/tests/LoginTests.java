package com.auto.tests;
import com.auto.test.pages.HomePage;
import com.auto.test.pages.LoginPage;
import com.auto.test.pages.OrderPage;
import com.framework.core.component.DataProviderUtils;
import com.framework.core.helper.Hookes;
import org.testng.annotations.Test;

//-----DataProvider example recording of date 28 FEB------//
public class LoginTests extends Hookes
{
    private OrderPage orderPage;

    @Test(dataProvider = "ExcelDataProvider", dataProviderClass = DataProviderUtils.class)
    public void loginScenario(String UserName, String Password, String FirstName, String LastName)
            throws Exception
    {
        System.out.println("UserName: " + UserName + ", Password: " + Password + ", FirstName: "
                + FirstName + ", LastName: " + LastName);

        HomePage homePage= new HomePage();
        LoginPage loginPage=homePage.clickOnSignIn(); //to set the page name as login page returing the login page
        orderPage= loginPage.loginAS(UserName, Password);
      //  String loginUser = homePage.getCustomerName("lbl_CustomerName");
    }

}
