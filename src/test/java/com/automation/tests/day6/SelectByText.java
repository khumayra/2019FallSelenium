package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get ("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        WebElement simpleDropDown = driver.findElement(By.id("dropdown"));
        Select selectSimpleDropDown = new Select (simpleDropDown);
        selectSimpleDropDown.selectByVisibleText("Option 2");
        selectSimpleDropDown.selectByVisibleText("Option 1");

        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));

        selectDay.selectByVisibleText("1");
        selectMonth.selectByVisibleText("February");
        selectYear.selectByVisibleText("2003");
        BrowserUtils.wait(3);
        //select all months one by one
        List<WebElement> months = selectMonth.getOptions();
        for (WebElement month:months){
            String monthName = month.getText();
            selectMonth.selectByVisibleText(monthName);
            BrowserUtils.wait(1);
        }

    /*    Select state = new Select(driver.findElement(By.id("state")));
        List<WebElement> states = state.getOptions();
        for (WebElement each:states){
            String stateName = each.getText();
            state.selectByVisibleText(stateName);
            BrowserUtils.wait(1);

        }*/

    Select stateSelect = new Select(driver.findElement(By.id("state")));
    stateSelect.selectByVisibleText("District of Columbia");

        //option that is currently selected
        // getFirstSelectedOption() -- returns a webelement, that's why we need to call getText()
        //getText() retrieves visible text from webelement
        String selected = stateSelect.getFirstSelectedOption().getText();
        if(selected.equals("District of Columbia")){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        BrowserUtils.wait(3);
        driver.quit();
    }
}
