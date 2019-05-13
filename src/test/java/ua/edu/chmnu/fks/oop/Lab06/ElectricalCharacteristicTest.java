package ua.edu.chmnu.fks.oop.Lab06;

import org.junit.jupiter.api.Test;
import ua.edu.chmnu.fks.oop.Lab06.Exceptions.InvalidValueException;
import ua.edu.chmnu.fks.oop.Lab06.Exceptions.NegativeValueException;
import ua.edu.chmnu.fks.oop.Lab06.Exceptions.ZeroValueException;

import static org.junit.jupiter.api.Assertions.*;

class ElectricalCharacteristicTest {

    ElectricalCharacteristic electricalCharacteristic;

    {
        try {
            electricalCharacteristic = new ElectricalCharacteristic(3.3, 1070.3);
        }
        catch (Exception ex){}
    }

    @Test
    void constructorTest() throws InvalidValueException {
        ElectricalCharacteristic electricalCharacteristic1 = new ElectricalCharacteristic(3.3, 1470.3);
        ElectricalCharacteristic electricalCharacteristic2 = new ElectricalCharacteristic(5, 1070.5);
        ElectricalCharacteristic electricalCharacteristic3 = new ElectricalCharacteristic(200, 800);
        assertEquals(3.3, electricalCharacteristic1.getVoltage());
        assertEquals(1470.3, electricalCharacteristic1.getPower());

        assertEquals(5, electricalCharacteristic2.getVoltage());
        assertEquals(1070.5, electricalCharacteristic2.getPower());

        assertEquals(200, electricalCharacteristic3.getVoltage());
        assertEquals(800, electricalCharacteristic3.getPower());

        assertThrows(ZeroValueException.class, () -> new ElectricalCharacteristic(0, 1470.3));
        assertThrows(ZeroValueException.class, () -> new ElectricalCharacteristic(3.3, 0));
        assertThrows(ZeroValueException.class, () -> new ElectricalCharacteristic(0, 0));

        assertThrows(NegativeValueException.class, () -> new ElectricalCharacteristic(-3.3, 1470.3));
        assertThrows(NegativeValueException.class, () -> new ElectricalCharacteristic(3.3, -1470.3));
        assertThrows(NegativeValueException.class, () -> new ElectricalCharacteristic(-3.3, -1470.3));
    }

    @Test
    void voltageSetterGetterTest() throws InvalidValueException {
        electricalCharacteristic.setVoltage(2.3);
        assertEquals(2.3, electricalCharacteristic.getVoltage());
        electricalCharacteristic.setVoltage(4.5);
        assertEquals(4.5, electricalCharacteristic.getVoltage());
        electricalCharacteristic.setVoltage(33.9);
        assertEquals(33.9, electricalCharacteristic.getVoltage());
        electricalCharacteristic.setVoltage(1.7);
        assertEquals(1.7, electricalCharacteristic.getVoltage());

        assertThrows(ZeroValueException.class, () -> electricalCharacteristic.setVoltage(0));
        assertThrows(NegativeValueException.class, () -> electricalCharacteristic.setVoltage(-2));
    }

    @Test
    void powerSetterGetterTest() throws InvalidValueException {
        electricalCharacteristic.setPower(2.3);
        assertEquals(2.3, electricalCharacteristic.getPower());
        electricalCharacteristic.setPower(4.5);
        assertEquals(4.5, electricalCharacteristic.getPower());
        electricalCharacteristic.setPower(33.9);
        assertEquals(33.9, electricalCharacteristic.getPower());
        electricalCharacteristic.setPower(1.7);
        assertEquals(1.7, electricalCharacteristic.getPower());

        assertThrows(ZeroValueException.class, () -> electricalCharacteristic.setPower(0));
        assertThrows(NegativeValueException.class, () -> electricalCharacteristic.setPower(-2));
    }
}