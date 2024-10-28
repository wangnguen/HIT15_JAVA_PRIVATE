package baitap.Book1;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      sc.nextLine();
      ArrayList<Book> arr = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        String ten = sc.nextLine();
        double gia = sc.nextDouble();
        int soLuong = sc.nextInt();
        sc.nextLine();
        Author x = new Author(sc.nextLine(), sc.nextLine(), sc.nextLine().charAt(0));
        Book b = new Book(ten, x, gia, soLuong);
        arr.add(b);
      }
      Collections.sort(arr, (Book b1, Book b2) -> {
        if (b1.getPrice() != b2.getPrice()) {
          if (b1.getPrice() < b2.getPrice())
            return 1;
          return -1;
        } else
          return b1.getName().compareTo(b2.getName());
      });
      for (Book x : arr) {
        System.out.println(x);
      }
    }
  }
}
/*
 * Sample Input:
 * 3
 * Song
 * 800000
 * 5000
 * Xuan Quynh
 * xuanquynh@gmail.com
 * M
 * Ha Do
 * 50000
 * 6000
 * Nguyen Nhat Anh
 * nhatanh@gmail.com
 * F
 * To Kill a Hockingbird
 * 100000
 * 15000
 * Harper Lee
 * lee@gmail.com
 * F
 */