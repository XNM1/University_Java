package ua.edu.chmnu.fks.oop.Lab06;

import org.junit.jupiter.api.Test;
import ua.edu.chmnu.fks.oop.Lab06.Exceptions.BigValueInApplianceException;
import ua.edu.chmnu.fks.oop.Lab06.Exceptions.NegativeValueException;
import ua.edu.chmnu.fks.oop.Lab06.Exceptions.ZeroValueException;

import static org.junit.jupiter.api.Assertions.*;

class WasherCharacteristicTest {

    WasherCharacteristic washerCharacteristic;

    {
        try {
            washerCharacteristic = new WasherCharacteristic(EfficiencyClass.A, 8, 100, EfficiencyClass.A, EfficiencyClass.B, 15, 1400, 1);
        }
        catch (Exception ex) {}
    }

    @Test
    void constructorTest() throws Exception {
        WasherCharacteristic washerCharacteristic = new WasherCharacteristic(EfficiencyClass.A, 8, 100, EfficiencyClass.A, EfficiencyClass.B, 15, 1400, 1);

        assertEquals(EfficiencyClass.A, washerCharacteristic.getEnergyClass());
        assertEquals(8, washerCharacteristic.getMaxWeightOfLinenKg());
        assertEquals(100, washerCharacteristic.getWaterConsumptionL());
        assertEquals(EfficiencyClass.A, washerCharacteristic.getWashClass());
        assertEquals(EfficiencyClass.B, washerCharacteristic.getSpinClass());
        assertEquals(15, washerCharacteristic.getCountOfProgram());
        assertEquals(1400, washerCharacteristic.getSpinSpeedMin());
        assertEquals(1, washerCharacteristic.getCountOfDrums());

        assertThrows(ZeroValueException.class, () -> new WasherCharacteristic(EfficiencyClass.A, 8, 100, EfficiencyClass.A, EfficiencyClass.B, 15, 1400, 0));
        assertThrows(NegativeValueException.class, () -> new WasherCharacteristic(EfficiencyClass.A, -8, 100, EfficiencyClass.A, EfficiencyClass.B, 15, 1400, 2));
        assertThrows(BigValueInApplianceException.class, () -> new WasherCharacteristic(EfficiencyClass.A, 8, 100, EfficiencyClass.A, EfficiencyClass.B, 1000, 1400, 1));
    }

    @Test
    void constructor2Test() throws Exception {
        String[] f1 = new String[] {"asdhqiowho", "asjdhqwje", "asdjhqwlke"};
        WasherCharacteristic washerCharacteristic = new WasherCharacteristic(EfficiencyClass.A, f1, 8, 100, EfficiencyClass.A, EfficiencyClass.B, 15, 1400, 1);

        assertEquals(EfficiencyClass.A, washerCharacteristic.getEnergyClass());
        assertEquals(8, washerCharacteristic.getMaxWeightOfLinenKg());
        assertEquals(100, washerCharacteristic.getWaterConsumptionL());
        assertEquals(EfficiencyClass.A, washerCharacteristic.getWashClass());
        assertEquals(EfficiencyClass.B, washerCharacteristic.getSpinClass());
        assertEquals(15, washerCharacteristic.getCountOfProgram());
        assertEquals(1400, washerCharacteristic.getSpinSpeedMin());
        assertEquals(1, washerCharacteristic.getCountOfDrums());
        assertEquals(f1, washerCharacteristic.getFeatures());

        assertThrows(ZeroValueException.class, () -> new WasherCharacteristic(EfficiencyClass.A, f1, 8, 100, EfficiencyClass.A, EfficiencyClass.B, 15, 1400, 0));
        assertThrows(NegativeValueException.class, () -> new WasherCharacteristic(EfficiencyClass.A, f1, -8, 100, EfficiencyClass.A, EfficiencyClass.B, 15, 1400, 2));
        assertThrows(BigValueInApplianceException.class, () -> new WasherCharacteristic(EfficiencyClass.A, f1, 8, 100, EfficiencyClass.A, EfficiencyClass.B, 1000, 1400, 1));
    }

    @Test
    void maxWeightOfLinenKgSetterGetterTest() throws Exception {
        washerCharacteristic.setMaxWeightOfLinenKg(2);
        assertEquals(2, washerCharacteristic.getMaxWeightOfLinenKg());
        washerCharacteristic.setMaxWeightOfLinenKg(10);
        assertEquals(10, washerCharacteristic.getMaxWeightOfLinenKg());
        washerCharacteristic.setMaxWeightOfLinenKg(15);
        assertEquals(15, washerCharacteristic.getMaxWeightOfLinenKg());
        washerCharacteristic.setMaxWeightOfLinenKg(5);
        assertEquals(5, washerCharacteristic.getMaxWeightOfLinenKg());

        assertThrows(NegativeValueException.class, () -> washerCharacteristic.setMaxWeightOfLinenKg(-3));
        assertThrows(ZeroValueException.class, () -> washerCharacteristic.setMaxWeightOfLinenKg(0));
        assertThrows(BigValueInApplianceException.class, () -> washerCharacteristic.setMaxWeightOfLinenKg(25));
    }

    @Test
    void waterConsumptionLSetterGetterTest() throws Exception {
        washerCharacteristic.setWaterConsumptionL(2);
        assertEquals(2, washerCharacteristic.getWaterConsumptionL());
        washerCharacteristic.setWaterConsumptionL(299);
        assertEquals(299, washerCharacteristic.getWaterConsumptionL());
        washerCharacteristic.setWaterConsumptionL(43);
        assertEquals(43, washerCharacteristic.getWaterConsumptionL());
        washerCharacteristic.setWaterConsumptionL(35);
        assertEquals(35, washerCharacteristic.getWaterConsumptionL());

        assertThrows(NegativeValueException.class, () -> washerCharacteristic.setWaterConsumptionL(-3));
        assertThrows(ZeroValueException.class, () -> washerCharacteristic.setWaterConsumptionL(0));
        assertThrows(BigValueInApplianceException.class, () -> washerCharacteristic.setWaterConsumptionL(700));
    }

    @Test
    void washClassSetterGetterTest() throws Exception {
        washerCharacteristic.setWashClass(EfficiencyClass.APPP);
        assertEquals(EfficiencyClass.APPP, washerCharacteristic.getWashClass());
        washerCharacteristic.setWashClass(EfficiencyClass.APP);
        assertEquals(EfficiencyClass.APP, washerCharacteristic.getWashClass());
        washerCharacteristic.setWashClass(EfficiencyClass.AP);
        assertEquals(EfficiencyClass.AP, washerCharacteristic.getWashClass());
        washerCharacteristic.setWashClass(EfficiencyClass.A);
        assertEquals(EfficiencyClass.A, washerCharacteristic.getWashClass());
        washerCharacteristic.setWashClass(EfficiencyClass.B);
        assertEquals(EfficiencyClass.B, washerCharacteristic.getWashClass());
        washerCharacteristic.setWashClass(EfficiencyClass.C);
        assertEquals(EfficiencyClass.C, washerCharacteristic.getWashClass());
        washerCharacteristic.setWashClass(EfficiencyClass.D);
        assertEquals(EfficiencyClass.D, washerCharacteristic.getWashClass());
        washerCharacteristic.setWashClass(EfficiencyClass.E);
        assertEquals(EfficiencyClass.E, washerCharacteristic.getWashClass());
        washerCharacteristic.setWashClass(EfficiencyClass.F);
        assertEquals(EfficiencyClass.F, washerCharacteristic.getWashClass());
        washerCharacteristic.setWashClass(EfficiencyClass.G);
        assertEquals(EfficiencyClass.G, washerCharacteristic.getWashClass());
    }

    @Test
    void spinClassSetterGetterTest() throws Exception {
        washerCharacteristic.setSpinClass(EfficiencyClass.APPP);
        assertEquals(EfficiencyClass.APPP, washerCharacteristic.getSpinClass());
        washerCharacteristic.setSpinClass(EfficiencyClass.APP);
        assertEquals(EfficiencyClass.APP, washerCharacteristic.getSpinClass());
        washerCharacteristic.setSpinClass(EfficiencyClass.AP);
        assertEquals(EfficiencyClass.AP, washerCharacteristic.getSpinClass());
        washerCharacteristic.setSpinClass(EfficiencyClass.A);
        assertEquals(EfficiencyClass.A, washerCharacteristic.getSpinClass());
        washerCharacteristic.setSpinClass(EfficiencyClass.B);
        assertEquals(EfficiencyClass.B, washerCharacteristic.getSpinClass());
        washerCharacteristic.setSpinClass(EfficiencyClass.C);
        assertEquals(EfficiencyClass.C, washerCharacteristic.getSpinClass());
        washerCharacteristic.setSpinClass(EfficiencyClass.D);
        assertEquals(EfficiencyClass.D, washerCharacteristic.getSpinClass());
        washerCharacteristic.setSpinClass(EfficiencyClass.E);
        assertEquals(EfficiencyClass.E, washerCharacteristic.getSpinClass());
        washerCharacteristic.setSpinClass(EfficiencyClass.F);
        assertEquals(EfficiencyClass.F, washerCharacteristic.getSpinClass());
        washerCharacteristic.setSpinClass(EfficiencyClass.G);
        assertEquals(EfficiencyClass.G, washerCharacteristic.getSpinClass());
    }

    @Test
    void countOfProgramSetterGetterTest() throws Exception {
        washerCharacteristic.setCountOfProgram(2);
        assertEquals(2, washerCharacteristic.getCountOfProgram());
        washerCharacteristic.setCountOfProgram(299);
        assertEquals(299, washerCharacteristic.getCountOfProgram());
        washerCharacteristic.setCountOfProgram(43);
        assertEquals(43, washerCharacteristic.getCountOfProgram());
        washerCharacteristic.setCountOfProgram(35);
        assertEquals(35, washerCharacteristic.getCountOfProgram());

        assertThrows(NegativeValueException.class, () -> washerCharacteristic.setCountOfProgram(-3));
        assertThrows(ZeroValueException.class, () -> washerCharacteristic.setCountOfProgram(0));
        assertThrows(BigValueInApplianceException.class, () -> washerCharacteristic.setCountOfProgram(700));
    }

    @Test
    void spinSpeedMinSetterGetterTest() throws Exception {
        washerCharacteristic.setSpinSpeedMin(2);
        assertEquals(2, washerCharacteristic.getSpinSpeedMin());
        washerCharacteristic.setSpinSpeedMin(299);
        assertEquals(299, washerCharacteristic.getSpinSpeedMin());
        washerCharacteristic.setSpinSpeedMin(43);
        assertEquals(43, washerCharacteristic.getSpinSpeedMin());
        washerCharacteristic.setSpinSpeedMin(35);
        assertEquals(35, washerCharacteristic.getSpinSpeedMin());

        assertThrows(NegativeValueException.class, () -> washerCharacteristic.setSpinSpeedMin(-3));
        assertThrows(ZeroValueException.class, () -> washerCharacteristic.setSpinSpeedMin(0));
        assertThrows(BigValueInApplianceException.class, () -> washerCharacteristic.setSpinSpeedMin(100001));
    }

    @Test
    void countOfDrumsSetterGetterTest() throws Exception {
        washerCharacteristic.setCountOfDrums(2);
        assertEquals(2, washerCharacteristic.getCountOfDrums());
        washerCharacteristic.setCountOfDrums(1);
        assertEquals(1, washerCharacteristic.getCountOfDrums());
        washerCharacteristic.setCountOfDrums(3);
        assertEquals(3, washerCharacteristic.getCountOfDrums());

        assertThrows(NegativeValueException.class, () -> washerCharacteristic.setCountOfDrums(-3));
        assertThrows(ZeroValueException.class, () -> washerCharacteristic.setCountOfDrums(0));
        assertThrows(BigValueInApplianceException.class, () -> washerCharacteristic.setCountOfDrums(7));
    }

    @Test
    void energyClassSetterGetterTest() throws Exception {
        washerCharacteristic.setEnergyClass(EfficiencyClass.APPP);
        assertEquals(EfficiencyClass.APPP, washerCharacteristic.getEnergyClass());
        washerCharacteristic.setEnergyClass(EfficiencyClass.APP);
        assertEquals(EfficiencyClass.APP, washerCharacteristic.getEnergyClass());
        washerCharacteristic.setEnergyClass(EfficiencyClass.AP);
        assertEquals(EfficiencyClass.AP, washerCharacteristic.getEnergyClass());
        washerCharacteristic.setEnergyClass(EfficiencyClass.A);
        assertEquals(EfficiencyClass.A, washerCharacteristic.getEnergyClass());
        washerCharacteristic.setEnergyClass(EfficiencyClass.B);
        assertEquals(EfficiencyClass.B, washerCharacteristic.getEnergyClass());
        washerCharacteristic.setEnergyClass(EfficiencyClass.C);
        assertEquals(EfficiencyClass.C, washerCharacteristic.getEnergyClass());
        washerCharacteristic.setEnergyClass(EfficiencyClass.D);
        assertEquals(EfficiencyClass.D, washerCharacteristic.getEnergyClass());
        washerCharacteristic.setEnergyClass(EfficiencyClass.E);
        assertEquals(EfficiencyClass.E, washerCharacteristic.getEnergyClass());
        washerCharacteristic.setEnergyClass(EfficiencyClass.F);
        assertEquals(EfficiencyClass.F, washerCharacteristic.getEnergyClass());
        washerCharacteristic.setEnergyClass(EfficiencyClass.G);
        assertEquals(EfficiencyClass.G, washerCharacteristic.getEnergyClass());
    }

    @Test
    void featuresSetterGetterTest() throws Exception {
        String[] f1 = new String[] {"asdhqiowho", "asjdhqwje", "asdjhqwlke"};
        String[] f2 = new String[] {"fghfgrty", "534sdf", "436gsdfd"};
        String[] f3 = new String[] {"asdhqiowho", "asdjhqwlke"};
        String[] f4 = new String[] {"asdhqiowho", "asdjhqwlke"};
        washerCharacteristic.setFeatures(f1);
        assertEquals(f1, washerCharacteristic.getFeatures());
        washerCharacteristic.setFeatures(f2);
        assertEquals(f2, washerCharacteristic.getFeatures());
        washerCharacteristic.setFeatures(f3);
        assertEquals(f3, washerCharacteristic.getFeatures());
        washerCharacteristic.setFeatures(f4);
        assertEquals(f4, washerCharacteristic.getFeatures());
    }

}