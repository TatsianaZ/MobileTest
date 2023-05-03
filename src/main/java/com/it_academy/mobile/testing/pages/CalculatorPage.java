package com.it_academy.mobile.testing.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

public class CalculatorPage extends BasePage {
    private static final By ADD_BUTTON = By.id("com.google.android.calculator:id/op_add");
    private static final By FINAL_RESULT = By.id("com.google.android.calculator:id/result_final");
    private static final By EQUALS_BUTTON = By.id("com.google.android.calculator:id/eq");
    private static final String DIGIT_ID_PATTERN = "com.google.android.calculator:id/digit_%d";

    @AndroidFindBy(id = "com.google.android.calculator:id/digit_9")
    private MobileElement nineDigit;

    @AndroidFindBy(id = "com.google.android.calculator:id/digit_1")
    private MobileElement oneDigit;

    @AndroidFindBy(id = "com.google.android.calculator:id/op_add")
    private MobileElement addButton;

    @AndroidFindBy(id = "com.google.android.calculator:id/eq")
    private MobileElement equalsButton;

    @AndroidFindBy(id = "com.google.android.calculator:id/result_final")
    private MobileElement calculationResult;

    public CalculatorPage selectDigit(int digit) {
        findElementById(String.format(DIGIT_ID_PATTERN, digit)).click();
        return this;
    }

    public CalculatorPage clickOnEqualsButton() {
        findElement(EQUALS_BUTTON).click();
        return this;
    }

    public String getCalculationResult() {
        return findElement(FINAL_RESULT).getText();
    }

    public CalculatorPage clickOnAddButton() {
        findElement(ADD_BUTTON).click();
        return this;
    }
}
