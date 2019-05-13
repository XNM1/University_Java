package ua.edu.chmnu.fks.oop.Lab06;

import org.junit.jupiter.api.Test;
import ua.edu.chmnu.fks.oop.Lab06.Exceptions.BigValueInApplianceException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ElectricalApplianceTest {

    ElectricalAppliance electricalAppliance;
    {
        try {
            PhysicalCharacteristics physicalCharacteristics = mock(PhysicalCharacteristics.class);
            Size size = mock(Size.class);
            when(size.getUnit()).thenReturn(Unit.M);
            when(size.getLength()).thenReturn(0.2);
            when(size.getWidth()).thenReturn(0.2);
            when(size.getHeight()).thenReturn(0.2);
            when(physicalCharacteristics.getSize()).thenReturn(size);
            when(physicalCharacteristics.getWeight()).thenReturn(7.);
            electricalAppliance = new ElectricalAppliance("AAAA", physicalCharacteristics, mock(ElectricalCharacteristic.class), mock(ElectricKettleCharacteristic.class));
        }
        catch (Exception ex) {}
    }

    @Test
    void constructorTest() throws Exception {
        PhysicalCharacteristics physicalCharacteristics = mock(PhysicalCharacteristics.class);
        Size size = mock(Size.class);
        when(size.getUnit()).thenReturn(Unit.M);
        when(size.getLength()).thenReturn(0.2);
        when(size.getWidth()).thenReturn(0.2);
        when(size.getHeight()).thenReturn(0.2);
        when(size.getVolume()).thenReturn(0.008);
        when(physicalCharacteristics.getSize()).thenReturn(size);
        when(physicalCharacteristics.getWeight()).thenReturn(7.);
        ElectricalCharacteristic electricalCharacteristic = mock(ElectricalCharacteristic.class);
        FridgeCharacteristic fridgeCharacteristic = mock(FridgeCharacteristic.class);

        ElectricalAppliance electricalAppliance1 = new ElectricalAppliance("AAAA", physicalCharacteristics, electricalCharacteristic, fridgeCharacteristic);

        assertEquals("AAAA", electricalAppliance1.getName());
        assertEquals(physicalCharacteristics, electricalAppliance1.getPhysicalCharacteristics());
        assertEquals(SizeType.SMALL, electricalAppliance1.getSizeType());
        assertEquals(electricalCharacteristic, electricalAppliance1.getElectricalCharacteristic());
        assertEquals(fridgeCharacteristic, electricalAppliance1.getApplianceCharacteristic());
        assertEquals(ApplianceType.FRIDGE, electricalAppliance1.getApplianceType());

        when(physicalCharacteristics.getSize().getLength()).thenReturn(12.);
        assertThrows(BigValueInApplianceException.class, () -> new ElectricalAppliance("AAAA", physicalCharacteristics, electricalCharacteristic, fridgeCharacteristic));
        when(physicalCharacteristics.getSize().getWidth()).thenReturn(20.);
        assertThrows(BigValueInApplianceException.class, () -> new ElectricalAppliance("BBB", physicalCharacteristics, electricalCharacteristic, fridgeCharacteristic));
        when(physicalCharacteristics.getSize().getHeight()).thenReturn(14.);
        assertThrows(BigValueInApplianceException.class, () -> new ElectricalAppliance("CC", physicalCharacteristics, electricalCharacteristic, fridgeCharacteristic));
        when(physicalCharacteristics.getWeight()).thenReturn(5000.);
        assertThrows(BigValueInApplianceException.class, () -> new ElectricalAppliance("CC", physicalCharacteristics, electricalCharacteristic, fridgeCharacteristic));
    }

    @Test
    void nameSetterGetterTest() throws Exception {
        electricalAppliance.setName("AAAA");
        assertEquals("AAAA", electricalAppliance.getName());
        electricalAppliance.setName("ACCB");
        assertEquals("ACCB", electricalAppliance.getName());
        electricalAppliance.setName("AAAA23");
        assertEquals("AAAA23", electricalAppliance.getName());
        electricalAppliance.setName("aaAA2");
        assertNotEquals("AAAA2", electricalAppliance.getName());
    }

    @Test
    void physicalCharacteristicsSetterGetterTest() throws Exception {
        PhysicalCharacteristics physicalCharacteristics1 = mock(PhysicalCharacteristics.class);
        Size size1 = mock(Size.class);
        when(size1.getUnit()).thenReturn(Unit.M);
        when(size1.getVolume()).thenReturn(0.1);
        when(physicalCharacteristics1.getSize()).thenReturn(size1);
        PhysicalCharacteristics physicalCharacteristics2 = mock(PhysicalCharacteristics.class);
        Size size2 = mock(Size.class);
        when(size2.getUnit()).thenReturn(Unit.M);
        when(size2.getVolume()).thenReturn(2.);
        when(physicalCharacteristics2.getSize()).thenReturn(size2);
        PhysicalCharacteristics physicalCharacteristics3 = mock(PhysicalCharacteristics.class);
        Size size3 = mock(Size.class);
        when(size3.getUnit()).thenReturn(Unit.M);
        when(size3.getVolume()).thenReturn(5.);
        when(physicalCharacteristics3.getSize()).thenReturn(size3);

        PhysicalCharacteristics physicalCharacteristicsE1 = mock(PhysicalCharacteristics.class);
        Size sizeE1 = mock(Size.class);
        when(sizeE1.getUnit()).thenReturn(Unit.M);
        when(sizeE1.getLength()).thenReturn(11.);
        when(sizeE1.getWidth()).thenReturn(0.2);
        when(sizeE1.getHeight()).thenReturn(0.2);
        when(physicalCharacteristicsE1.getSize()).thenReturn(sizeE1);
        when(physicalCharacteristicsE1.getWeight()).thenReturn(7.);
        PhysicalCharacteristics physicalCharacteristicsE2 = mock(PhysicalCharacteristics.class);
        Size sizeE2 = mock(Size.class);
        when(sizeE2.getUnit()).thenReturn(Unit.M);
        when(sizeE2.getLength()).thenReturn(0.2);
        when(sizeE2.getWidth()).thenReturn(11.);
        when(sizeE2.getHeight()).thenReturn(0.2);
        when(physicalCharacteristicsE2.getSize()).thenReturn(sizeE2);
        when(physicalCharacteristicsE2.getWeight()).thenReturn(7.);
        PhysicalCharacteristics physicalCharacteristicsE3 = mock(PhysicalCharacteristics.class);
        Size sizeE3 = mock(Size.class);
        when(sizeE3.getUnit()).thenReturn(Unit.M);
        when(sizeE3.getLength()).thenReturn(0.2);
        when(sizeE3.getWidth()).thenReturn(0.2);
        when(sizeE3.getHeight()).thenReturn(11.);
        when(physicalCharacteristicsE3.getSize()).thenReturn(sizeE3);
        when(physicalCharacteristicsE3.getWeight()).thenReturn(7.);
        PhysicalCharacteristics physicalCharacteristicsE4 = mock(PhysicalCharacteristics.class);
        Size sizeE4 = mock(Size.class);
        when(sizeE4.getUnit()).thenReturn(Unit.M);
        when(sizeE4.getLength()).thenReturn(0.2);
        when(sizeE4.getWidth()).thenReturn(0.2);
        when(sizeE4.getHeight()).thenReturn(0.2);
        when(physicalCharacteristicsE4.getSize()).thenReturn(sizeE4);
        when(physicalCharacteristicsE4.getWeight()).thenReturn(1500.);

        electricalAppliance.setPhysicalCharacteristics(physicalCharacteristics1);
        assertEquals(physicalCharacteristics1, electricalAppliance.getPhysicalCharacteristics());
        assertEquals(SizeType.SMALL, electricalAppliance.getSizeType());

        electricalAppliance.setPhysicalCharacteristics(physicalCharacteristics2);
        assertEquals(physicalCharacteristics2, electricalAppliance.getPhysicalCharacteristics());
        assertEquals(SizeType.MEDIUM, electricalAppliance.getSizeType());

        electricalAppliance.setPhysicalCharacteristics(physicalCharacteristics3);
        assertEquals(physicalCharacteristics3, electricalAppliance.getPhysicalCharacteristics());
        assertEquals(SizeType.BIG, electricalAppliance.getSizeType());

        assertThrows(BigValueInApplianceException.class, () -> electricalAppliance.setPhysicalCharacteristics(physicalCharacteristicsE1));
        assertThrows(BigValueInApplianceException.class, () -> electricalAppliance.setPhysicalCharacteristics(physicalCharacteristicsE2));
        assertThrows(BigValueInApplianceException.class, () -> electricalAppliance.setPhysicalCharacteristics(physicalCharacteristicsE3));
        assertThrows(BigValueInApplianceException.class, () -> electricalAppliance.setPhysicalCharacteristics(physicalCharacteristicsE4));
    }

    @Test
    void electricalCharacteristicSetterGetterTest() throws Exception {
        ElectricalCharacteristic electricalCharacteristic1 = mock(ElectricalCharacteristic.class);
        ElectricalCharacteristic electricalCharacteristic2 = mock(ElectricalCharacteristic.class);
        ElectricalCharacteristic electricalCharacteristic3 = mock(ElectricalCharacteristic.class);

        ElectricalCharacteristic electricalCharacteristicE4 = mock(ElectricalCharacteristic.class);
        when(electricalCharacteristicE4.getPower()).thenReturn(100002.);
        when(electricalCharacteristicE4.getVoltage()).thenReturn(800.);
        ElectricalCharacteristic electricalCharacteristicE5 = mock(ElectricalCharacteristic.class);
        when(electricalCharacteristicE5.getPower()).thenReturn(945.);
        when(electricalCharacteristicE5.getVoltage()).thenReturn(1002.);

        electricalAppliance.setElectricalCharacteristic(electricalCharacteristic1);
        assertEquals(electricalCharacteristic1, electricalAppliance.getElectricalCharacteristic());

        electricalAppliance.setElectricalCharacteristic(electricalCharacteristic2);
        assertEquals(electricalCharacteristic2, electricalAppliance.getElectricalCharacteristic());

        electricalAppliance.setElectricalCharacteristic(electricalCharacteristic3);
        assertEquals(electricalCharacteristic3, electricalAppliance.getElectricalCharacteristic());

        assertThrows(BigValueInApplianceException.class, () -> electricalAppliance.setElectricalCharacteristic(electricalCharacteristicE5));
    }

    @Test
    void applianceCharacteristicSetterGetterTest() throws Exception {
        AirСonditioningCharacteristic airСonditioningCharacteristic = mock(AirСonditioningCharacteristic.class);
        FridgeCharacteristic fridgeCharacteristic = mock(FridgeCharacteristic.class);
        ElectricKettleCharacteristic electricKettleCharacteristic = mock(ElectricKettleCharacteristic.class);
        WasherCharacteristic washerCharacteristic = mock(WasherCharacteristic.class);

        electricalAppliance.setApplianceCharacteristic(airСonditioningCharacteristic);
        assertEquals(airСonditioningCharacteristic, electricalAppliance.getApplianceCharacteristic());
        assertEquals(ApplianceType.AIR_СONDITIONING, electricalAppliance.getApplianceType());

        electricalAppliance.setApplianceCharacteristic(fridgeCharacteristic);
        assertEquals(fridgeCharacteristic, electricalAppliance.getApplianceCharacteristic());
        assertEquals(ApplianceType.FRIDGE, electricalAppliance.getApplianceType());

        electricalAppliance.setApplianceCharacteristic(electricKettleCharacteristic);
        assertEquals(electricKettleCharacteristic, electricalAppliance.getApplianceCharacteristic());
        assertEquals(ApplianceType.ELECTRICAL_KETTLE, electricalAppliance.getApplianceType());

        electricalAppliance.setApplianceCharacteristic(washerCharacteristic);
        assertEquals(washerCharacteristic, electricalAppliance.getApplianceCharacteristic());
        assertEquals(ApplianceType.WASHER, electricalAppliance.getApplianceType());
    }

}