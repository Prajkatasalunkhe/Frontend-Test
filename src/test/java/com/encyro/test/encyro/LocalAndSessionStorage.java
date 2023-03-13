package com.encyro.test.encyro;

import com.encyro.util.CustUtil;
import com.encyro.util.FileUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.html5.WebStorage;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.Set;

public class LocalAndSessionStorage {

    @Test
    public void test() throws InterruptedException {

        WebDriver driver;

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(10));


        String produrl = "https://alpha20200204.encyro.com";

        System.out.println(produrl);
        driver.get(produrl);

        SessionStorage session1 = ((WebStorage) driver).getSessionStorage();
        LocalStorage local = ((WebStorage) driver).getLocalStorage();


        System.out.println("************");
        System.out.println(local.size()+"**"+session1.size());
        String TempFolder = System.getProperty("user.dir") + "/Temp";
        new File(TempFolder).mkdir();
        String locStrFileName = TempFolder+ "/LocStr_" + CustUtil.getCurrentDateTimeStamp()+".txt";
        String sessionStrFileName = TempFolder+ "/SessionStr_" + CustUtil.getCurrentDateTimeStamp()+".txt";
        Set<String> LocKeys = local.keySet();
        Set<String> SessKeys = session1.keySet();

        String finalLocStrFileName = locStrFileName;
        LocKeys.forEach((s) ->
                FileUtil.writeLineToFile(finalLocStrFileName,s+" : "+((WebStorage) driver).getLocalStorage().getItem(s))
        );


        String finalSessionStrFileName = sessionStrFileName;
        SessKeys.forEach((s1) ->
                FileUtil.writeLineToFile(finalSessionStrFileName,s1+" : "+((WebStorage) driver).getSessionStorage().getItem(s1))
        );
        System.out.println("************");




        Thread.sleep(3000);



        driver.findElement(By.xpath("//li/a[@href=\"/my\"]/span[text()='Login']")).click();


        Thread.sleep(3000);

        driver.findElement(By.id("lgusrname")).sendKeys("encyrodev04@yopmail.com");
//        driver.findElement(By.xpath("id=\"lgusrname\""));

        driver.findElement((By.id("lgpasswd"))).sendKeys("P@55word");
        driver.findElement(By.xpath("//button[@type=\"submit\" and contains(text(),'Log in')]")).click();
        Thread.sleep(5000);
        local = ((WebStorage) driver).getLocalStorage();
        session1 = ((WebStorage) driver).getSessionStorage();
//        System.out.println( local.toString());
        LocKeys = local.keySet();
       SessKeys = session1.keySet();

        System.out.println("************");
        System.out.println(local.size()+"**"+session1.size());
         locStrFileName = TempFolder+ "/LoginLocStr_" + CustUtil.getCurrentDateTimeStamp()+".txt";
         sessionStrFileName = TempFolder+ "/LoginSessionStr_" + CustUtil.getCurrentDateTimeStamp()+".txt";

        String finalLocStrFileName1 = locStrFileName;
        LocKeys.forEach((s) ->
                FileUtil.writeLineToFile(finalLocStrFileName1,s+" : "+((WebStorage) driver).getLocalStorage().getItem(s))
        );


        String finalSessionStrFileName1 = sessionStrFileName;
        SessKeys.forEach((s1) ->
                FileUtil.writeLineToFile(finalSessionStrFileName1,s1+" : "+((WebStorage) driver).getSessionStorage().getItem(s1))
        );
        System.out.println("************");

        driver.close();
        driver.quit();

    }

}
