package ua.edu.chmnu.fks.oop.Lab06;

import org.junit.jupiter.api.Test;
import ua.edu.chmnu.fks.oop.Lab06.Exceptions.BigValueInApplianceException;
import ua.edu.chmnu.fks.oop.Lab06.Exceptions.NegativeValueException;
import ua.edu.chmnu.fks.oop.Lab06.Exceptions.ZeroValueException;

import static org.junit.jupiter.api.Assertions.*;

class ElectricKettleCharacteristicTest {

    ElectricKettleCharacteristic electricKettleCharacteristic;

    {
        try {
            electricKettleCharacteristic = new ElectricKettleCharacteristic(EfficiencyClass.E, BodyMaterial.METAL, 2.2, false);
        }
        catch (Exception ex) {}
    }

    @Test
    void constructorTest() throws Exception {
        ElectricKettleCharacteristic electricKettleCharacteristic1 = new ElectricKettleCharacteristic(EfficiencyClass.E, BodyMaterial.METAL, 2.2, false);
        ElectricKettleCharacteristic electricKettleCharacteristic2 = new ElectricKettleCharacteristic(EfficiencyClass.B, BodyMaterial.PLASTIC, 3, true);
        ElectricKettleCharacteristic electricKettleCharacteristic3 = new ElectricKettleCharacteristic(EfficiencyClass.A, BodyMaterial.PLASTIC_METAL, 1.2, false);

        assertEquals(EfficiencyClass.E, electricKettleCharacteristic1.getEnergyClass());
        assertEquals(BodyMaterial.METAL, electricKettleCharacteristic1.getBodyMaterial());
        assertEquals(2.2, electricKettleCharacteristic1.getVolume());
        assertEquals(false, electricKettleCharacteristic1.isWithIndicator());

        assertEquals(EfficiencyClass.B, electricKettleCharacteristic2.getEnergyClass());
        assertEquals(BodyMaterial.PLASTIC, electricKettleCharacteristic2.getBodyMaterial());
        assertEquals(3, electricKettleCharacteristic2.getVolume());
        assertEquals(true, electricKettleCharacteristic2.isWithIndicator());

        assertEquals(EfficiencyClass.A, electricKettleCharacteristic3.getEnergyClass());
        assertEquals(BodyMaterial.PLASTIC_METAL, electricKettleCharacteristic3.getBodyMaterial());
        assertEquals(1.2, electricKettleCharacteristic3.getVolume());
        assertEquals(false, electricKettleCharacteristic3.isWithIndicator());

        assertThrows(ZeroValueException.class, () -> new ElectricKettleCharacteristic(EfficiencyClass.E, BodyMaterial.METAL, 0, false));
        assertThrows(NegativeValueException.class, () -> new ElectricKettleCharacteristic(EfficiencyClass.E, BodyMaterial.METAL, -9, false));
        assertThrows(BigValueInApplianceException.class, () -> new ElectricKettleCharacteristic(EfficiencyClass.E, BodyMaterial.METAL, 5, false));
    }

    @Test
    void constructor2Test() throws Exception {
        String[] f1 = new String[] {"asdhqiowho", "asjdhqwje", "asdjhqwlke"};
        String[] f2 = new String[] {"fghfgrty", "534sdf", "436gsdfd"};
        String[] f3 = new String[] {"asdhqiowho", "asdjhqwlke"};
        ElectricKettleCharacteristic electricKettleCharacteristic1 = new ElectricKettleCharacteristic(EfficiencyClass.E, f1, BodyMaterial.METAL, 2.2, false);
        ElectricKettleCharacteristic electricKettleCharacteristic2 = new ElectricKettleCharacteristic(EfficiencyClass.B, f2, BodyMaterial.PLASTIC, 3, true);
        ElectricKettleCharacteristic electricKettleCharacteristic3 = new ElectricKettleCharacteristic(EfficiencyClass.A, f3, BodyMaterial.PLASTIC_METAL, 1.2, false);

        assertEquals(EfficiencyClass.E, electricKettleCharacteristic1.getEnergyClass());
        assertEquals(BodyMaterial.METAL, electricKettleCharacteristic1.getBodyMaterial());
        assertEquals(2.2, electricKettleCharacteristic1.getVolume());
        assertEquals(false, electricKettleCharacteristic1.isWithIndicator());
        assertEquals(f1, electricKettleCharacteristic1.getFeatures());

        assertEquals(EfficiencyClass.B, electricKettleCharacteristic2.getEnergyClass());
        assertEquals(BodyMaterial.PLASTIC, electricKettleCharacteristic2.getBodyMaterial());
        assertEquals(3, electricKettleCharacteristic2.getVolume());
        assertEquals(true, electricKettleCharacteristic2.isWithIndicator());
        assertEquals(f2, electricKettleCharacteristic2.getFeatures());

        assertEquals(EfficiencyClass.A, electricKettleCharacteristic3.getEnergyClass());
        assertEquals(BodyMaterial.PLASTIC_METAL, electricKettleCharacteristic3.getBodyMaterial());
        assertEquals(1.2, electricKettleCharacteristic3.getVolume());
        assertEquals(false, electricKettleCharacteristic3.isWithIndicator());
        assertEquals(f3, electricKettleCharacteristic3.getFeatures());

        assertThrows(ZeroValueException.class, () -> new ElectricKettleCharacteristic(EfficiencyClass.E, f1, BodyMaterial.METAL, 0, false));
        assertThrows(NegativeValueException.class, () -> new ElectricKettleCharacteristic(EfficiencyClass.E, f2, BodyMaterial.METAL, -9, false));
        assertThrows(BigValueInApplianceException.class, () -> new ElectricKettleCharacteristic(EfficiencyClass.E, f3, BodyMaterial.METAL, 5, false));
    }

    @Test
    void bodyMaterialSetterGetterTest() throws Exception {
        electricKettleCharacteristic.setBodyMaterial(BodyMaterial.METAL);
        assertEquals(BodyMaterial.METAL, electricKettleCharacteristic.getBodyMaterial());
        electricKettleCharacteristic.setBodyMaterial(BodyMaterial.PLASTIC);
        assertEquals(BodyMaterial.PLASTIC, electricKettleCharacteristic.getBodyMaterial());
        electricKettleCharacteristic.setBodyMaterial(BodyMaterial.PLASTIC_METAL);
        assertEquals(BodyMaterial.PLASTIC_METAL, electricKettleCharacteristic.getBodyMaterial());
    }

    @Test
    void volumeSetterGetterTest() throws Exception {
        electricKettleCharacteristic.setVolume(2.3);
        assertEquals(2.3, electricKettleCharacteristic.getVolume());
        electricKettleCharacteristic.setVolume(3);
        assertEquals(3, electricKettleCharacteristic.getVolume());
        electricKettleCharacteristic.setVolume(1.5);
        assertEquals(1.5, electricKettleCharacteristic.getVolume());
        electricKettleCharacteristic.setVolume(1);
        assertEquals(1, electricKettleCharacteristic.getVolume());

        assertThrows(NegativeValueException.class, () -> electricKettleCharacteristic.setVolume(-3.8));
        assertThrows(ZeroValueException.class, () -> electricKettleCharacteristic.setVolume(0));
        assertThrows(BigValueInApplianceException.class, () -> electricKettleCharacteristic.setVolume(5));
    }

    @Test
    void withIndicatorSetterGetterTest() throws Exception {
        electricKettleCharacteristic.setWithIndicator(true);
        assertEquals(true, electricKettleCharacteristic.isWithIndicator());
        electricKettleCharacteristic.setWithIndicator(false);
        assertEquals(false, electricKettleCharacteristic.isWithIndicator());
    }

    @Test
    void energyClassSetterGetterTest() throws Exception {
        electricKettleCharacteristic.setEnergyClass(EfficiencyClass.APPP);
        assertEquals(EfficiencyClass.APPP, electricKettleCharacteristic.getEnergyClass());
        electricKettleCharacteristic.setEnergyClass(EfficiencyClass.APP);
        assertEquals(EfficiencyClass.APP, electricKettleCharacteristic.getEnergyClass());
        electricKettleCharacteristic.setEnergyClass(EfficiencyClass.AP);
        assertEquals(EfficiencyClass.AP, electricKettleCharacteristic.getEnergyClass());
        electricKettleCharacteristic.setEnergyClass(EfficiencyClass.A);
        assertEquals(EfficiencyClass.A, electricKettleCharacteristic.getEnergyClass());
        electricKettleCharacteristic.setEnergyClass(EfficiencyClass.B);
        assertEquals(EfficiencyClass.B, electricKettleCharacteristic.getEnergyClass());
        electricKettleCharacteristic.setEnergyClass(EfficiencyClass.C);
        assertEquals(EfficiencyClass.C, electricKettleCharacteristic.getEnergyClass());
        electricKettleCharacteristic.setEnergyClass(EfficiencyClass.D);
        assertEquals(EfficiencyClass.D, electricKettleCharacteristic.getEnergyClass());
        electricKettleCharacteristic.setEnergyClass(EfficiencyClass.E);
        assertEquals(EfficiencyClass.E, electricKettleCharacteristic.getEnergyClass());
        electricKettleCharacteristic.setEnergyClass(EfficiencyClass.F);
        assertEquals(EfficiencyClass.F, electricKettleCharacteristic.getEnergyClass());
        electricKettleCharacteristic.setEnergyClass(EfficiencyClass.G);
        assertEquals(EfficiencyClass.G, electricKettleCharacteristic.getEnergyClass());
    }

    @Test
    void featuresSetterGetterTest() throws Exception {
        String[] f1 = new String[] {"asdhqiowho", "asjdhqwje", "asdjhqwlke"};
        String[] f2 = new String[] {"fghfgrty", "534sdf", "436gsdfd"};
        String[] f3 = new String[] {"asdhqiowho", "asdjhqwlke"};
        String[] f4 = new String[] {"asdhqiowho", "asdjhqwlke"};
        electricKettleCharacteristic.setFeatures(f1);
        assertEquals(f1, electricKettleCharacteristic.getFeatures());
        electricKettleCharacteristic.setFeatures(f2);
        assertEquals(f2, electricKettleCharacteristic.getFeatures());
        electricKettleCharacteristic.setFeatures(f3);
        assertEquals(f3, electricKettleCharacteristic.getFeatures());
        electricKettleCharacteristic.setFeatures(f4);
        assertEquals(f4, electricKettleCharacteristic.getFeatures());
    }
}