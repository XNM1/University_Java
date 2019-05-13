package ua.edu.chmnu.fks.oop.Lab06;

import ua.edu.chmnu.fks.oop.Lab06.Exceptions.*;

public class FridgeCharacteristic extends ApplianceCharacteristic {
    private int countOfChamber;
    private CompressorType compressorType;
    private int refrigeratorVolumeL;
    private int freezerVolumeL;

    public FridgeCharacteristic(EfficiencyClass energyClass, int countOfChamber, CompressorType compressorType, int refrigeratorVolumeL, int freezerVolumeL) throws Exception {
        super(energyClass);
        setCountOfChamber(countOfChamber);
        setCompressorType(compressorType);
        setRefrigeratorVolumeL(refrigeratorVolumeL);
        setFreezerVolumeL(freezerVolumeL);
    }

    public FridgeCharacteristic(EfficiencyClass energyClass, String[] features, int countOfChamber, CompressorType compressorType, int refrigeratorVolumeL, int freezerVolumeL) throws Exception {
        super(energyClass, features);
        setCountOfChamber(countOfChamber);
        setCompressorType(compressorType);
        setRefrigeratorVolumeL(refrigeratorVolumeL);
        setFreezerVolumeL(freezerVolumeL);
    }

    public void setCountOfChamber(int countOfChamber) throws Exception {
        if (countOfChamber < 0)
            throw new NegativeValueException("negative count of chamber");
        if (countOfChamber == 0)
            throw new ZeroValueException("zero count of chamber");
        if (countOfChamber > 10)
            throw new BigValueInApplianceException("vary big count of chamber");
        this.countOfChamber = countOfChamber;
    }

    public void setCompressorType(CompressorType compressorType) {
        this.compressorType = compressorType;
    }

    public void setRefrigeratorVolumeL(int refrigeratorVolumeL) throws Exception {
        if (refrigeratorVolumeL < 0)
            throw new NegativeValueException("negative refrigerator volume litres");
        if (refrigeratorVolumeL == 0)
            throw new ZeroValueException("zero refrigerator volume litres");
        if (refrigeratorVolumeL > 1000)
            throw new BigValueInApplianceException("vary big refrigerator volume litres");
        this.refrigeratorVolumeL = refrigeratorVolumeL;
    }

    public void setFreezerVolumeL(int freezerVolumeL) throws Exception {
        if (freezerVolumeL < 0)
            throw new NegativeValueException("negative freezer volume litres");
        if (freezerVolumeL == 0)
            throw new ZeroValueException("zero freezer volume litres");
        if (freezerVolumeL > 1000)
            throw new BigValueInApplianceException("vary big freezer volume litres");
        this.freezerVolumeL = freezerVolumeL;
    }

    public int getCountOfChamber() {
        return countOfChamber;
    }

    public CompressorType getCompressorType() {
        return compressorType;
    }

    public int getRefrigeratorVolumeL() {
        return refrigeratorVolumeL;
    }

    public int getFreezerVolumeL() {
        return freezerVolumeL;
    }
}
