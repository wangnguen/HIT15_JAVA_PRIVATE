package buoi1.lythuyet;
import java.util.Scanner;

public class Bai1 {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String name = sc.next();
      int age = sc.nextInt();
      sc.nextLine();
      String address = sc.next();
      System.out.printf("%-10s %-5s %-30s\n", "Ten", "Tuoi", "DiaChi");
      System.out.printf("%-10s %-5d %-30s\n", name, age, address);
    }
  }
}
