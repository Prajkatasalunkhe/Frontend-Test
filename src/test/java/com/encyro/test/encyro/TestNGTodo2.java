package com.encyro.test.encyro;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.support.ui.WebDriverWait;

public class TestNGTodo2 {

    private RemoteWebDriver driver;
    private final String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String username = System.getenv("LT_USERNAME") == null ? "hemangihere" : System.getenv("LT_USERNAME");
        String authkey = System.getenv("LT_ACCESS_KEY") == null ? "HXYulgNmkdDliTmsRYNj0AuqOJ8eWmW4hNqdv1h0hDUju2CXGT" : System.getenv("LT_ACCESS_KEY");
        String hub = "@hub.lambdatest.com/wd/hub";

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("105.0");
        HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("username", "hemangihere");
        ltOptions.put("accessKey", "HXYulgNmkdDliTmsRYNj0AuqOJ8eWmW4hNqdv1h0hDUju2CXGT");
        ltOptions.put("project", "Untitled");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        browserOptions.setCapability("LT:Options", ltOptions);

        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), browserOptions);
    }

    @Test
    public void basicTest() throws InterruptedException {

        System.out.println("Loading Url");

        driver.get("https://www.softwaretestinghelp.com/browser-testing-with-lambdatest/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
        WebDriverWait mywait = new WebDriverWait(driver, Duration.ofMinutes(3));

        mywait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li/a[@href=\"/my\"]/span[text()='Login']")));

        Thread.sleep(3000);
        driver.findElement(By.xpath("//li/a[@href=\"/my\"]/span[text()='Login']")).click();

        Thread.sleep(3000);


    }

    @AfterMethod
    public void tearDown() {
        driver.executeScript("lambda-status=" + Status);
        driver.quit();
    }

}