package service.impl;

import model.Account;
import model.Status;
import service.AccountService;

import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements AccountService {
    private List<Account> accounts;

    public AccountServiceImpl() {
        this.accounts = new ArrayList<>();
    }

    @Override
    public List<Account> getAllAccount() {
        return accounts;
    }

    @Override
    public void createNewAccount(Account account) {
        for (Account acc : accounts) {
            if (acc.getUsername().equals(account.getUsername())) {
                System.out.println("Tài khoản đã tồn tại.");
                return;
            }
        }
        accounts.add(account);
        System.out.println("Tạo tài khoản thành công.");
    }

    @Override
    public Account getAccountByUsername(String username) {
        for (Account account : accounts) {
            if (account.getUsername().equals(username)) {
                return account;
            }
        }
        System.out.println("Không tìm thấy tài khoản.");
        return null;
    }

    @Override
    public void deleteAccount(String username) {
        accounts.removeIf(account -> account.getUsername().equals(username));
        System.out.println("Xóa tài khoản thành công.");
    }

    @Override
    public void changeStatus(String username, Status status) {
        Account account = getAccountByUsername(username);
        if (account != null) {
            account.setStatus(status);
            System.out.println("Thay đổi trạng thái thành công.");
        }
    }
}
