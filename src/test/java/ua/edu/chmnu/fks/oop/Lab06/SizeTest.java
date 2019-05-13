package ua.edu.chmnu.fks.oop.Lab06;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import ua.edu.chmnu.fks.oop.Lab06.Exceptions.InvalidValueException;
import ua.edu.chmnu.fks.oop.Lab06.Exceptions.NegativeValueException;
import ua.edu.chmnu.fks.oop.Lab06.Exceptions.ZeroValueException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SizeTest {

    private final double accuracy = 0.001;
    private Size size;

    {
        try {
            size = new Size(1, 2, 3, Unit.M);
        }
        catch (Exception ex){}
    }

    @Test
    void constructorTest() throws InvalidValueException {
        Size size1 = new Size(1, 2, 3, Unit.M);
        Size size2 = new Size(4, 2.3, 34.1, Unit.CM);
        Size size3 = new Size(4444, 123.1, 222.7, Unit.DM);
        assertEquals(1, size1.getLength());
        assertEquals(2, size1.getWidth());
        assertEquals(3, size1.getHeight());
        assertEquals(Unit.M, size1.getUnit());
        /////////////////
        assertEquals(4, size2.getLength());
        assertEquals(2.3, size2.getWidth());
        assertEquals(34.1, size2.getHeight());
        assertEquals(Unit.CM, size2.getUnit());
        /////////////////
        assertEquals(4444, size3.getLength());
        assertEquals(123.1, size3.getWidth());
        assertEquals(222.7, size3.getHeight());
        assertEquals(Unit.DM, size3.getUnit());

        assertThrows(ZeroValueException.class, () -> new Size(0, 2, 3, Unit.CM));
        assertThrows(ZeroValueException.class, () -> new Size(1, 0, 3, Unit.DM));
        assertThrows(ZeroValueException.class, () -> new Size(1, 2, 0, Unit.M));
        assertThrows(ZeroValueException.class, () -> new Size(0, 2, 0, Unit.M));
        ////
        assertThrows(NegativeValueException.class, () -> new Size(-24., 2, 3, Unit.DM));
        assertThrows(NegativeValueException.class, () -> new Size(1, -23.2, 3, Unit.CM));
        assertThrows(NegativeValueException.class, () -> new Size(1, 2, -43, Unit.M));
        assertThrows(NegativeValueException.class, () -> new Size(1, -2, -3, Unit.M));
        assertThrows(NegativeValueException.class, () -> new Size(1, -2, 0, Unit.M));
    }

    @Test
    void unitSetterGetterTest() throws InvalidValueException {
        size.setUnit(Unit.M);
        assertEquals(Unit.M, size.getUnit());
        size.setUnit(Unit.CM);
        assertEquals(Unit.CM, size.getUnit());
        size.setUnit(Unit.MM);
        assertEquals(Unit.MM, size.getUnit());
        size.setUnit(Unit.DM);
        assertEquals(Unit.DM, size.getUnit());
    }

    @Test
    void heightSetterGetterTest() throws Exception {
        size.setHeight(2.3);
        assertEquals(2.3, size.getHeight());
        size.setHeight(4.5);
        assertEquals(4.5, size.getHeight());
        size.setHeight(33.9);
        assertEquals(33.9, size.getHeight());
        size.setHeight(1.7);
        assertEquals(1.7, size.getHeight());

        assertThrows(ZeroValueException.class, () -> size.setHeight(0));
        assertThrows(NegativeValueException.class, () -> size.setHeight(-2));
    }

    @Test
    void widthSetterGetterTest() throws Exception  {
        size.setWidth(2.3);
        assertEquals(2.3, size.getWidth());
        size.setWidth(4.5);
        assertEquals(4.5, size.getWidth());
        size.setWidth(33.9);
        assertEquals(33.9, size.getWidth());
        size.setWidth(1.7);
        assertEquals(1.7, size.getWidth());

        assertThrows(ZeroValueException.class, () -> size.setWidth(0));
        assertThrows(NegativeValueException.class, () -> size.setWidth(-2));
    }

    @Test
    void lengthSetterGetterTest() throws Exception {
        size.setLength(2.3);
        assertEquals(2.3, size.getLength());
        size.setLength(4.5);
        assertEquals(4.5, size.getLength());
        size.setLength(33.9);
        assertEquals(33.9, size.getLength());
        size.setLength(1.7);
        assertEquals(1.7, size.getLength());

        assertThrows(ZeroValueException.class, () -> size.setLength(0));
        assertThrows(NegativeValueException.class, () -> size.setLength(-2));
    }

    @Test
    void getVolumeTest() throws InvalidValueException {
        assertEquals(6, size.getVolume());
        size.setLength(2.2);
        size.setWidth(3.3);
        size.setHeight(4.4);
        boolean isEq = false;
        if (Math.abs(31.944 - size.getVolume()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);

        size.setLength(29.1);
        size.setWidth(94.1);
        size.setHeight(23.7);
        isEq = false;
        if (Math.abs(64897.947 - size.getVolume()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);
    }
}