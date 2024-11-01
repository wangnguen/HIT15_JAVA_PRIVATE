package buoi3.baitap;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String studentCode = sc.nextLine();
      String fullName = sc.nextLine();
      byte age = sc.nextByte();
      sc.nextLine();
      String gender = sc.nextLine();
      String phoneNumber = sc.nextLine();
      String email = sc.nextLine();
      Student student = new Student(studentCode, fullName, age, gender, phoneNumber, email);
      student.display();
    }
  }
}
