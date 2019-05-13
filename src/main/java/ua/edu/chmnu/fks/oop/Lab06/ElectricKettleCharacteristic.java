package ua.edu.chmnu.fks.oop.Lab06;

import ua.edu.chmnu.fks.oop.Lab06.Exceptions.*;

public class ElectricKettleCharacteristic extends ApplianceCharacteristic {
    private BodyMaterial bodyMaterial;
    private double volume;
    private boolean withIndicator;

    public ElectricKettleCharacteristic(EfficiencyClass energyClass, BodyMaterial bodyMaterial, double volume, boolean withIndicator) throws Exception {
        super(energyClass);
        this.bodyMaterial = bodyMaterial;
        setVolume(volume);
        this.withIndicator = withIndicator;
    }

    public ElectricKettleCharacteristic(EfficiencyClass energyClass, String[] features, BodyMaterial bodyMaterial, double volume, boolean withIndicator) throws Exception {
        super(energyClass, features);
        this.bodyMaterial = bodyMaterial;
        setVolume(volume);
        this.withIndicator = withIndicator;
    }

    public void setBodyMaterial(BodyMaterial bodyMaterial) {
        this.bodyMaterial = bodyMaterial;
    }

    public void setVolume(double volume) throws Exception {
        if (volume < 0)
            throw new NegativeValueException("negative volume of kettle");
        if (volume == 0)
            throw new ZeroValueException("zero volume of kettle");
        if (volume > 4)
            throw new BigValueInApplianceException("vary big volume of kettle");
        this.volume = volume;
    }

    public void setWithIndicator(boolean withIndicator) {
        this.withIndicator = withIndicator;
    }

    public BodyMaterial getBodyMaterial() {
        return bodyMaterial;
    }

    public double getVolume() {
        return volume;
    }

    public boolean isWithIndicator() {
        return withIndicator;
    }
}
