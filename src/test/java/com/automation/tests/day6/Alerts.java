package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Alerts {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(3);

        List<WebElement> buttons = driver.findElements(By.tagName("button")); // get all buttons on page
        buttons.get(0).click(); // to click on the first button
        BrowserUtils.wait(1);

        String popup = driver.switchTo().alert().getText();
        System.out.println(popup);
        driver.switchTo().alert().accept();//to click OK on alert window

        BrowserUtils.wait(3);
        driver.quit();
    }
}
