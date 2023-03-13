package com.encyro.test.encyro;

import com.aventstack.extentreports.Status;
import com.encyro.pagefactory.homePage;
import com.encyro.pagefactory.loginPage;
import com.encyro.util.TestBed;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class EncyroLogin extends TestBed {


    @Test
    //	@Parameters("myName")
    public void loginTest(Method method) throws InterruptedException {
        loginPage objLogin = new loginPage(getDriver(), getWebDriverWait());
       homePage objHome = new homePage(getDriver(), getWebDriverWait());
        test = extent.createTest(method.getName());

//       objLogin.clickLoginMenuBtn();
       objLogin.Login("salunkheprajakta14+pstmnth31@gmail.com", "Welcome@123");//""P@55word");

//        Prajakta code forgetpassword
          objLogin.forgetPwdButton();
         Thread.sleep(7000);
//       objLogin.forgetEmailEnter("salunkheprajakta14@gmail.com");
          objLogin.forgetEmaillogin();
           Thread.sleep(3000);

//        objHome.clickLogout();
          Thread.sleep(3000);
//        		objLogin.Logout();
    }
}
