package services.impl;

import java.util.ArrayList;
import java.util.List;

import models.Account;
import models.Address;
import models.Role;
import models.Status;
import services.IAccountService;

public class IAccountServiceImpl implements IAccountService {
  private ArrayList<Account> accounts = new ArrayList<>();

  public IAccountServiceImpl() {
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
  }

  @Override
  public void changeStatus(String username, Status status) {
    for (Account account : accounts) {
      if (account.getUsername().equals(username)) {
        account.setStatus(status);
        System.out.println("Chinh sua trang thai thanh cong");
        return;
      }
    }
    System.out.println("Khong tim thay user");

  }

  @Override
  public void createNewAccount(Account account) {
    accounts.add(account);
    System.out.println("Add successfully");
  }

  @Override
  public void deleteAccount(String userName) {
    for (Account account : accounts) {
      if (account.getUsername().equals(userName)) {
        accounts.remove(account);
        System.out.println("Xoa thanh cong");
        return;
      }
    }
    System.out.println("Khong tim thay user");
  }

  @Override
  public Account getAccountByUsername(String username) {
    for (Account account : accounts) {
      if (account.getUsername().equals(username)) {
        System.out.println("Tim kiem thanh cong");
        return account;
      }
    }
    System.out.println("Khong tim thay user");
    return null;
  }

  @Override
  public ArrayList<Account> getAllAccount() {
    try {
      return accounts;
    } catch (Exception e) {
      System.out.println("Loi");
    }
    return accounts;
  }

}
