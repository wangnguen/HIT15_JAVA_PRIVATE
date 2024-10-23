package buoi2.lythuyet;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.Set;
import java.util.Map;

public class BT1_Cach1 {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      int max = (int) -1e9;
      TreeMap<Integer, Integer> map = new TreeMap<>();
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
        if (map.containsKey(arr[i])) {
          int tmp = map.get(arr[i]);
          ++tmp;
          max = Math.max(max, tmp);
          map.put(arr[i], tmp);
        } else {
          map.put(arr[i], 1);
        }
      }
      Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
      for (Map.Entry<Integer, Integer> entry : entrySet) {
        if (entry.getValue() == max) {
          System.out.println(entry.getKey() + " " + entry.getValue());
          return;
        }
      }
    }
  }
}
