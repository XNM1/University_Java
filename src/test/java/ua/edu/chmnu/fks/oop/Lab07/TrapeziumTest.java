package ua.edu.chmnu.fks.oop.Lab07;

import org.junit.jupiter.api.Test;
import ua.edu.chmnu.fks.oop.Lab07.Exceptions.*;

import static org.junit.jupiter.api.Assertions.*;

class TrapeziumTest {
    private final double accuracy = 0.001;
    private Trapezium trapezium;

    {
        try {
            trapezium = new Trapezium(3.3, 2.2, 5, 1);
        }
        catch (Exception ex){}
    }

    @Test
    void constructorTest() throws FigureException {
        Trapezium trapezium1 = new Trapezium(2.3, 4, 3, 2);
        Trapezium trapezium2 = new Trapezium(1.2, 3, 2, 1.7);
        Trapezium trapezium3 = new Trapezium(7, 7, 11, 2);

        assertEquals(2.3, trapezium1.getA());
        assertEquals(4, trapezium1.getB());
        assertEquals(3, trapezium1.getC());
        assertEquals(2, trapezium1.getD());

        assertEquals(1.2, trapezium2.getA());
        assertEquals(3, trapezium2.getB());
        assertEquals(2, trapezium2.getC());
        assertEquals(1.7, trapezium2.getD());

        assertEquals(7, trapezium3.getA());
        assertEquals(7, trapezium3.getB());
        assertEquals(11, trapezium3.getC());
        assertEquals(2, trapezium3.getD());

        assertThrows(ZeroValueException.class, () -> new Trapezium(0, 4, 3, 2));
        assertThrows(ZeroValueException.class, () -> new Trapezium(2.3, 0, 3, 2));
        assertThrows(ZeroValueException.class, () -> new Trapezium(2.3, 4, 0, 2));
        assertThrows(ZeroValueException.class, () -> new Trapezium(2.3, 4, 3, 0));
        assertThrows(ZeroValueException.class, () -> new Trapezium(2.3, 0, 0, 2));

        assertThrows(NegativeValueException.class, () -> new Trapezium(-2.3, 4, 3, 2));
        assertThrows(NegativeValueException.class, () -> new Trapezium(2.3, -4, 3, 2));
        assertThrows(NegativeValueException.class, () -> new Trapezium(2.3, 4, -3, 2));
        assertThrows(NegativeValueException.class, () -> new Trapezium(2.3, 4, 3, -2));
        assertThrows(NegativeValueException.class, () -> new Trapezium(2.3, -4, 3, -2));
        assertThrows(InvalidFigureException.class, () -> new Trapezium(22.3, 4, 3, 2));
    }

    @Test
    void aSetterGetterTest() throws FigureException {
        trapezium.setA(2.3);
        assertEquals(2.3, trapezium.getA());
        trapezium.setA(4.5);
        assertEquals(4.5, trapezium.getA());
        trapezium.setA(2.9);
        assertEquals(2.9, trapezium.getA());
        trapezium.setA(5.7);
        assertEquals(5.7, trapezium.getA());

        assertThrows(ZeroValueException.class, () -> trapezium.setA(0));
        assertThrows(NegativeValueException.class, () -> trapezium.setA(-2));
        assertThrows(InvalidFigureException.class, () -> trapezium.setA(1234));
    }

    @Test
    void bSetterGetterTest() throws FigureException {
        trapezium.setB(2.3);
        assertEquals(2.3, trapezium.getB());
        trapezium.setB(4.5);
        assertEquals(4.5, trapezium.getB());
        trapezium.setB(2.9);
        assertEquals(2.9, trapezium.getB());
        trapezium.setB(5.7);
        assertEquals(5.7, trapezium.getB());

        assertThrows(ZeroValueException.class, () -> trapezium.setB(0));
        assertThrows(NegativeValueException.class, () -> trapezium.setB(-2));
        assertThrows(InvalidFigureException.class, () -> trapezium.setB(1234));
    }

    @Test
    void cSetterGetterTest() throws FigureException {
        trapezium.setC(2.3);
        assertEquals(2.3, trapezium.getC());
        trapezium.setC(4.5);
        assertEquals(4.5, trapezium.getC());
        trapezium.setC(2.9);
        assertEquals(2.9, trapezium.getC());
        trapezium.setC(5.7);
        assertEquals(5.7, trapezium.getC());

        assertThrows(ZeroValueException.class, () -> trapezium.setC(0));
        assertThrows(NegativeValueException.class, () -> trapezium.setC(-2));
        assertThrows(InvalidFigureException.class, () -> trapezium.setC(1234));
    }

    @Test
    void dSetterGetterTest() throws FigureException {
        trapezium.setD(2.3);
        assertEquals(2.3, trapezium.getD());
        trapezium.setD(4.5);
        assertEquals(4.5, trapezium.getD());
        trapezium.setD(2.9);
        assertEquals(2.9, trapezium.getD());
        trapezium.setD(5.7);
        assertEquals(5.7, trapezium.getD());

        assertThrows(ZeroValueException.class, () -> trapezium.setD(0));
        assertThrows(NegativeValueException.class, () -> trapezium.setD(-2));
        assertThrows(InvalidFigureException.class, () -> trapezium.setD(1234));
    }


    @Test
    void areaTest() throws FigureException {
        trapezium = new Trapezium(2.3, 4, 3, 2);
        boolean isEq = false;
        if (Math.abs(6.897 - trapezium.area()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);

        trapezium = new Trapezium(1.2, 3, 2, 1.7);
        isEq = false;
        if (Math.abs(2.708 - trapezium.area()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);

        trapezium = new Trapezium(7, 7, 11, 2);
        isEq = false;
        if (Math.abs(23.344 - trapezium.area()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);
    }

    @Test
    void perimeterTest() throws FigureException {
        trapezium = new Trapezium(2.3, 4, 3, 2);
        boolean isEq = false;
        if (Math.abs(11.3 - trapezium.perimeter()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);

        trapezium = new Trapezium(1.2, 3, 2, 1.7);
        isEq = false;
        if (Math.abs(7.9 - trapezium.perimeter()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);

        trapezium = new Trapezium(7, 7, 11, 2);
        isEq = false;
        if (Math.abs(27 - trapezium.perimeter()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);
    }
}