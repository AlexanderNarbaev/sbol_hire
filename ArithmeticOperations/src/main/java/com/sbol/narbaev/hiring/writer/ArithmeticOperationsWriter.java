package com.sbol.narbaev.hiring.writer;

import com.sbol.narbaev.hiring.model.ArithmeticOperationModel;

import java.io.File;
import java.util.Collection;

/**
 * Записыватель в файл арифметических операций
 */
public interface ArithmeticOperationsWriter <T extends Number>{
    /**
     * Записать в файл
     *  @param file ссылка на файл
     * @param operationModels коллекция арифметических операций
     */
     void writeFile(File file, Collection<ArithmeticOperationModel<T>> operationModels) throws ArithmeticOperationsWriterException;
}
