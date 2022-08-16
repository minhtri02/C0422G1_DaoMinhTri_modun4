package com.example.service.impl;

import com.example.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {

    @Override
    public String calculator(double num1, double num2, String operator) {
        String result;
        switch (operator) {
            case "+":
                result = num1 + num2 + "";
                break;
            case "-":
                result = num1 - num2 + "";
                break;
            case "x":
                result = num1 * num2 + "";
                break;
            case "/":
                if (num2 == 0) {
                    result = "cannot be divided by 0";
                }else {
                    result = num1 / num2 + "";
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }
        return result;
    }
}
