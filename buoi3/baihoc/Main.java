package buoi3.baihoc;

public class Main {
  public static void main(String[] args) {
    Account account = new Account(0, "Quang", 50000);
    account.deposit(5000);
    account.withdraw(500);
    account.display();
  }
}
