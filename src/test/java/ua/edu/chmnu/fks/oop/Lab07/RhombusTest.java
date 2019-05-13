package ua.edu.chmnu.fks.oop.Lab07;

import org.junit.jupiter.api.Test;
import ua.edu.chmnu.fks.oop.Lab07.Exceptions.*;

import static org.junit.jupiter.api.Assertions.*;

class RhombusTest {
    private final double accuracy = 0.001;
    private Rhombus rhombus;

    {
        try {
            rhombus = new Rhombus(3.3, 23);
        }
        catch (Exception ex){}
    }

    @Test
    void constructorTest() throws FigureException {
        Rhombus rhombus1 = new Rhombus(3.3, 98);
        Rhombus rhombus2 = new Rhombus(23.8, 3);
        Rhombus rhombus3 = new Rhombus(356, 34.9);

        assertEquals(3.3, rhombus1.getA());
        assertEquals(98, rhombus1.getAlpha());

        assertEquals(23.8, rhombus2.getA());
        assertEquals(3, rhombus2.getAlpha());

        assertEquals(356, rhombus3.getA());
        assertEquals(34.9, rhombus3.getAlpha());

        assertThrows(ZeroValueException.class, () -> new Rhombus(0, 42.6));
        assertThrows(ZeroValueException.class, () -> new Rhombus(3.3, 0));
        assertThrows(ZeroValueException.class, () -> new Rhombus(0, 0));

        assertThrows(NegativeValueException.class, () -> new Rhombus(-3.3, 42.6));
        assertThrows(NegativeValueException.class, () -> new Rhombus(3.3, -42.6));
        assertThrows(InvalidFigureException.class, () -> new Rhombus(-42.6, 234.9));
    }

    @Test
    void aSetterGetterTest() throws FigureException {
        rhombus.setA(2.3);
        assertEquals(2.3, rhombus.getA());
        rhombus.setA(4.5);
        assertEquals(4.5, rhombus.getA());
        rhombus.setA(33.9);
        assertEquals(33.9, rhombus.getA());
        rhombus.setA(1.7);
        assertEquals(1.7, rhombus.getA());

        assertThrows(ZeroValueException.class, () -> rhombus.setA(0));
        assertThrows(NegativeValueException.class, () -> rhombus.setA(-2));
    }

    @Test
    void alphaSetterGetterTest() throws FigureException {
        rhombus.setAlpha(2.3);
        assertEquals(2.3, rhombus.getAlpha());
        rhombus.setAlpha(4.5);
        assertEquals(4.5, rhombus.getAlpha());
        rhombus.setAlpha(33.9);
        assertEquals(33.9, rhombus.getAlpha());
        rhombus.setAlpha(1.7);
        assertEquals(1.7, rhombus.getAlpha());

        assertThrows(ZeroValueException.class, () -> rhombus.setAlpha(0));
        assertThrows(NegativeValueException.class, () -> rhombus.setAlpha(-2));
        assertThrows(FigureException.class, () -> rhombus.setAlpha(182));
    }

    @Test
    void areaTest() throws FigureException {
        rhombus.setA(2.3);
        rhombus.setAlpha(57);
        boolean isEq = false;
        if (Math.abs(4.436 - rhombus.area()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);

        rhombus.setA(32.4);
        rhombus.setAlpha(90);
        isEq = false;
        if (Math.abs(1049.76 - rhombus.area()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);

        rhombus.setA(7);
        rhombus.setAlpha(23);
        isEq = false;
        if (Math.abs(19.145 - rhombus.area()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);
    }

    @Test
    void perimeterTest() throws InvalidValueException {
        rhombus.setA(2.3);
        boolean isEq = false;
        if (Math.abs(9.2 - rhombus.perimeter()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);

        rhombus.setA(32.4);
        isEq = false;
        if (Math.abs(129.6 - rhombus.perimeter()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);

        rhombus.setA(7);
        isEq = false;
        if (Math.abs(28 - rhombus.perimeter()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);
    }
}