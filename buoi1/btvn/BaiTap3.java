package buoi1.btvn;

import java.util.Scanner;

public class BaiTap3 {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = sc.nextInt();
      }
      int numberOne = (int) -1e9, numberTwo = (int) -1e9;
      for (int i = 0; i < n; i++) {
        if (a[i] > numberOne) {
          numberTwo = numberOne;
          numberOne = a[i];
        } else if (a[i] > numberTwo && numberOne >= a[i]) {
          numberTwo = a[i];
        }
      }
      System.out.println(numberOne + " " + numberTwo);
    }
  }
}