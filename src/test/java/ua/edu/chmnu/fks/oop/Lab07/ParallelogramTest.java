package ua.edu.chmnu.fks.oop.Lab07;

import org.junit.jupiter.api.Test;
import ua.edu.chmnu.fks.oop.Lab07.Exceptions.*;

import static org.junit.jupiter.api.Assertions.*;

class ParallelogramTest {
    private final double accuracy = 0.001;
    private Parallelogram parallelogram;

    {
        try {
            parallelogram = new Parallelogram(3.3, 2.2, 5);
        }
        catch (Exception ex){}
    }

    @Test
    void constructorTest() throws FigureException {
        Parallelogram parallelogram1 = new Parallelogram(3.3, 42.6, 87);
        Parallelogram parallelogram2 = new Parallelogram(23.8, 12, 3);
        Parallelogram parallelogram3 = new Parallelogram(356, 34.5, 34.9);

        assertEquals(3.3, parallelogram1.getA());
        assertEquals(42.6, parallelogram1.getB());
        assertEquals(87, parallelogram1.getAlpha());

        assertEquals(23.8, parallelogram2.getA());
        assertEquals(12, parallelogram2.getB());
        assertEquals(3, parallelogram2.getAlpha());

        assertEquals(356, parallelogram3.getA());
        assertEquals(34.5, parallelogram3.getB());
        assertEquals(34.9, parallelogram3.getAlpha());

        assertThrows(ZeroValueException.class, () -> new Parallelogram(0, 42.6, 12));
        assertThrows(ZeroValueException.class, () -> new Parallelogram(3.3, 0, 12));
        assertThrows(ZeroValueException.class, () -> new Parallelogram(3.3, 42.6, 0));
        assertThrows(ZeroValueException.class, () -> new Parallelogram(0, 42.6, 0));

        assertThrows(NegativeValueException.class, () -> new Parallelogram(-3.3, 42.6, 12));
        assertThrows(NegativeValueException.class, () -> new Parallelogram(3.3, -42.6, 12));
        assertThrows(NegativeValueException.class, () -> new Parallelogram(3.3, 42.6, -12));
        assertThrows(InvalidFigureException.class, () -> new Parallelogram(3.3, -42.6, 234.9));
    }

    @Test
    void aSetterGetterTest() throws InvalidValueException {
        parallelogram.setA(2.3);
        assertEquals(2.3, parallelogram.getA());
        parallelogram.setA(4.5);
        assertEquals(4.5, parallelogram.getA());
        parallelogram.setA(33.9);
        assertEquals(33.9, parallelogram.getA());
        parallelogram.setA(1.7);
        assertEquals(1.7, parallelogram.getA());

        assertThrows(ZeroValueException.class, () -> parallelogram.setA(0));
        assertThrows(NegativeValueException.class, () -> parallelogram.setA(-2));
    }

    @Test
    void bSetterGetterTest() throws InvalidValueException {
        parallelogram.setB(2.3);
        assertEquals(2.3, parallelogram.getB());
        parallelogram.setB(4.5);
        assertEquals(4.5, parallelogram.getB());
        parallelogram.setB(33.9);
        assertEquals(33.9, parallelogram.getB());
        parallelogram.setB(1.7);
        assertEquals(1.7, parallelogram.getB());

        assertThrows(ZeroValueException.class, () -> parallelogram.setB(0));
        assertThrows(NegativeValueException.class, () -> parallelogram.setB(-2));
    }

    @Test
    void alphaSetterGetterTest() throws FigureException {
        parallelogram.setAlpha(2.3);
        assertEquals(2.3, parallelogram.getAlpha());
        parallelogram.setAlpha(4.5);
        assertEquals(4.5, parallelogram.getAlpha());
        parallelogram.setAlpha(33.9);
        assertEquals(33.9, parallelogram.getAlpha());
        parallelogram.setAlpha(1.7);
        assertEquals(1.7, parallelogram.getAlpha());

        assertThrows(ZeroValueException.class, () -> parallelogram.setAlpha(0));
        assertThrows(NegativeValueException.class, () -> parallelogram.setAlpha(-2));
        assertThrows(FigureException.class, () -> parallelogram.setAlpha(182));
    }

    @Test
    void areaTest() throws FigureException {
        parallelogram.setA(2.3);
        parallelogram.setB(24.2);
        parallelogram.setAlpha(57);
        boolean isEq = false;
        if (Math.abs(46.680 - parallelogram.area()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);

        parallelogram.setA(32.4);
        parallelogram.setB(23.2);
        parallelogram.setAlpha(90);
        isEq = false;
        if (Math.abs(751.68 - parallelogram.area()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);

        parallelogram.setA(7);
        parallelogram.setB(7);
        parallelogram.setAlpha(23);
        isEq = false;
        if (Math.abs(19.145 - parallelogram.area()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);
    }

    @Test
    void perimeterTest() throws InvalidValueException {
        parallelogram.setA(2.3);
        parallelogram.setB(24.2);
        boolean isEq = false;
        if (Math.abs(53 - parallelogram.perimeter()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);

        parallelogram.setA(32.4);
        parallelogram.setB(23.2);
        isEq = false;
        if (Math.abs(111.2 - parallelogram.perimeter()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);

        parallelogram.setA(7);
        parallelogram.setB(7);
        isEq = false;
        if (Math.abs(28 - parallelogram.perimeter()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);
    }
}