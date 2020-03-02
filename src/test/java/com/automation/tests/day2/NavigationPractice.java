package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationPractice {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver chrome = new ChromeDriver();

        chrome.get("http://amazon.com"); // goin to amazon page
        if(chrome.getTitle().equalsIgnoreCase("amazon")){
            System.out.println("TEST PASSED!");
        } else {
            System.out.println("TEST FAILED!");
        }

        chrome.navigate().to("http://google.com");
        Thread.sleep(3000);

        chrome.navigate().back();
        chrome.findElement(By.xpath("//input[@title=\"Search\"]")).sendKeys("hello world");
        Thread.sleep(1000);
        chrome.findElement(By.name("btnK")).click();

    }

}
