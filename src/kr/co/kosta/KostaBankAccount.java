package kr.co.kosta;

public class KostaBankAccount {

    public static void main(String[] args) {
        // 변수 선언 및 초기화
        String owner = "코스타";
        double initialBalance = 1000.0;
        double depositAmount = 500.0;
        double withdrawAmount = 200.0;
        boolean isAccountActive = true;

        // 변수 출력
        System.out.println("계좌 소유자: " + owner);
        System.out.println("초기 잔액: " + initialBalance + "원");
        System.out.println();

        // 입금 처리
        initialBalance = initialBalance + depositAmount; // 산술 연산자 사용
        System.out.println(depositAmount + "원이 입금되었습니다.");
        System.out.println("현재 잔액: " + initialBalance + "원");
        System.out.println();

        // 출금 처리
        initialBalance = initialBalance - withdrawAmount; // 산술 연산자 사용
        System.out.println(withdrawAmount + "원이 출금되었습니다.");
        System.out.println("현재 잔액: " + initialBalance + "원");
        System.out.println();

        // 비교 연산자 사용
        boolean isBalancePositive = initialBalance > 0;
        System.out.println("잔액이 0보다 큽니까? " + isBalancePositive);
        System.out.println();

        // 논리 연산자 사용
        boolean canWithdraw = isAccountActive && (initialBalance >= withdrawAmount);
        System.out.println("출금이 가능합니까? " + canWithdraw);
        System.out.println();

        // 변수의 값 변경 및 출력
        initialBalance = initialBalance - 100; // 추가 출금
        System.out.println("100원이 추가로 출금되었습니다.");
        System.out.println("최종 잔액: " + initialBalance + "원");
        System.out.println();

        // 잔액 음수 여부 확인
        boolean isBalanceNegative = initialBalance < 0;
        System.out.println("잔액이 0보다 작습니까? " + isBalanceNegative);
    }

}
