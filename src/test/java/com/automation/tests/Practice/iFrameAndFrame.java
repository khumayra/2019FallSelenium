package com.automation.tests.Practice;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.MyTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class iFrameAndFrame {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/frames");

        driver.findElement(By.linkText("iFrame")).click();
        //clearing the form
        driver.switchTo().frame("mce_0_ifr").findElement(By.id("tinymce")).clear();
        BrowserUtils.wait(3);
        //finding bold button and pressing it before adding the text
        //driver.findElement(By.tagName("button")).click();

        driver.findElement(By.id("tinymce")).sendKeys("Hello, World!");

        String expected = "Hello, World!";
        String actual = driver.findElement(By.id("tinymce")).getText();
        MyTest.checkResult(actual,expected);

        BrowserUtils.wait(3);
        driver.quit();
    }
}
