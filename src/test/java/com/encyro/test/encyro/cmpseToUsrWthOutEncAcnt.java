package com.encyro.test.encyro;

import com.encyro.pagefactory.homePage;
import com.encyro.pagefactory.loginPage;
import com.encyro.pagefactory.yopmail;
import com.encyro.util.CustUtil;
import com.encyro.util.TestBed;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

public class cmpseToUsrWthOutEncAcnt extends TestBed {
    String subject ="Sub"+CustUtil.getCurrentDateTimeStamp();
    String toEmailWithoutEncAccount = "hktester7@yopmail.com";
    String securedMessage ="TestSecuredMessage_"+ CustUtil.getCurrentDate();
    @Test(priority = 0,enabled=true)
    //	@Parameters("myName")
    public void composeSecMsgToUsrWthOutEncAcntTest(Method method) throws InterruptedException {
        loginPage objLogin = new loginPage(getDriver(), getWebDriverWait());
        homePage objHome = new homePage(getDriver(), getWebDriverWait());
        test = extent.createTest(method.getName());

        objLogin.clickLoginMenuBtn();
        objLogin.Login("encyrodev04@yopmail.com", "P@55word");

        objHome.clickCompose();
        objHome.enterEmailInToField(toEmailWithoutEncAccount);

        objHome.enterSecuredMessge(securedMessage);
        Thread.sleep(2000);
        objHome.clickOnAddEmailIntro();
        objHome.enterEmailSubject(subject);
        int wait = 35000;
        test.info("waiting for seconds: "+wait);
        Thread.sleep(wait);

        try {
            String dataFile = new java.io.File(".").getCanonicalPath()+"\\testdata\\cat.png";
            objHome.selectFileUsingBrowse(dataFile);
        } catch (IOException e)  {
            throw new RuntimeException(e);
        }

        objHome.clickSendBtn();

        objHome.verifyToastrMsgSent();
        objHome.clickLogout();
        objHome.clickRemove();
        Thread.sleep(30000);
    }



    @Test(priority = 1,enabled=true,dependsOnMethods = {"composeSecMsgToUsrWthOutEncAcntTest"})
    public void testVerifyEmailWithOutEncAcnt(Method method)  throws Exception {
        test = extent.createTest(method.getName());
        yopmail ypml = new yopmail(getDriver(), getWebDriverWait());
        ypml.verifyLinksLetItExpAndSetPwd(toEmailWithoutEncAccount,securedMessage,subject);

    }

}
