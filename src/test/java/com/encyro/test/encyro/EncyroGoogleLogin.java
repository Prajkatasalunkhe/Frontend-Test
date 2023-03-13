package com.encyro.test.encyro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class EncyroGoogleLogin {

    @Test
    public void LoginViaGoogleStandAlone() throws InterruptedException {
        String produrl = "https://alpha20200204.encyro.com";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(10));
        driver.get(produrl);

        Thread.sleep(3000);
        driver.findElement(By.xpath("//li/a[@href=\"/my\"]/span[text()='Login']")).click();

        driver.findElement(By.xpath("//div[@class=\"gsignbtn socialbtn\"]/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@type=\"email\"]")).sendKeys("wfhuser2@gmail.com");
        driver.findElement(By.xpath("//div[@id=\"identifierNext\"]//button[@jsname=\"LgbsSe\"]")).click();
        Thread.sleep(5000);
        driver.close();
        driver.quit();

    }
}
