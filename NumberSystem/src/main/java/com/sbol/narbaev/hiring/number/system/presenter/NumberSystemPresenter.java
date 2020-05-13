package com.sbol.narbaev.hiring.number.system.presenter;

public class NumberSystemPresenter {
    private static final String[] NUMERIC_SYSTEM_CODES = new String[]{
            "0",
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "A",
            "B",
            "C",
            "D",
            "E",
            "F",
            "G",
            "H",
            "I",
            "J",
            "K",
            "L",
            "M",
            "N",
            "O",
            "P",
            "Q",
            "R",
            "S",
            "T",
            "U",
            "V",
            "W",
            "X",
            "Y",
            "Z"
    };

    public static String getNumberSystemPresentation(int numberToPresent) throws NumberSystemException {
        if (numberToPresent < 0 || numberToPresent >= 36) {
            throw new NumberSystemException(numberToPresent);
        }
        return NUMERIC_SYSTEM_CODES[numberToPresent];
    }
}
