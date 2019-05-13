package ua.edu.chmnu.fks.oop.Lab06;

import ua.edu.chmnu.fks.oop.Lab06.Exceptions.*;

public class Size {
    private double height;
    private double width;
    private double length;
    private Unit unit;

    public Size(double length, double width, double height, Unit unit) throws InvalidValueException {
        setLength(length);
        setWidth(width);
        setHeight(height);
        this.unit = unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public void setHeight(double height) throws InvalidValueException {
        if (height < 0)
            throw new NegativeValueException("negative height");
        if (height == 0)
            throw new ZeroValueException("zero height");
        this.height = height;
    }

    public void setWidth(double width) throws InvalidValueException {
        if (width < 0)
            throw new NegativeValueException("negative width");
        if (width == 0)
            throw new ZeroValueException("zero width");
        this.width = width;
    }

    public void setLength(double length) throws InvalidValueException {
        if (length < 0)
            throw new NegativeValueException("negative length");
        if (length == 0)
            throw new ZeroValueException("zero length");
        this.length = length;
    }

    public double getVolume() {
        return length * width * height;
    }

    public Unit getUnit() {
        return unit;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }
}
