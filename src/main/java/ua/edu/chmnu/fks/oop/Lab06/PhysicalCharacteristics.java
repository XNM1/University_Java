package ua.edu.chmnu.fks.oop.Lab06;

import ua.edu.chmnu.fks.oop.Lab06.Exceptions.*;

import java.awt.*;

public class PhysicalCharacteristics {
    private Color color;
    private double weight;
    private Size size;

    public PhysicalCharacteristics(Color color, double weight, Size size) throws InvalidValueException {
        this.color = color;
        setWeight(weight);
        setSize(size);
    }

    public PhysicalCharacteristics(Color color, double weight, double length, double width, double height, Unit unit) throws InvalidValueException {
        this.color = color;
        setWeight(weight);
        setSize(length, width, height, unit);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setWeight(double weight) throws InvalidValueException {
        if (weight < 0)
            throw new NegativeValueException("negative weight");
        if (weight == 0)
            throw new ZeroValueException("zero weight");
        this.weight = weight;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void setSize(double length, double width, double height, Unit unit) throws InvalidValueException {
        this.size = new Size(length, width, height, unit);
    }

    public Color getColor() {
        return color;
    }

    public double getWeight() {
        return weight;
    }

    public Size getSize() {
        return size;
    }
}
