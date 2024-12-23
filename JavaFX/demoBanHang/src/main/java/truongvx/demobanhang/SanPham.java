package truongvx.demobanhang;

public class SanPham {
  private int id;
  private String name;
  private String price;
  private String description;

  public SanPham(String name, String price, String description) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.description = description;
  }

  // Getters and Setters
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return id + " | " + name + " | " + price + " | " + description;
  }
}
