import db.JDBCConnector;

import java.sql.*;
import java.util.Scanner;

public class Main {
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {

    try {
      Connection connection = JDBCConnector.getConnection();
      while (true) {
        System.out.println("\nMenu\n1.Hien Thi\n2.Them\n3.Sua\n4.Xoa\n5.Tim Kiem\n6.Exit");
        System.out.println("Lua chon");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
          case 1:
            hienThi(connection);
            break;
          case 2:
            them(connection);
            break;
          case 3:
            System.out.println("Nhap id muon sua");
            int id = Integer.parseInt(sc.nextLine());
            edit(connection, id);
            break;
          case 4:
            System.out.println("Nhap id muon xoa");
            int idDelete = Integer.parseInt(sc.nextLine());
            delete(connection, idDelete);
            break;
          case 5:
            System.out.println("Nhap ten can tim");
            String name = sc.nextLine();
            timKiem(connection, name);
            break;
          case 6:
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

  public static void hienThi(Connection connection) {
    String query = "SELECT * FROM Product";

    if (connection == null) {
      System.err.println("Kết nối đến cơ sở dữ liệu không hợp lệ.");
      return;
    }

    try (Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query)) {

      System.out.println("Danh sách sản phẩm:");
      System.out.printf("%-10s %-20s %-10s %-10s%n", "ID", "Tên sản phẩm", "Giá", "Loại ID");
      while (resultSet.next()) {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        int price = resultSet.getInt("price");
        int category_id = resultSet.getInt("category_id");
        System.out.printf("%-10d %-20s %-10d %-10d%n", id, name, price, category_id);
      }

    } catch (SQLException e) {
      System.err.println("Lỗi khi truy vấn dữ liệu: " + e.getMessage());
    }
  }

  public static void them(Connection connection) throws SQLException {
    String query = "INSERT INTO Product (id, name, price, category_id) VALUES (?, ?, ?, ?)";

    if (connection == null) {
      System.err.println("Kết nối đến cơ sở dữ liệu không hợp lệ.");
      return;
    }

    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
      // Nhập thông tin từ người dùng
      System.out.println("Nhập ID sản phẩm:");
      int id = Integer.parseInt(sc.nextLine());

      System.out.println("Nhập tên sản phẩm:");
      String name = sc.nextLine();

      System.out.println("Nhập giá sản phẩm:");
      int price = Integer.parseInt(sc.nextLine());

      System.out.println("Nhập ID loại sản phẩm:");
      int category_id = Integer.parseInt(sc.nextLine());

      // Thiết lập tham số
      preparedStatement.setInt(1, id);
      preparedStatement.setString(2, name);
      preparedStatement.setInt(3, price);
      preparedStatement.setInt(4, category_id);

      // Thực thi lệnh
      int rowsAffected = preparedStatement.executeUpdate();
      System.out.println("Đã thêm thành công: " + rowsAffected + " bản ghi.");
    } catch (SQLException e) {
      System.err.println("Lỗi khi thêm sản phẩm: " + e.getMessage());
    } catch (NumberFormatException e) {
      System.err.println("Dữ liệu nhập vào không hợp lệ. Vui lòng kiểm tra lại.");
    }
  }

  public static void edit(Connection connection, int id) throws SQLException {
    String query = "UPDATE product SET name = ?, price = ?, category_id = ? WHERE id = ?";
    if (connection != null) {
      try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        // Nhập dữ liệu từ người dùng
        System.out.println("Nhập tên sản phẩm cần sửa:");
        String name = sc.nextLine();

        System.out.println("Nhập giá sản phẩm:");
        int price = Integer.parseInt(sc.nextLine());

        System.out.println("Nhập ID loại sản phẩm:");
        int category_id = Integer.parseInt(sc.nextLine());

        // Thiết lập tham số cho câu truy vấn
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, price);
        preparedStatement.setInt(3, category_id);
        preparedStatement.setInt(4, id);

        // Thực thi câu lệnh
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
          System.out.println("Cập nhật thành công: " + rowsAffected + " bản ghi.");
        } else {
          System.out.println("Không tìm thấy sản phẩm với ID: " + id);
        }
      } catch (SQLException e) {
        System.err.println("Lỗi khi cập nhật sản phẩm: " + e.getMessage());
      }
    } else {
      System.err.println("Kết nối đến cơ sở dữ liệu không hợp lệ.");
    }
  }

  public static void delete(Connection connection, int id) throws SQLException {
    String query = "DELETE FROM product WHERE id = ?";
    if (connection != null) {
      try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setInt(1, id);
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
          System.out.println("Đã xóa thành công: " + rowsAffected + " bản ghi.");
        } else {
          System.out.println("Không tìm thấy bản ghi với ID: " + id);
        }
      } catch (SQLException e) {
        System.err.println("Lỗi khi xóa: " + e.getMessage());
      }
    } else {
      System.err.println("Kết nối đến cơ sở dữ liệu không hợp lệ.");
    }
  }

  public static void timKiem(Connection connection, String name) {
    String query = "SELECT * FROM Product WHERE name LIKE ?";

    if (connection == null) {
      System.err.println("Kết nối đến cơ sở dữ liệu không hợp lệ.");
      return;
    }

    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
      // Thêm ký tự `%` để tìm kiếm gần đúng
      preparedStatement.setString(1, "%" + name + "%");

      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        System.out.println("Kết quả tìm kiếm:");
        boolean found = false;
        while (resultSet.next()) {
          found = true;
          int productId = resultSet.getInt("id");
          String productName = resultSet.getString("name");
          int price = resultSet.getInt("price");
          int categoryId = resultSet.getInt("category_id");

          // Hiển thị thông tin sản phẩm
          System.out.printf("ID: %d, Tên: %s, Giá: %d, Loại ID: %d%n", productId, productName, price, categoryId);
        }
        if (!found) {
          System.out.println("Không tìm thấy sản phẩm với tên: " + name);
        }
      }
    } catch (SQLException e) {
      System.err.println("Lỗi khi truy vấn sản phẩm: " + e.getMessage());
    }
  }

}
