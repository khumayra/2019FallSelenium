package com.automation.tests.day4;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;

public class WarmUpTask {

    static WebDriver driver;

    public static void main(String[] args) throws Exception {
     //   ebayTest();
     //   amazonTest();
        wikiTest();
    }
    //        Go to ebay
//        enter search term
//        click on search button
//        print number of results
    public static void ebayTest() throws Exception {
        WebDriver driver = DriverFactory.createADriver("chrome");
                //        Go to ebay
                //        enter search term
                //        click on search button
                //        print number of results
        driver.get("https://www.ebay.com/");
        driver.findElement(By.id("gh-ac")).sendKeys("java book");
        driver.findElement(By.id("gh-btn")).click();
        WebElement searchResult = driver.findElement(By.tagName("h1"));

        String[] searchSentence = searchResult.getText().split(" ");
        System.out.println(Arrays.toString(searchSentence));
        System.out.println(searchSentence[0]);
        driver.quit();

        Thread.sleep(3000);
        driver.quit();
    }

    public static void amazonTest() throws Exception{
        //        go to amazon
        //        enter search term
        //      click on search button
        //        verify title contains search term
        driver = DriverFactory.createADriver("chrome");
        driver.get("http://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java book", Keys.ENTER);
        String title = driver.getTitle();
        if (title.contains("java book")){
            System.out.println("TEST PASSED!");
        } else {
            System.out.println("TEST FAILED!");
        }
        driver.quit();//        Go to wikipedia.org
//        enter search term `selenium webdriver`
//        click on search button
//        click on search result `Selenium (software)`
//        verify url ends with `Selenium_(software)`
    }
    public static void wikiTest()throws Exception{
        //        Go to wikipedia.org
        //        enter search term `selenium webdriver`
        //        click on search button
        //        click on search result `Selenium (software)`
        //        verify url ends with `Selenium_(software)`
        driver = DriverFactory.createADriver("chrome");
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver",Keys.ENTER);
        driver.findElement(By.partialLinkText("Selenium (software)")).click();
        Thread.sleep(4000);
        String link = driver.getCurrentUrl();
        Thread.sleep(6000);
        if (link.endsWith("Selenium_(software)")){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed!");
        }

        driver.quit();
    }







}
