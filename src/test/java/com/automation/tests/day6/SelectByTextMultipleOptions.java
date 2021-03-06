package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByTextMultipleOptions {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);

        Select languagesSelect = new Select (driver.findElement(By.name("Languages")));
        //whether this select element support selecting multiple options at the same time?
        //This is done by checking the value of the multiple attribute

        boolean isMultiple = languagesSelect.isMultiple();
        System.out.println(isMultiple);
        //if it's true, you can select more than 1 option
        languagesSelect.selectByVisibleText("Java");
        languagesSelect.selectByVisibleText("JavaScript");
        languagesSelect.selectByVisibleText("Python");

        //let's get all selected option
        List<WebElement> selectedLanguages = languagesSelect.getAllSelectedOptions();

        for (WebElement each:selectedLanguages) {
            System.out.println(each.getText());
        }
        BrowserUtils.wait(3);
        languagesSelect.deselectByVisibleText("Java"); //to unselect something
        BrowserUtils.wait(3);

        languagesSelect.deselectAll();
        BrowserUtils.wait(3);

        driver.quit();
    }
}
