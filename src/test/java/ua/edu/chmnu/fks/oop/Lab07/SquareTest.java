package ua.edu.chmnu.fks.oop.Lab07;

import org.junit.jupiter.api.Test;
import ua.edu.chmnu.fks.oop.Lab07.Exceptions.InvalidValueException;
import ua.edu.chmnu.fks.oop.Lab07.Exceptions.NegativeValueException;
import ua.edu.chmnu.fks.oop.Lab07.Exceptions.ZeroValueException;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {
    private final double accuracy = 0.001;
    private Square square;

    {
        try {
            square = new Square(3.3);
        }
        catch (Exception ex){}
    }

    @Test
    void constructorTest() throws InvalidValueException {
        Square square1 = new Square(3.3);
        Square square2 = new Square(23.8);
        Square square3 = new Square(356);

        assertEquals(3.3, square1.getA());
        assertEquals(23.8, square2.getA());
        assertEquals(356, square3.getA());

        assertThrows(ZeroValueException.class, () -> new Square(0));
        assertThrows(NegativeValueException.class, () -> new Square(-3.3));
    }

    @Test
    void aSetterGetterTest() throws InvalidValueException {
        square.setA(2.3);
        assertEquals(2.3, square.getA());
        square.setA(4.5);
        assertEquals(4.5, square.getA());
        square.setA(33.9);
        assertEquals(33.9, square.getA());
        square.setA(1.7);
        assertEquals(1.7, square.getA());

        assertThrows(ZeroValueException.class, () -> square.setA(0));
        assertThrows(NegativeValueException.class, () -> square.setA(-2));
    }

    @Test
    void areaTest() throws InvalidValueException {
        square.setA(2.3);
        boolean isEq = false;
        if (Math.abs(5.29 - square.area()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);

        square.setA(32.4);
        isEq = false;
        if (Math.abs(1049.76 - square.area()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);

        square.setA(7);
        isEq = false;
        if (Math.abs(49 - square.area()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);
    }

    @Test
    void perimeterTest() throws InvalidValueException {
        square.setA(2.3);
        boolean isEq = false;
        if (Math.abs(9.2 - square.perimeter()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);

        square.setA(32.4);
        isEq = false;
        if (Math.abs(129.6 - square.perimeter()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);

        square.setA(7);
        isEq = false;
        if (Math.abs(28 - square.perimeter()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);
    }
}