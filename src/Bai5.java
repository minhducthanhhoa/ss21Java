import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Nhập số nguyên dương: ");
            int n = scanner.nextInt();

            if(n <= 0){
                System.err.println("Số nhập vào phải là số nguyên dương lớn hơn 0.");
            }

            if(isPrime(n)){
                System.out.println(n + " là số nguyên tố.");
            } else {
                System.out.println(n + " không phải là số nguyên tố.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Bạn phải nhập số nguyên.");
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } finally {
            System.out.println("Chương trình kết thúc.");
        }
    }

    public static boolean isPrime(int n){
        if(n < 2)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
