package com.it_academy.mobile.testing;

import com.it_academy.mobile.testing.pages.CalculatorPage;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest extends BaseTest {

    @Test
    public void testSumOfTwoDigits() {
        CalculatorPage calculatorPage = new CalculatorPage();
        String calculationResult = calculatorPage.selectDigit(9)
                .clickOnAddButton()
                .selectDigit(1)
                .clickOnEqualsButton()
                .getCalculationResult();
        assertThat(calculationResult).as("Sum is incorrect").isEqualTo("10");
    }
}
