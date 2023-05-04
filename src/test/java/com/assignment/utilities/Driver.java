package com.assignment.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver() {
    }
    private static final ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (drivers.get() == null) {
            synchronized (Driver.class) {
                WebDriverManager.chromedriver().setup();
                drivers.set(new ChromeDriver());
                drivers.get().manage().window().maximize();
                drivers.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }
        }
        return drivers.get();
    }
    public static void closeDriver() {
        if (drivers.get() != null) {
            drivers.get().quit();
            drivers.remove();
        }
    }
}
