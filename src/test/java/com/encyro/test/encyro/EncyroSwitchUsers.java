package com.encyro.test.encyro;

import com.encyro.pagefactory.homePage;
import com.encyro.pagefactory.loginPage;
import com.encyro.util.TestBed;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class EncyroSwitchUsers extends TestBed {
    
        @Test
        //	@Parameters("myName")
        public void SwitchUser(Method method) throws InterruptedException {
            loginPage objLogin = new loginPage(getDriver(), getWebDriverWait());
            homePage objHome = new homePage(getDriver(), getWebDriverWait());
            System.out.println(method.getName());
            test = extent.createTest(method.getName());

            objLogin.clickLoginMenuBtn();
            objLogin.Login("encyrodev04@yopmail.com", "P@55word");
            objHome.clickAcntDrpDnButton();
            objHome.clickAddAcntBtn();
            objLogin.Login("encyrodev03@yopmail.com", "Welcome@123");
            objHome.clickAcntDrpDnButton();
            objHome.switchAcnt("encyrodev04@yopmail.com");
            objHome.clickLogout();
        }

}
