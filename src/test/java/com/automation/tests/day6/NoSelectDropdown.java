package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Driver;
import java.util.List;

public class NoSelectDropdown {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        driver.findElement(By.id("dropdownMenuLink")).click();
        //to expand dropdown

        List<WebElement> allLinks = driver.findElements(By.className("dropdown-item"));
        for (WebElement each: allLinks) {
            System.out.println(each.getText()+" "+each.getAttribute("href"));
        }

        //<a class="dropdown-item" href="https://www.amazon.com/">Amazon</a>
        BrowserUtils.wait(3);
        driver.findElement(By.linkText("Google")).click(); //click on option



        driver.quit();


    }
}
