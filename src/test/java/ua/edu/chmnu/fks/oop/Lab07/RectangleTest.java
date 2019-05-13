package ua.edu.chmnu.fks.oop.Lab07;

import org.junit.jupiter.api.Test;
import ua.edu.chmnu.fks.oop.Lab07.Exceptions.InvalidValueException;
import ua.edu.chmnu.fks.oop.Lab07.Exceptions.NegativeValueException;
import ua.edu.chmnu.fks.oop.Lab07.Exceptions.ZeroValueException;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    private final double accuracy = 0.001;
    private Rectangle rectangle;

    {
        try {
            rectangle = new Rectangle(3.3, 2.2);
        } catch (Exception ex) {
        }
    }

    @Test
    void constructorTest() throws InvalidValueException {
        Rectangle rectangle1 = new Rectangle(3.3, 42.6);
        Rectangle rectangle2 = new Rectangle(23.8, 12);
        Rectangle rectangle3 = new Rectangle(356, 34.5);

        assertEquals(3.3, rectangle1.getA());
        assertEquals(42.6, rectangle1.getB());

        assertEquals(23.8, rectangle2.getA());
        assertEquals(12, rectangle2.getB());

        assertEquals(356, rectangle3.getA());
        assertEquals(34.5, rectangle3.getB());

        assertThrows(ZeroValueException.class, () -> new Rectangle(0, 42.6));
        assertThrows(ZeroValueException.class, () -> new Rectangle(3.3, 0));
        assertThrows(ZeroValueException.class, () -> new Rectangle(0, 0));

        assertThrows(NegativeValueException.class, () -> new Rectangle(-3.3, 42.6));
        assertThrows(NegativeValueException.class, () -> new Rectangle(3.3, -42.6));
        assertThrows(NegativeValueException.class, () -> new Rectangle(-3.3, -42.6));
    }

    @Test
    void aSetterGetterTest() throws InvalidValueException {
        rectangle.setA(2.3);
        assertEquals(2.3, rectangle.getA());
        rectangle.setA(4.5);
        assertEquals(4.5, rectangle.getA());
        rectangle.setA(33.9);
        assertEquals(33.9, rectangle.getA());
        rectangle.setA(1.7);
        assertEquals(1.7, rectangle.getA());

        assertThrows(ZeroValueException.class, () -> rectangle.setA(0));
        assertThrows(NegativeValueException.class, () -> rectangle.setA(-2));
    }

    @Test
    void bSetterGetterTest() throws InvalidValueException {
        rectangle.setB(2.3);
        assertEquals(2.3, rectangle.getB());
        rectangle.setB(4.5);
        assertEquals(4.5, rectangle.getB());
        rectangle.setB(33.9);
        assertEquals(33.9, rectangle.getB());
        rectangle.setB(1.7);
        assertEquals(1.7, rectangle.getB());

        assertThrows(ZeroValueException.class, () -> rectangle.setB(0));
        assertThrows(NegativeValueException.class, () -> rectangle.setB(-2));
    }

    @Test
    void areaTest() throws InvalidValueException {
        rectangle.setA(2.3);
        rectangle.setB(24.2);
        boolean isEq = false;
        if (Math.abs(55.66 - rectangle.area()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);

        rectangle.setA(32.4);
        rectangle.setB(23.2);
        isEq = false;
        if (Math.abs(751.68 - rectangle.area()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);

        rectangle.setA(7);
        rectangle.setB(7);
        isEq = false;
        if (Math.abs(49 - rectangle.area()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);
    }

    @Test
    void perimeterTest() throws InvalidValueException {
        rectangle.setA(2.3);
        rectangle.setB(24.2);
        boolean isEq = false;
        if (Math.abs(53 - rectangle.perimeter()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);

        rectangle.setA(32.4);
        rectangle.setB(23.2);
        isEq = false;
        if (Math.abs(111.2 - rectangle.perimeter()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);

        rectangle.setA(7);
        rectangle.setB(7);
        isEq = false;
        if (Math.abs(28 - rectangle.perimeter()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);

    }
}