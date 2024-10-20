package buoi1.lythuyet;

import java.util.Scanner;

public class Bai2 {
  public static long GCD(long a, long b) {
    if (b == 0) {
      return a;
    } else {
      return GCD(b, a % b);
    }
  }

  public static long LCM(long a, long b) {
    return a / GCD(a, b) * b;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      long a = sc.nextLong();
      long b = sc.nextLong();
      long c = sc.nextLong();
      System.out.println("UCLN: " + GCD(a, GCD(b, c)));
      System.out.println("BCNN: " + LCM(a, LCM(b, c)));
    }
  }
}
