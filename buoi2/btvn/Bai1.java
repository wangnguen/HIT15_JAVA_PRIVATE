package buoi2.btvn;

import java.util.Scanner;

import java.util.Arrays;

/**
 * Bai1
 */
public class Bai1 {
  public static int binarySearch(int[] a, int n, int k) {
    int index = -1;
    int l = 0, r = n - 1;
    while (l <= r) {
      int m = (l + r) / 2;
      if (a[m] == k) {
        index = m;
        r = m - 1;
      } else if (a[m] > k) {
        r = m - 1;
      } else {
        l = m + 1;
      }
    }
    return index;
  }

  public static int index2 = -1;

  public static int binarySearch2(int[] a, int l, int r, int k) {
    if (l > r)
      return index2;
    int m = (l + r) / 2;
    if (a[m] == k) {
      index2 = m;
      return binarySearch2(a, l, m - 1, k);
    } else if (a[m] > k) {
      return binarySearch2(a, l, m - 1, k);
    } else {
      return binarySearch2(a, m + 1, r, k);
    }
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] numbers = new int[n];
      for (int i = 0; i < n; i++) {
        numbers[i] = sc.nextInt();
      }
      Arrays.sort(numbers);
      for (int number : numbers) {
        System.out.print(number + " ");
      }
      System.out.println();
      System.out.println(binarySearch(numbers, n, k));
      System.out.println(binarySearch2(numbers, 0, n - 1, k));
    }
  }
}