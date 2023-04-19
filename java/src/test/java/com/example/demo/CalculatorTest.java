package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {
  @Test
  void testAdd() {
    // Arrange
    int expected = 5;

    // Act
    Calculator calculator = new Calculator();
    int actual = calculator.add(2, 3);

    // Assert
    assertEquals(expected, actual);
  }
}