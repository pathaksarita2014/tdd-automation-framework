package com.auto.test.pages;

import com.framework.core.component.WebComponents;

public class OrderPage extends WebComponents
{
    static String pageName=OrderPage.class.getSimpleName();
    public OrderPage()
    {
        super(pageName);

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
}
