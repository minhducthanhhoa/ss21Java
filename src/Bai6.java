import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập danh sách chuỗi: ");
        String input = scanner.nextLine();

        String[] elements = input.split(" , ");

        List<Integer> validNumbers = new ArrayList<>();
        int invalidNumber = 0;

        for(String element : elements){
            element = element.trim();

            try {
                int number = Integer.parseInt(element);
                validNumbers.add(number);
            } catch (NumberFormatException e) {
                invalidNumber++;
            } finally {
                System.out.println("Chương trình kết thúc");
            }
        }


    }
}
