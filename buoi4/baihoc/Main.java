package buoi4.baihoc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
  public static Person[] persons = new Person[5];

  public static void init() {
    persons[0] = new Person("01", "Quang", 19, "Lai Chau", "0123456789");
    persons[1] = new Person("02", "Trang", 25, "Hung Yen", "0123456789");
    persons[2] = new Person("03", "Trinh", 15, "Thai Binh", "0123456789");
    persons[3] = new Person("04", "Quynh", 38, "Lai Chau", "0123456789");
    persons[4] = new Person("05", "Huong", 45, "Ha Noi", "0123456789");
  }

  public static void timKiemTheoTen(String name) {
    for (Person person : persons) {
      if (person.getTen().equalsIgnoreCase(name)) {
        person.display();
        return;
      }
    }
    System.out.println("Khong tim thay nguoi ten " + name);
  }

  public static void timKiemTheoMaCCCD(String maCCCD) {
    for (Person person : persons) {
      if (person.getMaCCCD().equals(maCCCD)) {
        person.display();
        return;
      }
    }
    System.out.println("Khong tim thay nguoi co ma" + maCCCD);
  }

  public static void sapXepTheoTuoi() {
    Arrays.sort(persons, new Comparator<Person>() {
      @Override
      public int compare(Person p1, Person p2) {
        if (p1.getTuoi() < p2.getTuoi()) {
          return -1;
        } else {
          return 1;
        }
      }
    });
  }

  public static void displayArr() {
    for (Person person : persons) {
      person.display();
    }
  }

  public static void main(String[] args) {
    boolean running = true;
    Scanner sc = new Scanner(System.in);
    init();
    while (running) {
      System.out.println("Bang dieu khien");
      System.out.println("1. Tim kiem theo ten");
      System.out.println("2. Tim kiem theo can cuoc cong dan");
      System.out.println("3. Sap xep theo tuoi");
      System.out.println("4. Hien thi");
      System.out.println("5. Thoat");
      System.out.print("Nhap lua chon cua ban : ");
      int input = sc.nextInt();
      sc.nextLine();
      switch (input) {
        case 1:
          String name = sc.nextLine();
          timKiemTheoTen(name);
          break;
        case 2:
          String maCCCD = sc.nextLine();
          timKiemTheoMaCCCD(maCCCD);
          break;
        case 3:
          sapXepTheoTuoi();
          break;
        case 4:
          displayArr();
          break;
        case 5:
          running = false;
          break;
      }
    }
  }
}