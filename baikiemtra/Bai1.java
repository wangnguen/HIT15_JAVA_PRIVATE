package baikiemtra;

import java.util.Scanner;

public class Bai1 {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int res = n;
      int donVi = n % 10;
      n /= 10;
      int chuc = n % 10;
      n /= 10;
      int tram = n;
      String[] tenDonVi = { "Một", "Hai", "Ba", "Bốn", "Năm", "Sáu", "Bảy", "Tám", "Chín", };
      String[] tenChuc = { "Mười", "Hai mươi", "Ba mươi", "Bốn mươi", "Năm mươi", "Sáu mươi", "Bảy mươi", "Tám mươi",
          "Chín mươi" };
      String[] tenTram = { "Một trăm", "Hai trăm", "Ba trăm", "Bốn trăm", "Năm trăm", "Sáu trăm", "Bảy trăm",
          "Tám trăm", "Chín trăm" };
      if (res == 0) {
        System.out.println("Không");
      } else if (res < 10) {
        System.out.println(tenDonVi[donVi - 1]);
      } else if (res < 100) {
        if (chuc != 0 && chuc != 0) {
          System.out.println(tenChuc[chuc - 1] + " " + tenDonVi[donVi - 1]);
        }
      } else {
        if (tram != 0 && chuc != 0 && donVi != 0) {
          System.out.println(tenTram[tram - 1] + " " + tenChuc[chuc - 1] + " " + tenDonVi[donVi - 1]);
        }
      }
    }
  }
}
