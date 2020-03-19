package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeTests {
/*    Create a class called PracticeTests
- setup before/after methods
	- in before method. instantiate webdriver and navigate
	to: http://practice.cybertekschool.com/
            - in after method - just close webdriver.
- create a test called lofinTest
	- go to “Form Authentication” page
	- enter valid credentials
	- verify that following sub-header message is displayed:
	 “Welcome to the Secure Area. When you are done click logout below.”*/
private WebDriver driver;

@Test
public void loginTest(){
    driver.findElement(By.linkText("Form Authentication")).click();
    BrowserUtils.wait(3);
    driver.findElement(By.name("username")).sendKeys("tomsmith");
    driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
    driver.findElement(By.id("wooden_spoon")).click();
    BrowserUtils.wait(3);
    String title = driver.findElement(By.tagName("h4")).getText();
    Assert.assertEquals(title,"Welcome to the Secure Area. When you are done click logout below.");
}

@Test
public void forgotPassword (){
    driver.findElement(By.linkText("Forgot Password")).click();
    BrowserUtils.wait(3);
    driver.findElement(By.name("email")).sendKeys("user@gmail.com", Keys.ENTER);
    String msg = driver.findElement(By.name("confirmation_message")).getText();
    Assert.assertEquals(msg, "Your e-mail's been sent!");
}

@Test
/** task for 5 mins
 * Given user is on the practice landing page
 * navigates to "Checkboxes" page
 * And clicks on checkbox #1
 */

public void checkTest1 (){
    driver.findElement(By.linkText("Checkboxes")).click();
    BrowserUtils.wait(3);
    driver.findElement(By.xpath("//input[@type='checkbox'][1]")).click();
    Boolean result = driver.findElement(By.xpath("//input[1]")).isSelected();
    Assert.assertTrue(result,"The checkbox# 1 is not selected");
}

@BeforeMethod
    public void setup(){
    WebDriverManager.chromedriver().version("79").setup();
    //INTERVIEW QUESTIONS: HOW TO HANDLE SSL ISSUES IN SELENIUM
    //ChromeOptions - use customize browser for tests
    ChromeOptions chromeOptions = new ChromeOptions();
    //to ignore "Your connection is not private issue
    chromeOptions.setAcceptInsecureCerts(true);
    driver = new ChromeDriver();
    driver.get("http://practice.cybertekschool.com");
    driver.manage().window().maximize();
}

@AfterMethod
    public void teardown(){
    driver.quit();
}
}
