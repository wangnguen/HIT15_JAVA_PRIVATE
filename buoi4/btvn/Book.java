package buoi4.btvn;

import java.util.Scanner;

public class Book {
  private int maSach;
  private String tenSach;
  private String tenTacGia;
  private int namSanXuat;
  private String tomTatNoiDung;
  private double giaTien;

  public Book() {
  }

  public Book(int maSach, String tenSach, String tenTacGia, int namSanXuat, String tomTatNoiDung, double giaTien) {
    this.maSach = maSach;
    this.tenSach = tenSach;
    this.tenTacGia = tenTacGia;
    this.namSanXuat = namSanXuat;
    this.tomTatNoiDung = tomTatNoiDung;
    this.giaTien = giaTien;
  }

  public int getMaSach() {
    return maSach;
  }

  public void setMaSach(int maSach) {
    this.maSach = maSach;
  }

  public String getTenSach() {
    return tenSach;
  }

  public void setTenSach(String tenSach) {
    this.tenSach = tenSach;
  }

  public String getTenTacGia() {
    return tenTacGia;
  }

  public void setTenTacGia(String tenTacGia) {
    this.tenTacGia = tenTacGia;
  }

  public void input() {
    Scanner sc = new Scanner(System.in);
    System.out.println("nhap ma sach");
    this.maSach = sc.nextInt();
    sc.nextLine();
    System.out.println("nhap ten");
    this.tenSach = sc.nextLine();
    System.out.println("Nhap tac gia");
    this.tenTacGia = sc.nextLine();
    System.out.println("nhap nam san xuat");
    this.namSanXuat = sc.nextInt();
    sc.nextLine();
    System.out.println("Nhap tom tat");
    this.tomTatNoiDung = sc.nextLine();
    System.out.println("nhap gia tien");
    this.giaTien = sc.nextDouble();
  }

  public int getNamSanXuat() {
    return namSanXuat;
  }

  public void setNamSanXuat(int namSanXuat) {
    this.namSanXuat = namSanXuat;
  }

  public String getTomTatNoiDung() {
    return tomTatNoiDung;
  }

  public void setTomTatNoiDung(String tomTatNoiDung) {
    this.tomTatNoiDung = tomTatNoiDung;
  }

  public double getGiaTien() {
    return giaTien;
  }

  public void setGiaTien(double giaTien) {
    this.giaTien = giaTien;
  }

  @Override
  public String toString() {
    return "Book [maSach=" + maSach + ", tenSach=" + tenSach + ", tenTacGia=" + tenTacGia + ", namSanXuat=" + namSanXuat
        + ", tomTatNoiDung=" + tomTatNoiDung + ", giaTien=" + giaTien + "]";
  }

  public void display() {
    System.out.println(toString());
  }
}
