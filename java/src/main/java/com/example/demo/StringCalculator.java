package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
  private int sum = 0;
  private List<Integer> minusNumbers = new ArrayList<>();

  public int add(String input) {
    if (input.isEmpty()) {
      return 0;
    }



    String delimiter = this.extractCustomDelimiter(input);
    String numberString = this.extractNumbers(input);
    String[] numberStrings = numberString.split("[" + delimiter + "]");
    if (numberStrings.length == 1) {
      return Integer.valueOf(numberString);
    }

    for (String numbeString : numberStrings) {
      int number = Integer.parseInt(numbeString);
      if (number > 1000) {
        number = 0;
      }
      if (number < 0) {
        this.minusNumbers.add(number);
      }
      this.sum += number;
    }
    if (!this.minusNumbers.isEmpty()) {
      this.throwError(this.minusNumbers);
    }
    return this.sum;
  }

  private void throwError(List<Integer> minusNumbers) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < minusNumbers.size(); i++) {
      sb.append(minusNumbers.get(i));
      if (i < minusNumbers.size() - 1) {
        sb.append(",");
      }
    }
    String minusNumbersString = sb.toString();
    String errorMessage = String.format("negatives not allowed: [%s]", minusNumbersString);
    throw new IllegalArgumentException(errorMessage);
  }

  private String extractCustomDelimiter(String input) {
    String baseDelimiter = ",\n";
    if (input.startsWith("//")) {
      Matcher m = Pattern.compile("//(.*)\n(.*)").matcher(input);
      if (m.matches()) {
        return baseDelimiter + m.group(1);
      }
    }

    return baseDelimiter;
  }

  private String extractNumbers(String input) {
    if (input.startsWith("//")) {
      Matcher m = Pattern.compile("//(.*)\n(.*)").matcher(input);
      if (m.matches()) {
        return m.group(2);
      }
    }

    return input;
  }
}
