package ua.edu.chmnu.fks.oop.Lab06;

import org.junit.jupiter.api.Test;
import ua.edu.chmnu.fks.oop.Lab06.Exceptions.BigValueInApplianceException;
import ua.edu.chmnu.fks.oop.Lab06.Exceptions.NegativeValueException;
import ua.edu.chmnu.fks.oop.Lab06.Exceptions.ZeroValueException;

import static org.junit.jupiter.api.Assertions.*;

class FridgeCharacteristicTest {

    FridgeCharacteristic fridgeCharacteristic;

    {
        try {
            fridgeCharacteristic = new FridgeCharacteristic(EfficiencyClass.A, 2, CompressorType.LINEAR, 222, 100);
        }
        catch (Exception ex) {}
    }

    @Test
    void constructorTest() throws Exception {
        FridgeCharacteristic fridgeCharacteristic1 = new FridgeCharacteristic(EfficiencyClass.A, 2, CompressorType.LINEAR, 300, 100);
        FridgeCharacteristic fridgeCharacteristic2 = new FridgeCharacteristic(EfficiencyClass.B, 3, CompressorType.INVERTOR, 222, 120);
        FridgeCharacteristic fridgeCharacteristic3 = new FridgeCharacteristic(EfficiencyClass.C, 1, CompressorType.USUAL, 120, 140);

        assertEquals(EfficiencyClass.A, fridgeCharacteristic1.getEnergyClass());
        assertEquals(2, fridgeCharacteristic1.getCountOfChamber());
        assertEquals(CompressorType.LINEAR, fridgeCharacteristic1.getCompressorType());
        assertEquals(300, fridgeCharacteristic1.getRefrigeratorVolumeL());
        assertEquals(100, fridgeCharacteristic1.getFreezerVolumeL());

        assertEquals(EfficiencyClass.B, fridgeCharacteristic2.getEnergyClass());
        assertEquals(3, fridgeCharacteristic2.getCountOfChamber());
        assertEquals(CompressorType.INVERTOR, fridgeCharacteristic2.getCompressorType());
        assertEquals(222, fridgeCharacteristic2.getRefrigeratorVolumeL());
        assertEquals(120, fridgeCharacteristic2.getFreezerVolumeL());

        assertEquals(EfficiencyClass.C, fridgeCharacteristic3.getEnergyClass());
        assertEquals(1, fridgeCharacteristic3.getCountOfChamber());
        assertEquals(CompressorType.USUAL, fridgeCharacteristic3.getCompressorType());
        assertEquals(120, fridgeCharacteristic3.getRefrigeratorVolumeL());
        assertEquals(140, fridgeCharacteristic3.getFreezerVolumeL());

        assertThrows(ZeroValueException.class, () -> new FridgeCharacteristic(EfficiencyClass.A, 0, CompressorType.LINEAR, 300, 100));
        assertThrows(NegativeValueException.class, () -> new FridgeCharacteristic(EfficiencyClass.A, -2, CompressorType.LINEAR, 300, 100));
        assertThrows(BigValueInApplianceException.class, () -> new FridgeCharacteristic(EfficiencyClass.A, 2, CompressorType.LINEAR, 1500, 100));
    }

    @Test
    void constructor2Test() throws Exception {
        String[] f1 = new String[] {"asdhqiowho", "asjdhqwje", "asdjhqwlke"};
        String[] f2 = new String[] {"fghfgrty", "534sdf", "436gsdfd"};
        String[] f3 = new String[] {"asdhqiowho", "asdjhqwlke"};
        FridgeCharacteristic fridgeCharacteristic1 = new FridgeCharacteristic(EfficiencyClass.A, f1, 2, CompressorType.LINEAR, 300, 100);
        FridgeCharacteristic fridgeCharacteristic2 = new FridgeCharacteristic(EfficiencyClass.B, f2, 3, CompressorType.INVERTOR, 222, 120);
        FridgeCharacteristic fridgeCharacteristic3 = new FridgeCharacteristic(EfficiencyClass.C, f3,1, CompressorType.USUAL, 120, 140);

        assertEquals(EfficiencyClass.A, fridgeCharacteristic1.getEnergyClass());
        assertEquals(2, fridgeCharacteristic1.getCountOfChamber());
        assertEquals(CompressorType.LINEAR, fridgeCharacteristic1.getCompressorType());
        assertEquals(300, fridgeCharacteristic1.getRefrigeratorVolumeL());
        assertEquals(100, fridgeCharacteristic1.getFreezerVolumeL());
        assertEquals(f1, fridgeCharacteristic1.getFeatures());

        assertEquals(EfficiencyClass.B, fridgeCharacteristic2.getEnergyClass());
        assertEquals(3, fridgeCharacteristic2.getCountOfChamber());
        assertEquals(CompressorType.INVERTOR, fridgeCharacteristic2.getCompressorType());
        assertEquals(222, fridgeCharacteristic2.getRefrigeratorVolumeL());
        assertEquals(120, fridgeCharacteristic2.getFreezerVolumeL());
        assertEquals(f2, fridgeCharacteristic2.getFeatures());

        assertEquals(EfficiencyClass.C, fridgeCharacteristic3.getEnergyClass());
        assertEquals(1, fridgeCharacteristic3.getCountOfChamber());
        assertEquals(CompressorType.USUAL, fridgeCharacteristic3.getCompressorType());
        assertEquals(120, fridgeCharacteristic3.getRefrigeratorVolumeL());
        assertEquals(140, fridgeCharacteristic3.getFreezerVolumeL());
        assertEquals(f3, fridgeCharacteristic3.getFeatures());

        assertThrows(ZeroValueException.class, () -> new FridgeCharacteristic(EfficiencyClass.A, f1, 2, CompressorType.LINEAR, 300, 0));
        assertThrows(NegativeValueException.class, () -> new FridgeCharacteristic(EfficiencyClass.A, f2, -2, CompressorType.LINEAR, 300, 100));
        assertThrows(BigValueInApplianceException.class, () -> new FridgeCharacteristic(EfficiencyClass.A, f3, 2, CompressorType.LINEAR, 1500, 100));
    }

    @Test
    void countOfChamberSetterGetterTest() throws Exception {
        fridgeCharacteristic.setCountOfChamber(2);
        assertEquals(2, fridgeCharacteristic.getCountOfChamber());
        fridgeCharacteristic.setCountOfChamber(9);
        assertEquals(9, fridgeCharacteristic.getCountOfChamber());
        fridgeCharacteristic.setCountOfChamber(3);
        assertEquals(3, fridgeCharacteristic.getCountOfChamber());
        fridgeCharacteristic.setCountOfChamber(4);
        assertEquals(4, fridgeCharacteristic.getCountOfChamber());

        assertThrows(NegativeValueException.class, () -> fridgeCharacteristic.setCountOfChamber(-3));
        assertThrows(ZeroValueException.class, () -> fridgeCharacteristic.setCountOfChamber(0));
        assertThrows(BigValueInApplianceException.class, () -> fridgeCharacteristic.setCountOfChamber(24));
    }

    @Test
    void compressorTypeSetterGetterTest() throws Exception {
        fridgeCharacteristic.setCompressorType(CompressorType.INVERTER_LINEAR);
        assertEquals(CompressorType.INVERTER_LINEAR, fridgeCharacteristic.getCompressorType());
        fridgeCharacteristic.setCompressorType(CompressorType.INVERTOR);
        assertEquals(CompressorType.INVERTOR, fridgeCharacteristic.getCompressorType());
        fridgeCharacteristic.setCompressorType(CompressorType.LINEAR);
        assertEquals(CompressorType.LINEAR, fridgeCharacteristic.getCompressorType());
        fridgeCharacteristic.setCompressorType(CompressorType.USUAL);
        assertEquals(CompressorType.USUAL, fridgeCharacteristic.getCompressorType());
    }

    @Test
    void refrigeratorVolumeLSetterGetterTest() throws Exception {
        fridgeCharacteristic.setRefrigeratorVolumeL(2);
        assertEquals(2, fridgeCharacteristic.getRefrigeratorVolumeL());
        fridgeCharacteristic.setRefrigeratorVolumeL(299);
        assertEquals(299, fridgeCharacteristic.getRefrigeratorVolumeL());
        fridgeCharacteristic.setRefrigeratorVolumeL(43);
        assertEquals(43, fridgeCharacteristic.getRefrigeratorVolumeL());
        fridgeCharacteristic.setRefrigeratorVolumeL(35);
        assertEquals(35, fridgeCharacteristic.getRefrigeratorVolumeL());

        assertThrows(NegativeValueException.class, () -> fridgeCharacteristic.setRefrigeratorVolumeL(-3));
        assertThrows(ZeroValueException.class, () -> fridgeCharacteristic.setRefrigeratorVolumeL(0));
        assertThrows(BigValueInApplianceException.class, () -> fridgeCharacteristic.setRefrigeratorVolumeL(1500));
    }

    @Test
    void freezerVolumeLSetterGetterTest() throws Exception {
        fridgeCharacteristic.setFreezerVolumeL(2);
        assertEquals(2, fridgeCharacteristic.getFreezerVolumeL());
        fridgeCharacteristic.setFreezerVolumeL(299);
        assertEquals(299, fridgeCharacteristic.getFreezerVolumeL());
        fridgeCharacteristic.setFreezerVolumeL(43);
        assertEquals(43, fridgeCharacteristic.getFreezerVolumeL());
        fridgeCharacteristic.setFreezerVolumeL(35);
        assertEquals(35, fridgeCharacteristic.getFreezerVolumeL());

        assertThrows(NegativeValueException.class, () -> fridgeCharacteristic.setFreezerVolumeL(-3));
        assertThrows(ZeroValueException.class, () -> fridgeCharacteristic.setFreezerVolumeL(0));
        assertThrows(BigValueInApplianceException.class, () -> fridgeCharacteristic.setFreezerVolumeL(1500));
    }

    @Test
    void energyClassSetterGetterTest() throws Exception {
        fridgeCharacteristic.setEnergyClass(EfficiencyClass.APPP);
        assertEquals(EfficiencyClass.APPP, fridgeCharacteristic.getEnergyClass());
        fridgeCharacteristic.setEnergyClass(EfficiencyClass.APP);
        assertEquals(EfficiencyClass.APP, fridgeCharacteristic.getEnergyClass());
        fridgeCharacteristic.setEnergyClass(EfficiencyClass.AP);
        assertEquals(EfficiencyClass.AP, fridgeCharacteristic.getEnergyClass());
        fridgeCharacteristic.setEnergyClass(EfficiencyClass.A);
        assertEquals(EfficiencyClass.A, fridgeCharacteristic.getEnergyClass());
        fridgeCharacteristic.setEnergyClass(EfficiencyClass.B);
        assertEquals(EfficiencyClass.B, fridgeCharacteristic.getEnergyClass());
        fridgeCharacteristic.setEnergyClass(EfficiencyClass.C);
        assertEquals(EfficiencyClass.C, fridgeCharacteristic.getEnergyClass());
        fridgeCharacteristic.setEnergyClass(EfficiencyClass.D);
        assertEquals(EfficiencyClass.D, fridgeCharacteristic.getEnergyClass());
        fridgeCharacteristic.setEnergyClass(EfficiencyClass.E);
        assertEquals(EfficiencyClass.E, fridgeCharacteristic.getEnergyClass());
        fridgeCharacteristic.setEnergyClass(EfficiencyClass.F);
        assertEquals(EfficiencyClass.F, fridgeCharacteristic.getEnergyClass());
        fridgeCharacteristic.setEnergyClass(EfficiencyClass.G);
        assertEquals(EfficiencyClass.G, fridgeCharacteristic.getEnergyClass());
    }

    @Test
    void featuresSetterGetterTest() throws Exception {
        String[] f1 = new String[] {"asdhqiowho", "asjdhqwje", "asdjhqwlke"};
        String[] f2 = new String[] {"fghfgrty", "534sdf", "436gsdfd"};
        String[] f3 = new String[] {"asdhqiowho", "asdjhqwlke"};
        String[] f4 = new String[] {"asdhqiowho", "asdjhqwlke"};
        fridgeCharacteristic.setFeatures(f1);
        assertEquals(f1, fridgeCharacteristic.getFeatures());
        fridgeCharacteristic.setFeatures(f2);
        assertEquals(f2, fridgeCharacteristic.getFeatures());
        fridgeCharacteristic.setFeatures(f3);
        assertEquals(f3, fridgeCharacteristic.getFeatures());
        fridgeCharacteristic.setFeatures(f4);
        assertEquals(f4, fridgeCharacteristic.getFeatures());
    }
}