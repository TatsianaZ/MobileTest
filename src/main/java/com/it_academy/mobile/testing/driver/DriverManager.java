package com.it_academy.mobile.testing.driver;

import com.it_academy.mobile.testing.configuration.AddressConfigurator;
import com.it_academy.mobile.testing.configuration.CapabilitiesConfigurator;
import com.it_academy.mobile.testing.configuration.ConfigurationReader;
import com.it_academy.mobile.testing.configuration.EnvironmentType;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Optional;

import static java.lang.String.format;

public class DriverManager {
    private static final Logger LOG = LoggerFactory.getLogger(DriverManager.class);
    private static final EnvironmentType ENVIRONMENT_TYPE =
            EnvironmentType.valueOf(ConfigurationReader.get().env().toUpperCase());

    private static AppiumDriver<MobileElement> driver;

    private DriverManager() {
    }

    public static AppiumDriver<MobileElement> getDriver() {
        if (driver == null) {
            LOG.info("driver is null");
            driver = createDriver();
        }
        return driver;
    }

    private static AppiumDriver<MobileElement> createDriver() {
        switch (ENVIRONMENT_TYPE) {
            case LOCAL ->
                    driver = new AndroidDriver<>(AddressConfigurator.getAppiumDriverLocalService(
                    ConfigurationReader.get().appiumPort()),
                    CapabilitiesConfigurator.getLocalCapabilities());
            default -> throw new IllegalArgumentException(format("Unexpected environment value: %s", ENVIRONMENT_TYPE));
        }
        LOG.info("driver is created");
        LOG.info("Environment type is {}", ENVIRONMENT_TYPE);
        return driver;
    }

    public static void closeDriver() {
        Optional.ofNullable(getDriver()).ifPresent(driverInstance -> {
            driverInstance.quit();
            driver = null;
            LOG.info("Driver is closed");
        });
    }

    public static void closeAppium() {
        AddressConfigurator.stopService();
    }

    public static void closeEmulator() {
        try {
            Runtime.getRuntime().exec(format("adb -s %s emu kill", ConfigurationReader.get().udid()));
            LOG.info("AVD is closed");
        } catch (IOException e) {
            LOG.info("AVD was not closed, message: {}", e.getMessage());
        }
    }
}
