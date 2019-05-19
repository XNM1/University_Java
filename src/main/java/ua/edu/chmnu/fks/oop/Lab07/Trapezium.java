package ua.edu.chmnu.fks.oop.Lab07;

import ua.edu.chmnu.fks.oop.Lab07.Exceptions.*;

public class Trapezium implements IFigure {
    private double a, b, c, d;

    public Trapezium(double a, double b, double c, double d) throws FigureException {
        isExist(a, b, c, d);
        setA(a);
        setB(b);
        setC(c);
        setD(d);
    }

    public double getA() {
        return a;
    }

    public void setA(double a) throws FigureException {
        isExist(a, b, c, d);
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
        isExist(a, b, c, d);
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
        isExist(a, b, c, d);
        if (c < 0)
            throw new NegativeValueException("c is negative");
        if (c == 0)
            throw new ZeroValueException("c is zero");
        this.c = c;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) throws FigureException {
        isExist(a, b, c, d);
        if (d < 0)
            throw new NegativeValueException("d is negative");
        if (d == 0)
            throw new ZeroValueException("d is zero");
        this.d = d;
    }

    private void isExist(double a, double b, double c, double d) throws InvalidFigureException {
        if(a <= 0 || b <= 0 || c <= 0 || d <= 0)
            return;
        double sumd = a + b + c;
        double sumc = a + b + d;
        double sumb = a + c + d;
        double suma = b + c + d;

        if(a >= suma)
            throw new InvalidFigureException("a is bigger than other sides (invalid trapezium)");
        if(b >= sumb)
            throw new InvalidFigureException("b is bigger than other sides (invalid trapezium)");
        if(c >= sumc)
            throw new InvalidFigureException("c is bigger than other sides (invalid trapezium)");
        if(d >= sumd)
            throw new InvalidFigureException("d is bigger than other sides (invalid trapezium)");
    }

    @Override
    public double area() {
        double p = perimeter() / 2;
        return ((b + d)/2) * Math.sqrt(a * a - Math.pow((Math.pow(d - b, 2) + a * a - c * c)/(2. * (b - d)), 2));
    }

    @Override
    public double perimeter() {
        return a + b + c + d;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trapezium)) return false;

        Trapezium trapezium = (Trapezium) o;

        if (Double.compare(trapezium.getA(), getA()) != 0) return false;
        if (Double.compare(trapezium.getB(), getB()) != 0) return false;
        if (Double.compare(trapezium.getC(), getC()) != 0) return false;
        return Double.compare(trapezium.getD(), getD()) == 0;
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
        temp = Double.doubleToLongBits(getD());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Trapezium{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                '}';
    }
}
