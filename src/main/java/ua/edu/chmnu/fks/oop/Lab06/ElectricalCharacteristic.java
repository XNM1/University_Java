package ua.edu.chmnu.fks.oop.Lab06;

import ua.edu.chmnu.fks.oop.Lab06.Exceptions.*;

public class ElectricalCharacteristic {
    private double voltage;
    private double power;

    public ElectricalCharacteristic(double voltage, double power) throws InvalidValueException {
        setVoltage(voltage);
        setPower(power);
    }

    public void setVoltage(double voltage) throws InvalidValueException {
        if (voltage < 0)
            throw new NegativeValueException("negative voltage");
        if (voltage == 0)
            throw new ZeroValueException("zero voltage");
        this.voltage = voltage;
    }

    public void setPower(double power) throws InvalidValueException {
        if (power < 0)
            throw new NegativeValueException("negative power");
        if (power == 0)
            throw new ZeroValueException("zero power");
        this.power = power;
    }

    public double getVoltage() {
        return voltage;
    }

    public double getPower() {
        return power;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ElectricalCharacteristic)) return false;

        ElectricalCharacteristic that = (ElectricalCharacteristic) o;

        if (Double.compare(that.getVoltage(), getVoltage()) != 0) return false;
        return Double.compare(that.getPower(), getPower()) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getVoltage());
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getPower());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "ElectricalCharacteristic{" +
                "voltage=" + voltage +
                ", power=" + power +
                '}';
    }
}
