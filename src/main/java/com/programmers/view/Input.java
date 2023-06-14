package com.programmers.view;

import com.programmers.error.CalculatorException;
import com.programmers.util.Validator;

import java.util.Scanner;

/**
 * 입력
 */

public class Input {
    private static final String NOTMENUMESSAGE = "없는 메뉴 입니다. 메뉴를 다시 입력해주세요\n선택 : ";
    private static final String NOTVALIDARITHMETICEXPRESSION = "계산식이 옳지 않습니다. 식을 다시 입력해주세요\n";

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMenu() {
        int menuNum = 0;
        boolean inputSuccessful = false;

        while(!inputSuccessful){
            try {
                String menuString = removeWhiteSpace(scanner.nextLine());
                menuNum = Validator.validateMenu(menuString);

                inputSuccessful = true;
            } catch (CalculatorException e) {
                System.out.println("다시 입력하세요.");
            }
        }

        System.out.println(); //공백

        return menuNum;
    }

    public static String inputExpression() {
        String expression = scanner.nextLine();

        //공백 제거
        expression = removeWhiteSpace(expression);

        //사칙연산(+,-,*,/)과 숫자만으로 구성되어 있는지 확인
        if (!Validator.checkValidArithmeticExpression(expression)) {
            System.out.print(NOTVALIDARITHMETICEXPRESSION);
            inputExpression(); //반복
        }

        return expression;
    }


    //공백 제거
    public static String removeWhiteSpace(String input) {
        return input.replaceAll("\\s+", "");
    }
}
