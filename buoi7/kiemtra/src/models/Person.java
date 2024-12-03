package models;

import java.util.Scanner;

public abstract class Person {
  private String id;
  private String fullName;
  private int age;
  private Address address;
  private String birthday;

  public Person() {

  }

  public Person(String id, String fullName, int age, Address address, String birthday) {
    this.id = id;
    this.fullName = fullName;
    this.age = age;
    this.address = address;
    this.birthday = birthday;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public String getBirthday() {
    return birthday;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

  public void input() {
    Scanner sc = new Scanner(System.in);
    this.id = sc.nextLine();
    this.fullName = sc.nextLine();
    this.age = sc.nextInt();
    sc.nextLine();
    this.address.inputAddress();
    this.birthday = sc.nextLine();
  }

  @Override
  public String toString() {
    return "Person [id=" + id + ", fullName=" + fullName + ", age=" + age + ", address=" + address + ", birthday="
        + birthday + "]";
  }

  public void display() {
    System.out.println(toString());
  }
}
