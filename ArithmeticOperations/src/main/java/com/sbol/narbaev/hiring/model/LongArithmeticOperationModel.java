package com.sbol.narbaev.hiring.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class LongArithmeticOperationModel implements ArithmeticOperationModel<Long> {

    private Long firstArgument;
    private Long secondArgument;
    private ArithmeticOperation arithmeticOperation;
    private Number operationResult;
    private String exceptionExplanation;


    @Override
    public void setFirstArgument(Long argument) {
        this.firstArgument = argument;
    }

    @Override
    public void setSecondArgument(Long argument) {
        this.secondArgument = argument;
    }

    @Override
    public void setOperation(ArithmeticOperation arithmeticOperation) {
        this.arithmeticOperation = arithmeticOperation;
    }

    @Override
    public void setOperationResult(Number result) {
        this.operationResult = result;
    }

    @Override
    public void setExceptionExplanation(String explanation) {
        this.exceptionExplanation = explanation;
    }

    @Override
    public Long getFirstArgument() {
        return firstArgument;
    }

    @Override
    public Long getSecondArgument() {
        return secondArgument;
    }

    @Override
    public ArithmeticOperation getOperation() {
        return arithmeticOperation;
    }

    @Override
    public Number getOperationResult() {
        return operationResult;
    }

    @Override
    public String getExceptionExplanation() {
        return exceptionExplanation;
    }
}
