package me.opopescu.test_octane_github_actions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class BooleanCalculatorTest {
    private boolean isFirstTestPassed = false;

    @DisplayName("Or test for one true")
    @Test
    public void testOr_whenOneTrue() {
        boolean expectedResult = true;

        BooleanCalculator calc = new BooleanCalculator();
        calc.or(true, false);
        boolean actualResult = calc.getResult();

        assertEquals(expectedResult, actualResult);
    }

    @DisplayName("Test that should be failed")
    @Test
    public void testFailed() {
        fail();
        isFirstTestPassed = true;
    }

    @DisplayName("Or test for both false")
    @Test
    public void testOr_whenBothFalse() {
        boolean expectedResult = false;

        BooleanCalculator calc = new BooleanCalculator();
        calc.or(false, false);
        boolean actualResult = calc.getResult();

        assertEquals(expectedResult, actualResult);
    }

    @DisplayName("And test for both true")
    @Test
    public void testAnd_whenBothTrue() {
        boolean expectedResult = true;

        BooleanCalculator calc = new BooleanCalculator();
        calc.and(true, true);
        boolean actualResult = calc.getResult();

        assertEquals(expectedResult, actualResult);
    }

    @DisplayName("And test for one false")
    @Test
    public void testAnd_whenOneFalse() {
        boolean expectedResult = false;

        BooleanCalculator calc = new BooleanCalculator();
        calc.and(false, true);
        boolean actualResult = calc.getResult();

        assertEquals(expectedResult, actualResult);
    }

    @DisplayName("Test that should be skipped")
    @Test
    public void testSkipped() {
        assumeTrue(isFirstTestPassed);

        boolean expectedResult = false;

        BooleanCalculator calc = new BooleanCalculator();
        calc.and(false, true);
        boolean actualResult = calc.getResult();

        assertEquals(expectedResult, actualResult);
    }
}
