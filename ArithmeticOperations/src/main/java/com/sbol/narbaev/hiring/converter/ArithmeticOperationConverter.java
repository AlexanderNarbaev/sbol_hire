package com.sbol.narbaev.hiring.converter;

import com.sbol.narbaev.hiring.model.ArithmeticOperationModel;

/**
 * Преобразуем строки в операции
 */
public interface ArithmeticOperationConverter<T extends Number> {

    /**
     * Получить арифметическую операцию
     *
     * @param inputSource источник информации в виде строки
     * @return операция
     * @see ArithmeticOperationModel
     */
    ArithmeticOperationModel<T> convert(String inputSource);
}
