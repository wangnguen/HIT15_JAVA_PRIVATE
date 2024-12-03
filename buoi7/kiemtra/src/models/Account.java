package models;

import java.util.Scanner;

public class Account extends Person {
  private String username;
  private String passworld;
  private Role role;
  private Status status;

  public Account() {
    super();
  }

  public Account(String id, String fullName, int age, Address address, String birthday, String username,
      String passworld, Role role, Status status) {
    super(id, fullName, age, address, birthday);
    this.username = username;
    this.passworld = passworld;
    this.role = role;
    this.status = status;
  }

  public String getUsername() {
    return username;
  }

  public String getPassworld() {
    return passworld;
  }

  public Role getRole() {
    return role;
  }

  public Status getStatus() {
    return status;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassworld(String passworld) {
    this.passworld = passworld;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  @Override
  public void input() {
    Scanner sc = new Scanner(System.in);
    super.input();
    this.username = sc.nextLine();
    this.passworld = sc.nextLine();
  }

  @Override
  public String toString() {
    return super.toString() + "Account [username=" + username + ", passworld=" + passworld + ", role=" + role
        + ", status=" + status + "]";
  }

  @Override
  public void display() {
    System.out.println(toString());
  }
}
