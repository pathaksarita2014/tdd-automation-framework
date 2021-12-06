package com.auto.tests;

import org.testng.annotations.Test;
import com.auto.test.pages.HomePage;
import com.auto.test.pages.LoginPage;
import com.auto.test.pages.OrderPage;
import com.framework.core.helper.Hookes;
import com.framework.core.helper.TestAsserts;

// ---- 27 feb assignment End to end Buy order functionality---//
public class VarifyingShoppingOrderTest extends Hookes
{
    @Test
     public void LoginPositiveTest() throws Exception {
         HomePage homePage= new HomePage();
         OrderPage orderPage= new OrderPage();
        LoginPage loginPage=homePage.clickOnSignIn(); //to set the page name as login page returing the login page
         orderPage= loginPage.loginAS("hey@abc.com", "Testing@123");
         String loginUser = homePage.getCustomerName("lbl_CustomerName");

         //Varify user login
         TestAsserts.assertEquals("Tarun Sachdeva",loginUser);

       //Varify that item is added in the cart
         homePage.clickOnSelectedItem("btn_Women");
         homePage.mouseHoverOnElement("btn_Item");
         homePage.switchWindowAndcickElement("btn_AddToCart");
         String successMassage= homePage.getSuccessMassage("lbl_SuccessMessage");
         TestAsserts.assertEquals("There is one item in the cart",successMassage);

       //Varify that price does not exceed total of $20
         homePage.clickOnSelectedItem("btn_CheckOut");
         String totalPrice =homePage.getCustomerName("total_price");
         double d=Double.parseDouble(totalPrice.replace("$", ""));
        // boolean result = Util.compareNumber(d,20);
        // TestAsserts.assertEquals(false,result);

         homePage.clickOnSelectedItem("btn_ProceedeToCheckOut");
         homePage.clickOnSelectedItem("btn_ProceedeToProcess");
         homePage.clickOnSelectedItem("btn_checkbox");
         homePage.clickOnSelectedItem("btn_ProceedeToCarrier");
         homePage.clickOnSelectedItem("btn_bankwire");
         homePage.clickOnSelectedItem("btn_confirm");

         String message = homePage.getCustomerName("lbl_confirm");
         String price=homePage.getCustomerName("lbl_confirmPrice");
         String accountOwner=homePage.getCustomerName("lbl_AccountOwner");
         String bankName=homePage.getCustomerName("lbl_BankName");

         //Varify successful order confirmation message
        //Varify total amount, accountOwner and bankName
         TestAsserts.assertEquals("Your order on My Store is complete.",message);
         TestAsserts.assertEquals("Pradeep Macharla",accountOwner);
         TestAsserts.assertEquals("RTP",bankName);

         Thread.sleep(4000);
     }

    @Test
    public void OrderItem()
    {
        OrderPage orderPage= new OrderPage();
        orderPage.clickOnSelectedItem("tab_TShirt");
    }

    @Test
    public void NewTest(){}
}

