package com.it_academy.mobile.testing;

import com.it_academy.mobile.testing.driver.DriverManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected static final Logger LOG = LoggerFactory.getLogger(BaseTest.class);

    @BeforeClass
    public void createSession() {
        DriverManager.getDriver();
    }

    //для того чтогбы после каждого теста приложение приходило к начальному состоянию
    //в котором оно было до запуска теста
    //вместе с этим сбрасывается вся текущая сессия
    @AfterMethod
    public void resetApp() {
        DriverManager.getDriver().resetApp();
    }

    @AfterClass
    public void closeSession() {
        DriverManager.closeDriver();
        //step service
        DriverManager.closeAppium();
        DriverManager.closeEmulator();
    }
}
