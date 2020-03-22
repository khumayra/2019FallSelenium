package com.automation.tests.day12;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class WarmUpTask {
    private WebDriver driver;
    private By lastNameBy = By.xpath("//table[1]//*[text()='Last Name']");

    @Test (description =  "Vasyl's option")
    public void test() {
        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        //click on column name
        driver.findElement(By.xpath("//table[1]//*[text()='Last Name']")).click();
        BrowserUtils.wait(2);
        //collect all values from the first column
        List<WebElement> column = driver.findElements(By.xpath("//table[1]//tbody//td[1]"));
        for (int i = 0; i < column.size() - 1; i++) {
            //take a string
            String value = column.get(i).getText();
            //take a following string
            String nextValue = column.get(i + 1).getText();

            System.out.println(value.compareTo(nextValue));

            //if difference is negative - order value is before nextValue in alphabetic order
            //if difference is positive - order value is after nextValue in alphabetic order
            //if difference is 0 - value and nextValue are equals
            Assert.assertTrue(value.compareTo(nextValue) <= 0);
        }
        driver.quit();
    }

    @Test
    public void test1(){
        List<String> list = BrowserUtils.getTextFromWebElements(driver.findElements(lastNameBy));
        String previous = ""; // empty string: guaranteed to be less than or equal to any other
        boolean actual = true;
        for (final String current: list) {
            if (current.compareTo(previous) < 0)
            previous = current;
            actual=false;
        }

        Assert.assertFalse(actual);
    }

    @Test
    public void test2(){
        List<String> list = BrowserUtils.getTextFromWebElements(driver.findElements(lastNameBy));
        System.out.println(list);
        boolean actual = true;
        for (int i = 0; i <list.size()-1 ; i++) {
            if(list.get(i).charAt(0)<list.get(i+1).charAt(0)){
                actual = false;
            }
        }
        Assert.assertFalse(actual);
    }
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        ChromeOptions option = new ChromeOptions();
        option.setHeadless(true);
        driver = new ChromeDriver(option);
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
    }
    @AfterMethod
    public void tearDown(){
        if(driver!=null){
            driver.quit();
            driver = null;
        }
    }
}
