package com.encyro.test.encyro;

import com.encyro.util.TestBed;
import org.testng.annotations.Test;
import com.encyro.pagefactory.homePage;
import com.encyro.pagefactory.loginPage;

import java.lang.reflect.Method;

public class LoginWithCookies extends TestBed {


    @Test
    //	@Parameters("myName")
    public void LoginWithCookiesTest(Method method) throws InterruptedException {
        loginPage objLogin = new loginPage(getDriver(), getWebDriverWait());
        homePage objHome = new homePage(getDriver(), getWebDriverWait());
        test = extent.createTest(method.getName());

        System.out.println("Cookies Before Login");
        objLogin.CookiesTest();

        objLogin.clickLoginMenuBtn();
        objLogin.Login("encyrodev04@yopmail.com", "P@55word");

        System.out.println("Cookies during Login");
        objLogin.CookiesTest();

        objHome.clickLogout();
        objHome.clickRemove();
        System.out.println("Cookies After Login");
        objLogin.CookiesTest();
        Thread.sleep(3000);
        //		objLogin.Logout();
    }
}
