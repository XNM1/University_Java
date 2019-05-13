package ua.edu.chmnu.fks.oop.Lab06;

import org.junit.jupiter.api.Test;
import ua.edu.chmnu.fks.oop.Lab06.Exceptions.BigValueInApplianceException;
import ua.edu.chmnu.fks.oop.Lab06.Exceptions.NegativeValueException;
import ua.edu.chmnu.fks.oop.Lab06.Exceptions.ZeroValueException;

import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class AirСonditioningCharacteristicTest {

    AirСonditioningCharacteristic airСonditioningCharacteristic;

    {
        try {
            airСonditioningCharacteristic = new AirСonditioningCharacteristic(EfficiencyClass.A, CompressorType.INVERTER_LINEAR, 1, "R1312", 400, 400);
        }
        catch (Exception ex) {}
    }

    @Test
    void constructorTest() throws Exception {
        AirСonditioningCharacteristic airСonditioningCharacteristic = new AirСonditioningCharacteristic(EfficiencyClass.A, CompressorType.INVERTER_LINEAR, 1, "R1312", 400, 420);
        assertEquals(EfficiencyClass.A, airСonditioningCharacteristic.getEnergyClass());
        assertEquals(CompressorType.INVERTER_LINEAR, airСonditioningCharacteristic.getCompressorType());
        assertEquals(1, airСonditioningCharacteristic.getFloorArea());
        assertEquals("R1312", airСonditioningCharacteristic.getFreonType());
        assertEquals(420, airСonditioningCharacteristic.getHeatProductivityBTU());
        assertEquals(400, airСonditioningCharacteristic.getColdProductivityBTU());

        assertThrows(ZeroValueException.class, () -> new AirСonditioningCharacteristic(EfficiencyClass.A, CompressorType.INVERTER_LINEAR, 0, "R1312", 400, 420));
        assertThrows(NegativeValueException.class, () -> new AirСonditioningCharacteristic(EfficiencyClass.A, CompressorType.INVERTER_LINEAR, 1, "R1312", 400, -420));
        assertThrows(BigValueInApplianceException.class, () -> new AirСonditioningCharacteristic(EfficiencyClass.A, CompressorType.INVERTER_LINEAR, 1, "R1312", 100001, 420));
    }

    @Test
    void constructor2Test() throws Exception {
        String[] f1 = new String[] {"asdhqiowho", "asjdhqwje", "asdjhqwlke"};
        AirСonditioningCharacteristic airСonditioningCharacteristic = new AirСonditioningCharacteristic(EfficiencyClass.A, f1, CompressorType.INVERTER_LINEAR, 1, "R1312", 400, 420);
        assertEquals(EfficiencyClass.A, airСonditioningCharacteristic.getEnergyClass());
        assertEquals(CompressorType.INVERTER_LINEAR, airСonditioningCharacteristic.getCompressorType());
        assertEquals(1, airСonditioningCharacteristic.getFloorArea());
        assertEquals("R1312", airСonditioningCharacteristic.getFreonType());
        assertEquals(420, airСonditioningCharacteristic.getHeatProductivityBTU());
        assertEquals(400, airСonditioningCharacteristic.getColdProductivityBTU());
        assertEquals(f1, airСonditioningCharacteristic.getFeatures());

        assertThrows(ZeroValueException.class, () -> new AirСonditioningCharacteristic(EfficiencyClass.A, f1, CompressorType.INVERTER_LINEAR, 0, "R1312", 400, 420));
        assertThrows(NegativeValueException.class, () -> new AirСonditioningCharacteristic(EfficiencyClass.A, f1, CompressorType.INVERTER_LINEAR, 1, "R1312", 400, -420));
        assertThrows(BigValueInApplianceException.class, () -> new AirСonditioningCharacteristic(EfficiencyClass.A, f1, CompressorType.INVERTER_LINEAR, 1, "R1312", 100001, 420));
    }

    @Test
    void compressorTypeSetterGetterTest() throws Exception {
        airСonditioningCharacteristic.setCompressorType(CompressorType.INVERTER_LINEAR);
        assertEquals(CompressorType.INVERTER_LINEAR, airСonditioningCharacteristic.getCompressorType());
        airСonditioningCharacteristic.setCompressorType(CompressorType.INVERTOR);
        assertEquals(CompressorType.INVERTOR, airСonditioningCharacteristic.getCompressorType());
        airСonditioningCharacteristic.setCompressorType(CompressorType.LINEAR);
        assertEquals(CompressorType.LINEAR, airСonditioningCharacteristic.getCompressorType());
        airСonditioningCharacteristic.setCompressorType(CompressorType.USUAL);
        assertEquals(CompressorType.USUAL, airСonditioningCharacteristic.getCompressorType());
    }

    @Test
    void floorAreaSetterGetterTest() throws Exception {
        airСonditioningCharacteristic.setFloorArea(2);
        assertEquals(2, airСonditioningCharacteristic.getFloorArea());
        airСonditioningCharacteristic.setFloorArea(299);
        assertEquals(299, airСonditioningCharacteristic.getFloorArea());
        airСonditioningCharacteristic.setFloorArea(43);
        assertEquals(43, airСonditioningCharacteristic.getFloorArea());
        airСonditioningCharacteristic.setFloorArea(35);
        assertEquals(35, airСonditioningCharacteristic.getFloorArea());

        assertThrows(NegativeValueException.class, () -> airСonditioningCharacteristic.setFloorArea(-3));
        assertThrows(ZeroValueException.class, () -> airСonditioningCharacteristic.setFloorArea(0));
        assertThrows(BigValueInApplianceException.class, () -> airСonditioningCharacteristic.setFloorArea(100001));
    }

    @Test
    void freonTypeSetterGetterTest() throws Exception {
        airСonditioningCharacteristic.setFreonType("R123");
        assertEquals("R123", airСonditioningCharacteristic.getFreonType());
        airСonditioningCharacteristic.setFreonType("R745");
        assertEquals("R745", airСonditioningCharacteristic.getFreonType());
        airСonditioningCharacteristic.setFreonType("R3454");
        assertEquals("R3454", airСonditioningCharacteristic.getFreonType());
        airСonditioningCharacteristic.setFreonType("R234");
        assertEquals("R234", airСonditioningCharacteristic.getFreonType());
    }

    @Test
    void coldProductivityBTUSetterGetterTest() throws Exception {
        airСonditioningCharacteristic.setColdProductivityBTU(2);
        assertEquals(2, airСonditioningCharacteristic.getColdProductivityBTU());
        airСonditioningCharacteristic.setColdProductivityBTU(299);
        assertEquals(299, airСonditioningCharacteristic.getColdProductivityBTU());
        airСonditioningCharacteristic.setColdProductivityBTU(43);
        assertEquals(43, airСonditioningCharacteristic.getColdProductivityBTU());
        airСonditioningCharacteristic.setColdProductivityBTU(35);
        assertEquals(35, airСonditioningCharacteristic.getColdProductivityBTU());

        assertThrows(NegativeValueException.class, () -> airСonditioningCharacteristic.setColdProductivityBTU(-3));
        assertThrows(ZeroValueException.class, () -> airСonditioningCharacteristic.setColdProductivityBTU(0));
        assertThrows(BigValueInApplianceException.class, () -> airСonditioningCharacteristic.setColdProductivityBTU(100001));
    }

    @Test
    void heatProductivityBTUSetterGetterTest() throws Exception {
        airСonditioningCharacteristic.setHeatProductivityBTU(2);
        assertEquals(2, airСonditioningCharacteristic.getHeatProductivityBTU());
        airСonditioningCharacteristic.setHeatProductivityBTU(299);
        assertEquals(299, airСonditioningCharacteristic.getHeatProductivityBTU());
        airСonditioningCharacteristic.setHeatProductivityBTU(43);
        assertEquals(43, airСonditioningCharacteristic.getHeatProductivityBTU());
        airСonditioningCharacteristic.setHeatProductivityBTU(35);
        assertEquals(35, airСonditioningCharacteristic.getHeatProductivityBTU());

        assertThrows(NegativeValueException.class, () -> airСonditioningCharacteristic.setHeatProductivityBTU(-3));
        assertThrows(ZeroValueException.class, () -> airСonditioningCharacteristic.setHeatProductivityBTU(0));
        assertThrows(BigValueInApplianceException.class, () -> airСonditioningCharacteristic.setHeatProductivityBTU(100001));
    }

    @Test
    void energyClassSetterGetterTest() throws Exception {
        airСonditioningCharacteristic.setEnergyClass(EfficiencyClass.APPP);
        assertEquals(EfficiencyClass.APPP, airСonditioningCharacteristic.getEnergyClass());
        airСonditioningCharacteristic.setEnergyClass(EfficiencyClass.APP);
        assertEquals(EfficiencyClass.APP, airСonditioningCharacteristic.getEnergyClass());
        airСonditioningCharacteristic.setEnergyClass(EfficiencyClass.AP);
        assertEquals(EfficiencyClass.AP, airСonditioningCharacteristic.getEnergyClass());
        airСonditioningCharacteristic.setEnergyClass(EfficiencyClass.A);
        assertEquals(EfficiencyClass.A, airСonditioningCharacteristic.getEnergyClass());
        airСonditioningCharacteristic.setEnergyClass(EfficiencyClass.B);
        assertEquals(EfficiencyClass.B, airСonditioningCharacteristic.getEnergyClass());
        airСonditioningCharacteristic.setEnergyClass(EfficiencyClass.C);
        assertEquals(EfficiencyClass.C, airСonditioningCharacteristic.getEnergyClass());
        airСonditioningCharacteristic.setEnergyClass(EfficiencyClass.D);
        assertEquals(EfficiencyClass.D, airСonditioningCharacteristic.getEnergyClass());
        airСonditioningCharacteristic.setEnergyClass(EfficiencyClass.E);
        assertEquals(EfficiencyClass.E, airСonditioningCharacteristic.getEnergyClass());
        airСonditioningCharacteristic.setEnergyClass(EfficiencyClass.F);
        assertEquals(EfficiencyClass.F, airСonditioningCharacteristic.getEnergyClass());
        airСonditioningCharacteristic.setEnergyClass(EfficiencyClass.G);
        assertEquals(EfficiencyClass.G, airСonditioningCharacteristic.getEnergyClass());
    }

    @Test
    void featuresSetterGetterTest() throws Exception {
        String[] f1 = new String[] {"asdhqiowho", "asjdhqwje", "asdjhqwlke"};
        String[] f2 = new String[] {"fghfgrty", "534sdf", "436gsdfd"};
        String[] f3 = new String[] {"asdhqiowho", "asdjhqwlke"};
        String[] f4 = new String[] {"asdhqiowho", "asdjhqwlke"};
        airСonditioningCharacteristic.setFeatures(f1);
        assertEquals(f1, airСonditioningCharacteristic.getFeatures());
        airСonditioningCharacteristic.setFeatures(f2);
        assertEquals(f2, airСonditioningCharacteristic.getFeatures());
        airСonditioningCharacteristic.setFeatures(f3);
        assertEquals(f3, airСonditioningCharacteristic.getFeatures());
        airСonditioningCharacteristic.setFeatures(f4);
        assertEquals(f4, airСonditioningCharacteristic.getFeatures());
    }
}