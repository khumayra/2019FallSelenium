package com.automation.tests.officeHours;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class findAllLinks {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get ("http://etsy.com");
        driver.findElement(By.id("global-enhancements-search-query")).sendKeys("dress");
        List<WebElement> allLinks = driver.findElements(By.tagName("h2"));
        System.out.println(allLinks);
    }
}
