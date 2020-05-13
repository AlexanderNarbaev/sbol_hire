package com.sbol.narbaev.hiring.model;

import java.text.MessageFormat;

public class ArithmeticOperationException extends Exception {

    public static final String ERROR_WRONG_OPERATION_VALUE = "Недопустимое значение для операции вида: {}";

    public ArithmeticOperationException(String operationValue) {
        super(MessageFormat.format(ERROR_WRONG_OPERATION_VALUE, operationValue));
    }
}
