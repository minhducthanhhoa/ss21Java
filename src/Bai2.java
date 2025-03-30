import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = {10, 20, 30, 40, 50};

        System.out.print("Mảng số nguyên: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("Nhập chỉ số của phần tử trong mảng: ");

        try {
            int index = scanner.nextInt();
            int value = numbers[index];
            System.out.println("Giá trị tại chỉ số " + index + " là: " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Lỗi: Chỉ số không hợp lệ! Vui lòng nhập từ 0 đến " + (numbers.length - 1));
        } catch (Exception e) {
            System.out.println("Lỗi: Vui lòng nhập một số nguyên hợp lệ!");
        } finally {
            System.out.println("Kết thúc chương trình");
        }
    }
}
