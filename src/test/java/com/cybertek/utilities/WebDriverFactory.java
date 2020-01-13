package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    //write a static method that takes a string parameter
    //based on value of the parameter
    //the method must return chromedriver or firefoxdriver object
    //name: getDriver

    public static WebDriver getDriver(String browserType){
        WebDriver driver=null;

        if ("chrome".equals(browserType.toLowerCase())) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if ("firefox".equals(browserType.toLowerCase())) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        return driver;
    }






}
