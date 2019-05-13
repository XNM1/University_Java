package ua.edu.chmnu.fks.oop.Lab06;

import ua.edu.chmnu.fks.oop.Lab06.Exceptions.*;

public class AirСonditioningCharacteristic extends ApplianceCharacteristic {
    private CompressorType compressorType;
    private int floorArea;
    private String freonType;
    private int coldProductivityBTU;
    private int heatProductivityBTU;

    public AirСonditioningCharacteristic(EfficiencyClass energyClass, CompressorType compressorType, int floorArea, String freonType, int coldProductivityBTU, int heatProductivityBTU) throws Exception {
        super(energyClass);
        this.compressorType = compressorType;
        setFloorArea(floorArea);
        this.freonType = freonType;
        setColdProductivityBTU(coldProductivityBTU);
        setHeatProductivityBTU(heatProductivityBTU);
    }

    public AirСonditioningCharacteristic(EfficiencyClass energyClass, String[] features, CompressorType compressorType, int floorArea, String freonType, int coldProductivityBTU, int heatProductivityBTU) throws Exception {
        super(energyClass, features);
        this.compressorType = compressorType;
        setFloorArea(floorArea);
        this.freonType = freonType;
        setColdProductivityBTU(coldProductivityBTU);
        setHeatProductivityBTU(heatProductivityBTU);
    }

    public void setCompressorType(CompressorType compressorType) {
        this.compressorType = compressorType;
    }

    public void setFloorArea(int floorArea) throws Exception {
        if (floorArea < 0)
            throw new NegativeValueException("negative floor area");
        if (floorArea == 0)
            throw new ZeroValueException("zero floor area");
        if (floorArea > 100000)
            throw new BigValueInApplianceException("vary big floor area");
        this.floorArea = floorArea;
    }

    public void setFreonType(String freonType) {
        this.freonType = freonType;
    }

    public void setColdProductivityBTU(int coldProductivityBTU) throws Exception {
        if (coldProductivityBTU < 0)
            throw new NegativeValueException("negative cold productivity");
        if (coldProductivityBTU == 0)
            throw new ZeroValueException("zero cold productivity");
        if (coldProductivityBTU > 100000)
            throw new BigValueInApplianceException("vary big cold productivity");
        this.coldProductivityBTU = coldProductivityBTU;
    }

    public void setHeatProductivityBTU(int heatProductivityBTU) throws Exception {
        if (heatProductivityBTU < 0)
            throw new NegativeValueException("negative heat productivity");
        if (heatProductivityBTU == 0)
            throw new ZeroValueException("zero heat productivity");
        if (heatProductivityBTU > 100000)
            throw new BigValueInApplianceException("vary big heat productivity");
        this.heatProductivityBTU = heatProductivityBTU;
    }

    public CompressorType getCompressorType() {
        return compressorType;
    }

    public int getFloorArea() {
        return floorArea;
    }

    public String getFreonType() {
        return freonType;
    }

    public int getColdProductivityBTU() {
        return coldProductivityBTU;
    }

    public int getHeatProductivityBTU() {
        return heatProductivityBTU;
    }
}
