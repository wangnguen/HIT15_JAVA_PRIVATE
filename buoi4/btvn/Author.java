package buoi4.btvn;

import java.util.Scanner;

public class Author {
    private String name;

    public Author() {

    }

    public Author(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ten tac gia");
        this.name = sc.nextLine();
    }

    @Override
    public String toString() {
        return name;
    }

}
