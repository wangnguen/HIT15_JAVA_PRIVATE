package models;

import java.util.Scanner;

public class Address {
  private String street;
  private String city;

  public Address() {

  }

  public Address(String street, String city) {
    this.street = street;
    this.city = city;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void inputAddress() {
    Scanner sc = new Scanner(System.in);
    this.street = sc.nextLine();
    this.city = sc.nextLine();
  }

  @Override
  public String toString() {
    return "Address [street=" + street + ", city=" + city + "]";
  }

  public void display() {
    System.out.println(toString());
  }
}