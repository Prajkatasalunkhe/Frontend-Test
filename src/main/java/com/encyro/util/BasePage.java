package com.encyro.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait mywait;

    protected CustUtil cu = new CustUtil();

    public BasePage(WebDriver driver, WebDriverWait mywait) {
        this.driver = driver;

        this.mywait = mywait;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TestBed.TIMEOUT), this);
    }

    protected void waitForElementToAppear(By locator) {
    	mywait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitForElementToDisappear(By locator) {
    	mywait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void waitForTextToDisappear(By locator, String text) {
    	mywait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(locator, text)));
    }
}
