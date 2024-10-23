package buoi2.lythuyet;

import java.util.Scanner;

public class BT1_Cach2 {
  public static int[] mCD = new int[1000000];

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      int max = (int) -1e9;
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
        mCD[arr[i]]++;
        max = Math.max(max, mCD[arr[i]]);
      }
      for (int i = 0; i < n; i++) {
        if (mCD[arr[i]] == max) {
          System.out.println(arr[i] + " " + mCD[arr[i]]);
          return;
        }
      }
    }
  }
}
