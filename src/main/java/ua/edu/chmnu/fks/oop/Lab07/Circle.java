package ua.edu.chmnu.fks.oop.Lab07;

import ua.edu.chmnu.fks.oop.Lab07.Exceptions.*;

public class Circle implements IFigure {
    private double r;

    public Circle(double r) throws InvalidValueException {
        setRadius(r);
    }

    public double getRadius() {
        return r;
    }

    public void setRadius(double r) throws InvalidValueException {
        if (r < 0)
            throw new NegativeValueException("radius is negative");
        if (r == 0)
            throw new ZeroValueException("radius is zero");
        this.r = r;
    }

    @Override
    public double area() {
        return Math.PI * r * r;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * r;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;

        Circle circle = (Circle) o;

        return Double.compare(circle.r, r) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(r);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + r +
                '}';
    }
}
