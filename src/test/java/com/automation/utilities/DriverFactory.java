package com.automation.utilities;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
    /**
     * This method returns webdriver object based on browser type
     */
    public static WebDriver createADriver(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().version("79.0").setup();
            return new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else {
            WebDriverManager.iedriver().setup();
            return new InternetExplorerDriver();
        }
    }
}