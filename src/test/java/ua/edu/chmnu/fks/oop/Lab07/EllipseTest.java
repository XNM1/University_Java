package ua.edu.chmnu.fks.oop.Lab07;

import org.junit.jupiter.api.Test;
import ua.edu.chmnu.fks.oop.Lab07.Exceptions.InvalidValueException;
import ua.edu.chmnu.fks.oop.Lab07.Exceptions.NegativeValueException;
import ua.edu.chmnu.fks.oop.Lab07.Exceptions.ZeroValueException;

import static org.junit.jupiter.api.Assertions.*;

class EllipseTest {

    private final double accuracy = 0.001;
    private Ellipse ellipse;

    {
        try {
            ellipse = new Ellipse(3.3, 2.2);
        }
        catch (Exception ex){}
    }

    @Test
    void constructorTest() throws InvalidValueException {
        Ellipse ellipse1 = new Ellipse(1, 2);
        Ellipse ellipse2 = new Ellipse(33.4, 44);
        Ellipse ellipse3 = new Ellipse(27.1, 91.2);

        assertEquals(1, ellipse1.getA());
        assertEquals(2, ellipse1.getB());

        assertEquals(33.4, ellipse2.getA());
        assertEquals(44, ellipse2.getB());

        assertEquals(27.1, ellipse3.getA());
        assertEquals(91.2, ellipse3.getB());

        assertThrows(NegativeValueException.class, () -> new Ellipse(-1, 2));
        assertThrows(ZeroValueException.class, () -> new Ellipse(0, 2));

        assertThrows(NegativeValueException.class, () -> new Ellipse(1, -1));
        assertThrows(ZeroValueException.class, () -> new Ellipse(1, 0));
    }

    @Test
    void aSetterGetterTest() throws InvalidValueException {
        ellipse.setA(2.3);
        assertEquals(2.3, ellipse.getA());
        ellipse.setA(4.5);
        assertEquals(4.5, ellipse.getA());
        ellipse.setA(33.9);
        assertEquals(33.9, ellipse.getA());
        ellipse.setA(1.7);
        assertEquals(1.7, ellipse.getA());

        assertThrows(ZeroValueException.class, () -> ellipse.setA(0));
        assertThrows(NegativeValueException.class, () -> ellipse.setA(-2));
    }

    @Test
    void bSetterGetterTest() throws InvalidValueException {
        ellipse.setB(2.3);
        assertEquals(2.3, ellipse.getB());
        ellipse.setB(4.5);
        assertEquals(4.5, ellipse.getB());
        ellipse.setB(33.9);
        assertEquals(33.9, ellipse.getB());
        ellipse.setB(1.7);
        assertEquals(1.7, ellipse.getB());

        assertThrows(ZeroValueException.class, () -> ellipse.setB(0));
        assertThrows(NegativeValueException.class, () -> ellipse.setB(-2));
    }

    @Test
    void areaTest() throws InvalidValueException {
        ellipse.setA(2.3);
        ellipse.setB(24.2);
        boolean isEq = false;
        if (Math.abs(174.861 - ellipse.area()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);

        ellipse.setA(32.4);
        ellipse.setB(23.2);
        isEq = false;
        if (Math.abs(2361.472 - ellipse.area()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);

        ellipse.setA(2);
        ellipse.setB(2);
        isEq = false;
        if (Math.abs(12.566 - ellipse.area()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);
    }

    @Test
    void perimeterTest() throws InvalidValueException {
        ellipse.setA(2.3);
        ellipse.setB(24.2);
        boolean isEq = false;
        if (Math.abs(108.00227153847953 - ellipse.perimeter()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);

        ellipse.setA(32.4);
        ellipse.setB(23.2);
        isEq = false;
        if (Math.abs(177.047 - ellipse.perimeter()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);

        ellipse.setA(2);
        ellipse.setB(2);
        isEq = false;
        if (Math.abs(12.566 - ellipse.perimeter()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);
    }

}