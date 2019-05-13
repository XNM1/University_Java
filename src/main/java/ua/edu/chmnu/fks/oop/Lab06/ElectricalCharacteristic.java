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
}
