package com.it_academy.mobile.testing.configuration;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import static io.appium.java_client.remote.AndroidMobileCapabilityType.AVD;

public class CapabilitiesConfigurator {
    private CapabilitiesConfigurator() {
    }

    public static DesiredCapabilities getLocalCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.UDID, ConfigurationReader.get().udid());
        capabilities.setCapability(AVD, ConfigurationReader.get().localDeviceName());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ConfigurationReader.get().platformName());
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, ConfigurationReader.get().appPackage());
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ConfigurationReader.get().appActivity());
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        return capabilities;
    }
}
