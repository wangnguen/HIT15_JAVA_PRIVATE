package buoi1.lythuyet;

import java.util.Scanner;

public class Bai3 {
  public static int tinhTienDien(int soDien) {
    int tienDien = 0;
    if (soDien <= 50) {
      tienDien = 1500 * soDien;
    } else if (soDien <= 100) {
      tienDien = 1500 * 50 + (soDien - 50 * 2000);
    } else if (soDien <= 200) {
      tienDien = 1500 * 50 + 2000 * 100 + (soDien - 100) * 2500;
    } else
      tienDien = 1500 * 50 + 2000 * 100 + 200 * 2500 + (soDien - 200) * 3000;
    return tienDien;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int soDien = sc.nextInt();
      System.out.println("So dien cua nha nay la" + tinhTienDien(soDien));
    }
  }
}
