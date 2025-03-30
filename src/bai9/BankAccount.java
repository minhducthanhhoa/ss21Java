package bai9;
import java.util.ArrayList;
import java.util.Scanner;

public class BankAccount {
    private String accountId;
    private double balance;

    public BankAccount() {

    }

    public BankAccount(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Số tiền gửi phải lớn hơn 0!");
        }
        balance += amount;
        System.out.println("Nạp thành công! Số dư hiện tại: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Số tiền rút phải lớn hơn 0!");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Số dư không đủ để rút!");
        }
        balance -= amount;
        System.out.println("Rút thành công! Số dư còn lại: " + balance);
    }

    public void transfer(BankAccount receiver, double amount) {
        if (receiver == null) {
            throw new IllegalArgumentException("Tài khoản nhận không tồn tại!");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Số tiền chuyển phải lớn hơn 0!");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Số dư không đủ để chuyển!");
        }

        this.balance -= amount;
        receiver.balance += amount;

        System.out.println("Chuyển thành công " + amount + " vào tài khoản " + receiver.getAccountId());
    }

    public void displayInfo() {
        System.out.println("Số tài khoản: " + accountId + " | Số dư: " + balance);
    }
}
