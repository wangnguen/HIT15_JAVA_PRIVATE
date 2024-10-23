package buoi2.lythuyet;

import java.util.Scanner;

public class BT2 {
  public static int[] D = new int[1000000];

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }
    for (int i = 0; i < n; i++) {
      if (i == 0) {
        D[i] = a[i];
      } else {
        D[i] = D[i - 1] + a[i];
      }
    }
    int q = sc.nextInt();
    while (q != 0) {
      int l = sc.nextInt();
      int r = sc.nextInt();
      --l;
      --r;
      if (l != 0) {
        System.out.println(D[r] - D[l - 1]);
      } else {
        System.out.println(D[r]);
      }
      --q;
    }
    sc.close();
  }
}
