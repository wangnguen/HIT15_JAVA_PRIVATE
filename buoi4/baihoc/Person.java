package buoi4.baihoc;

import java.util.Scanner;

public class Person {
  private String maCCCD;
  private String ten;
  private int tuoi;
  private String diaChi;
  private String soDienThoai;

  public Person() {
  }

  public Person(String maCCCD, String ten, int tuoi, String diaChi, String soDienThoai) {
    this.maCCCD = maCCCD;
    this.ten = ten;
    this.tuoi = tuoi;
    this.diaChi = diaChi;
    this.soDienThoai = soDienThoai;
  }

  public String getMaCCCD() {
    return maCCCD;
  }

  public void setMaCCCD(String maCCCD) {
    this.maCCCD = maCCCD;
  }

  public String getTen() {
    return ten;
  }

  public void setTen(String ten) {
    this.ten = ten;
  }

  public int getTuoi() {
    return tuoi;
  }

  public void setTuoi(int tuoi) {
    this.tuoi = tuoi;
  }

  public String getDiaChi() {
    return diaChi;
  }

  public void setDiaChi(String diaChi) {
    this.diaChi = diaChi;
  }

  public String getSoDienThoai() {
    return soDienThoai;
  }

  public void setSoDienThoai(String soDienThoai) {
    this.soDienThoai = soDienThoai;
  }

  public void input() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Can cuoc cong dan");
    this.maCCCD = sc.nextLine();
    System.out.println("Ten ");
    this.ten = sc.nextLine();
    System.out.println("Tuoi");
    this.tuoi = sc.nextInt();
    sc.nextLine();
    System.out.println("Dia chi");
    this.diaChi = sc.nextLine();
    System.out.println("So dien thoai");
    this.soDienThoai = sc.nextLine();
  }

  public void display() {
    System.out.println(
        "Person [maCCCD=" + maCCCD + ", ten=" + ten + ", tuoi=" + tuoi + ", diaChi=" + diaChi + ", soDienThoai="
            + soDienThoai + "]");
  }
}
