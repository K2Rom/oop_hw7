package model;

import java.text.DecimalFormat;

public class ComplexNumber {

    private double xPart = 0.0;
    private double yPart = 0.0;

    public ComplexNumber() {
        this.xPart = 0.0;
        this.yPart = 0.0;
    }

    public ComplexNumber(double xPart) {
        this.xPart = xPart;
        this.yPart = 0.0;
    }

    public ComplexNumber(double xPart, double yPart) {
        this.xPart = xPart;
        this.yPart = yPart;
    }

    public double getXPart() {
        return xPart;
    }

    public double getYPart() {
        return yPart;
    }

    public ComplexNumber getCurrentNumber() {
        return new ComplexNumber(xPart, yPart);
    }

    DecimalFormat dF = new DecimalFormat( "#.#####" );

    @Override
    public String toString() {
        if (this.yPart < 0) {
            return " (" + dF.format(this.xPart) + " - j" + dF.format(-this.yPart) + ")";
        } else {
            return " (" + dF.format(this.xPart) + " + j" + dF.format(this.yPart) + ")";
        }
    }

}
