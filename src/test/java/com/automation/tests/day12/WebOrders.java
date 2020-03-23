package com.automation.tests.day12;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebOrders {
    private WebDriver driver;
    /**
     * until 5:37
     * :: TASK for 10 minutes ::
     * Go to web orders page
     * Verify that Steve Johns zip code is 21233
     * Then update his zip code to 20002
     * Then verify that Steve Johns zip code is 20002
     */
    @Test
    public void updateZipCode(){
        WebElement zipcode = driver.findElement(By.xpath("//td[text()='Steve Johns']//following-sibling::td[7]"));
        Assert.assertEquals(zipcode.getText(), "21233");
        //click on update image
        driver.findElement(By.xpath(" //td[text()='Steve Johns']//following-sibling::td/input")).click();
        WebElement zipcodeInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));
        zipcodeInput.clear();
        zipcodeInput.sendKeys("20002");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();
        zipcode = driver.findElement(By.xpath("//td[text()='Steve Johns']//following-sibling::td[7]"));
        Assert.assertEquals(zipcode.getText(), "20002");
    }


    /**
     * Go to web orders page
     * Click on "Check All" button
     * Verify that all records are selected
     */

    @Test
    public void checkBoxTest(){
        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();

        List<WebElement> list = driver.findElements(By.xpath("//input[@type = 'checkbox']"));
        boolean actual = false;
        WebDriverWait wait = new WebDriverWait(driver,3);
        for (int i = 0; i < list.size(); i++) {
            actual = wait.until(ExpectedConditions.elementToBeSelected(list.get(i)));
        }
        Assert.assertTrue(actual);
    }

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createADriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test", Keys.ENTER);
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
