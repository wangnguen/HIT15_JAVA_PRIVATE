package buoi2.lythuyet;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.Set;
import java.util.Map;

public class BT3 {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String s = sc.nextLine();
      TreeMap<Character, Integer> map = new TreeMap<>();
      for (char x : s.toCharArray()) {
        if (map.containsKey(x)) {
          int tmp = map.get(x);
          ++tmp;
          map.put(x, tmp);
        } else {
          map.put(x, 1);
        }
      }

      Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
      int countAlplha = 0, countNumber = 0, countSymbol = 0;
      for (Map.Entry<Character, Integer> entry : entrySet) {
        if (Character.isDigit(entry.getKey())) {
          ++countNumber;
        } else if (Character.isAlphabetic(entry.getKey())) {
          ++countAlplha;
        } else {
          ++countSymbol;
        }
      }
      System.out.println(countAlplha + " " + countNumber + " " + countSymbol);
    }
  }
}
