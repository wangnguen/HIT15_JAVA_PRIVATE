package services;

import java.util.List;

import models.Account;
import models.Status;

public interface IAccountService {
  List<Account> getAllAccount();

  void createNewAccount(Account account);

  Account getAccountByUsername(String username);

  void deleteAccount(String userName);

  void changeStatus(String username, Status status);
}
