
import java.util.Scanner;

import models.Role;
import models.User;
import services.impl.IUserServiceImpl;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    IUserServiceImpl userService = new IUserServiceImpl();
    User person = new User("006", "Anh", "anh@gmail.com", "1234", 18, "02/08/2006", Role.USER);
    while (true) {
      System.out.println(
          "1.Login\n2.Display Member\n3.Add Member(Admin Only)\n4.Delete Member(Admin Only)\n5.Logout\n6.Exit");
      System.out.println("Enter your choice: ");
      int choice = scanner.nextInt();
      scanner.nextLine();
      switch (choice) {
        case 1:
          userService.login(scanner);
          break;
        case 2:
          userService.display();
          break;
        case 3:
          if (userService.addMember(person) == true) {
            System.out.println("Add User Successfully!");
          } else {
            System.out.println("Add User NOT Successfully!");
          }
          break;
        case 4:
          String id = scanner.nextLine();
          if (userService.deleteMember(id) == true) {
            System.out.println("Delete User Successfully!");
          } else {
            System.out.println("Delete User NOT Successfully!");
          }
          break;
        case 5:
          userService.logout();
          break;
        case 6:
          System.exit(0);
          System.out.println("Exit!");
        default:
          System.out.println("Invalid choice!");
      }
    }
  }
}
