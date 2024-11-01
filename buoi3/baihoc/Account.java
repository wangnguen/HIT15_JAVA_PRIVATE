package buoi3.baihoc;

public class Account {
  private int id;
  private String name;
  private int balance;

  Account(int id, String name) {
    this.id = id;
    this.name = name;
  }

  Account(int id, String name, int balance) {
    this.id = id;
    this.name = name;
    this.balance = balance;
  }

  public int getId() {
    return this.id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getBalance() {
    return this.balance;
  }

  public void deposit(int amount) {
    this.balance += amount;
  }

  public void withdraw(int amount) {
    if (this.balance < amount) {
      System.out.println("That amount exceeds your current balance.");
    } else {
      this.balance -= amount;
    }
  }

  public void display() {
    System.out.println("ID: " + this.id + "\n" + "Name: " + this.name + "\n" + "Balance: " + this.balance);
  }
}
