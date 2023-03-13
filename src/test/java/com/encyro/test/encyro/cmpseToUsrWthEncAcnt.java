package com.encyro.test.encyro;

import com.encyro.pagefactory.homePage;
import com.encyro.pagefactory.loginPage;
import com.encyro.pagefactory.yopmail;
import com.encyro.util.CustUtil;
import com.encyro.util.TestBed;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

public class cmpseToUsrWthEncAcnt extends TestBed {
 String toEmailWithEncyroAccount = "encyrodev03@yopmail.com"; //"alphaencyro03@yopmail.com"
String securedMessage ="Test Secured Message : "+ CustUtil.getCurrentDateTimeStamp();
String subject ="Sub"+CustUtil.getCurrentDateTimeStamp();
    @Test(priority = 0,enabled=true)
    //	@Parameters("myName")
    public void composeSecMesgToUsrWthEncAcntTest(Method method) throws InterruptedException {
        WebDriver drv = getDriver();
        loginPage objLogin = new loginPage(drv, getWebDriverWait());
        homePage objHome = new homePage(drv, getWebDriverWait());
        test = extent.createTest(method.getName());

//        objLogin.clickLoginMenuBtn();
        objLogin.Login("encyrodev04@yopmail.com", "P@55word");

        objHome.clickCompose();
        objHome.enterEmailInToField(toEmailWithEncyroAccount);

        Thread.sleep(3000);

        try {
            String dataFile = new java.io.File(".").getCanonicalPath()+"\\testdata\\cat.png";
            objHome.selectFileUsingBrowse(dataFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        objHome.enterSecuredMessge(securedMessage);
        Thread.sleep(2000);
        objHome.clickOnAddEmailIntro();
        objHome.enterEmailSubject(subject);
     //   drv.findElement(By.xpath("//div[@id=\"new-cmps\"]//button[text()='Add Email Intro']")).click();
//        drv.findElement(By.xpath("//div[@id=\"new-cmps\"]//textarea[@placeholder=\"Subject (not secure)\"]")).sendKeys(subject);
        Thread.sleep(2000);
//        objHome.clickAddEmailIntro();
//        objHome.enterEmailIntroSubject();

        objHome.clickSendBtn();

        objHome.verifyToastrMsgSent();
        objHome.clickLogout();
        objHome.clickRemove();
        int wait = 35000;
        test.info("waiting for seconds: "+wait);
        Thread.sleep(wait);
    }

    @Test(priority = 1,enabled=true) //dependsOnMethods = {"composeSecMesgToUsrWthEncAcntTest"}d
    public void testVerifyEmail(Method method)  throws Exception {
        test = extent.createTest(method.getName());
       yopmail ypml = new yopmail(getDriver(), getWebDriverWait());
        ypml.verifyAccessNowLink(toEmailWithEncyroAccount,subject);
//        ypml.AcntLoginAndVerifyScrMsg(securedMessage);
    }

}
