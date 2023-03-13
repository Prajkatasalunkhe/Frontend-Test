package com.encyro.test.encyro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class EncyroFbLogin {

    @Test
    public void LoginViaFBStandAlone() throws InterruptedException {
        String produrl = "https://alpha20200204.encyro.com";

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(produrl);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//li/a[@href=\"/my\"]/span[text()='Login']")).click();

        driver.findElement(By.xpath("//div[@class=\"socialbtn fbsignbtn\"]/img")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("9880272369"); //Welcome@123
        driver.findElement(By.xpath("//input[@name=\"pass\"]")).sendKeys("Welcome@123");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@name=\"login\"]")).click();
        Thread.sleep(5000);
        driver.close();
        driver.quit();

    }
}
