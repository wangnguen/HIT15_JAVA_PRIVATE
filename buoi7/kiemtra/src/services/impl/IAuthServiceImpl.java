package services.impl;

import java.util.Scanner;

import java.util.ArrayList;

import services.IAuthService;
import models.Account;
import models.Address;
import models.Status;
import models.Role;

public class IAuthServiceImpl implements IAuthService {
  private ArrayList<Account> accounts = new ArrayList<>();
  private Account curAccount;

  public IAuthServiceImpl() {
    Address address1 = new Address("Tan Uyen", "Lai Chau");
    Address address2 = new Address("Pho Nhon", "Ha Noi");
    Address address3 = new Address("Pho Nhon", "Ha Noi");
    accounts
        .add(new Account("001", "Kim Quang", 19, address1, "07/09/2005", "admin", "12345", Role.ADMIN, Status.ACTIVE));
    accounts
        .add(
            new Account("002", "Minh Anh", 18, address2, "02/08/2006", "username1", "12345", Role.USER, Status.ACTIVE));
    accounts
        .add(
            new Account("003", "Thanh Hang", 18, address3, "02/08/2005", "username2", "12345", Role.USER,
                Status.BAN));
    curAccount = null;
  }

  public Account getCurAccount() {
    return curAccount;
  }

  public void setCurAccount(Account curAccount) {
    this.curAccount = curAccount;
  }

  @Override
  public void changePassword(String username, String oldPassword, String newPassword) {
    for (Account account : accounts) {
      if (account.getUsername().equals(username) && account.getPassworld().equals(oldPassword)) {
        account.setPassworld(newPassword);
        System.out.println("Change password successfully");
        return;
      }
    }
  }

  @Override
  public void login(Scanner sc) {
    System.out.println("Nhap username");
    String username = sc.nextLine();
    System.out.println("Nhap password");
    String password = sc.nextLine();
    for (Account account : accounts) {
      if (account.getUsername().equals(username) && account.getPassworld().equals(password)) {
        curAccount = account;
        System.out.println("Login successfully!");
        return;
      }
    }
    System.out.println("Login Failed");
  }

  @Override
  public void logout() {
    if (curAccount != null) {
      System.out.println("Logout successfully");
      curAccount = null;
    } else {
      System.out.println("No user is currently logged in");
    }
  }

}
