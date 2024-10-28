package baitap.Book2;

public class Book {
  private String name;
  private Author[] authors;
  private double price;
  private int qty;

  Book() {
  }

  public Book(String name, Author[] authors, double price) {
    this.name = name;
    this.authors = authors;
    this.price = price;
  }

  public Book(String name, Author[] authors, double price, int qty) {
    this.name = name;
    this.authors = authors;
    this.price = price;
    this.qty = qty;
  }

  public String getName() {
    return name;
  }

  public Author[] getAuthor() {
    return authors;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public int getQty() {
    return qty;
  }

  public void setQty(int qty) {
    this.qty = qty;
  }

  @Override
  public String toString() {
    String tmp = "Book Details : \n" + this.name + "\n" + (int) this.price + "\n" + this.qty + "\n"
        + "Author Information :\n";
    StringBuilder sb = new StringBuilder();
    for (Author i : authors) {
      sb.append(i.toString());
    }
    tmp = tmp + sb.toString();
    return tmp;
  }
}
