package baikiemtra;

import java.util.Scanner;

public class Bai3 {
  public static final int MOD = (int) 1e9 + 7;

  public static long binPow(int a, long b) {
    if (b == 0) {
      return 1;
    } else {
      long res = binPow(a, b / 2);
      if (b % 2 == 0) {
        return (res % MOD * res % MOD) % MOD;
      } else {
        return (res % MOD * res % MOD) % MOD * (a % MOD) % MOD;
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int x = sc.nextInt();
    long y = sc.nextLong();
    System.out.println(binPow(x, y));
    sc.close();
  }
}
