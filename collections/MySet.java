package collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.Scanner;

public class MySet {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    HashSet<Integer> set = new HashSet<>(); // luu phan tu khong theo vi tri
    LinkedHashSet<Integer> set2 = new LinkedHashSet<>(); // luu phan tu theo vi tri them vao
    TreeSet<Integer> set3 = new TreeSet<>(); // luu phan tu theo vi tri tang dan (logN)
    for (int i = 0; i < n; i++) {
      int tmp = sc.nextInt();
      set.add(tmp); // them
      set2.add(tmp);
      set3.add(tmp);
    }
    for (int i : set) {
      System.out.print(i + " ");
    }
    System.out.println();
    for (int i : set2) {
      System.out.print(i + " ");
    }
    System.out.println();
    set3.add(3);
    set3.remove(3); // xoa
    System.out.println(set3.contains(3)); // ton tai
    for (int i : set3) {
      System.out.print(i + " ");
    }
    sc.close();
  }
}