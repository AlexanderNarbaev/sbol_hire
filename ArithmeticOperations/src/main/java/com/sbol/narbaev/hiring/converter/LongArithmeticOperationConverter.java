package com.sbol.narbaev.hiring.converter;

import com.sbol.narbaev.hiring.model.ArithmeticOperation;
import com.sbol.narbaev.hiring.model.ArithmeticOperationException;
import com.sbol.narbaev.hiring.model.ArithmeticOperationModel;
import com.sbol.narbaev.hiring.model.LongArithmeticOperationModel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LongArithmeticOperationConverter implements ArithmeticOperationConverter<Long> {
    @Override
    public ArithmeticOperationModel<Long> convert(String inputSource) {
        LongArithmeticOperationModel longArithmeticOperationModel = new LongArithmeticOperationModel();
        String[] split = inputSource.split("(\\/|\\*|\\+|-)");
        if (split.length != 2) {
            longArithmeticOperationModel.setExceptionExplanation("Неверное количество аргументов");
        } else {
            try {
                longArithmeticOperationModel.setFirstArgument(Long.parseLong(split[0]));
            } catch (NumberFormatException e) {
                longArithmeticOperationModel.setExceptionExplanation("Ошибка при парсинге первого аргумента");
            }
            try {
                longArithmeticOperationModel.setSecondArgument(Long.parseLong(split[1]));
            } catch (NumberFormatException e) {
                longArithmeticOperationModel.setExceptionExplanation("Ошибка при парсинге второго аргумента");
            }
        }
        Pattern pattern = Pattern.compile("(\\/|\\*|\\+|-)");
        Matcher matcher = pattern.matcher(inputSource);
        if (matcher.find() && matcher.groupCount() == 1) {
            try {
                longArithmeticOperationModel.setOperation(ArithmeticOperation.fromValue(matcher.group(1)));
            } catch (ArithmeticOperationException e) {
                longArithmeticOperationModel.setExceptionExplanation("Неверное значение операции");
            }
        } else {
            longArithmeticOperationModel.setExceptionExplanation("Неверное значение операции");
        }
        return longArithmeticOperationModel;
    }
}
