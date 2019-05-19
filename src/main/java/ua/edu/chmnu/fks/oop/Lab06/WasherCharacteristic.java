package ua.edu.chmnu.fks.oop.Lab06;

import ua.edu.chmnu.fks.oop.Lab06.Exceptions.*;

public class WasherCharacteristic extends ApplianceCharacteristic {
    private int maxWeightOfLinenKg;
    private int waterConsumptionL;
    private EfficiencyClass washClass;
    private EfficiencyClass spinClass;
    private int countOfProgram;
    private int spinSpeedMin;
    private int countOfDrums;

    public WasherCharacteristic(EfficiencyClass energyClass, int maxWeightOfLinenKg, int waterConsumptionL, EfficiencyClass washClass, EfficiencyClass spinClass, int countOfProgram, int spinSpeedMin, int countOfDrums) throws Exception {
        super(energyClass);
        setMaxWeightOfLinenKg(maxWeightOfLinenKg);
        setWaterConsumptionL(waterConsumptionL);
        this.washClass = washClass;
        this.spinClass = spinClass;
        setCountOfProgram(countOfProgram);
        setSpinSpeedMin(spinSpeedMin);
        setCountOfDrums(countOfDrums);
    }

    public WasherCharacteristic(EfficiencyClass energyClass, String[] features, int maxWeightOfLinenKg, int waterConsumptionL, EfficiencyClass washClass, EfficiencyClass spinClass, int countOfProgram, int spinSpeedMin, int countOfDrums) throws Exception {
        super(energyClass, features);
        setMaxWeightOfLinenKg(maxWeightOfLinenKg);
        setWaterConsumptionL(waterConsumptionL);
        this.washClass = washClass;
        this.spinClass = spinClass;
        setCountOfProgram(countOfProgram);
        setSpinSpeedMin(spinSpeedMin);
        setCountOfDrums(countOfDrums);
    }

    public void setWashClass(EfficiencyClass washClass) {
        this.washClass = washClass;
    }

    public void setSpinClass(EfficiencyClass spinClass) {
        this.spinClass = spinClass;
    }

    public void setMaxWeightOfLinenKg(int maxWeightOfLinenKg) throws Exception {
        if (maxWeightOfLinenKg < 0)
            throw new NegativeValueException("negative weight of linen");
        if (maxWeightOfLinenKg == 0)
            throw new ZeroValueException("zero weight of linen");
        if (maxWeightOfLinenKg > 20)
            throw new BigValueInApplianceException("vary big weight of linen");
        this.maxWeightOfLinenKg = maxWeightOfLinenKg;
    }

    public void setWaterConsumptionL(int waterConsumptionL) throws Exception {
        if (waterConsumptionL < 0)
            throw new NegativeValueException("negative water consumption");
        if (waterConsumptionL == 0)
            throw new ZeroValueException("zero water consumption");
        if (waterConsumptionL > 500)
            throw new BigValueInApplianceException("vary big water consumption");
        this.waterConsumptionL = waterConsumptionL;
    }

    public void setCountOfProgram(int countOfProgram) throws Exception {
        if (countOfProgram < 0)
            throw new NegativeValueException("negative count of program");
        if (countOfProgram == 0)
            throw new ZeroValueException("zero count of program");
        if (countOfProgram > 500)
            throw new BigValueInApplianceException("vary big count of program");
        this.countOfProgram = countOfProgram;
    }

    public void setSpinSpeedMin(int spinSpeedMin) throws Exception {
        if (spinSpeedMin < 0)
            throw new NegativeValueException("negative spin speed minutes");
        if (spinSpeedMin == 0)
            throw new ZeroValueException("zero spin speed minutes");
        if (spinSpeedMin > 100000)
            throw new BigValueInApplianceException("vary big spin speed minutes");
        this.spinSpeedMin = spinSpeedMin;
    }

    public void setCountOfDrums(int countOfDrums) throws Exception {
        if (countOfDrums < 0)
            throw new NegativeValueException("negative count of drums");
        if (countOfDrums == 0)
            throw new ZeroValueException("zero count of drums");
        if (countOfDrums > 3)
            throw new BigValueInApplianceException("vary big count of drums");
        this.countOfDrums = countOfDrums;
    }

    public int getMaxWeightOfLinenKg() {
        return maxWeightOfLinenKg;
    }

    public int getWaterConsumptionL() {
        return waterConsumptionL;
    }

    public EfficiencyClass getWashClass() {
        return washClass;
    }

    public EfficiencyClass getSpinClass() {
        return spinClass;
    }

    public int getCountOfProgram() {
        return countOfProgram;
    }

    public int getSpinSpeedMin() {
        return spinSpeedMin;
    }

    public int getCountOfDrums() {
        return countOfDrums;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WasherCharacteristic)) return false;

        WasherCharacteristic that = (WasherCharacteristic) o;

        if (getMaxWeightOfLinenKg() != that.getMaxWeightOfLinenKg()) return false;
        if (getWaterConsumptionL() != that.getWaterConsumptionL()) return false;
        if (getCountOfProgram() != that.getCountOfProgram()) return false;
        if (getSpinSpeedMin() != that.getSpinSpeedMin()) return false;
        if (getCountOfDrums() != that.getCountOfDrums()) return false;
        if (getWashClass() != that.getWashClass()) return false;
        return getSpinClass() == that.getSpinClass();
    }

    @Override
    public int hashCode() {
        int result = getMaxWeightOfLinenKg();
        result = 31 * result + getWaterConsumptionL();
        result = 31 * result + getWashClass().hashCode();
        result = 31 * result + getSpinClass().hashCode();
        result = 31 * result + getCountOfProgram();
        result = 31 * result + getSpinSpeedMin();
        result = 31 * result + getCountOfDrums();
        return result;
    }

    @Override
    public String toString() {
        return "WasherCharacteristic{" +
                "maxWeightOfLinenKg=" + maxWeightOfLinenKg +
                ", waterConsumptionL=" + waterConsumptionL +
                ", washClass=" + washClass +
                ", spinClass=" + spinClass +
                ", countOfProgram=" + countOfProgram +
                ", spinSpeedMin=" + spinSpeedMin +
                ", countOfDrums=" + countOfDrums +
                '}';
    }
}
