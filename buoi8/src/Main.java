import db.DbConnect;

import java.sql.*;
import java.util.Scanner;

public class Main {
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {

    try {
      Connection connection = DbConnect.getConnection();
      while (true) {
        System.out.println("\nMenu\n1.ExcuteQuery\n2.ExecuteUpdate\n3.Exit");
        System.out.println("Lua chon");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
          case 1:
            testExecuteQuery(connection);
            break;
          case 2:
            testExecuteUpdate(connection);
            break;
          case 3:
            System.exit(0);
            break;
          default:
            System.out.println("Lua chon khong hop le. Vui long thu lai.");
            break;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void testExecuteQuery(Connection connection) throws SQLException {
    String query = "SELECT * FROM Product";
    if (connection != null) {
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(query);
      while (resultSet.next()) {
        System.out.println(
            resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getInt(3) + " " + resultSet.getInt(4));
      }
    }
  }

  public static void testExecuteUpdate(Connection connection) throws SQLException {
    String query = "INSERT INTO Product VALUES(?,?,?,?)";
    if (connection != null) {
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      int id = Integer.parseInt(sc.nextLine());
      String name = sc.nextLine();
      int price = Integer.parseInt(sc.nextLine());
      int category_id = Integer.parseInt(sc.nextLine());
      preparedStatement.setInt(1, id);
      preparedStatement.setString(2, name);
      preparedStatement.setInt(3, price);
      preparedStatement.setInt(4, category_id);
      int rowsAffected = preparedStatement.executeUpdate();
      System.out.println("So dong da them: " + rowsAffected);
    }
  }
}
