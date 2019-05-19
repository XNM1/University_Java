package ua.edu.chmnu.fks.oop.Lab07;

import ua.edu.chmnu.fks.oop.Lab07.Exceptions.*;

public class Rhombus implements IFigure {
    private double a, alpha;

    public Rhombus(double a, double alpha) throws FigureException {
        isExist(alpha);
        setA(a);
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

    private void isExist(double alpha) throws InvalidFigureException {
        if (alpha >= 180)
            throw new InvalidFigureException("invalid rhombus");
    }

    @Override
    public double area() {
        return a * a * Math.sin(alpha * (Math.PI / 180));
    }

    @Override
    public double perimeter() {
        return 4 * a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rhombus)) return false;

        Rhombus rhombus = (Rhombus) o;

        if (Double.compare(rhombus.getA(), getA()) != 0) return false;
        return Double.compare(rhombus.getAlpha(), getAlpha()) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getA());
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getAlpha());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Rhombus{" +
                "a=" + a +
                ", alpha=" + alpha +
                '}';
    }
}
