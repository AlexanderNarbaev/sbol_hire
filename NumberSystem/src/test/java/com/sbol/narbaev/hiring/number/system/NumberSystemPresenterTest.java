package com.sbol.narbaev.hiring.number.system;

import com.sbol.narbaev.hiring.number.system.presenter.NumberSystemException;
import com.sbol.narbaev.hiring.number.system.presenter.NumberSystemPresenter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberSystemPresenterTest {

    @Test
    @DisplayName("Проверка презентера системы счисления")
    void getNumberSystemPresentation() throws NumberSystemException {
        Assertions.assertThrows(NumberSystemException.class,
                () -> NumberSystemPresenter.getNumberSystemPresentation(Integer.MIN_VALUE));
        Assertions.assertThrows(NumberSystemException.class,
                () -> NumberSystemPresenter.getNumberSystemPresentation(Integer.MAX_VALUE));
        Assertions.assertThrows(NumberSystemException.class,
                () -> NumberSystemPresenter.getNumberSystemPresentation(-1));
        Assertions.assertEquals("0", NumberSystemPresenter.getNumberSystemPresentation(0));
        Assertions.assertEquals("1", NumberSystemPresenter.getNumberSystemPresentation(1));
        Assertions.assertEquals("2", NumberSystemPresenter.getNumberSystemPresentation(2));
        Assertions.assertEquals("3", NumberSystemPresenter.getNumberSystemPresentation(3));
        Assertions.assertEquals("4", NumberSystemPresenter.getNumberSystemPresentation(4));
        Assertions.assertEquals("5", NumberSystemPresenter.getNumberSystemPresentation(5));
        Assertions.assertEquals("6", NumberSystemPresenter.getNumberSystemPresentation(6));
        Assertions.assertEquals("7", NumberSystemPresenter.getNumberSystemPresentation(7));
        Assertions.assertEquals("8", NumberSystemPresenter.getNumberSystemPresentation(8));
        Assertions.assertEquals("9", NumberSystemPresenter.getNumberSystemPresentation(9));
        Assertions.assertEquals("A", NumberSystemPresenter.getNumberSystemPresentation(10));
        Assertions.assertEquals("B", NumberSystemPresenter.getNumberSystemPresentation(11));
        Assertions.assertEquals("C", NumberSystemPresenter.getNumberSystemPresentation(12));
        Assertions.assertEquals("D", NumberSystemPresenter.getNumberSystemPresentation(13));
        Assertions.assertEquals("E", NumberSystemPresenter.getNumberSystemPresentation(14));
        Assertions.assertEquals("F", NumberSystemPresenter.getNumberSystemPresentation(15));
        Assertions.assertEquals("G", NumberSystemPresenter.getNumberSystemPresentation(16));
        Assertions.assertEquals("H", NumberSystemPresenter.getNumberSystemPresentation(17));
        Assertions.assertEquals("I", NumberSystemPresenter.getNumberSystemPresentation(18));
        Assertions.assertEquals("J", NumberSystemPresenter.getNumberSystemPresentation(19));
        Assertions.assertEquals("K", NumberSystemPresenter.getNumberSystemPresentation(20));
        Assertions.assertEquals("L", NumberSystemPresenter.getNumberSystemPresentation(21));
        Assertions.assertEquals("M", NumberSystemPresenter.getNumberSystemPresentation(22));
        Assertions.assertEquals("N", NumberSystemPresenter.getNumberSystemPresentation(23));
        Assertions.assertEquals("O", NumberSystemPresenter.getNumberSystemPresentation(24));
        Assertions.assertEquals("P", NumberSystemPresenter.getNumberSystemPresentation(25));
        Assertions.assertEquals("Q", NumberSystemPresenter.getNumberSystemPresentation(26));
        Assertions.assertEquals("R", NumberSystemPresenter.getNumberSystemPresentation(27));
        Assertions.assertEquals("S", NumberSystemPresenter.getNumberSystemPresentation(28));
        Assertions.assertEquals("T", NumberSystemPresenter.getNumberSystemPresentation(29));
        Assertions.assertEquals("U", NumberSystemPresenter.getNumberSystemPresentation(30));
        Assertions.assertEquals("V", NumberSystemPresenter.getNumberSystemPresentation(31));
        Assertions.assertEquals("W", NumberSystemPresenter.getNumberSystemPresentation(32));
        Assertions.assertEquals("X", NumberSystemPresenter.getNumberSystemPresentation(33));
        Assertions.assertEquals("Y", NumberSystemPresenter.getNumberSystemPresentation(34));
        Assertions.assertEquals("Z", NumberSystemPresenter.getNumberSystemPresentation(35));
        Assertions.assertThrows(NumberSystemException.class,
                () -> NumberSystemPresenter.getNumberSystemPresentation(36));
    }
}