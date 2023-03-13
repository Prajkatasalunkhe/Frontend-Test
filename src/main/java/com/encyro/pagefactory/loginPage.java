package com.encyro.pagefactory;

import com.encyro.util.CustUtil;
import com.encyro.util.FileUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.encyro.util.BasePage;
import java.io.File;
import java.util.Set;

import static com.encyro.util.TestBed.TestBedBrowser;

public class loginPage extends BasePage {

    homePage objHome = new homePage(driver, mywait);
    ObjectRepository objRepo = new ObjectRepository(driver, mywait);

    public loginPage(WebDriver driver, WebDriverWait mywait) {
        super(driver, mywait);
        // TODO Auto-generated constructor stub
    }

    public void setUserName(String sName) {
        mywait.until(ExpectedConditions.visibilityOf(objRepo.txtUsername));
        objRepo.txtUsername.clear();
        objRepo.txtUsername.sendKeys(sName);
    }

    // Set password in password textbox
    public void setPassword(String sPwd) {
        mywait.until(ExpectedConditions.visibilityOf(objRepo.txtPassword));
        objRepo.txtPassword.clear();
        objRepo.txtPassword.sendKeys(sPwd);
    }
    public void setNavPassword(String sPwd) {
        mywait.until(ExpectedConditions.visibilityOf(objRepo.txtNavPassword));
        objRepo.txtNavPassword.clear();
        objRepo.txtNavPassword.sendKeys(sPwd);
    }
    public void clickLogin() {
        mywait.until(ExpectedConditions.visibilityOf(objRepo.btnLogin));
        mywait.until(ExpectedConditions.elementToBeClickable(objRepo.btnLogin));
        objRepo.btnLogin.click();

    }


    public void clickContinue() {
        mywait.until(ExpectedConditions.visibilityOf(objRepo.btnContinue));
        mywait.until(ExpectedConditions.elementToBeClickable(objRepo.btnContinue));
        objRepo.btnContinue.click();

    }


    public void clickLoginMenuBtn() {
        mywait.until(ExpectedConditions.visibilityOf(objRepo.loginMenuBtn));
        mywait.until(ExpectedConditions.elementToBeClickable(objRepo.loginMenuBtn));
        objRepo.loginMenuBtn.click();

    }

//    Prajakta code forgetpassword

    public void forgetPwdButton() {
        mywait.until(ExpectedConditions.visibilityOf(objRepo.forgetPwdButton));
        mywait.until(ExpectedConditions.elementToBeClickable(objRepo.forgetPwdButton));
        objRepo.forgetPwdButton.click();

    }


//    public void forgetEmailEnter(String emailName) {
//        mywait.until(ExpectedConditions.visibilityOf(objRepo.forgetEmailEnter));
//        objRepo.txtUsername.clear();
//        objRepo.txtUsername.sendKeys(emailName);
//    }


    public void forgetEmaillogin() {
        mywait.until(ExpectedConditions.visibilityOf(objRepo.forgetEmaillogin));
        mywait.until(ExpectedConditions.elementToBeClickable(objRepo.forgetEmaillogin));
        objRepo.forgetEmaillogin.click();

    }




    public void Login(String sName, String pwd) throws InterruptedException {
//		driver.navigate().refresh();
        this.setUserName(sName);
        this.setPassword(pwd);
        this.clickLogin();

        this.forgetPwdButton();
//      this.forgetEmailEnter(emailName);
        this.forgetEmaillogin();


//        mywait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(objRepo.spinner));
        //div[@class="initspinner"]
        mywait.until(ExpectedConditions.invisibilityOfElementLocated(objRepo.spinner));
        String str1 = "(//span[text()='"+sName+"'])[1]";//(//nav//span[@as=\"span\" and text()='"+sName+"'])[1])";

        try {
            Thread.sleep(5000);
            if (!TestBedBrowser.equalsIgnoreCase("safari")) {
                driver.findElement(By.xpath(str1)).isDisplayed();
//                System.out.println(objHome.getHomeUsername());
//                TestBed.test.log(Status.PASS, objHome.getHomeUsername());
                Reporter.log("login successful for user: " + sName);
            }

            cu.captureScreenShot(driver, "After Login");

        } catch (Exception e) {
            try {
                if (!TestBedBrowser.equalsIgnoreCase("safari")) {
                    if (!driver.findElement(By.xpath(str1)).isDisplayed()) {
                        Assert.fail("UserName Not displayed on Login");
                    } else {
                        Assert.fail("Login not successful");
                    }
                }
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
//        mywait.until(ExpectedConditions.elementToBeClickable(objRepo.btnAcntDrpDn));
    }

//    public void Login( String pwd) throws InterruptedException {
//        this.setNavPassword(pwd);
//        this.clickContinue();
//
//        //div[@class="initspinner"]
//        mywait.until(ExpectedConditions.invisibilityOfElementLocated(objRepo.spinner));
//
//        try {
//            Thread.sleep(2000);
//            if (!TestBedBrowser.equalsIgnoreCase("safari")) {
//                capUserName.isDisplayed();
////                System.out.println(objHome.getHomeUsername());
////                TestBed.test.log(Status.PASS, objHome.getHomeUsername());
//                Reporter.log("login successful for user: ");
//            }
//
//            cu.captureScreenShot(driver, "After Login");
//
//        } catch (Exception e) {
//            try {
//                if (!TestBedBrowser.equalsIgnoreCase("safari")) {
//                    if (!capUserName.isDisplayed()) {
//                        Assert.fail("UserName Not displayed on Login");
//                    } else {
//                        Assert.fail("Login not successful");
//                    }
//                }
//            } catch (Exception e2) {
//                throw new RuntimeException(e2);
//            }
//        }
//        mywait.until(ExpectedConditions.elementToBeClickable(objRepo.btnAcntDrpDn));
//    }
    public void CookiesTest() {
        String TempFolder = System.getProperty("user.dir") + "/Temp";
        new File(TempFolder).mkdir();
        String FileName = TempFolder + "/Cookie_" + CustUtil.getCurrentDateTimeStamp() + ".txt";

        Set<Cookie> cookies = driver.manage().getCookies();

        System.out.println("__________________");
        for (Cookie ck : cookies) {
            FileUtil.writeLineToFile(FileName, "Name: " + ck.getName());
            FileUtil.writeLineToFile(FileName, "Value: " + ck.getValue());
            FileUtil.writeLineToFile(FileName, "Domain: " + ck.getDomain());
            FileUtil.writeLineToFile(FileName, "Path: " + ck.getPath());
            FileUtil.writeLineToFile(FileName, "Expiary: " + ck.getExpiry());
            FileUtil.writeLineToFile(FileName, "Is Secure: " + ck.isSecure());
            FileUtil.writeLineToFile(FileName, "__________________");
        }
    }

}
