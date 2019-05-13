package ua.edu.chmnu.fks.oop.Lab06;

import ua.edu.chmnu.fks.oop.Lab06.Exceptions.*;

import java.awt.*;

public class ElectricalAppliance {
    private String name;
    private PhysicalCharacteristics physicalCharacteristics;
    private ElectricalCharacteristic electricalCharacteristic;
    private ApplianceCharacteristic applianceCharacteristic;
    private SizeType sizeType;
    private ApplianceType applianceType;

    public ElectricalAppliance(String name, PhysicalCharacteristics physicalCharacteristics, ElectricalCharacteristic electricalCharacteristic, ApplianceCharacteristic applianceCharacteristic) throws Exception {
        this.name = name;
        setPhysicalCharacteristics(physicalCharacteristics);
        setElectricalCharacteristic(electricalCharacteristic);
        setApplianceCharacteristic(applianceCharacteristic);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhysicalCharacteristics(PhysicalCharacteristics physicalCharacteristics) throws Exception {
        if (physicalCharacteristics.getSize().getUnit() == Unit.M && (physicalCharacteristics.getSize().getHeight() >= 10 || physicalCharacteristics.getSize().getWidth() >= 10 || physicalCharacteristics.getSize().getLength() >= 10))
            throw new BigValueInApplianceException("very big size of appliance");
        if (physicalCharacteristics.getWeight() > 1000)
            throw new BigValueInApplianceException("very big weight of appliance");
        this.physicalCharacteristics = physicalCharacteristics;
        setSizeType();
    }

    public void setElectricalCharacteristic(@org.jetbrains.annotations.NotNull ElectricalCharacteristic electricalCharacteristic) throws BigValueInApplianceException {
        if (electricalCharacteristic.getPower() > 100000)
            throw new BigValueInApplianceException("very big consumption");
        if (electricalCharacteristic.getVoltage() > 1000)
            throw new BigValueInApplianceException("very big voltage");
        this.electricalCharacteristic = electricalCharacteristic;
    }

    public void setApplianceCharacteristic(ApplianceCharacteristic applianceCharacteristic) {
        this.applianceCharacteristic = applianceCharacteristic;
        setApplianceType();
    }

    private void setSizeType() {
        double mCI = 1;
        switch (physicalCharacteristics.getSize().getUnit())
        {
            case MM:
                mCI = 1000;
                break;
            case CM:
                mCI = 100;
                break;
            case DM:
                mCI = 10;
                break;
            default:
                mCI = 1;
                break;
        }
        if(physicalCharacteristics.getSize().getVolume() - 0.125 * mCI < 0) {
            this.sizeType = SizeType.SMALL;
        }
        else if(physicalCharacteristics.getSize().getVolume() - 3.375 * mCI < 0) {
            this.sizeType = SizeType.MEDIUM;
        }
        else {
            this.sizeType = SizeType.BIG;
        }
    }

    private void setApplianceType() {
        if (applianceCharacteristic instanceof WasherCharacteristic)
            this.applianceType = ApplianceType.WASHER;
        if (applianceCharacteristic instanceof FridgeCharacteristic)
            this.applianceType = ApplianceType.FRIDGE;
        if (applianceCharacteristic instanceof AirСonditioningCharacteristic)
            this.applianceType = ApplianceType.AIR_СONDITIONING;
        if (applianceCharacteristic instanceof ElectricKettleCharacteristic)
            this.applianceType = ApplianceType.ELECTRICAL_KETTLE;
    }

    public String getName() {
        return name;
    }

    public PhysicalCharacteristics getPhysicalCharacteristics() {
        return physicalCharacteristics;
    }

    public ElectricalCharacteristic getElectricalCharacteristic() {
        return electricalCharacteristic;
    }

    public ApplianceCharacteristic getApplianceCharacteristic() {
        return applianceCharacteristic;
    }

    public SizeType getSizeType() {
        return sizeType;
    }

    public ApplianceType getApplianceType() {
        return applianceType;
    }
}
