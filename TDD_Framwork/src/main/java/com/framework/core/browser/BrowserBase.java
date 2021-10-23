package com.framework.core.browser;

import org.openqa.selenium.WebDriver;

// Base class for all type of browsers so we will make this class abstract
public abstract class BrowserBase
{

        public abstract void setDefaultOptions();

        public abstract WebDriver buildWebDriver();

}
