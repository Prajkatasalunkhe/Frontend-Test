package com.encyro.test.encyro;

import com.encyro.pagefactory.*;
import com.encyro.util.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

public class composeESign  extends TestBed {

    @Test(priority = 0,enabled=true)
    //	@Parameters("myName")
    public void eSignWithSignature(Method method) throws InterruptedException {
//        WebDriver driver = getDriver();
        loginPage objLogin = new loginPage(getDriver(), getWebDriverWait());
        homePage objHome = new homePage(getDriver(), getWebDriverWait());
        test = extent.createTest(method.getName());

        objLogin.clickLoginMenuBtn();
        objLogin.Login("encyrodev04@yopmail.com", "P@55word");

        objHome.clickComposeEsign();
        String sFile;
        try {
            sFile = new java.io.File(".").getCanonicalPath()+"\\testdata\\sample.txt";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        objHome.selectFileToBrowse(sFile);

        Thread.sleep(8000);
        objHome.clickonAddNewSign();
        objHome.fillAdSignerForm("wfhuser1@gmail.com","wfhuser1","QA");
        objHome.clickOnSave();
//        Thread.sleep(5000);
        CustUtil.pageScrollDown(getDriver());
        objHome.AddSignature();
//        Thread.sleep(5000);

        objHome.AddInitials();
//        Thread.sleep(5000);
        objHome.AddSignDate();
//        Thread.sleep(5000);
        objHome.AddDate();
//        Thread.sleep(5000);
        objHome.AddText();
//        Thread.sleep(5000);
        objHome.AddCheckbox();
//        Thread.sleep(5000);
        objHome.AddCInsertText();
//        Thread.sleep(5000);
        objHome.clickOnNext();

        objHome.clickOnEsignSend();
        objHome.verifyEsignRsstSent();
        objHome.clickLogout();
        objHome.clickRemove();
}


    @Test(priority = 1,enabled=false)
    //	@Parameters("myName")
    public void eSignWitInitials(Method method) throws InterruptedException {
        loginPage objLogin = new loginPage(getDriver(), getWebDriverWait());
        homePage objHome = new homePage(getDriver(), getWebDriverWait());
        test = extent.createTest(method.getName());

        objLogin.clickLoginMenuBtn();
        objLogin.Login("encyrodev04@yopmail.com", "P@55word");

        objHome.clickComposeEsign();

        objHome.selectFileToBrowse("");
//        objHome.esingDoc();
        Thread.sleep(15000);
        objHome.clickonAddNewSign();
        objHome.fillAdSignerForm("wfhuser1@gmail.com","wfhuser1","QA");
        objHome.clickOnSave();
        Thread.sleep(5000);

        objHome.AddInitials();
        Thread.sleep(5000);

        objHome.clickOnNext();

        objHome.clickOnEsignSend();
        objHome.verifyEsignRsstSent();
        objHome.clickLogout();
        objHome.clickRemove();
    }


    @Test(priority = 2,enabled=false)
    //	@Parameters("myName")
    public void eSignWithSignDate(Method method) throws InterruptedException {

        loginPage objLogin = new loginPage(getDriver(), getWebDriverWait());
        homePage objHome = new homePage(getDriver(), getWebDriverWait());
        test = extent.createTest(method.getName());

        objLogin.clickLoginMenuBtn();
        objLogin.Login("encyrodev04@yopmail.com", "P@55word");

        objHome.clickComposeEsign();
        objHome.selectFileToBrowse("");
//        objHome.esingDoc();
        Thread.sleep(15000);
        objHome.clickonAddNewSign();
        objHome.fillAdSignerForm("wfhuser1@gmail.com","wfhuser1","QA");
        objHome.clickOnSave();
        Thread.sleep(5000);


        objHome.AddSignDate();
        Thread.sleep(5000);
//        objHome.AddDate();
//        Thread.sleep(5000);
//        objHome.AddText();
//        Thread.sleep(5000);
//        objHome.AddCheckbox();
//        Thread.sleep(5000);
//        objHome.AddCInsertText();
//        Thread.sleep(5000);
        objHome.clickOnNext();

        objHome.clickOnEsignSend();
        objHome.verifyEsignRsstSent();
        objHome.clickLogout();
        objHome.clickRemove();
    }

    @Test(priority = 3,enabled=false)
    //	@Parameters("myName")
    public void eSignWithDate(Method method) throws InterruptedException {

        loginPage objLogin = new loginPage(getDriver(), getWebDriverWait());
        homePage objHome = new homePage(getDriver(), getWebDriverWait());
        test = extent.createTest(method.getName());

        objLogin.clickLoginMenuBtn();
        objLogin.Login("encyrodev04@yopmail.com", "P@55word");

        objHome.clickComposeEsign();
        objHome.selectFileToBrowse("");
//        objHome.esingDoc();
        Thread.sleep(15000);
        objHome.clickonAddNewSign();
        objHome.fillAdSignerForm("wfhuser1@gmail.com","wfhuser1","QA");
        objHome.clickOnSave();
        Thread.sleep(5000);


        objHome.AddDate();
        Thread.sleep(5000);

        objHome.clickOnNext();

        objHome.clickOnEsignSend();
        objHome.verifyEsignRsstSent();
        objHome.clickLogout();
        objHome.clickRemove();
    }

    @Test(priority = 4,enabled=false)
    //	@Parameters("myName")
    public void eSignWithText(Method method) throws InterruptedException {

        loginPage objLogin = new loginPage(getDriver(), getWebDriverWait());
        homePage objHome = new homePage(getDriver(), getWebDriverWait());
        test = extent.createTest(method.getName());

        objLogin.clickLoginMenuBtn();
        objLogin.Login("encyrodev04@yopmail.com", "P@55word");

        objHome.clickComposeEsign();
        objHome.selectFileToBrowse("");
//        objHome.esingDoc();
        Thread.sleep(15000);
        objHome.clickonAddNewSign();
        objHome.fillAdSignerForm("wfhuser1@gmail.com","wfhuser1","QA");
        objHome.clickOnSave();
        Thread.sleep(5000);

        objHome.AddText();
        Thread.sleep(5000);

        objHome.clickOnNext();

        objHome.clickOnEsignSend();
        objHome.verifyEsignRsstSent();
        objHome.clickLogout();
        objHome.clickRemove();
    }


    @Test(priority = 5,enabled=false)
    //	@Parameters("myName")
    public void eSignWithCheckBox(Method method) throws InterruptedException {

        loginPage objLogin = new loginPage(getDriver(), getWebDriverWait());
        homePage objHome = new homePage(getDriver(), getWebDriverWait());
        test = extent.createTest(method.getName());

        objLogin.clickLoginMenuBtn();
        objLogin.Login("encyrodev04@yopmail.com", "P@55word");

        objHome.clickComposeEsign();
        objHome.selectFileToBrowse("");
//        objHome.esingDoc();
        Thread.sleep(15000);
        objHome.clickonAddNewSign();
        objHome.fillAdSignerForm("wfhuser1@gmail.com","wfhuser1","QA");
        objHome.clickOnSave();
        Thread.sleep(5000);

        objHome.AddCheckbox();
        Thread.sleep(5000);

        objHome.clickOnNext();

        objHome.clickOnEsignSend();
        objHome.verifyEsignRsstSent();
        objHome.clickLogout();
        objHome.clickRemove();
    }

    @Test(priority = 6,enabled=false)
    //	@Parameters("myName")
    public void eSignWithInsertText(Method method) throws InterruptedException {

        loginPage objLogin = new loginPage(getDriver(), getWebDriverWait());
        homePage objHome = new homePage(getDriver(), getWebDriverWait());
        test = extent.createTest(method.getName());

        objLogin.clickLoginMenuBtn();
        objLogin.Login("encyrodev04@yopmail.com", "P@55word");

        objHome.clickComposeEsign();
        objHome.selectFileToBrowse("");
//        objHome.esingDoc();
        Thread.sleep(15000);
        objHome.clickonAddNewSign();
        objHome.fillAdSignerForm("wfhuser1@gmail.com","wfhuser1","QA");
        objHome.clickOnSave();
        Thread.sleep(5000);

        objHome.AddCInsertText();
        Thread.sleep(5000);
        objHome.clickOnNext();

        objHome.clickOnEsignSend();
        objHome.verifyEsignRsstSent();
        objHome.clickLogout();
        objHome.clickRemove();
    }
}
