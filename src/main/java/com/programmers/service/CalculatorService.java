package com.programmers.service;

import com.programmers.dto.CalculatorDto;
import com.programmers.repository.CalculatorRepository;
import com.programmers.util.CalculatorHelper;
import com.programmers.util.Converter;

import java.util.List;


public class CalculatorService {
    private final CalculatorRepository calculatorRepository;

    public CalculatorService(CalculatorRepository calculatorRepository) {
        this.calculatorRepository = calculatorRepository;
    }

    //계산 수행 후 저장
    public int calculate(String expression) {
        //계산
        String postfixExpression = Converter.convertToPostFix(expression);
        int result = CalculatorHelper.calculateExpression(postfixExpression);

        //저장
        calculatorRepository.save(new CalculatorDto(expression, result));
        return result;
    }

    //history 조회
    public List<CalculatorDto> getHistories() {
        return calculatorRepository.findAll();
    }


}
