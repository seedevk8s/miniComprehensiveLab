package kr.co.kosta2;

/*
 * Scanner 클래스 
    Scanner 클래스는 자바에서 표준 입력 스트림(System.in)으로부터 사용자의 입력을 받아들이기 위해 사용됩니다. 
    Scanner는 자바 유틸리티 패키지(java.util)에 포함되어 있습니다. 
    이 클래스는 다양한 기본 데이터 타입을 쉽게 읽을 수 있는 메서드를 제공하며, 
    공백, 탭, 엔터 등을 구분자로 인식하여 입력을 처리합니다.

    주요 메서드
    nextInt(): 정수를 입력받습니다.
    nextDouble(): 실수를 입력받습니다.
    nextLine(): 한 줄 전체를 문자열로 입력받습니다.
    next(): 단어 단위로 문자열을 입력받습니다.
    hasNext(): 입력으로부터 다음 토큰이 있는지 확인합니다.
    close(): 스캐너를 닫고 리소스를 해제합니다.

    Scanner를 활용한 예제 프로그램
    이 예제는 사용자로부터 이름, 나이, 잔액을 입력받아 은행 계좌를 생성하고, 
    입금 및 출금 기능을 제공하는 간단한 프로그램입니다.
 */

 /*
    사용자 입력 처리:
    Scanner scanner = new Scanner(System.in);: Scanner 객체를 생성하여 사용자 입력을 받습니다.
    String owner = scanner.nextLine();: 사용자로부터 계좌 소유자 이름을 입력받습니다.
    double balance = scanner.nextDouble();: 초기 입금액을 입력받습니다.

    반복문을 통한 메뉴 처리:
    while (!exit): exit 변수가 true가 될 때까지 반복문을 실행합니다.
    int choice = scanner.nextInt();: 사용자가 메뉴에서 선택한 항목을 입력받습니다.

    입금 처리:
    사용자가 1을 선택하면 입금 금액을 입력받고, 잔액에 더해줍니다.

    출금 처리:
    사용자가 2를 선택하면 출금 금액을 입력받고, 잔액이 충분한지 확인한 후 출금합니다. 
    잔액이 부족하면 오류 메시지를 출력합니다.

    잔액 확인:
    사용자가 3을 선택하면 현재 잔액을 출력합니다.

    프로그램 종료:
    사용자가 4를 선택하면 반복문을 종료하고 프로그램을 종료합니다.

    입력 검증:
    잘못된 선택을 했을 경우 오류 메시지를 출력합니다.

    이 프로그램은 모든 로직을 main 메서드 내에 작성하여 단순한 구조를 유지하면서도 
    기본적인 은행 계좌 관리 기능을 제공합니다. 이를 통해 Scanner 클래스를 활용하여 
    사용자 입력을 처리하는 방법과 변수 및 연산자를 사용하는 방법을 익힐 수 있습니다.
  */
import java.util.Scanner;

public class SimpleBankAccount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 사용자 입력으로 계좌 개설
        System.out.println("계좌 소유자 이름을 입력하세요:");
        String owner = scanner.nextLine();
        System.out.println("초기 입금액을 입력하세요:");
        double balance = scanner.nextDouble();

        boolean exit = false;
        while (!exit) {
            // 메뉴 출력
            System.out.println("\n메뉴를 선택하세요: 1. 입금 2. 출금 3. 잔액 확인 4. 종료");
            int choice = scanner.nextInt();

            if (choice == 1) {
                // 입금 처리
                System.out.println("입금할 금액을 입력하세요:");
                double depositAmount = scanner.nextDouble();
                balance += depositAmount;
                System.out.println(depositAmount + "원이 입금되었습니다. 현재 잔액: " + balance + "원");
            } else if (choice == 2) {
                // 출금 처리
                System.out.println("출금할 금액을 입력하세요:");
                double withdrawAmount = scanner.nextDouble();
                if (withdrawAmount <= balance) {
                    balance -= withdrawAmount;
                    System.out.println(withdrawAmount + "원이 출금되었습니다. 현재 잔액: " + balance + "원");
                } else {
                    System.out.println("잔액이 부족합니다. 현재 잔액: " + balance + "원");
                }
            } else if (choice == 3) {
                // 잔액 확인
                System.out.println(owner + "님의 현재 잔액은 " + balance + "원입니다.");
            } else if (choice == 4) {
                // 종료
                exit = true;
                System.out.println("프로그램을 종료합니다.");
            } else {
                System.out.println("잘못된 선택입니다. 다시 입력해주세요.");
            }
        }

        scanner.close();
    }
}
