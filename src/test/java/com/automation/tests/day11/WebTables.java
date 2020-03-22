package com.automation.tests.day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WebTables {
    private WebDriver driver;

    //first way :
    //once you find email cell in the first table that has this email (jdoe@hotmail.com) then go to following sibling has linkText delete :
    //td element with email and td element that contains delete => are siblings
    ////td[text()='jdoe@hotmail.com']//following-sibling::td/a[text()='delete']

    //to make it easier :
    //go back to parent and find link that has text delete
    //td is child of tr
    ////td[text()='fbach@yahoo.com']/..//a[text()='delete']

    //even more simple way :
    //it is more hardcoded! but easiest => you provide index so it s not flexible, if index is change ilocator will never find it
    //go to find email in the first table go to parent go to second link inside this element
    ////table[1]//td[text()='jsmith@gmail.com']/..//a[2]

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        //headless mode makes execution twice faster
        //it does everything except file uploading
        //set it to tru to make it work
        chromeOptions.setHeadless(false);//to run browser without GUI. Makes browser invisible.
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
    }
    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(2);
        driver.quit();
    }
    @Test
    public void task(){
        /** TASK until 4:45
         * Go to tables example page
         * Delete record with jsmith@gmail.com email
         * verify that number of rows is equals to 3
         * verify that jsmith@gmail.com doesn't exists any more in the table
         */
        driver.findElement(By.xpath("//table[1]//td[text()='jsmith@gmail.com']/..//a[text()='delete']")).click();

        int rowCount = driver.findElements(By.xpath("//table[1]//tbody//tr")).size();
        Assert.assertEquals(rowCount,3);
        Assert.assertTrue(driver.findElements(By.xpath("//table[1]//td[text()='jsmith@gmail.com']")).isEmpty());

    }
    //Let's write a function that will return a column index based on column name
    @Test
    public void getColumnIndexByName(){
        String columnName = "Email";
        List<WebElement> columnNames = driver.findElements(By.xpath("//table[2]//th"));
        int index = 0;
        for(int i=0; i<columnNames.size();i++){
            String actualColumnName=columnNames.get(i).getText();
            System.out.println(String.format("Column name: %s, position %s",actualColumnName,i));

            if(columnNames.get(i).getText().equals(columnName)){
                index = i+1;
                break;
            }
        }
        Assert.assertEquals(index,3);
    }
    @Test
    public void getSpecificCell(){
        String expected = "www.jdoe.com";
        int row=1;
        int column=1;
        String xpath = "//table[1]//tbody//tr["+row+"]//td["+column+"]";

        WebElement cell = driver.findElement(By.xpath(xpath));
        Assert.assertEquals(cell.getText(),expected);

    }





    @Test
    public void getColumnNames() {
        //th - represents table header cells
        List<String> expected = Arrays.asList("Last", "First Name", "Email", "Due", "Web Site", "Action");
        List<WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));
        for (WebElement columnName : columnNames) {
            System.out.println(columnName.getText());
        }
        Assert.assertEquals(BrowserUtils.getTextFromWebElements(columnNames), expected);
    }

    @Test
    public void verifyRowCount() {
        ////tbody//tr - to get all rows from table body, excluding table header
        List<WebElement> rows = driver.findElements(By.xpath("//table[1]//tbody//tr"));
        //if we will get a size of this collection, it automatically equals to number of elements
        Assert.assertEquals(rows.size(), 4);
    }

    //Muhammed Arslan Fatih method - need to check and learn
    @Test
    public void tryTable() throws InterruptedException{
        driver.get("http://practice.cybertekschool.com/tables");
        List<WebElement> headers=driver.findElements(By.xpath("//table[@id='table1']//thead//tr//th"));
        List<String> result=headers.stream().map(x->x.getText()).collect(Collectors.toList());
        System.out.println(result);
    }

    //trying to collect all data and save it into CSV file
   @Test
    public void collectData(){
       driver.get("http://practice.cybertekschool.com/tables");
       List<WebElement> allData = driver.findElements(By.xpath("//table[@id='table1']"));
       File csvFile = new File("table1");
       BrowserUtils.wait(3);
       try (PrintWriter csvWriter = new PrintWriter(new FileWriter(csvFile))){
           for(WebElement item : allData){
               csvWriter.println(item.getText());
           }
       } catch (IOException e) {
           //Handle exception
           e.printStackTrace();
       }
   }

}
