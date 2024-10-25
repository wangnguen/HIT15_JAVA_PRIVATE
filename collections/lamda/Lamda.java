package collections.lamda;

public class Lamda {
  public static void main(String[] args) {
    Person man = (firstName, lastName) -> {
      System.out.println("Say hello " + firstName + " " + lastName);
    };
    man.sayHello("Quang", "Quang");
  }
}
