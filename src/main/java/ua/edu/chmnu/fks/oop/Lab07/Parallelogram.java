package ua.edu.chmnu.fks.oop.Lab07;

import ua.edu.chmnu.fks.oop.Lab07.Exceptions.*;

public class Parallelogram implements IFigure {
    private double a, b, alpha;

    public Parallelogram(double a, double b, double alpha) throws FigureException {
        isExist(alpha);
        setA(a);
        setB(b);
        setAlpha(alpha);
    }

    public double getAlpha() {
        return alpha;
    }

    public void setAlpha(double alpha) throws FigureException {
        isExist(alpha);
        if (alpha < 0)
            throw new NegativeValueException("alpha is negative");
        if (alpha == 0)
            throw new ZeroValueException("alpha is zero");
        this.alpha = alpha;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) throws InvalidValueException {
        if (a < 0)
            throw new NegativeValueException("a is negative");
        if (a == 0)
            throw new ZeroValueException("a is zero");
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) throws InvalidValueException {
        if (b < 0)
            throw new NegativeValueException("b is negative");
        if (b == 0)
            throw new ZeroValueException("b is zero");
        this.b = b;
    }

    private void isExist(double alpha) throws InvalidFigureException {
        if (alpha >= 180)
            throw new InvalidFigureException("invalid parallelogram");
    }

    @Override
    public double area() {
        return a * b * Math.sin(alpha * (Math.PI / 180));
    }

    @Override
    public double perimeter() {
        return 2 * (a + b);
    }
}
