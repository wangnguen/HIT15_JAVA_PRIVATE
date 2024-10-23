package collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class MyMapp {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    HashMap<String, Integer> map1 = new HashMap<>();
    TreeMap<String, Integer> map2 = new TreeMap<>();
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
      String text = sc.next();
      int tmp = sc.nextInt();
      map1.put(text, tmp);
      map2.put(text, tmp);
    }
    Set<Map.Entry<String, Integer>> entrySet1 = map1.entrySet();
    Set<Map.Entry<String, Integer>> entrySet2 = map2.entrySet();
    for (Map.Entry<String, Integer> entry : entrySet1) {
      System.out.println(entry.getKey() + " -> " + entry.getValue());
    }
    for (Map.Entry<String, Integer> entry : entrySet2) {
      System.out.println(entry.getKey() + " -> " + entry.getValue());
    }
    sc.close();
  }
}
