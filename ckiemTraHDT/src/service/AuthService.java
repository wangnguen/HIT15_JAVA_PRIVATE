package service;

import model.Account;

import java.util.Scanner;

public interface AuthService {
   public void login(Scanner scanner);

   public Account getLoggedInAccount();

   public void logout();

   public void changePassword(String username, String oldPassword, String newPassword);
}
