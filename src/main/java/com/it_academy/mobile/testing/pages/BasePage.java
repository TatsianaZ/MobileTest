package com.it_academy.mobile.testing.pages;

import com.it_academy.mobile.testing.driver.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage {
    private static final Logger LOG = LoggerFactory.getLogger(BasePage.class);
    private static AppiumDriver<MobileElement> driver;

    public BasePage() {
        LOG.info("I am in BasePage constructor");
        //PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
        //PageFactory.initElements(DriverManager.getDriver(), this);
        driver = DriverManager.getDriver();
    }

    public MobileElement findElement(By by) {
        return driver.findElement(by);
    }

    public MobileElement findElementById(String id) {
        return driver.findElementById(id);
    }
}
