package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

//isSelected - returns true if button selected
//isEnabled - returns true if button is enabled, otherwise return false

public class RadioButtons {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79.0").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();

        BrowserUtils.wait(2);
        List<WebElement> radioButtons = driver.findElements(By.tagName("input"));

        for (WebElement radioButton:radioButtons){
            // to check if button can be clicked
            //<input typ="radio" id="red" name="color">
            String id = radioButton.getAttribute("id");

            boolean isSelected = radioButton.isSelected();
            System.out.println(id+" is selected? "+isSelected);
            //if button selected it will return true, otherwise - false

            //if button is eligible to click
            //returns true of you can click on the button

            if (radioButton.isEnabled()){ //isEnabled - return true, if button can be clicked, otherwise - false.
                radioButton.click();
                System.out.println("Click on ::"+radioButton.getAttribute("id"));
                BrowserUtils.wait(1);
            }else {
                System.out.println("Button is disabled, not clicked ::"+id);
            }
            System.out.println();

        }
        //<input type="radio" id="black" name="color">
        WebElement blackButton = driver.findElement(By.id("black"));
        blackButton.click();
        //how do we verify that button clicked
        //returns true, if button clicked
        if(blackButton.isSelected()){
            System.out.println("TEST PASSED!");
        }else {
            System.out.println("TEST FAILED");
        }

        driver.quit();

    }
}
