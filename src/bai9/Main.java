package bai9;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();

        accounts.add(new BankAccount("123456", 5000000));
        accounts.add(new BankAccount("987654", 2000000));
        accounts.add(new BankAccount("456789", 1000000));

        while (true) {
            System.out.println("\nQUẢN LÝ GIAO DỊCH NGÂN HÀNG");
            System.out.println("1.️ Gửi tiền");
            System.out.println("2.️ Rút tiền");
            System.out.println("3️. Chuyển tiền");
            System.out.println("4️. Hiển thị tài khoản");
            System.out.println("0️. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("🔹 Nhập số tài khoản: ");
                    String depositAccId = scanner.next();
                    BankAccount depositAcc = findAccount(accounts, depositAccId);
                    if (depositAcc != null) {
                        System.out.print("Nhập số tiền gửi: ");
                        double amount = scanner.nextDouble();
                        try {
                            depositAcc.deposit(amount);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Tài khoản không tồn tại!");
                    }
                    break;

                case 2:
                    System.out.print("Nhập số tài khoản: ");
                    String withdrawAccId = scanner.next();
                    BankAccount withdrawAcc = findAccount(accounts, withdrawAccId);
                    if (withdrawAcc != null) {
                        System.out.print("Nhập số tiền rút: ");
                        double amount = scanner.nextDouble();
                        try {
                            withdrawAcc.withdraw(amount);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Tài khoản không tồn tại!");
                    }
                    break;

                case 3:
                    System.out.print("🔹 Nhập số tài khoản nguồn: ");
                    String senderAccId = scanner.next();
                    BankAccount sender = findAccount(accounts, senderAccId);
                    if (sender != null) {
                        System.out.print("🔹 Nhập số tài khoản đích: ");
                        String receiverAccId = scanner.next();
                        BankAccount receiver = findAccount(accounts, receiverAccId);
                        if (receiver != null) {
                            System.out.print("Nhập số tiền chuyển: ");
                            double amount = scanner.nextDouble();
                            try {
                                sender.transfer(receiver, amount);
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                        } else {
                            System.out.println("Tài khoản nhận không tồn tại!");
                        }
                    } else {
                        System.out.println("Tài khoản nguồn không tồn tại!");
                    }
                    break;

                case 4:
                    System.out.println("DANH SÁCH TÀI KHOẢN:");
                    for (BankAccount acc : accounts) {
                        acc.displayInfo();
                    }
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static BankAccount findAccount(ArrayList<BankAccount> accounts, String accountId) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountId().equals(accountId)) {
                return acc;
            }
        }
        return null;
    }
}
