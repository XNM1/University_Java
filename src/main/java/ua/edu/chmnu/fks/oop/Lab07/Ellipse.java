package ua.edu.chmnu.fks.oop.Lab07;

import ua.edu.chmnu.fks.oop.Lab07.Exceptions.*;

public class Ellipse implements IFigure {
    private double a, b;

    public Ellipse(double a, double b) throws InvalidValueException {
        setA(a);
        setB(b);
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

    @Override
    public double area() {
        return Math.PI * a * b;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * Math.sqrt((a * a + b * b)/2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ellipse)) return false;

        Ellipse ellipse = (Ellipse) o;

        if (Double.compare(ellipse.getA(), getA()) != 0) return false;
        return Double.compare(ellipse.getB(), getB()) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getA());
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getB());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Ellipse{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
