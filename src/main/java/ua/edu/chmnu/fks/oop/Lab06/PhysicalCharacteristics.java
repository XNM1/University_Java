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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhysicalCharacteristics)) return false;

        PhysicalCharacteristics that = (PhysicalCharacteristics) o;

        if (Double.compare(that.getWeight(), getWeight()) != 0) return false;
        if (!getColor().equals(that.getColor())) return false;
        return getSize().equals(that.getSize());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getColor().hashCode();
        temp = Double.doubleToLongBits(getWeight());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getSize().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PhysicalCharacteristics{" +
                "color=" + color +
                ", weight=" + weight +
                ", size=" + size +
                '}';
    }
}
