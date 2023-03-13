package com.encyro.pagefactory;

import com.aventstack.extentreports.Status;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.encyro.util.TestBed;

import com.encyro.util.BasePage;

import static com.encyro.util.TestBed.test;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class yopmail extends BasePage {

    loginPage objLogin = new loginPage(driver, mywait);

    public yopmail(WebDriver driver, WebDriverWait mywait) {
        super(driver, mywait);
        // TODO Auto-generated constructor stub
    }

    @FindBy(id = "ycptcpt")
    WebElement btnYopmailHome;

    @FindBy(id = "login")
    WebElement txtYopmailEmail;
    @FindBy(xpath = "//div[@id='refreshbut']/button/i")
    WebElement btnGoToEmail;

    @FindBy(xpath = "//div[@class='m']/button/div/span[2]")
    WebElement linkFirstEmail;

    @FindBy(xpath = "//table//a[contains(text(),'Access And Let Expire')]")
    WebElement linkAccessAndLetExpire;

    @FindBy(xpath = "//table//a[contains(text(),'Set Password and Access')]")
    WebElement SetPwdAndAccess;

    @FindBy(xpath = "//p/b[contains(text(),'expire on')]")
    WebElement expiryDate;

    public void openYopMailAndOpenEmail(String email, String Subject) throws Exception {
            driver.get("https://yopmail.com/en/");
            btnYopmailHome.click();
            txtYopmailEmail.click();
//        driver.findElement(By.id("login")).click();
            //ERROR: Caught exception [ERROR: Unsupported command [doubleClick | id=login | ]]
            txtYopmailEmail.clear();
            txtYopmailEmail.sendKeys(email);//"alphaencyro03@yopmail.com");
            btnGoToEmail.click();
            Thread.sleep(3000);
            driver.switchTo().frame("ifinbox");

//            linkFirstEmail.click();
            By emailsub = By.xpath("//button[@class=\"lm\"]//div[text()='"+Subject+"']");
            driver.findElement(emailsub).click();
            driver.switchTo().defaultContent();
            Thread.sleep(5000);

            driver.switchTo().frame("ifmail");
        }

        public void  verifyLinksLetItExpAndSetPwd (String email,String sMessage,String subject) throws Exception {
            openYopMailAndOpenEmail(email,subject);
            String originalWindow = driver.getWindowHandle();
            String emailHref = (linkAccessAndLetExpire.getDomProperty("href"));
            String ExpDate = expiryDate.getText();
            String pwdLink = (SetPwdAndAccess.getDomProperty("href"));

//            System.out.println(emailHref);
//            System.out.println(ExpDate);
//            System.out.println(pwdLink);

            test.log(Status.PASS,ExpDate);
            test.log(Status.PASS,emailHref);
            test.log(Status.PASS,pwdLink);

            SetPwdAndAccess.click();
            mywait.until(numberOfWindowsToBe(2));
            Thread.sleep(5000);

            for (String windowHandle : driver.getWindowHandles()) {
                if (!originalWindow.contentEquals(windowHandle)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }

            Thread.sleep(5000);
//            System.out.println("***** "+driver.getTitle());
            mywait.until(titleIs("New Password - Encyro, Inc."));
            test.info("New Password - Encyro, Inc. - Verfied window correctly");

            String pwdWindow = driver.getWindowHandle();
//            System.out.println(driver.getCurrentUrl());
            Assert.assertTrue(pwdLink.equals(driver.getCurrentUrl()), "Access and let it expire URL link is not matching");

            for (String windowHandle : driver.getWindowHandles()) {
                if (originalWindow.contentEquals(windowHandle) ) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }

            driver.switchTo().frame("ifmail");
            linkAccessAndLetExpire.click();

            mywait.until(numberOfWindowsToBe(3));
            Thread.sleep(5000);

            for (String windowHandle : driver.getWindowHandles()) {
                if (!originalWindow.contentEquals(windowHandle) && !pwdWindow.contentEquals(windowHandle)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }

            Thread.sleep(5000);
//            System.out.println("---------"+driver.getTitle());
            mywait.until(titleIs("Secure Message and Files."));
            test.info("Verified secure message and files window");
//            System.out.println(driver.getCurrentUrl());

            System.out.println(sMessage);
//            By secMessage = By.xpath("//div[contains(text(),'"+sMessage+"')]");
            By secMessage = By.xpath("//div[contains(text(),'"+sMessage+"')]");
            By boldGrpMsg = By.xpath("//div/b[text()='test_org_up']");
            System.out.println("&&&&&"+driver.findElement(boldGrpMsg).getText());
            System.out.println("&&&&&"+driver.findElement(secMessage).getText());



        }

    public void verifyAccessNowLink (String email,String Subject) throws Exception {
        openYopMailAndOpenEmail(email,Subject);
        String originalWindow = driver.getWindowHandle();
        driver.findElement(By.linkText("Access Now →")).click();

        String NewUrl = driver.findElement(By.xpath("//div[@id=\"mail\"]//span[contains(text(),\"https://alpha20200204.encyro.com/my?umsg\")]")).getText();
        mywait.until(numberOfWindowsToBe(2));
        System.out.println("NewUrl : " + NewUrl);
        Thread.sleep(5000);

        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        mywait.until(titleIs("Encyro Secure Messages"));

        Assert.assertTrue(NewUrl.equals(driver.getCurrentUrl()), "URL link is not matching");

    }

//        public void AcntLoginAndVerifyScrMsg(String message)throws Exception  {
//            By linkTest = By.xpath("//div[@class=\"txtsecure text-break\" and contains(text(),'"+message+"')]");
////            By linkTest = By.xpath("//div[@class=\"txtsecure text-break\" and contains(text(),'Test Secured Message : 2022_Sep_09_05_19_45')]");
//
//            objLogin.Login("Welcome@123");
////            Thread.sleep(15000);
//            mywait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(linkTest));
//            test.log(Status.PASS, "Email Verified Successfully");
//
//    }

}

