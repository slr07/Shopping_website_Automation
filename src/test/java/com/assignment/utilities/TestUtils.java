package com.assignment.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestUtils {


    public static final long WAIT_5S = 5;

    public WebDriver driver;

    public TestUtils() {
        this.driver = Driver.getDriver();
    }

    public WebDriverWait wait = new WebDriverWait(Driver.getDriver(), WAIT_5S);

    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    public static void scrollWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void waitFor(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000L);
    }

    public void click(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }

    public void waitForVisibility(WebElement webElement) {
        try {
            wait.until(ExpectedConditions.visibilityOf(webElement)).isDisplayed();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
