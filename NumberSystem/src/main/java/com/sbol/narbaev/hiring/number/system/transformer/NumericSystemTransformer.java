package com.sbol.narbaev.hiring.number.system.transformer;

import com.sbol.narbaev.hiring.number.system.presenter.NumberSystemException;

public interface NumericSystemTransformer<T> {

    String transformFromTenNumericSystem(T numberToTransform, int numericSystem) throws NumberSystemTransformerException, NumberSystemException;
}
