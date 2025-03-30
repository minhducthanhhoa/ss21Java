import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Nhập số nguyên thú nhất: ");
            int num1 = scanner.nextInt();

            System.out.println("Nhập số nguyên thứ hai: ");
            int num2 = scanner.nextInt();

            int result = num1 / num2;
            System.out.println("Kết quả của phép chia: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Lỗi: không thể chia cho 0.");
        } catch (Exception e) {
            System.out.println("Lỗi: dữ liệu nhập vào không hợp lệ.");
        } finally {
            System.out.println("Kết thúc chương trình.");
        }
    }
}
