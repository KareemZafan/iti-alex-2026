package org.iti.app;

public class Calculator {

    public double add(double a, double b) {
        return a + b;
    }

    public double sub(double a, double b) {
        return a - b;
    }

    public double mul(double a, double b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        return a * b;
    }

    public double div(double a, double b) {
        if (b == 0) throw new ArithmeticException("Division by zero");

        return a / b;
    }

    public double pow(double a, double b) {
        if (a == 0 && b == 0) throw new ArithmeticException("Power by zero");
        return Math.pow(a, b);
    }

    public int mod(int a, int b) {
        return a % b;
    }

    public double getSquareRoot(double a) {
        if (a < 0) throw new IllegalArgumentException("Negative numbers are not allowed");
        return Math.sqrt(a);
    }

    public boolean isEven(int a) {
        return (a & 1) == 0;
    }

}
