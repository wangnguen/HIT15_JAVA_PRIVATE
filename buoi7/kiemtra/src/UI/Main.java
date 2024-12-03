package UI;

import java.util.ArrayList;
import java.util.Scanner;

import models.*;
import services.impl.IAccountServiceImpl;
import services.impl.IAuthServiceImpl;

public class Main {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    IAccountServiceImpl service = new IAccountServiceImpl();
    IAuthServiceImpl authService = new IAuthServiceImpl();
    authService.login(sc);

    if (authService.getCurAccount().getRole().equals(Role.ADMIN)) {
      boolean running = true;
      while (running) {
        System.out.println("\n===== HE THONG QUAN LY TAI KHOAN=====\n");
        System.out.println("Xin chao ADMIN: " + authService.getCurAccount().getUsername());
        System.out.println("Chon mot trong cac chuc nang sau");
        System.out.println("1. Xem danh sach tai khoan ");
        System.out.println("2. Tao tai khoan moi");
        System.out.println("3.Tim kiem tai khoan theo username");
        System.out.println("4. Xoa tai khoan");
        System.err.println("5. Thay doi trang thai tai khoan");
        System.out.println("6. Xem thong tin ca nhan");
        System.out.println("0. Dang xuat");
        System.out.println("-------------------------");
        System.out.println("Nhap lua chon cua ban");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
          case 1:
            for (Account account : service.getAllAccount()) {
              account.display();
            }
            break;
          case 2:
            Address address1 = new Address("Tan Uyen", "Lai Chau");
            Account accountEx = new Account("005", "Kim Hung", 45, address1, "29/09/1979", "admin", "12345", Role.ADMIN,
                Status.ACTIVE);
            service.createNewAccount(accountEx);
            break;
          case 3:
            System.out.println("Nhap username can tim");
            String username = sc.nextLine();
            service.getAccountByUsername(username);
            break;
          case 4:
            System.out.println("Nhap username can xoa");
            String usernameDel = sc.nextLine();
            service.deleteAccount(usernameDel);
            break;
          case 5:
            System.out.println("Nhap username can xoa");
            String usernameChange = sc.nextLine();
            service.changeStatus(usernameChange, Status.BAN);
            break;
          case 6:
            authService.getCurAccount().display();
            break;
          case 0:
            running = false;
            System.exit(0);
            break;
          default:
            System.out.println("Nhap lai");
            break;
        }
      }
    } else {
      System.out.println("\n=====HE THONG NGUOI DUNG=====\n");
      boolean running = true;
      while (running) {
        System.out.println("\n===== HE THONG QUAN LY TAI KHOAN=====\n");
        System.out.println("Xin chao ADMIN: " + authService.getCurAccount().getUsername());
        System.out.println("Chon mot trong cac chuc nang sau");
        System.out.println("1. Doi mat khau ");
        System.out.println("2. Xem thong tin ca nhan");

        System.out.println("0. Dang xuat");
        System.out.println("-------------------------");
        System.out.println("Nhap lua chon cua ban");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
          case 1:
            System.out.println("Nhap username");
            String username = sc.nextLine();
            System.out.println("Nhap password cu");
            String oldpassword = sc.nextLine();
            System.out.println("Nhap password moi");
            String newpassword = sc.nextLine();
            authService.changePassword(username, oldpassword, newpassword);
            break;
          case 2:
            authService.getCurAccount().display();
            break;
          case 3:
            authService.logout();
            System.exit(0);
            break;
          default:
            System.out.println("Nhap lai");
            break;
        }
      }
    }
  }
}