package testJdbc2;

public class Product {
    private int id;
    private String name;
    private double price;
    private int shopId;

    public Product(){}

    public Product(int id, String name, double price, int shopId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.shopId = shopId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", price = " + price +
                ", shopId = " + shopId +
                '}';
    }
}
