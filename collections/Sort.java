package collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

class Sort {
  public static void main(String[] args) {
    int[] arr = { 5, 2, 3, 5, 7, 9, 1 };
    /// Arrays
    // Arrays.sort(arr);
    // for (int i : arr) {
    // System.out.print(i + " ");
    // }
    /// ArrayList
    ArrayList<Integer> arr2 = new ArrayList<>();
    for (int i : arr) {
      arr2.add(i);
    }
    arr2.sort(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o1 - o2;
      }
    });
    Collections.sort(arr2, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2 - o1;
      }
    });
    /// forEach
    arr2.forEach((i) -> System.out.print(i + " "));
  }
}