package subway.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String showMainSelectUIAndGetUserInput() {
        System.out.println("## 원하는 기능을 선택하세요.");
        try {
            String userInput = scanner.nextLine();
            isInputFitToMainDisplay(userInput);
            return userInput;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return showMainSelectUIAndGetUserInput();
        }
    }

    private static void isInputFitToMainDisplay(String userInput) {
        if (!userInput.equals("1") && !userInput.equals("Q")) {
            throw new IllegalArgumentException("올바른 문자를 입력해주세요.");
        }
    }

    public static String showSecondDisplayUIAndGetUserInput() {
        System.out.println("## 원하는 기능을 선택하세요.");
        try {
            String userInput = scanner.nextLine();
            isInputFitToSecondDisplay(userInput);
            return userInput;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return showSecondDisplayUIAndGetUserInput();
        }
    }

    private static void isInputFitToSecondDisplay(String userInput) {
        if (!userInput.equals("1") && !userInput.equals("2") && !userInput.equals("B")) {
            throw new IllegalArgumentException("올바른 문자를 입력해주세요.");
        }
    }

    public static String showDepartureEnteringUIAndGetInput() {
        System.out.println("## 출발역을 입력하세요.");
        String userInput = scanner.nextLine();
        return userInput;
    }

    public static String showArrivalEnteringUIAndGetInput() {
        System.out.println("## 도착역을 입력하세요.");
        String userInput = scanner.nextLine();
        return userInput;
    }
}
