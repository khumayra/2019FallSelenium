package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.security.cert.Extension;
import java.util.Set;

public class HomePractice {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

//        driver.get("http://google.com"); // opened page 1
//        Thread.sleep(1000);
//        System.out.println(driver.getTitle());
//
//        driver.navigate().to("http://amazon.com"); // opened page 2
//        Thread.sleep(1000);
//        System.out.println(driver.getTitle());
//
//        driver.navigate().to("http://facebook.com"); // opened page 3
//        Thread.sleep(1000);
//        System.out.println(driver.getTitle());
//
//        driver.navigate().to("http://ebay.com"); // opened page 4
//        Thread.sleep(1000);
//        System.out.println(driver.getTitle());
//        driver.manage().window().fullscreen();
//
//        driver.close();

        driver.get("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(3000);
        String windowHandle = driver.getWindowHandle();

        Set<String> windowHandles = driver.getWindowHandles();//pulled id

        for (String windowId: windowHandles){
            if(windowId.equals(windowHandle)) {
                //to jump to the new window
                driver.switchTo().window(windowId);
            }
        }
        Thread.sleep(3000);
       switchBasedOnTitle("Fresh tab",driver);


    }

    /**
     * Method to compare two titles of web-pages
     * @param page1
     * @param page2
     */
    public static void verifyTitleOfPage (String page1,String page2){
        if (page1.contains(page2)){
            System.out.println("TEST PASSED!");
        } else {
            System.out.println("TEST FAILED!");
        }
    }

    public static void switchBasedOnTitle (String title, WebDriver driver){
        Set <String> windows = driver.getWindowHandles();
        for(String window:windows){
            driver.switchTo().window(window);
            if (driver.getTitle().equals(title)){
                break;
            }
        }
    }

}
