package com.misc.misctest;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dunmy {
    static WebDriver driver;
    public static void main(String[] args) {
//        WebDriverManager driver=new ChromeDriverManager();
    System.setProperty("webdriver.chrome.driver","d:/selenium/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com");


    }
}
