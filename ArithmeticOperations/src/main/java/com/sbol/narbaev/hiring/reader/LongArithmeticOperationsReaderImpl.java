package com.sbol.narbaev.hiring.reader;

import com.sbol.narbaev.hiring.converter.ArithmeticOperationConverter;
import com.sbol.narbaev.hiring.converter.LongArithmeticOperationConverter;
import com.sbol.narbaev.hiring.model.ArithmeticOperationModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class LongArithmeticOperationsReaderImpl implements ArithmeticOperationsReader<Long> {
    @Override
    public Collection<ArithmeticOperationModel<Long>> readFile(File file) throws ArithmeticOperationsReaderException {
        if (file == null || !file.isFile() || !file.exists() || !file.canRead()) {
            throw new ArithmeticOperationsReaderException();
        }
        ArithmeticOperationConverter<Long> converter = new LongArithmeticOperationConverter();
        Collection<ArithmeticOperationModel<Long>> returnResult = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                returnResult.add(converter.convert(line));
            }
        } catch (IOException e) {
            throw new ArithmeticOperationsReaderException();
        }
        return returnResult;
    }
}
