package buoi5.btvn;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Person {
    protected String name;
    protected int age;
    protected Address address;

    public Person() {
    }

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", address=" + address + "]";
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ten");
        this.name = sc.nextLine();
        System.out.println("Nhap tuoi");
        this.age = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap dia chi");
        Address address = new Address();
        address.input();
        this.address = address;
    }

    public void output() {
        System.out.println(toString());
    }
}