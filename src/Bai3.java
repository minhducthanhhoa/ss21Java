import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập tuổi của bạn: ");
            int age = scanner.nextInt();
            checkAge(age);
            System.out.println("Chào mừng bạn!");
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        } finally {
            System.out.println("kết thúc chương trình");
        }
    }

    public static void checkAge(int age) throws Exception {
        if (age < 18) {
            throw new Exception("Bạn chưa đủ 18 tuổi!");
        }
    }
}
