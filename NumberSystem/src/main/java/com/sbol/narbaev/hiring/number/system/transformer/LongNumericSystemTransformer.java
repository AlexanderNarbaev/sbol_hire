package com.sbol.narbaev.hiring.number.system.transformer;

import com.sbol.narbaev.hiring.number.system.presenter.NumberSystemException;
import com.sbol.narbaev.hiring.number.system.presenter.NumberSystemPresenter;

public class LongNumericSystemTransformer implements NumericSystemTransformer<Long> {
    @Override
    public String transformFromTenNumericSystem(Long numberToTransform, int numericSystem) throws NumberSystemTransformerException, NumberSystemException {
        if (numberToTransform == null) {
            throw new NumberSystemTransformerException();
        }
        return new StringBuffer()
                .append(numberToTransform / numericSystem != 0
                        ? transformFromTenNumericSystem(numberToTransform / numericSystem, numericSystem)
                        : "")
                .append(
                        NumberSystemPresenter.
                                getNumberSystemPresentation(
                                        Math.toIntExact(
                                                numberToTransform % numericSystem)))
                .toString();
    }
}
