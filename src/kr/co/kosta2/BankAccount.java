package kr.co.kosta2;
/*
    변수 선언 및 초기화:
    Scanner scanner = new Scanner(System.in);: Scanner 객체를 생성하여 사용자 입력을 받습니다.

    사용자 입력:
    String owner = scanner.nextLine();: 사용자로부터 계좌 소유자 이름을 입력받습니다.
    double initialBalance = scanner.nextDouble();: 초기 입금액을 입력받습니다.

    입금 및 출금 기능:
    deposit(double amount): 입금할 금액을 받아 잔액에 더합니다.
    withdraw(double amount): 출금할 금액을 받아 잔액에서 뺍니다. 잔액이 부족할 경우 메시지를 출력합니다.

    잔액 확인:
    checkBalance(): 현재 잔액을 출력합니다.

    메뉴 반복:
    사용자가 메뉴에서 선택한 항목에 따라 입금, 출금, 잔액 확인, 프로그램 종료를 처리합니다.

    프로그램 종료:
    scanner.close();: 스캐너를 닫아 리소스를 해제합니다.

    이 프로그램은 사용자와 상호작용하며 입력을 받고, 
    다양한 기능을 수행하는 방법을 보여줍니다. 
    Scanner 클래스를 활용하여 사용자 입력을 받아 처리하는 기본적인 방법을 이해하는 데 도움이 됩니다.
 */
import java.util.Scanner;

public class BankAccount {
    private String owner;
    private double balance;

    public BankAccount(String owner, double initialBalance) {
        this.owner = owner;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + "원이 입금되었습니다.");
        } else {
            System.out.println("입금할 금액은 0원보다 커야 합니다.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + "원이 출금되었습니다.");
        } else if (amount > balance) {
            System.out.println("잔액이 부족합니다.");
        } else {
            System.out.println("출금할 금액은 0원보다 커야 합니다.");
        }
    }

    public void checkBalance() {
        System.out.println(owner + "님의 현재 잔액은 " + balance + "원입니다.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 사용자 입력으로 계좌 개설
        System.out.println("계좌 소유자 이름을 입력하세요:");
        String owner = scanner.nextLine();
        System.out.println("초기 입금액을 입력하세요:");
        double initialBalance = scanner.nextDouble();

        BankAccount account = new BankAccount(owner, initialBalance);

        boolean exit = false;
        while (!exit) {
            // 메뉴 출력
            System.out.println("\n메뉴를 선택하세요:");
            System.out.println("1. 입금");
            System.out.println("2. 출금");
            System.out.println("3. 잔액 확인");
            System.out.println("4. 종료");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // 입금 처리
                    System.out.println("입금할 금액을 입력하세요:");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    // 출금 처리
                    System.out.println("출금할 금액을 입력하세요:");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    // 잔액 확인
                    account.checkBalance();
                    break;
                case 4:
                    // 종료
                    exit = true;
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }
        }

        scanner.close();
    }
}
