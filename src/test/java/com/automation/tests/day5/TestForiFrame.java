package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestForiFrame {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/iframe");
        BrowserUtils.wait(2);

        driver.switchTo().frame("mce_0_ifr");
        BrowserUtils.wait(2);
        WebElement iFrame = driver.findElement(By.id("tinymce"));
        iFrame.clear();
        iFrame.sendKeys("Hello, World!");
        System.out.println(iFrame.getText());
        BrowserUtils.wait(2);

        driver.switchTo().defaultContent();





        driver.quit();
    }
}
