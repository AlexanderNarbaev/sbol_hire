package com.sbol.narbaev.hiring.performer;

import com.sbol.narbaev.hiring.model.ArithmeticOperationModel;

import java.util.Collection;

/**
 * Производитель действия над операцией
 */
public interface ArithmeticOperationPerformer<T extends Number> {
    /**
     * Произвести действие над списком операцией
     *
     * @param arithmeticOperationModels список операций
     * @return список после действий над операциями
     */
    Collection<ArithmeticOperationModel<T>> performOperations(Collection<ArithmeticOperationModel<T>> arithmeticOperationModels);
}
