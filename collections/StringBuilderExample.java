package collections;

public class StringBuilderExample {
  public static void main(String[] args) {
    String name = "PHAm KiEu TRang";
    String[] names = name.split("\\s+");
    String newName = "";
    for (String x : names) {
      newName += Character.toUpperCase(x.charAt(0));
      for (int i = 1; i < x.length(); i++) {
        newName += Character.toLowerCase(x.charAt(i));
      }
      newName += " ";
    }
    newName.trim();
    System.out.println(newName);

    String birth = "10/3/2005";
    StringBuilder sb = new StringBuilder(birth);
    if (sb.charAt(1) == '/') {
      sb.insert(0, '0');
    }
    if (sb.charAt(4) == '/') {
      sb.insert(3, '0');
    }
    birth = sb.toString();
    System.out.println(birth);
  }
}
