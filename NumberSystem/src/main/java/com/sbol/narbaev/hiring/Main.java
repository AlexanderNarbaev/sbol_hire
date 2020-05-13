package com.sbol.narbaev.hiring;

import com.sbol.narbaev.hiring.number.system.presenter.NumberSystemException;
import com.sbol.narbaev.hiring.number.system.transformer.LongNumericSystemTransformer;
import com.sbol.narbaev.hiring.number.system.transformer.NumberSystemTransformerException;
import com.sbol.narbaev.hiring.number.system.transformer.NumericSystemTransformer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.MessageFormat;

public class Main {

    public static final String ERROR_IN_PARSE_NUMERIC_SYSTEM = "Было введено некорректное число: {0}";
    public static final String ENTER_NUMBER_TO_TRANSFROM = "Введите число в десятичной системе счисления для перевода " +
            "в {0} систему счисления или \'STOP\' для выхода";
    public static final String TRANSFORMED_NUMBER_IS = "Число {0} в {1} системе счисления имеет вид: {2}";
    public static final String STOP_WORD = "STOP";
    public static final String ERROR_IN_PARSE_NUMBER_TO_TRANSFROM = "Было введено некорректное число: {0}";
    public static final String ERROR_IN_TRANSFORM = "Произошла ошибка при переводе в указанную систему счисления: {0}";
    private static final String IO_EXCEPTION = "Возникла непредвиденная ошибка операции ввода/вывода";
    private static final String WELLCOME_MESSAGE = "Добро пожаловать! Программа для перевода чисел из десятичной системы счисления" +
            " в другую от двоичной до тридцати-шестиричной";
    private static final String ENTER_NUMERIC_SYSTEM = "Для продолжения введите систему счисления в виде простого целого числа от 2 до 36:";
    private static final String ERROR_WRONG_NUMERIC_SYSTEM = "Число введено не из допустимого диапазона";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(WELLCOME_MESSAGE);
            int numericSystem = 0;
            while (true) {
                System.out.println(ENTER_NUMERIC_SYSTEM);
                try {
                    String readeLine = reader.readLine();
                    if (readeLine.matches("\\d+")) {
                        numericSystem = Integer.parseInt(readeLine);
                        if (numericSystem < 0 || numericSystem > 36) {
                            throw new NumberFormatException(ERROR_WRONG_NUMERIC_SYSTEM);
                        }
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println(MessageFormat.format(ERROR_IN_PARSE_NUMERIC_SYSTEM, e.getLocalizedMessage()));
                }
            }
            NumericSystemTransformer<Long> numericSystemTransformer = new LongNumericSystemTransformer();
            Long numberToTransform = null;
            while (true) {
                System.out.println(MessageFormat.format(ENTER_NUMBER_TO_TRANSFROM, numericSystem));
                try {
                    String readeLine = reader.readLine();
                    if (readeLine.matches("\\d+")) {
                        numberToTransform = Long.parseLong(readeLine);
                        System.out.println(MessageFormat.format(TRANSFORMED_NUMBER_IS,
                                numberToTransform, numericSystem, numericSystemTransformer.transformFromTenNumericSystem(numberToTransform, numericSystem)));
                    } else if (readeLine.equalsIgnoreCase(STOP_WORD)) {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println(MessageFormat.format(ERROR_IN_PARSE_NUMBER_TO_TRANSFROM, e.getLocalizedMessage()));
                } catch (NumberSystemTransformerException | NumberSystemException e) {
                    System.out.println(MessageFormat.format(ERROR_IN_TRANSFORM, e.getLocalizedMessage()));
                }
            }
        } catch (IOException e) {
            System.err.println(IO_EXCEPTION);
        }
    }
}
