package com.encyro.test.encyro;


        import java.time.Duration;

        import org.testng.annotations.*;
        import static org.testng.Assert.*;
        import org.openqa.selenium.*;
        import org.openqa.selenium.chrome.ChromeDriver;


public class checkEmailAndClickLink {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private JavascriptExecutor js;

    @BeforeClass(alwaysRun = true)
    public void setUp()  {
        System.setProperty("webdriver.chrome.driver", "");
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        js = (JavascriptExecutor) driver;
    }

    @Test
    public void testVerifyEmail2()  {
        driver.get("https://yopmail.com/en/");
        driver.findElement(By.id("ycptcpt")).click();
        driver.findElement(By.id("login")).click();
        driver.findElement(By.id("login")).click();
        //ERROR: Caught exception [ERROR: Unsupported command [doubleClick | id=login | ]]
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys("alphaencyro03@yopmail.com");
        driver.findElement(By.xpath("//div[@id='refreshbut']/button/i")).click();
        //ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=0 | ]]
        driver.findElement(By.xpath("//div[@id='e_ZwVjBGN4ZGRmZwN4ZQNjZmLmZmx4AN==']/button/div/span[2]")).click();
        //ERROR: Caught exception [ERROR: Unsupported command [selectFrame | relative=parent | ]]
        //ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=2 | ]]
        driver.findElement(By.linkText("Access Now →")).click();
        driver.get("https://alpha20200204.encyro.com/my?umsg=EAAAADah%2BJRv78gsxenw5z0%2BgJ1BhkY9zkO6PA2scq5lemM0hzGO%2FKxtIbc92794aW0Z8htAr9JeMWlyHMm8%2BG00aulR5gIGSZWu84zgGF3vq3Z%2F5pWMnZWqBEiifL4prxGihEg3tqGT%2FrTkmJX%2FAkX7%2BhtztZzyNwQ9UcU4AsDBWSTi&eml=YWxwaGFlbmN5cm8wM0B5b3BtYWlsLmNvbQ%3D%3D&lgts=n");
        //ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_1 | ]]
        driver.close();
        //ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_local | ]]
    }

    @AfterClass(alwaysRun = true)
    public void tearDown()  {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
