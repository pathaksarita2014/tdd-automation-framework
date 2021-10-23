package com.framework.core.helper;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;

public class TestAsserts
{
    public static void assertEquals(String expectedValue, String actualValue)
    {
        Assert.assertEquals(actualValue, expectedValue);
    }

    public static void assertEquals(int expectedValue, int actualValue)
    {
        Assert.assertEquals(actualValue, expectedValue);
    }

    public static void assertNotEquals(String expectedValue, String actualValue)
    {
        Assert.assertNotEquals(actualValue, expectedValue);
    }

    public static void assertIfVisible(WebElement element)
    {
        Assert.assertTrue(element.isDisplayed());
    }

    public static void assertIfEnabled(WebElement element)
    {
        Assert.assertTrue(element.isEnabled());
    }

    public static void assertEquals(boolean expectedValue, boolean actualValue)
    {
        Assert.assertEquals(actualValue, expectedValue);
    }

    public static void assertNotnull(String value)
    {
        Assert.assertNotNull(value);
    }


    public static void assertEquals(List<String> originalList, List<String> sortedlList) {
        Assert.assertEquals(originalList, sortedlList);

    }
}

