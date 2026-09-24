package me.opopescu.test_octane_github_actions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @DisplayName("Add test for positive numbers")
    @Test
    public void testAdd_whenPositiveNumbers() {
        int expectedResult = 3;

        Calculator calc = new Calculator();
        calc.add(1, 2);
        int actualResult = calc.getResult();

        assertEquals(expectedResult, actualResult);
    }

    @DisplayName("Add test for negative numbers")
    @Test
    public void testAdd_whenNegativeNumbers() {
        int expectedResult = -3;

        Calculator calc = new Calculator();
        calc.add(-1, -2);
        int actualResult = calc.getResult();

        assertEquals(expectedResult, actualResult);
    }

    @DisplayName("Sub test for positive numbers")
    @Test
    public void testSub_whenPositiveNumbers() {
        int expectedResult = -1;

        Calculator calc = new Calculator();
        calc.sub(1, 2);
        int actualResult = calc.getResult();

        assertEquals(expectedResult, actualResult);
    }

    @DisplayName("Sub test for negative numbers")
    @Test
    public void testSub_whenNegativeNumbers() {
        int expectedResult = 1;

        Calculator calc = new Calculator();
        calc.sub(-1, -2);
        int actualResult = calc.getResult();

        assertEquals(expectedResult, actualResult);
    }

    @DisplayName("Multiply test for positive numbers")
    @Test
    public void testMultiply_whenPositiveNumbers() {
        int expectedResult = 10;

        Calculator calc = new Calculator();
        calc.multiply(2, 5);
        int actualResult = calc.getResult();

        assertEquals(expectedResult, actualResult);
    }

    @DisplayName("Multiply test for one negative number")
    @Test
    public void testMultiply_whenOneNegativeNumber() {
        int expectedResult = -10;

        Calculator calc = new Calculator();
        calc.multiply(-2, 5);
        int actualResult = calc.getResult();

        assertEquals(expectedResult, actualResult);
    }

    @DisplayName("Divide test for non-zero denominator")
    @Test
    public void testMultiply_whenDenominatorIsNotZero() {
        int expectedResult = 2;

        Calculator calc = new Calculator();
        calc.divide(10, 5);
        int actualResult = calc.getResult();

        assertEquals(expectedResult, actualResult);
    }

    @DisplayName("Divide test for zero denominator")
    @Test
    public void testMultiply_whenDenominatorIsZero() {
        int expectedResult = 0;

        Calculator calc = new Calculator();
        calc.divide(10, 0);
        int actualResult = calc.getResult();

        assertEquals(expectedResult, actualResult);
    }

    @DisplayName("Sleep for 10 seconds")
    @Test
    public void testSleep_when1Second() throws InterruptedException {
        Thread.sleep(10000L);
    }
}
