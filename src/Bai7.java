import java.util.Scanner;

public class Bai7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double balance = 1000000;
        double minBalance = 50000;

        try {
            System.out.print("Nhập số tiền muốn rút: ");
            double amount = Double.parseDouble(scanner.nextLine());

            if (amount <= 0) {
                throw new IllegalArgumentException("Lỗi: Số tiền rút phải lớn hơn 0!");
            }

            if (amount > balance) {
                throw new IllegalArgumentException("Lỗi: Số tiền rút vượt quá số dư!");
            }

            if ((balance - amount) < minBalance) {
                throw new IllegalArgumentException("Lỗi: Tài khoản phải duy trì số dư tối thiểu 50.000 đồng!");
            }

            balance -= amount;
            System.out.println("Rút tiền thành công! Số dư còn lại: " + balance + " VNĐ");

        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Vui lòng nhập một số hợp lệ!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Chương trình kết thúc.");
        }
    }
}
