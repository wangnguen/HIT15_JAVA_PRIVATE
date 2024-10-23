package buoi2.lythuyet;

import java.util.Scanner;

public class BT4 {
  public static boolean checkPangram(String s) {
    int[] a = new int[26];
    for (char x : s.toCharArray()) {
      a[x - 'a'] = 1;
    }

    for (int i = 0; i < 26; i++) {
      if (a[i] == 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String string = sc.nextLine();
      String temp = "";
      for (char x : string.toCharArray()) {
        temp += Character.toLowerCase(x);
      }
      System.out.println(checkPangram(temp));
    }
  }
}
