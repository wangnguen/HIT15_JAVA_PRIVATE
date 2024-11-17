package buoi5.btvn;

import java.util.Scanner;

public class Address {
    private String commune;
    private String district;
    private String city;

    public Address() {
    }

    public Address(String commune, String district, String city) {
        this.commune = commune;
        this.district = district;
        this.city = city;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap xa");
        this.commune = sc.nextLine();
        System.out.println("Nhap huyen");
        this.district = sc.nextLine();
        System.out.println("Nhap tinh/thanh pho");
        this.city = sc.nextLine();
    }

    @Override
    public String toString() {
        return "Address [commune=" + commune + ", district=" + district + ", city=" + city + "]";
    }

    public void output() {
        System.out.println(toString());
    }
}