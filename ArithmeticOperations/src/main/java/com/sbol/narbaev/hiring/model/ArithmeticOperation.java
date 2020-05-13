package com.sbol.narbaev.hiring.model;

import lombok.Getter;

@Getter
public enum ArithmeticOperation {
    DIVIDE("/"),
    MULTIPLY("*"),
    SUBTRACT("-"),
    ADD("+");

    private String value;

    ArithmeticOperation(String value) {
        this.value = value;
    }

    public static ArithmeticOperation fromValue(String value) throws ArithmeticOperationException {
        switch (value) {
            case "+":
                return ADD;
            case "-":
                return SUBTRACT;
            case "*":
                return MULTIPLY;
            case "/":
                return DIVIDE;
            default:
                throw new ArithmeticOperationException(value);
        }
    }
}
