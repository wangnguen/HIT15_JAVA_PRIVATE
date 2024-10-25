package collections.lamda;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Sort {
  public static void main(String[] args) {
    List<Integer> arr = new ArrayList<>();
    arr.add(3);
    arr.add(6);
    arr.add(0);
    arr.add(1);
    arr.add(8);
    Collections.sort(arr, (o1, o2) -> {
      return o1 - o2;
    });
  }
}
