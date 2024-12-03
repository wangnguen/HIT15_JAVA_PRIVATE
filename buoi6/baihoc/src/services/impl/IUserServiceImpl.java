package services.impl;

import java.util.ArrayList;
import java.util.Scanner;

import models.Role;
import models.User;
import services.IUserService;

public class IUserServiceImpl implements IUserService {
  private ArrayList<User> userList = new ArrayList<>();
  private User currentUser;

  public IUserServiceImpl() {
    User admin = new User("001", "Admin", "a@gmail.com", "admin", 18, "07/09/2005", Role.ADMIN);
    userList.add(admin);
    currentUser = null;
  }

  @Override
  public boolean addMember(User user) {
    if (isAdmin()) {
      userList.add(user);
      return true;
    }
    return false;
  }

  @Override
  public boolean deleteMember(String id) {
    if (isAdmin()) {
      for (User user : userList) {
        if (user.getId().equals(id)) {
          userList.remove(user);
          return true;
        }
      }
    }
    return false;
  }

  @Override
  public void display() {
    if (userList.isEmpty()) {
      System.out.println("No member found!");
    } else {
      System.out.println("Member List: ");
      for (User user : userList) {
        user.display();
      }
    }
  }

  @Override
  public void login(Scanner scanner) {
    System.out.print("Enter email: ");
    String email = scanner.nextLine();
    System.out.print("Enter password: ");
    String password = scanner.nextLine();

    for (User user : userList) {
      if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
        currentUser = user;
        System.out.println("Login successfully!");
        return;
      }
    }

    System.out.println("Invalid email or password!");
  }

  @Override
  public void logout() {
    if (currentUser != null) {
      System.out.println("Logout successfully!");
      currentUser = null;
    } else {
      System.out.println("No user is currently logged in!");
    }

  }

  private boolean isAdmin() {
    return currentUser != null && currentUser.getRole() == Role.ADMIN;
  }
}
