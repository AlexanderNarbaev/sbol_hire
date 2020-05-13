package com.sbol.narbaev.hiring.writer;

import com.sbol.narbaev.hiring.model.ArithmeticOperationModel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

public class LongArithmeticOperationsWriterImpl implements ArithmeticOperationsWriter<Long> {
    @Override
    public void writeFile(File file, Collection<ArithmeticOperationModel<Long>> operationModels) throws ArithmeticOperationsWriterException {
        if (file == null || !file.isFile() || !file.exists() || !file.canRead()) {
            throw new ArithmeticOperationsWriterException();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            for (ArithmeticOperationModel<Long> arithmeticOperationModel : operationModels) {
                writer.write(arithmeticOperationModel.getOperationResult() != null
                        ? arithmeticOperationModel.getOperationResult().toString()
                        : (arithmeticOperationModel.getExceptionExplanation() != null
                        ? arithmeticOperationModel.getExceptionExplanation()
                        : ""));
                writer.write("\n");
            }
        } catch (IOException e) {
            throw new ArithmeticOperationsWriterException();
        }
    }
}
