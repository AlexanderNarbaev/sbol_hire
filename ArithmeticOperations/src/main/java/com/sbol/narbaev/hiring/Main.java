package com.sbol.narbaev.hiring;

import com.sbol.narbaev.hiring.performer.LongArithmeticOperationPerformer;
import com.sbol.narbaev.hiring.reader.ArithmeticOperationsReaderException;
import com.sbol.narbaev.hiring.reader.LongArithmeticOperationsReaderImpl;
import com.sbol.narbaev.hiring.writer.ArithmeticOperationsWriterException;
import com.sbol.narbaev.hiring.writer.LongArithmeticOperationsWriterImpl;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File input = new File("input.txt");
        File output = new File("output.txt");
        try {
            new LongArithmeticOperationsWriterImpl().writeFile(output,
                    new LongArithmeticOperationPerformer().performOperations(
                            new LongArithmeticOperationsReaderImpl().readFile(input)));
        } catch (ArithmeticOperationsWriterException | ArithmeticOperationsReaderException e) {
            System.out.println("Произошла ошибка чтения/записи");
        }
    }
}
