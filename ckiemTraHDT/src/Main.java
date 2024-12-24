import model.Account;
import model.Address;
import model.Role;
import model.Status;
import service.impl.AccountServiceImpl;
import service.impl.AuthServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AccountServiceImpl accountService = new AccountServiceImpl();
        AuthServiceImpl authService = new AuthServiceImpl(accountService.getAllAccount());

        Address adminAddress = new Address("123 Admin St", "Admin City");
        accountService.createNewAccount(new Account("A001", "Nguyen Van Admin", 35, adminAddress, "1989-01-01", "admin",
                "1234", Role.ADMIN, Status.ACTIVE));

        Address userAddress = new Address("456 User St", "User City");
        accountService.createNewAccount(new Account("U001", "Nguyen Van User", 30, userAddress, "1993-05-15", "user",
                "abcd", Role.USER, Status.ACTIVE));

        while (true) {
            if (authService.getLoggedInAccount() == null) {
                System.out.println("--- Menu ---");
                System.out.println("1. Đăng nhập");
                System.out.println("2. Thoát");
                System.out.print("Chọn tùy chọn: ");
                int choice = Integer.parseInt(scanner.nextLine());

                if (choice == 1) {
                    authService.login(scanner);
                } else if (choice == 2) {
                    System.out.println("Kết thúc chương trình.");
                    break;
                } else {
                    System.out.println("Lựa chọn không hợp lệ.");
                }
            } else {
                Account loggedInAccount = authService.getLoggedInAccount();
                System.out.println("--- Menu chính ---");
                System.out.println("1. Xem thông tin cá nhân");

                if (loggedInAccount.getRole() == Role.ADMIN) {
                    System.out.println("2. Xem danh sách tài khoản");
                    System.out.println("3. Tạo tài khoản mới");
                    System.out.println("4. Tìm kiếm tài khoản theo username");
                    System.out.println("5. Xóa tài khoản");
                    System.out.println("6. Thay đổi trạng thái tài khoản");
                    System.out.println("0. Đăng xuất");
                } else if (loggedInAccount.getRole() == Role.USER) {
                    System.out.println("2. Đổi mật khẩu");
                    System.out.println("0. Đăng xuất");
                }

                System.out.print("Chọn tùy chọn: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.println(loggedInAccount);
                        break;
                    case 2:
                        if (loggedInAccount.getRole() == Role.ADMIN) {
                            System.out.println("Danh sách tài khoản:");
                            for (Account account : accountService.getAllAccount()) {
                                System.out.println(account);
                            }
                        } else if (loggedInAccount.getRole() == Role.USER) {
                            System.out.print("Nhập mật khẩu cũ: ");
                            String oldPassword = scanner.nextLine();
                            System.out.print("Nhập mật khẩu mới: ");
                            String newPassword = scanner.nextLine();
                            authService.changePassword(loggedInAccount.getUsername(), oldPassword, newPassword);
                        }
                        break;
                    case 3:
                        if (loggedInAccount.getRole() == Role.ADMIN) {
                            System.out.println(
                                    "Nhập thông tin tài khoản mới (username, password, full name, age, street, city, birthday, status): ");
                            System.out.print("Nhập username: ");
                            String username = scanner.nextLine();
                            System.out.print("Nhập password: ");
                            String password = scanner.nextLine();
                            System.out.print("Nhập họ và tên: ");
                            String fullName = scanner.nextLine();
                            System.out.print("Nhập tuổi: ");
                            int age = Integer.parseInt(scanner.nextLine());
                            System.out.print("Nhập đường phố: ");
                            String street = scanner.nextLine();
                            System.out.print("Nhập thành phố: ");
                            String city = scanner.nextLine();
                            System.out.print("Nhập ngày sinh: ");
                            String birthday = scanner.nextLine();
                            System.out.print("Nhập trạng thái tài khoàn(ACTIVE-Kích hoạt), (BAN-chặn): ");
                            Status status = Status.valueOf(scanner.nextLine().toUpperCase());

                            Account newAccount = new Account("", fullName, age, new Address(street, city), birthday,
                                    username, password, Role.USER, status);
                            accountService.createNewAccount(newAccount);
                        } else if (loggedInAccount.getRole() == Role.USER) {
                            authService.logout();
                        }
                        break;
                    case 4:
                        if (loggedInAccount.getRole() == Role.ADMIN) {
                            System.out.print("Nhập username cần tìm: ");
                            String username = scanner.nextLine();
                            Account account = accountService.getAccountByUsername(username);
                            if (account != null) {
                                System.out.println(account);
                            }
                        }
                        break;
                    case 5:
                        if (loggedInAccount.getRole() == Role.ADMIN) {
                            System.out.print("Nhập username cần xóa: ");
                            String username = scanner.nextLine();
                            accountService.deleteAccount(username);
                        }
                        break;
                    case 6:
                        if (loggedInAccount.getRole() == Role.ADMIN) {
                            System.out.print("Nhập username cần thay đổi trạng thái: ");
                            String username = scanner.nextLine();
                            System.out.print("Nhập trạng thái mới (ACTIVE/BAN): ");
                            Status status = Status.valueOf(scanner.nextLine().toUpperCase());
                            accountService.changeStatus(username, status);
                        }
                        break;
                    case 0:
                        authService.logout();

                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ.");
                        break;
                }
            }
        }
    }
}
