package com.sbol.narbaev.hiring.number.system.transformer;

import java.text.MessageFormat;

public class NumberSystemTransformerException extends Exception {

    private final static String WRONG_NUMBER_MESSAGE = "Ошибка при при попытке перевода {0} из \"{1}\"системы счисления в \"{2}\"";
    private final static String TRANSFORMATION_MESSAGE = "Ошибка при попытке перевода из системы счисления";

    public NumberSystemTransformerException(Number numberToConvert, int numericSystemFrom, int numericSystemTo) {
        super(MessageFormat.format(WRONG_NUMBER_MESSAGE, numberToConvert, numericSystemTo, numericSystemFrom));
    }

    public NumberSystemTransformerException() {
        super(TRANSFORMATION_MESSAGE);
    }
}
