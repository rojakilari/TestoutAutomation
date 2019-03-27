package com.testout.simulator.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Browser {
    static WebDriver driver;

    static {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.edgedriver().setup();
    }

    public static WebDriver getDriver(String browserName) {
        WebDriver driver = null;
        if ("CHROME".equalsIgnoreCase(browserName)) {
            driver =  new ChromeDriver();
        } else if ("FIREFOX".equalsIgnoreCase(browserName)) {
            driver =  new FirefoxDriver();
        }
        else if("edge".equalsIgnoreCase(browserName)){
            driver = new EdgeDriver();
        }

        if(driver!=null){
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().setSize(new Dimension(1536,2048));
        }
        return driver;
    }
}
