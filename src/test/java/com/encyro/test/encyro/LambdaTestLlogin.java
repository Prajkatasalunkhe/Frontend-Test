package com.encyro.test.encyro;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LambdaTestLlogin {

        private RemoteWebDriver driver;

    @BeforeMethod
        public void setup(Method m, ITestContext ctx) throws MalformedURLException {
            String username = System.getenv("LT_USERNAME") == null ? "hemangihere" : System.getenv("LT_USERNAME");
            String authkey = System.getenv("LT_ACCESS_KEY") == null ? "HXYulgNmkdDliTmsRYNj0AuqOJ8eWmW4hNqdv1h0hDUju2CXGT" : System.getenv("LT_ACCESS_KEY");
            String hub = "@hub.lambdatest.com/wd/hub";

            DesiredCapabilities caps = new DesiredCapabilities();
            // Configure your capabilities here

        caps.setCapability("platform", "Windows 10");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("version", "92.0");
        caps.setCapability("resolution", "1024x768");
                caps.setCapability("build", "encyro Demo Login1");
            caps.setCapability("name", m.getName() + this.getClass().getName());
            caps.setCapability("plugin", "git-testng");

            String[] Tags = new String[] { "Feature", "Magicleap", "Severe" };
            caps.setCapability("tags", Tags);

            driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
        }

        @Test
        public void testEncyro02() throws Exception {


            String produrl = "https://alpha20200204.encyro.com/";

            System.out.println(produrl);
            driver.get(produrl);
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
            WebDriverWait mywait = new WebDriverWait(driver, Duration.ofMinutes(3));

            mywait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li/a[@href=\"/my\"]/span[text()='Login']")));

            Thread.sleep(3000);

            driver.findElement(By.id("lgusrname")).sendKeys("encyrodev04@yopmail.com");
//        driver.findElement(By.xpath("id=\"lgusrname\""));

            driver.findElement((By.id("lgpasswd"))).sendKeys("P@55word");
//            //driver.findElement(By.xpath("//button[@type=\"submit\" and contains(text(),'Log in')]")).click();
//            Thread.sleep(4000);
//            driver.findElement(By.xpath("//div[@id='lgn-optns']/div[5]/button")).click();
//            driver.findElement(By.xpath("//div[@id='lgn-optns']/div[6]/div/form/button")).click();
//            driver.findElement(By.id("fldrs")).click();
//            driver.findElement(By.id("nv-actv-acntnm")).click();
//            driver.findElement(By.xpath("//div[@id='navtopmenu']/ul/li[4]/div/button")).click();
//            driver.findElement(By.id("lgusrname")).click();
//            driver.findElement(By.id("lgn-optns")).click();
//            driver.findElement(By.id("lgn-optns")).click();
//            driver.findElement(By.id("lgusrname")).click();
//            driver.findElement(By.id("lgusrname")).clear();
//            driver.findElement(By.id("lgusrname")).sendKeys("encyrodev03@yopmail.com");
//            driver.findElement(By.id("lgpasswd")).clear();
//            driver.findElement(By.id("lgpasswd")).sendKeys("Welcome@123");
//            driver.findElement(By.xpath("//div[@id='lgn-optns']/div[6]/div/form/button")).click();
//            driver.findElement(By.id("lgusrname")).clear();
//            driver.findElement(By.id("lgusrname")).sendKeys("encyrodev03@yopmail.com");
//            driver.findElement(By.id("lgpasswd")).clear();
//            driver.findElement(By.id("lgpasswd")).sendKeys("Welcome@123");
//            driver.findElement(By.xpath("//div[4]/form/input")).clear();
//            driver.findElement(By.xpath("//div[4]/form/input")).sendKeys("encyrodev03@yopmail.com");
//            driver.findElement(By.xpath("//div[4]/form/div/input")).clear();
//            driver.findElement(By.xpath("//div[4]/form/div/input")).sendKeys("Welcome@123");
//            driver.findElement(By.id("nv-actv-acntnm")).click();
//            driver.findElement(By.xpath("//div[@id='nv-acnts']/div/div[2]")).click();
        }



        @AfterMethod
        public void tearDown() {
            String status = "failed";
            driver.executeScript("lambda-status=" + status);
            driver.quit();
        }

    }

