package kr.co.kosta2;
/*
    클래스 및 변수 선언:

    SimpleBankAccount 클래스는 owner와 balance 변수를 가집니다.
    생성자는 계좌 소유자 이름과 초기 잔액을 초기화합니다.

    입금 메서드:
    deposit(double amount): 입금할 금액을 받아 잔액에 더합니다. 잔액을 업데이트한 후 현재 잔액을 출력합니다.

    출금 메서드:
    withdraw(double amount): 출금할 금액을 받아 잔액에서 빼줍니다. 
    잔액이 부족할 경우 출금이 불가능하다는 메시지를 출력합니다.

    잔액 확인 메서드:
    checkBalance(): 현재 잔액을 출력합니다.

    메인 메서드:
    main 메서드는 Scanner를 사용하여 사용자 입력을 받아 계좌를 생성하고, 
    반복문을 통해 입금, 출금, 잔액 확인, 프로그램 종료 기능을 제공합니다.

    특징
    사용자 입력을 받아 간단한 은행 계좌 기능을 수행합니다.
    코드 구조가 단순하여 초보자가 이해하기 쉽습니다.
    입금 및 출금 시 잔액을 즉시 확인할 수 있습니다.
    이 프로그램은 Scanner 클래스를 사용하여 사용자 입력을 처리하고, 
    간단한 계좌 관리 기능을 제공합니다. 
    이 예제를 통해 자바의 기본적인 변수 선언과 연산자 사용 방법을 쉽게 이해할 수 있습니다.
 */
import java.util.Scanner;

public class SimpleBankAccount2 {
    private String owner;
    private double balance;

    public SimpleBankAccount2(String owner, double initialBalance) {
        this.owner = owner;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println(amount + "원이 입금되었습니다. 현재 잔액: " + balance + "원");
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(amount + "원이 출금되었습니다. 현재 잔액: " + balance + "원");
        } else {
            System.out.println("잔액이 부족합니다. 현재 잔액: " + balance + "원");
        }
    }

    public void checkBalance() {
        System.out.println(owner + "님의 현재 잔액은 " + balance + "원입니다.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("계좌 소유자 이름을 입력하세요:");
        String owner = scanner.nextLine();
        System.out.println("초기 입금액을 입력하세요:");
        double initialBalance = scanner.nextDouble();

        SimpleBankAccount2 account = new SimpleBankAccount2(owner, initialBalance);

        while (true) {
            System.out.println("\n메뉴를 선택하세요: 1. 입금 2. 출금 3. 잔액 확인 4. 종료");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("입금할 금액을 입력하세요:");
                double amount = scanner.nextDouble();
                account.deposit(amount);
            } else if (choice == 2) {
                System.out.println("출금할 금액을 입력하세요:");
                double amount = scanner.nextDouble();
                account.withdraw(amount);
            } else if (choice == 3) {
                account.checkBalance();
            } else if (choice == 4) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 선택입니다. 다시 입력해주세요.");
            }
        }

        scanner.close();
    }
}
