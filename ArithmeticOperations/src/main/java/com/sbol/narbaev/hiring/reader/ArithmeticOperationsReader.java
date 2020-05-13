package com.sbol.narbaev.hiring.reader;

import com.sbol.narbaev.hiring.model.ArithmeticOperationModel;

import java.io.File;
import java.util.Collection;

/**
 * Вычитыватель из файла арифметических операция
 */
public interface ArithmeticOperationsReader<T extends Number> {
    /**
     * Вычитать из файла
     *
     * @param file ссылка на файл
     * @return коллекция арифметических операций
     */
    Collection<ArithmeticOperationModel<T>> readFile(File file) throws ArithmeticOperationsReaderException;
}
