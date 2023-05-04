package com.assignment.Steps;

import com.assignment.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hook {
    String url = "https://www.saucedemo.com";

    @Before
    public void setUp() {

        Driver.getDriver().manage().deleteAllCookies();
        Driver.getDriver().get(url);
        Driver.getDriver().manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    }

    @After
    public static void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte [] screenshots = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshots,"image/png",scenario.getName());
        }
        Driver.closeDriver();
    }

}
