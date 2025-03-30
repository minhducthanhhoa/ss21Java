package bai10;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();
        ShoppingCart cart = new ShoppingCart();

        products.add(new Product("P001", "Laptop", 15000000));
        products.add(new Product("P002", "Điện thoại", 8000000));
        products.add(new Product("P003", "Tai nghe", 1000000));

        while (true) {
            System.out.println("\nHỆ THỐNG GIỎ HÀNG MUA SẮM");
            System.out.println("1️. Xem danh sách sản phẩm");
            System.out.println("2️. Thêm sản phẩm vào giỏ hàng");
            System.out.println("3️. Xóa sản phẩm khỏi giỏ hàng");
            System.out.println("4. Xem giỏ hàng");
            System.out.println("5️. Thanh toán");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("DANH SÁCH SẢN PHẨM:");
                    for (Product p : products) {
                        p.display();
                    }
                    break;

                case 2:
                    System.out.print("Nhập mã sản phẩm: ");
                    String addProductId = scanner.next();
                    Product addProduct = findProduct(products, addProductId);
                    if (addProduct != null) {
                        System.out.print("Nhập số lượng: ");
                        int quantity = scanner.nextInt();
                        try {
                            cart.addToCart(addProduct, quantity);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Sản phẩm không tồn tại!");
                    }
                    break;

                case 3:
                    System.out.print("Nhập mã sản phẩm cần xóa: ");
                    String removeProductId = scanner.next();
                    try {
                        cart.removeFromCart(removeProductId);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    cart.displayCart();
                    break;

                case 5:
                    cart.checkout();
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static Product findProduct(ArrayList<Product> products, String productId) {
        for (Product p : products) {
            if (p.getId().equalsIgnoreCase(productId)) {
                return p;
            }
        }
        return null;
    }
}
