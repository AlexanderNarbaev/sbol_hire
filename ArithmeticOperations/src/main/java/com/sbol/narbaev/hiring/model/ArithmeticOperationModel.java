package com.sbol.narbaev.hiring.model;

/**
 * Модель данных для арифметических операций
 *
 * @param <T> расширяемое от
 * @see Number
 */
public interface ArithmeticOperationModel<T extends Number> {

    /**
     * Установить первый аргумент операции
     *
     * @param argument значение
     */
    void setFirstArgument(T argument);

    /**
     * Установить второй аргумент операции
     *
     * @param argument значение
     */
    void setSecondArgument(T argument);

    /**
     * Установить операцию
     *
     * @param arithmeticOperation - тип операции
     * @see ArithmeticOperation
     */
    void setOperation(ArithmeticOperation arithmeticOperation);

    /**
     * Установить результат операции
     *
     * @param result значение
     * @see Number
     */
    void setOperationResult(Number result);

    /**
     * Установить значение ошибки для операции
     *
     * @param explanation значение
     */
    void setExceptionExplanation(String explanation);

    /**
     * Получить первый аргумент операции
     *
     * @return значение
     */
    T getFirstArgument();

    /**
     * Получить второй аргумент операции
     *
     * @return значение
     */
    T getSecondArgument();

    /**
     * Получить операцию
     *
     * @return тип операции
     * @see ArithmeticOperation
     */
    ArithmeticOperation getOperation();

    /**
     * Получить результат операции
     *
     * @return значение
     */
    Number getOperationResult();

    /**
     * Получить описание ошибки
     *
     * @return
     */
    String getExceptionExplanation();
}
