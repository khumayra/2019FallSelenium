package com.automation.tests.Practice;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationForm {
    private String URL = "http://practice.cybertekschool.com/registration_form";
    private WebDriver driver;
    // p tag name of success message
    // one xpath for all inputs: //label[text()='Label name']/..//input
    private By firstNameBy = By.name("firstname");
    private By lastNameBy = By.name("lastname");
    private By usernameBy = By.name("username");
    private By emailBy = By.name("email");
    private By passwordBy = By.name("password");
    private By phoneBy = By.name("phone");
    //gender
    private By maleBy = By.cssSelector("input[value='male']");
    private By femaleBy = By.cssSelector("input[value='female']");
    private By otherBy = By.cssSelector("input[value='other']");
    private By dateOfBirthBy = By.name("birthday");
    private By departmentBy = By.name("department");
    private By jobTitleBy = By.name("job_title");
    //languages
    private By cplusplusBy = By.xpath("//label[text()='C++']/preceding-sibling::input");
    private By javaBy = By.xpath("//label[text()='Java']/preceding-sibling::input");
    private By javascriptBy = By.xpath("//label[text()='JavaScript']/preceding-sibling::input");



    @Test
    public void fillOutForm(){
     driver.findElement(firstNameBy).sendKeys("Tom");
     driver.findElement(lastNameBy).sendKeys("Smith");
     driver.findElement(usernameBy).sendKeys("tomsmith");
     driver.findElement(emailBy).sendKeys("tom.smith@gmail.com");
     driver.findElement(passwordBy).sendKeys("UserUser123");
     driver.findElement(phoneBy).sendKeys("571-337-5130");
     driver.findElement(dateOfBirthBy).sendKeys("01/01/1990");
     driver.findElement(maleBy).click();

     Select departmentSelect = new Select(driver.findElement(departmentBy));
     departmentSelect.selectByVisibleText("Department of Agriculture");

     Select jobTitleSelect = new Select (driver.findElement(jobTitleBy));
     jobTitleSelect.selectByVisibleText("SDET");

     driver.findElement(javaBy).click();
     driver.findElement(By.id("wooden_spoon")).click();
     BrowserUtils.wait(5);

     String expected = "You've successfully completed registration!";
     String actual = driver.findElement(By.tagName("p")).getText();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void verifyFirstNameLengthTest(){
        driver.findElement(firstNameBy).sendKeys("a");
        BrowserUtils.wait(3);
        WebElement warningMsg = driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']"));
        Assert.assertTrue(warningMsg.isDisplayed());
    }

    @Test
    public void verifyAlphabeticLetterOnlyTest(){
        driver.findElement(firstNameBy).sendKeys("123");
        BrowserUtils.wait(3);
        WebElement warningMessage = driver.findElement(By.xpath("//small[text()='first name can only consist of alphabetical letters']"));
        Assert.assertTrue(warningMessage.isDisplayed());
    }



    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
    }

    @AfterTest
    public void tearDown(){
        if (driver!=null){
            driver.quit();
            driver =null;
        }
    }
}
