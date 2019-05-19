package ua.edu.chmnu.fks.oop.Lab07;

import ua.edu.chmnu.fks.oop.Lab07.Exceptions.*;

public class Square implements IFigure {
    private double a;

    public Square(double a) throws InvalidValueException {
        setA(a);
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

    @Override
    public double area() {
        return a * a;
    }

    @Override
    public double perimeter() {
        return 4 * a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Square)) return false;

        Square square = (Square) o;

        return Double.compare(square.getA(), getA()) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(getA());
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public String toString() {
        return "Square{" +
                "a=" + a +
                '}';
    }
}
