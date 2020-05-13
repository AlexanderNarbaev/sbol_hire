package com.sbol.narbaev.hiring.performer;

import com.sbol.narbaev.hiring.model.ArithmeticOperationModel;

import java.util.Collection;

public class LongArithmeticOperationPerformer implements ArithmeticOperationPerformer<Long> {
    @Override
    public Collection<ArithmeticOperationModel<Long>> performOperations(Collection<ArithmeticOperationModel<Long>> arithmeticOperationModels) {
        arithmeticOperationModels
                .forEach(arithmeticOperationModel -> performOperation(arithmeticOperationModel));
        return arithmeticOperationModels;
    }

    private ArithmeticOperationModel<Long> performOperation(ArithmeticOperationModel<Long> arithmeticOperationModel) {
        if (arithmeticOperationModel.getExceptionExplanation() != null
                && !arithmeticOperationModel.getExceptionExplanation()
                .trim()
                .replaceAll(" ", "")
                .equalsIgnoreCase("")) {
            return arithmeticOperationModel;
        }
        if (arithmeticOperationModel.getOperation() != null) {
            switch (arithmeticOperationModel.getOperation()) {
                case DIVIDE:
                    if (arithmeticOperationModel.getSecondArgument() != null
                            && arithmeticOperationModel.getSecondArgument().compareTo(0L) == 0) {
                        arithmeticOperationModel.setExceptionExplanation("Делить на ноль нельзя");
                    }
                    try {
                        arithmeticOperationModel.setOperationResult(
                                arithmeticOperationModel.getFirstArgument() / arithmeticOperationModel.getSecondArgument());
                    } catch (Exception e) {
                        arithmeticOperationModel.setExceptionExplanation("Ошибка операции деления");
                    }
                    break;
                case MULTIPLY:
                    try {
                        arithmeticOperationModel.setOperationResult(
                                arithmeticOperationModel.getFirstArgument() * arithmeticOperationModel.getSecondArgument());
                    } catch (Exception e) {
                        arithmeticOperationModel.setExceptionExplanation("Ошибка операции умножения");
                    }
                    break;
                case SUBTRACT:
                    try {
                        arithmeticOperationModel.setOperationResult(
                                arithmeticOperationModel.getFirstArgument() - arithmeticOperationModel.getSecondArgument());
                    } catch (Exception e) {
                        arithmeticOperationModel.setExceptionExplanation("Ошибка операции вычитания");
                    }
                    break;
                case ADD:
                    try {
                        arithmeticOperationModel.setOperationResult(
                                arithmeticOperationModel.getFirstArgument() + arithmeticOperationModel.getSecondArgument());
                    } catch (Exception e) {
                        arithmeticOperationModel.setExceptionExplanation("Ошибка операции сложения");
                    }
                    break;
            }
        }
        return arithmeticOperationModel;
    }
}
