package baikiemtra;

import java.util.Scanner;

public class Bai2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String text = sc.nextLine();
    String digit = "", alpha = "";
    for (char x : text.toCharArray()) {
      if (Character.isDigit(x)) {
        digit += x;
        alpha += " ";
      } else {
        digit += " ";
        alpha += x;
      }
    }
    System.out.println(digit.trim());
    System.out.println(alpha.trim());
    sc.close();
  }
}
