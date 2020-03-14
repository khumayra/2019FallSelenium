package com.automation.tests.officeHours;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindXpath {
    public static void main(String[] args) throws Exception {
        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/registration_form");

//        driver.findElement(By.xpath("//input[@class[1]='form-control']")).sendKeys("John");
//        driver.findElement(By.xpath("//input[@class[2]='form-control']")).sendKeys("Oliver");

        List<WebElement> list = driver.findElements(By.tagName("input"));
        Thread.sleep(1000);
        driver.quit();

    }
}
