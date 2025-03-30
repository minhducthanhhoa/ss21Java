package bai10;

public class Product {
    private String id;
    private String name;
    private double price;

    public Product() {

    }

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void display() {
        System.out.println(id + " | " + name + " | " + price + " VND");
    }
}
