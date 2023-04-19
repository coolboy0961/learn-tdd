package com.example.demo;

public class Calculator {
  public int add(int a, int b) {
    return a + b;
  }

  public static void main(String[] args) {
    Calculator calculator = new Calculator();
    int a = 5;
    int b = 7;
    int result = calculator.add(a, b);
    System.out.println("The sum of " + a + " and " + b + " is: " + result);
  }

}