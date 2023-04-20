package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringCalculatorTest {

  @Test
  void 数字が0個の場合_0が返される() {
    // Arrange
    int expected = 0;

    // Act
    StringCalculator calculator = new StringCalculator();
    int actual = calculator.add("");

    // Assert
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @CsvSource({
      "'1', 1",
      "'2', 2", })
  void 数字が1個の場合_その数字が返される(String input, int expected) {
    // Arrange

    // Act
    StringCalculator calculator = new StringCalculator();
    int actual = calculator.add(input);

    // Assert
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @CsvSource({
      "'1,2', 3",
      "'4,5', 9"
    })
  void 数字が2個の場合_合計が返される(String input, int expected) {
    // Arrange
    // No setup needed

    // Act
    StringCalculator calculator = new StringCalculator();
    int actual = calculator.add(input);

    // Assert
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @CsvSource({
      "'1,2,3', 6",
      "'4,5,6,7', 22"
    })
  void 数字が2個以上の場合_合計が返される(String input, int expected) {
    // Arrange
    // No setup needed

    // Act
    StringCalculator calculator = new StringCalculator();
    int actual = calculator.add(input);

    // Assert
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @CsvSource({
      "'1000,1', 1001",
      "'1001,2', 2" })
  void 数字が1000より大きい場合_0として扱う(String input, int expected) {
    // Arrange
    // No setup needed

    // Act
    StringCalculator calculator = new StringCalculator();
    int actual = calculator.add(input);

    // Assert
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @CsvSource({
      "'-1,2', 'negatives not allowed: [-1]'",
      "'1,-2', 'negatives not allowed: [-2]'",
      "'1,-2,-8', 'negatives not allowed: [-2,-8]'"
    })
  void マイナスの数字が入る場合_例外が投げられる(String input, String expected) {
    // Arrange
    // No setup needed

    // Act
    StringCalculator calculator = new StringCalculator();

    // Assert
    Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.add(input));
    assertEquals(expected, exception.getMessage());
  }

  @ParameterizedTest
  @CsvSource({
      "'1\n2,3', 6",
      "'1\n2\n3', 6" })
  void 区切り文字がカンマと改行の場合_合計が返される(String input, int expected) {
    // Arrange
    // No setup needed

    // Act
    StringCalculator calculator = new StringCalculator();
    int actual = calculator.add(input);

    // Assert
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @CsvSource({
      "'//;\n1;2', 3",
      "'//|\n1|2|3', 6" })
  void カスタム区切り文字が指定された場合_合計が返される(String input, int expected) {
    // Arrange
    // No setup needed

    // Act
    StringCalculator calculator = new StringCalculator();
    int actual = calculator.add(input);

    // Assert
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @CsvSource({
      "'//[*][%]\\n1*2%3', 6",
      "'//[@][#][!]\\n1@2#3!4', 10" })
  void 複数のカスタム区切り文字が指定された場合_合計が返される(String input, int expected) {
    // Arrange
    // No setup needed

    // Act
    StringCalculator calculator = new StringCalculator();
    int actual = calculator.add(input);

    // Assert
    assertEquals(expected, actual);
  }
}
