package services;

import java.util.Scanner;

import models.User;

public interface IUserService {
  public void login(Scanner scanner);

  public void logout();

  public void display();

  public boolean addMember(User user); // admin use method

  public boolean deleteMember(String id); // admin use method
}
