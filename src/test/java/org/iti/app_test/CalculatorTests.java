package org.iti.app_test;

import org.iti.app.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTests {
    private static Calculator calculator;

    /*@BeforeEach
    void beforeEachTestCase() {
        System.out.println("This method will be run for each test case");
        calculator = new Calculator();
    }*/

    @BeforeAll
    static void beforeAllTestCase() {
        System.out.println("This method will run once");
        calculator = new Calculator();
    }

    static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(100, 10),
                Arguments.of(625, 25),
                Arguments.of(0, 0)
        );
    }

    @ParameterizedTest
    @DisplayName("Feature-123 Test Add Functionality")
    @CsvFileSource(resources = "/testData.csv", numLinesToSkip = 1)
    @Disabled
    void testAdd(String input1, String input2, String result) {
        // Arrange
        // Action
        // Assert
        assertEquals(Double.parseDouble(result), calculator.add(Double.parseDouble(input1), Double.parseDouble(input2)));
    }

    @Test
    @DisplayName("Feature-123 Test Subtraction Functionality")
    void testSubtract() {
        // Arrange

        // Action
        // Assert
        assertEquals(-1, calculator.sub(1, 2));
        assertEquals(-3, calculator.sub(-1, 2));
        assertEquals(-1, calculator.sub(-1, 0));
        assertEquals(-3.5, calculator.sub(-1, 2.5));
    }

    @Test
    @DisplayName("Feature-123 Test Multiplication Functionality")
    @Tag("FEB_RElEASE")
    void testMultiplication() {
        // Arrange

        // Action
        // Assert
        assertEquals(2, calculator.mul(1, 2));
        assertEquals(-2, calculator.mul(-1, 2));
        assertEquals(0, calculator.mul(-1, 0));
        assertEquals(-2.5, calculator.mul(-1, 2.5));
    }

    @DisplayName("Feature-123 Test Division Functionality")
    @Tag("FEB_RElEASE")
    @ParameterizedTest
    @CsvFileSource(resources = "/testData.csv", numLinesToSkip = 7)
    void testDivision(String input1, String input2, String result) {
        // Arrange

        // Action
        // Assert
        assertEquals(Double.parseDouble(result), calculator.div(Double.parseDouble(input1), Double.parseDouble(input2)));

        ArithmeticException ex = assertThrowsExactly(ArithmeticException.class, () -> calculator.div(-1, 0));
        assertEquals("Division by zero", ex.getMessage());
    }

    @Test
    @DisplayName("Feature-123 Test Power Functionality")
    @Tag("FEB_RElEASE")
    void testPower() {
        // Arrange

        // Action
        // Assert
        assertEquals(1, calculator.pow(1, 2));
        assertEquals(1, calculator.pow(-1, 2));

        assertEquals(0, calculator.pow(0, 2.5));
        assertEquals(1, calculator.pow(2.5, 0));


        ArithmeticException ex = assertThrowsExactly(ArithmeticException.class, () -> calculator.pow(0, 0));
        assertEquals("Power by zero", ex.getMessage());
    }

    @Test
    @DisplayName("Feature-123 Test Moduls Functionality")
    //@Disabled
    //@EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_11)
    @DisabledOnOs(OS.WINDOWS)
    void testModuls() {
        // Arrange

        // Action
        // Assert
        assertEquals(1, calculator.mod(1, 2));
        assertEquals(2, calculator.mod(12, 5));
        assertEquals(0, calculator.mod(120, 6));
    }

    @ParameterizedTest
    @DisplayName("Feature-123 Test Square Root Functionality")
    @MethodSource(value = "provideTestData")
    void testSquareRoot(double input1, double result) {
        // Arrange

        // Action
        // Assert
        assertEquals(result, calculator.getSquareRoot(input1));

        Exception ex = assertThrowsExactly(IllegalArgumentException.class, () -> calculator.getSquareRoot(-1));
        assertEquals("Negative numbers are not allowed", ex.getMessage());

    }

    @ParameterizedTest
    @ValueSource(ints = {2, -20, 12, 14, 16})
    void testEvenNumbers(int input1) {
        assertTrue(calculator.isEven(input1));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 15, 17, 33, -99})
    void testOddNumbers(int input1) {
        assertFalse(calculator.isEven(input1));
    }

}
