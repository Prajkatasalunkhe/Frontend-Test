package com.encyro.test.encyro;

import com.encyro.pagefactory.homePage;
import com.encyro.pagefactory.loginPage;
import com.encyro.util.TestBed;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Method;

public class EncyroForwardMessage extends TestBed {

    @Test(enabled=true,priority = 0)
    public void Forward( Method method) throws InterruptedException {

        loginPage objLogin = new loginPage(getDriver(), getWebDriverWait());
        homePage objHome = new homePage(getDriver(), getWebDriverWait());
        System.out.println(method.getName());
        test = extent.createTest(method.getName());

        objLogin.clickLoginMenuBtn();
        objLogin.Login("encyrodev04@yopmail.com", "P@55word");

        objHome.selectFolder("encyro21user2@yopmail.com");

        objHome.selectMessageToForward("encyro21user2@yopmail.com");

        objHome.enterEmailInToField("wfhuser1@gmail.com");
//        objHome.selectFileUsingBrowse("e:\\testdata\\cat.png");
        try {
            String dataFile = new java.io.File(".").getCanonicalPath()+"\\testdata\\cat.png";
            objHome.selectFileUsingBrowse(dataFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        objHome.clickSendBtn();

        objHome.verifyToastrMsgSent();
        objHome.clickLogout();
    }

    @Test(enabled=false)
    public void Forward2( Method method) {
        test = extent.createTest(method.getName());

    }
}
