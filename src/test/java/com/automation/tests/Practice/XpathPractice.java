package com.automation.tests.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathPractice {

    public static void main(String[] args) throws Exception{
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/nested_frames");
        Thread.sleep(1000);

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");

        WebElement left = driver.findElement(By.name("frame-middle"));
        WebElement body = driver.findElement(By.tagName("body"));
        System.out.println(body.getText());
        Thread.sleep(1000);

//        driver.switchTo().frame("frame-middle");
//        WebElement middle = driver.findElement(By.xpath("//frame[@src='/frame_left']/following-sibling::frame"));
//        System.out.println(middle.getText());
//        Thread.sleep(1000);
//
//        driver.switchTo().frame("frame-right");
//        WebElement right = driver.findElement(By.xpath("//frame[@src='/frame_left']/following-sibling::frame/following-sibling::frame"));
//        System.out.println(right.getText());
//        Thread.sleep(1000);

        driver.quit();

    }
}
