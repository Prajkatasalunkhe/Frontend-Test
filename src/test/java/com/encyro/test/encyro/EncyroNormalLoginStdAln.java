package com.encyro.test.encyro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class EncyroNormalLoginStdAln {

    @Test
    public void test() throws InterruptedException {

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
//        options.addArguments("--start-minimized");
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(10));


        String produrl = "https://alpha20200204.encyro.com";

        System.out.println(produrl);
        driver.get(produrl);

        Thread.sleep(3000);
        driver.findElement(By.xpath("//li/a[@href=\"/my\"]/span[text()='Login']")).click();


        Thread.sleep(3000);

        driver.findElement(By.id("lgusrname")).sendKeys("encyrodev04@yopmail.com");
//        driver.findElement(By.xpath("id=\"lgusrname\""));

        driver.findElement((By.id("lgpasswd"))).sendKeys("P@55word");
    driver.findElement(By.xpath("//button[@type=\"submit\" and contains(text(),'Log in')]")).click();
    Thread.sleep(4000);
    driver.close();
    driver.quit();

    }
}
