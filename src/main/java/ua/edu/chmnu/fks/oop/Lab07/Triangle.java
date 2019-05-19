package ua.edu.chmnu.fks.oop.Lab07;


import ua.edu.chmnu.fks.oop.Lab07.Exceptions.*;

public class Triangle implements IFigure {
    private double a, b, c;

    public Triangle(double a, double b, double c) throws FigureException {
        isExist(a, b, c);
        setA(a);
        setB(b);
        setC(c);
    }

    public double getA() {
        return a;
    }

    public void setA(double a) throws FigureException {
        isExist(a, b, c);
        if (a < 0)
            throw new NegativeValueException("a is negative");
        if (a == 0)
            throw new ZeroValueException("a is zero");
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) throws FigureException {
        isExist(a, b, c);
        if (b < 0)
            throw new NegativeValueException("b is negative");
        if (b == 0)
            throw new ZeroValueException("b is zero");
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) throws FigureException {
        isExist(a, b, c);
        if (c < 0)
            throw new NegativeValueException("c is negative");
        if (c == 0)
            throw new ZeroValueException("c is zero");
        this.c = c;
    }

    private void isExist(double a, double b, double c) throws InvalidFigureException {
        if(a <= 0 || b <= 0 || c <= 0)
            return;
        double sumc = a + b ;
        double sumb = a + c;
        double suma = b + c;

        if(a >= suma)
            throw new InvalidFigureException("a is bigger than other sides (invalid triangle)");
        if(b >= sumb)
            throw new InvalidFigureException("b is bigger than other sides (invalid triangle)");
        if(c >= sumc)
            throw new InvalidFigureException("c is bigger than other sides (invalid triangle)");
    }

    @Override
    public double area() {
        double p = perimeter() / 2;
        return Math.sqrt(p*(p - a)*(p - b)*(p - c));
    }

    @Override
    public double perimeter() {
        return a + b + c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;

        Triangle triangle = (Triangle) o;

        if (Double.compare(triangle.getA(), getA()) != 0) return false;
        if (Double.compare(triangle.getB(), getB()) != 0) return false;
        return Double.compare(triangle.getC(), getC()) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getA());
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getB());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getC());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
