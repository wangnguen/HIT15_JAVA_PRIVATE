package collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class MyList {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    ArrayList<Integer> arr = new ArrayList<>();
    // them vao mang
    for (int i = 0; i < n; i++) {
      int tmp = sc.nextInt();
      arr.add(tmp);
    }
    System.out.println(arr.contains(9)); // xem trong mang co ptu
    System.out.println(arr.indexOf(1)); // tra ve vi tri dau tien
    // duyet binh thuong
    for (int i = 0; i < arr.size(); i++) {
      System.out.print(arr.get(i) + " "); // get lay vi tri thu
    }
    // sx tang dan
    arr.sort(new Comparator<Integer>() {
      public int compare(Integer o1, Integer o2) {
        return o1 - o2;
      }
    });
    arr.remove((Object) 2); // xoa phan tu
    arr.remove(4); // xoa vi tri
    System.out.println();
    // duyet forEach
    arr.forEach((i) -> System.out.print(i + " "));
    Object[] b = arr.toArray(); // dua ve mang thuong
    System.out.println();
    for (Object i : b) {
      System.out.print(i + " ");
    }
    sc.close();
  }
}