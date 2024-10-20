package buoi1.btvn;

import java.util.Scanner;

public class BaiTap2 {
  public static long calculate(long number) {
    long result = 1;
    while (number != 0) {
      result *= number % 10;
      number /= 10;
    }
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      long number = sc.nextLong();
      System.out.println(calculate(number));
    }
  }
}