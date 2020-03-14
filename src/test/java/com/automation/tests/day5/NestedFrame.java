package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.*;

public class NestedFrame {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/nested_frames");
        BrowserUtils.wait(3);

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");

        WebElement content = driver.findElement(By.xpath("//div[text()='MIDDLE']"));
        System.out.println(content.getText());

        driver.switchTo().parentFrame(); //go to the top frame
        driver.switchTo().frame("frame-right"); //switch to the right Frame
        WebElement body = driver.findElement(By.tagName("body"));
        System.out.println(body.getText());
        driver.switchTo().defaultContent();
        driver.switchTo().frame ("frame-bottom");
        System.out.println(driver.findElement(By.tagName("body")).getText());


        driver.switchTo().defaultContent();
        driver.quit();



    }
}
