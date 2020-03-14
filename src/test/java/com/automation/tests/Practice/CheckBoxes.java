package com.automation.tests.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxes {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/checkboxes");
        List<WebElement> list = driver.findElements(By.tagName("input"));

        if(!list.get(0).isSelected()&&list.get(0).isDisplayed()&&list.get(0).isEnabled()){
            list.get(0).click();
        }

        for (WebElement checkbox:list) {
            if (checkbox.isSelected()){
                System.out.println("TEST PASSED");
            } else {
                System.out.println("TEST FAILED");
            }

        }
        Thread.sleep(3000);
        driver.quit();


    }
}
