package ua.edu.chmnu.fks.oop.Lab06;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import ua.edu.chmnu.fks.oop.Lab06.Exceptions.InvalidValueException;
import ua.edu.chmnu.fks.oop.Lab06.Exceptions.NegativeValueException;
import ua.edu.chmnu.fks.oop.Lab06.Exceptions.ZeroValueException;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class PhysicalCharacteristicsTest {

    private PhysicalCharacteristics physicalCharacteristics;
    Color color1 = mock(Color.class);
    Size size = mock(Size.class);

    {
        try {
            physicalCharacteristics = new PhysicalCharacteristics(color1, 3.2, size);
        }
        catch (Exception ex){}
    }

    @Test
    void constructorTest() throws InvalidValueException {
        Color color1 = mock(Color.class);
        Size size = mock(Size.class);
        when(size.getUnit()).thenReturn(Unit.M);

        PhysicalCharacteristics physicalCharacteristics = new PhysicalCharacteristics(color1, 3.2, size);
        assertEquals(3.2, physicalCharacteristics.getWeight());
        assertEquals(size, physicalCharacteristics.getSize());
        assertEquals(Unit.M, physicalCharacteristics.getSize().getUnit());
        assertEquals(color1, physicalCharacteristics.getColor());

        assertThrows(NegativeValueException.class, () -> new PhysicalCharacteristics(color1, -3.2, size));
        assertThrows(ZeroValueException.class, () -> new PhysicalCharacteristics(color1, 0, size));
    }

    @Test
    void constructor2Test() throws InvalidValueException {
        Color color1 = mock(Color.class);

        PhysicalCharacteristics physicalCharacteristics = new PhysicalCharacteristics(color1, 3.2, 1.9, 23, 12.9, Unit.CM);
        assertEquals(3.2, physicalCharacteristics.getWeight());
        assertEquals(1.9, physicalCharacteristics.getSize().getLength());
        assertEquals(23, physicalCharacteristics.getSize().getWidth());
        assertEquals(12.9, physicalCharacteristics.getSize().getHeight());
        assertEquals(Unit.CM, physicalCharacteristics.getSize().getUnit());
        assertEquals(color1, physicalCharacteristics.getColor());

        assertThrows(NegativeValueException.class, () -> new PhysicalCharacteristics(color1, -3.2, 1.9, 23, 12.9, Unit.CM));
        assertThrows(ZeroValueException.class, () -> new PhysicalCharacteristics(color1, 0, 1.9, 23, 12.9, Unit.CM));

        assertThrows(NegativeValueException.class, () -> new PhysicalCharacteristics(color1, 3.2, -1.9, 23, 12.9, Unit.CM));
        assertThrows(NegativeValueException.class, () -> new PhysicalCharacteristics(color1, 3.2, 1.9, -23, 12.9, Unit.CM));
        assertThrows(NegativeValueException.class, () -> new PhysicalCharacteristics(color1, 3.2, 1.9, 23, -12.9, Unit.CM));
        assertThrows(NegativeValueException.class, () -> new PhysicalCharacteristics(color1, 3.2, 1.9, -23, -12.9, Unit.CM));

        assertThrows(ZeroValueException.class, () -> new PhysicalCharacteristics(color1, 3.2, 0, 23, 12.9, Unit.CM));
        assertThrows(ZeroValueException.class, () -> new PhysicalCharacteristics(color1, 3.2, 1.9, 0, 12.9, Unit.CM));
        assertThrows(ZeroValueException.class, () -> new PhysicalCharacteristics(color1, 3.2, 1.9, 23, 0, Unit.CM));
        assertThrows(ZeroValueException.class, () -> new PhysicalCharacteristics(color1, 3.2, 0, 23, 0, Unit.CM));
    }

    @Test
    void colorSetterGetterTest() throws InvalidValueException {
        Color color1 = mock(Color.class);
        Color color2 = mock(Color.class);
        Color color3 = mock(Color.class);
        Color color4 = mock(Color.class);
        physicalCharacteristics.setColor(color1);
        assertEquals(color1, physicalCharacteristics.getColor());
        physicalCharacteristics.setColor(color2);
        assertEquals(color2, physicalCharacteristics.getColor());
        physicalCharacteristics.setColor(color3);
        assertEquals(color3, physicalCharacteristics.getColor());
        physicalCharacteristics.setColor(color4);
        assertEquals(color4, physicalCharacteristics.getColor());
    }

    @Test
    void weightSetterGetterTest() throws InvalidValueException {
        physicalCharacteristics.setWeight(2.3);
        assertEquals(2.3, physicalCharacteristics.getWeight());
        physicalCharacteristics.setWeight(299.3);
        assertEquals(299.3, physicalCharacteristics.getWeight());
        physicalCharacteristics.setWeight(43.5);
        assertEquals(43.5, physicalCharacteristics.getWeight());
        physicalCharacteristics.setWeight(35.2);
        assertEquals(35.2, physicalCharacteristics.getWeight());

        assertThrows(NegativeValueException.class, () -> physicalCharacteristics.setWeight(-3.8));
        assertThrows(ZeroValueException.class, () -> physicalCharacteristics.setWeight(0));
    }

    @Test
    void sizeSetterGetterTest() throws InvalidValueException {
        Size size1 = mock(Size.class);
        Size size2 = mock(Size.class);
        Size size3 = mock(Size.class);
        Size size4 = mock(Size.class);
        physicalCharacteristics.setSize(size1);
        assertEquals(size1, physicalCharacteristics.getSize());
        physicalCharacteristics.setSize(size2);
        assertEquals(size2, physicalCharacteristics.getSize());
        physicalCharacteristics.setSize(size3);
        assertEquals(size3, physicalCharacteristics.getSize());
        physicalCharacteristics.setSize(size4);
        assertEquals(size4, physicalCharacteristics.getSize());
    }

    @Test
    void size2SetterGetterTest() throws InvalidValueException {
        physicalCharacteristics.setSize(1.5, 3.7, 9.2, Unit.M);
        assertEquals(1.5, physicalCharacteristics.getSize().getLength());
        assertEquals(3.7, physicalCharacteristics.getSize().getWidth());
        assertEquals(9.2, physicalCharacteristics.getSize().getHeight());
        assertEquals(Unit.M, physicalCharacteristics.getSize().getUnit());

        assertThrows(NegativeValueException.class, () -> physicalCharacteristics.setSize(-3.8, 2, 3, Unit.M));
        assertThrows(NegativeValueException.class, () -> physicalCharacteristics.setSize(3.8, -2, 3, Unit.M));
        assertThrows(NegativeValueException.class, () -> physicalCharacteristics.setSize(3.8, 2, -3, Unit.M));
        assertThrows(NegativeValueException.class, () -> physicalCharacteristics.setSize(-3.8, 2, -3, Unit.M));

        assertThrows(ZeroValueException.class, () -> physicalCharacteristics.setSize(0, 2, 3, Unit.M));
        assertThrows(ZeroValueException.class, () -> physicalCharacteristics.setSize(3.8, 0, 3, Unit.M));
        assertThrows(ZeroValueException.class, () -> physicalCharacteristics.setSize(3.8, 2, 0, Unit.M));
        assertThrows(ZeroValueException.class, () -> physicalCharacteristics.setSize(3.8, 0, 0, Unit.M));
    }
}