package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUploading {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/upload");

        BrowserUtils.wait(3);

        WebElement upload = driver.findElement(By.id("file-upload"));

        //I am going to upload pom.xml file
        //https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
        String filePath = System.getProperty("user.dir")+"/pom.xml";
        String filePath2 = "/Users/Khumayra/Desktop/Screen Shot 2020-03-07 at 11.34.35 AM.png";

        upload.sendKeys(filePath2);
        driver.findElement(By.id("file-submit")).click();//click to upload
        BrowserUtils.wait(5);
        driver.quit();


    }
}
