package bai8;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập các số điện thoại, cách nhau bằng dấu phẩy:");
        String input = scanner.nextLine();

        String[] phoneNumbers = input.split(",");

        List<String> validPhones = new ArrayList<>();
        List<String> invalidPhones = new ArrayList<>();

        for (String phone : phoneNumbers) {
            phone = phone.trim();

            try {
                validatePhoneNumber(phone);
                validPhones.add(phone);
            } catch (NumberFormatException e) {
                invalidPhones.add(phone + " - Lỗi: Số điện thoại chứa ký tự không hợp lệ!");
            } catch (InvalidPhoneNumberLengthException e) {
                invalidPhones.add(phone + " - " + e.getMessage());
            }
        }

        System.out.println("\nDanh sách số điện thoại hợp lệ:");
        for (String phone : validPhones) {
            System.out.println("- " + phone);
        }

        System.out.println("\nDanh sách số điện thoại không hợp lệ:");
        for (String error : invalidPhones) {
            System.out.println("- " + error);
        }
    }

    public static void validatePhoneNumber(String phone) throws InvalidPhoneNumberLengthException {
        if (phone.length() != 10) {
            throw new InvalidPhoneNumberLengthException("Lỗi: Số điện thoại phải đúng 10 chữ số!");
        }
        if (!phone.matches("\\d+")) {
            throw new NumberFormatException();
        }
    }
}
