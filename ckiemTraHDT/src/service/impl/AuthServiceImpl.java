package service.impl;

import model.Account;
import model.Status;
import service.AuthService;

import java.util.List;
import java.util.Scanner;

public class AuthServiceImpl implements AuthService {
    private Account loggedInAccount;
    private List<Account> accounts;

    public AuthServiceImpl(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public void login(Scanner scanner) {
        System.out.print("Nhập username: ");
        String username = scanner.nextLine();
        System.out.print("Nhập password: ");
        String password = scanner.nextLine();

        for (Account account : accounts) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)
                    && account.getStatus() == Status.ACTIVE) {
                loggedInAccount = account;
                System.out.println("Đăng nhập thành công!");
                return;
            }
        }
        System.out.println("Sai thông tin đăng nhập hoặc tài khoản đã bị khóa.");
    }

    @Override
    public Account getLoggedInAccount() {
        return loggedInAccount;
    }

    @Override
    public void logout() {
        if (loggedInAccount != null) {
            System.out.println("Đăng xuất thành công: " + loggedInAccount.getUsername());
            loggedInAccount = null;
        } else {
            System.out.println("Không có tài khoản nào đang đăng nhập.");
        }
    }

    @Override
    public void changePassword(String username, String oldPassword, String newPassword) {
        if (loggedInAccount != null && loggedInAccount.getUsername().equals(username)) {
            if (loggedInAccount.getPassword().equals(oldPassword)) {
                loggedInAccount.setPassword(newPassword);
                System.out.println("Đổi mật khẩu thành công.");
            } else {
                System.out.println("Mật khẩu cũ không đúng.");
            }
        } else {
            System.out.println(
                    "Không thể đổi mật khẩu. Bạn chưa đăng nhập hoặc không có quyền đổi mật khẩu tài khoản khác.");
        }
    }
}
