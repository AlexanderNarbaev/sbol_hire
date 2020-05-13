package com.sbol.narbaev.hiring.number.system.presenter;

import java.text.MessageFormat;

public class NumberSystemException extends Exception {
    private final static String PRESENT_EXCEPTION_MESSAGE = "Ошибка при попытке интерпритировать значение в систему счисления для числа {0}";

    public NumberSystemException(int numberToPresent) {
        super(MessageFormat.format(PRESENT_EXCEPTION_MESSAGE, numberToPresent));
    }
}
