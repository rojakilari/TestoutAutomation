package com.testout.simulator.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Navigator {

    private WebDriver driver;
    private Actions actions;
    private WebDriverWait wait;

    public Navigator(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, 15);
    }

    public void clickById(String elementId){
        actions.moveToElement(driver.findElement(By.id(elementId))).perform();
        wait.until(ExpectedConditions.elementToBeClickable(By.id(elementId)));
        this.actions.moveToElement(driver.findElement(By.id(elementId))).click().perform();
    }

    public void doubleClickById(String elementId) {
        actions.moveToElement(driver.findElement(By.id(elementId))).perform();
        wait.until(ExpectedConditions.elementToBeClickable(By.id(elementId)));
        this.actions.moveToElement(driver.findElement(By.id(elementId))).doubleClick().perform();
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public void dragBy(String elementId, int xPos, int yPos){
        actions.moveToElement(driver.findElement(By.id(elementId))).perform();
        wait.until(ExpectedConditions.elementToBeClickable(By.id(elementId)));
        actions.clickAndHold(
                driver.findElement(
                        By.id(elementId)))
                .moveByOffset(xPos, yPos)
                .release()
                .build().perform();
    }
    public void enter(String elementId, String text){
        actions.moveToElement(driver.findElement(By.id(elementId))).perform();
        wait.until(ExpectedConditions.elementToBeClickable(By.id(elementId)));
        driver.findElement(By.id(elementId)).sendKeys(text);
    }

    public String getValue(String elementId){
        actions.moveToElement(driver.findElement(By.id(elementId))).perform();
        wait.until(ExpectedConditions.textToBePresentInElementValue(By.id(elementId),"993"));
        return driver.findElement(By.id(elementId)).getAttribute("value");
    }


}
