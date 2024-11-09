package buoi4.btvn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
  public static int index = 5;
  public static Book[] books = new Book[100];

  public static void init() {
    books[0] = new Book(1, "Toan", "Q", 2024, "Mo ta Toan", 105);
    books[1] = new Book(2, "Tieng Viet", "T", 2023, "Mo ta Tieng Viet", 50);
    books[2] = new Book(3, "Sinh Hoc", "K", 2020, "Mo ta Sinh Hoc", 40);
    books[3] = new Book(4, "Lich Su", "H", 2021, "Mo ta Lich Su", 55);
    books[4] = new Book(5, "Vat Li", "L", 2019, "Mo ta Vat Li", 96);
  }

  public static void themSach() {
    Book book = new Book();
    book.input();
    books[index] = book;
    System.out.println("Them thanh cong vao danh sach !");
    ++index;
  }

  public static void chinhSuaThongTin(Book newBook) {
    for (int i = 0; i < index; i++) {
      if (books[i].getTenSach().equalsIgnoreCase(newBook.getTenSach())) {
        books[i].setMaSach(newBook.getMaSach());
        books[i].setTenTacGia(newBook.getTenTacGia());
        books[i].setNamSanXuat(newBook.getNamSanXuat());
        books[i].setTomTatNoiDung(newBook.getTomTatNoiDung());
        books[i].setGiaTien(newBook.getGiaTien());
        System.out.println("Thay doi thanh cong !");
        return;
      }
    }
    System.out.println("Khong tim thay sach !");
  }

  public static void in() {
    for (int i = 0; i < index; i++) {
      books[i].display();
    }
  }

  public static void sachLauDoi() {
    System.out.println("Cuon sach lau doi nhat la:");
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < index; i++) {
      min = Math.min(min, books[i].getNamSanXuat());
    }
    for (int i = 0; i < index; i++) {
      if (books[i].getNamSanXuat() == min) {
        books[i].display();
        return;
      }
    }
  }

  public static void sachVuaGiaTien(double tienSach) {
    System.out.println("Sach phu hop voi tien cua ban la:");
    for (int i = 0; i < index; i++) {
      if (books[i].getGiaTien() <= tienSach) {
        books[i].display();
      }
    }
  }

  public static void sapXepTheoGia() {
    Arrays.sort(books, 0, index, new Comparator<Book>() {
      public int compare(Book o1, Book o2) {
        if (o1.getGiaTien() < o2.getGiaTien()) {
          return -1;
        } else {
          return 1;
        }
      }
    });
  }

  public static void sapXepTheoTen() {
    Arrays.sort(books, 0, index, new Comparator<Book>() {
      @Override
      public int compare(Book b1, Book b2) {
        return b1.getTenSach().compareToIgnoreCase(b2.getTenSach());
      }
    });
  }

  public static void main(String[] args) {
    init();
    boolean running = true;
    while (running) {
      System.out.println("\nMenu:");
      System.out.println("1. Them sach moi");
      System.out.println("2. Chinh sua thong tin sach");
      System.out.println("3. Hien thi toan bo sach");
      System.out.println("4. In ra quyen sach lau doi nhat");
      System.out.println("5. In ra cuon sach phu hop voi gia");
      System.out.println("6. Sap xep sach theo gia tien");
      System.out.println("7. Sap xep sach theo ten");
      System.out.println("8. Thoat");
      System.out.println("Nhap lua chon cua ban: ");
      Scanner sc = new Scanner(System.in);
      int input = sc.nextInt();
      sc.nextLine();
      switch (input) {
        case 1:
          themSach();
          break;
        case 2:
          Book book = new Book();
          book.input();
          chinhSuaThongTin(book);
          break;
        case 3:
          in();
          break;
        case 4:
          sachLauDoi();
          break;
        case 5:
          System.out.println("Nhap so tien ban co");
          double tien = sc.nextDouble();
          sc.nextLine();
          sachVuaGiaTien(tien);
          break;
        case 6:
          sapXepTheoGia();
          break;
        case 7:
          sapXepTheoTen();
          break;
        case 8:
          running = false;
          break;
        default:
          System.out.println("Lua chon khong hop le");
          running = false;
          break;
      }
    }
  }
}
