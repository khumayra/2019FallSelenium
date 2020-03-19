package com.automation.tests.vytrack.fleet;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class VehiclesPageTests {
    private WebDriver driver;
    private String URL = "https://qa2.vytrack.com/user/login";
    private By userNameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private String username = "storemanager85";
    private String password = "UserUser123";
    private By fleetBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Fleet')]");
    private By customersBy = By.xpath("//span[@class='title title-level-1' and contains(text(), 'Customers')]");



    @Test
    public void verifyPageSubtitle(){

        Actions action = new Actions (driver);
        //Actions is the class used for more advance browser interactions
        //move to element instead of clicking
        action.moveToElement(driver.findElement(fleetBy)).perform();
        BrowserUtils.wait(3);
        // driver.findElement(fleetBy).click();
        // BrowserUtils.wait(2);
        driver.findElement(By.linkText("Vehicles")).click();
        BrowserUtils.wait(3);
        String actual = driver.findElement(By.className("oro-subtitle")).getText();
        BrowserUtils.wait(5);
        String expected = "All Cars";
        assertEquals(actual,expected,"Not All Cars");
    }

    @Test
    public void verfiyNumberOfPages(){
        Actions action = new Actions (driver);
        //Actions is the class used for more advance browser interactions
        //move to element instead of clicking
        action.moveToElement(driver.findElement(fleetBy)).perform();
        BrowserUtils.wait(3);
        driver.findElement(By.linkText("Vehicles")).click();
        BrowserUtils.wait(3);

        String actual = driver.findElement(By.xpath("//input[@type='number']")).getAttribute("value");
        assertEquals(actual, "1");

    }


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.findElement(userNameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(5);
    }

    @AfterTest
    public void tearDown(){

    if(driver!=null){
        driver.quit();
        driver=null;
    }
    }
}
