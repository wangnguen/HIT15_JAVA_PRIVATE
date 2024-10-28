package baitap.Book2;

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
        System.out.println("So luong tac gia");
        int t = sc.nextInt();
        sc.nextLine();
        Author[] a = new Author[t];
        for (int j = 0; j < t; j++) {
          Author x = new Author(sc.nextLine(), sc.nextLine(), sc.nextLine().charAt(0));
          a[j] = x;
        }
        Book b = new Book(ten, a, gia, soLuong);
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
// Sample output
// 1
// Song
// 800000
// 5000
// 2
// Xuan Quynh
// xuanquynh@gmail.com
// F
// Quang Nguyen
// wangnguenlc79@gmail.com
// M
