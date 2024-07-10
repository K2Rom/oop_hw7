package calculator;

import logger.ComplexCalcLogger;
import model.ComplexNumber;

public class ComplexCalculator {

    private final ComplexCalcLogger logger = new ComplexCalcLogger();

    public ComplexNumber add(ComplexNumber a, ComplexNumber b) {
        ComplexNumber res = new ComplexNumber(a.getXPart() + b.getXPart(), a.getYPart() + b.getYPart());
        logger.log("Сумма " + a + " и " + b);
        logger.log("Результат " + res);
        return res;
    }

    public ComplexNumber mul(ComplexNumber a, ComplexNumber b) {
        double multX = a.getXPart() * b.getXPart() - a.getYPart() * b.getYPart();
        double multY = a.getXPart() * b.getYPart() + a.getYPart() * b.getXPart();
        ComplexNumber res = new ComplexNumber(multX, multY);
        logger.log("Умножение " + a + " и " + b);
        logger.log("Результат " + res);
        return res;
    }

    public ComplexNumber div(ComplexNumber a, ComplexNumber b) {
        double divider = b.getXPart() * b.getXPart() + b.getYPart() * b.getYPart();
        logger.log("Деление " + a + " на " + b);
        if (divider == 0) {
            logger.log("Попытка деления на ноль!");
            return null;
        }
        double divX = (a.getXPart() * b.getXPart() + a.getYPart() * b.getYPart()) / divider;
        double divY = (a.getYPart() * b.getXPart() - a.getXPart() * b.getYPart()) / divider;
        ComplexNumber res = new ComplexNumber(divX, divY);
        logger.log("Результат " + res);
        return res;
    }

    public ComplexNumber sub(ComplexNumber a, ComplexNumber b) {
        ComplexNumber res = new ComplexNumber(a.getXPart() - b.getXPart(), a.getYPart() - b.getYPart());
        logger.log("Вычитание " + b + " из " + a);
        logger.log("Результат " + res);
        return res;
    }
}
