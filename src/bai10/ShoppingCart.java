package bai10;
import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<CartItem> cartItems = new ArrayList<>();

    public void addToCart(Product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Lỗi: Số lượng không hợp lệ!");
        }

        for (CartItem item : cartItems) {
            if (item.getProduct().getId().equals(product.getId())) {
                item.setQuantity(item.getQuantity() + quantity);
                System.out.println("Đã tăng số lượng sản phẩm trong giỏ!");
                return;
            }
        }

        cartItems.add(new CartItem(product, quantity));
        System.out.println("Đã thêm sản phẩm vào giỏ hàng!");
    }

    public void removeFromCart(String productId) {
        for (CartItem item : cartItems) {
            if (item.getProduct().getId().equals(productId)) {
                cartItems.remove(item);
                System.out.println("Đã xóa sản phẩm khỏi giỏ hàng!");
                return;
            }
        }
        throw new IllegalArgumentException("Lỗi: Không tìm thấy sản phẩm trong giỏ hàng!");
    }

    public void displayCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Giỏ hàng đang trống!");
            return;
        }
        System.out.println("DANH SÁCH SẢN PHẨM TRONG GIỎ:");
        for (CartItem item : cartItems) {
            item.display();
        }
    }

    public void checkout() {
        double total = 0;
        for (CartItem item : cartItems) {
            total += item.getProduct().getPrice() * item.getQuantity();
        }
        System.out.println("Tổng tiền cần thanh toán: " + total + " VND");
    }
}
