//package com.encyro.test.encyro;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.MutableCapabilities;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//
//import org.openqa.selenium.safari.SafariOptions;
//import org.testng.ITestContext;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import java.lang.reflect.Method;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.time.Duration;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class SaucelabsTestLlogin2 {
//
//        private RemoteWebDriver driver;
//
//    @BeforeMethod
//        public void setup(Method m, ITestContext ctx) throws MalformedURLException {
//
////        ChromeOptions browserOptions = new ChromeOptions();
////        browserOptions.setPlatformName("Windows 11");
////        browserOptions.setBrowserVersion("latest");
//
//
//        }
//
//        @Test(enabled = false)
//        public void testEncyro02() throws Exception {
//            String produrl = "https://alpha20200204.encyro.com/";
//
//            SafariOptions browserOptions = new SafariOptions();
//            browserOptions.setPlatformName("macOS 11.00");
//            browserOptions.setBrowserVersion("14");
//            Map<String, Object> sauceOptions = new HashMap<>();
//            sauceOptions.put("build", "encyro>");
//            sauceOptions.put("name", "login ");
//            browserOptions.setCapability("sauce:options", sauceOptions);
//            URL url = new URL("https://oauth-wfhuser1-73eca:9bfe8edd-f6da-4558-8451-572e6e682985@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
//            driver = new RemoteWebDriver(url, browserOptions);
//
//            System.out.println(produrl);
//            driver.get(produrl);
////            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
//            WebDriverWait mywait = new WebDriverWait(driver, Duration.ofMinutes(3));
//
//            mywait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li/a[@href=\"/my\"]/span[text()='Login']")));
//
//            Thread.sleep(3000);
//            driver.findElement(By.xpath("//li/a[@href=\"/my\"]/span[text()='Login']")).click();
//
//            Thread.sleep(3000);
//
//            driver.findElement(By.id("lgusrname")).sendKeys("encyrodev04@yopmail.com");
////        driver.findElement(By.xpath("id=\"lgusrname\""));
//
//            driver.findElement((By.id("lgpasswd"))).sendKeys("P@55word");
////            driver.findElement(By.xpath("//button[@type=\"submit\" and contains(text(),'Log in')]")).click();
////            Thread.sleep(4000);
////            driver.findElement(By.xpath("//div[@id='lgn-optns']/div[5]/button")).click();
////            driver.findElement(By.xpath("//div[@id='lgn-optns']/div[6]/div/form/button")).click();
////            driver.findElement(By.id("fldrs")).click();
////            driver.findElement(By.id("nv-actv-acntnm")).click();
////            driver.findElement(By.xpath("//div[@id='navtopmenu']/ul/li[4]/div/button")).click();
////            driver.findElement(By.id("lgusrname")).click();
////            driver.findElement(By.id("lgn-optns")).click();
////            driver.findElement(By.id("lgn-optns")).click();
////            driver.findElement(By.id("lgusrname")).click();
////            driver.findElement(By.id("lgusrname")).clear();
////            driver.findElement(By.id("lgusrname")).sendKeys("encyrodev03@yopmail.com");
////            driver.findElement(By.id("lgpasswd")).clear();
////            driver.findElement(By.id("lgpasswd")).sendKeys("Welcome@123");
////            driver.findElement(By.xpath("//div[@id='lgn-optns']/div[6]/div/form/button")).click();
////            driver.findElement(By.id("lgusrname")).clear();
////            driver.findElement(By.id("lgusrname")).sendKeys("encyrodev03@yopmail.com");
////            driver.findElement(By.id("lgpasswd")).clear();
////            driver.findElement(By.id("lgpasswd")).sendKeys("Welcome@123");
////            driver.findElement(By.xpath("//div[4]/form/input")).clear();
////            driver.findElement(By.xpath("//div[4]/form/input")).sendKeys("encyrodev03@yopmail.com");
////            driver.findElement(By.xpath("//div[4]/form/div/input")).clear();
////            driver.findElement(By.xpath("//div[4]/form/div/input")).sendKeys("Welcome@123");
////            driver.findElement(By.id("nv-actv-acntnm")).click();
////            driver.findElement(By.xpath("//div[@id='nv-acnts']/div/div[2]")).click();
//        }
//    @Test(enabled = true)
//    public void testEncyro03() throws Exception {
//        String produrl = "https://alpha20200204.encyro.com/";
//
//
//        MutableCapabilities caps = new MutableCapabilities();
//        caps.setCapability("platformName", "Android");
//        caps.setCapability("browserName", "Chrome");
//        caps.setCapability("appium:deviceName", "Samsung Galaxy Tab S7 Plus GoogleAPI Emulator");
//        caps.setCapability("appium:platformVersion", "12.0");
//        MutableCapabilities sauceOptions = new MutableCapabilities();
//        sauceOptions.setCapability("appiumVersion", "1.22.1");
//        sauceOptions.setCapability("build", "<your build id>");
//        sauceOptions.setCapability("name", "<your test name>");
//        caps.setCapability("sauce:options", sauceOptions);
//
//        URL url = new URL("https://oauth-wfhuser1-73eca:9bfe8edd-f6da-4558-8451-572e6e682985@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
////        AndroidDriver driver = new AndroidDriver(url, caps);
//        WebDriver driver = new RemoteWebDriver(caps.);
//        System.out.println(produrl);
//        driver.get(produrl);
////            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
//        WebDriverWait mywait = new WebDriverWait(driver, Duration.ofMinutes(3));
//
//        mywait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li/a[@href=\"/my\"]/span[text()='Login']")));
//
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//li/a[@href=\"/my\"]/span[text()='Login']")).click();
//
//        Thread.sleep(3000);
//
//        driver.findElement(By.id("lgusrname")).sendKeys("encyrodev04@yopmail.com");
////        driver.findElement(By.xpath("id=\"lgusrname\""));
//
//     }
//        @AfterMethod
//        public void tearDown() {
//            //String status = "failed";
//          //  driver.executeScript("lambda-status=" + status);
//            driver.close();
//            driver.quit();
//        }
//
//    }
//
