package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FizzBuzzTest {

  @ParameterizedTest
  @CsvSource({
      "1, '1'",
      "2, '2'",
      "4, '4'",
  })
  void test_数字を数字の文字列に変換して返す(int input, String expected) {
    // Arrange

    // Act
    FizzBuzz fizzBuzz = new FizzBuzz();
    String actual = fizzBuzz.process(input);

    // Assert
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @CsvSource({
      "3, 'Fizz'",
      "6, 'Fizz'",
      "33, 'Fizz'",
  })
  void test_3で割り切れる場合はFizzを返す(int input, String expected) {
    // Arrange

    // Act
    FizzBuzz fizzBuzz = new FizzBuzz();
    String actual = fizzBuzz.process(input);

    // Assert
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @CsvSource({
      "5, 'Buzz'",
      "10, 'Buzz'",
      "20, 'Buzz'",
  })
  void test_5で割り切れる場合はBuzzを返す(int input, String expected) {
    // Arrange

    // Act
    FizzBuzz fizzBuzz = new FizzBuzz();
    String actual = fizzBuzz.process(input);

    // Assert
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @CsvSource({
      "15, 'FizzBuzz'",
      "30, 'FizzBuzz'",
      "45, 'FizzBuzz'",
  })
  void test_3と5で割り切れる場合はFizzBuzzを返す(int input, String expected) {
    // Arrange

    // Act
    FizzBuzz fizzBuzz = new FizzBuzz();
    String actual = fizzBuzz.process(input);

    // Assert
    assertEquals(expected, actual);
  }
}
