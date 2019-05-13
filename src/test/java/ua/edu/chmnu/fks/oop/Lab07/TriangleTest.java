package ua.edu.chmnu.fks.oop.Lab07;

import org.junit.jupiter.api.Test;
import ua.edu.chmnu.fks.oop.Lab07.Exceptions.*;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    private final double accuracy = 0.001;
    private Triangle triangle;

    {
        try {
            triangle = new Triangle(3.3, 2.2, 5);
        }
        catch (Exception ex){}
    }

    @Test
    void constructorTest() throws FigureException {
        Triangle triangle1 = new Triangle(3.3, 22.6, 24);
        Triangle triangle2 = new Triangle(11, 12, 3);
        Triangle triangle3 = new Triangle(356.2, 343.5, 34.9);

        assertEquals(3.3, triangle1.getA());
        assertEquals(22.6, triangle1.getB());
        assertEquals(24, triangle1.getC());

        assertEquals(11, triangle2.getA());
        assertEquals(12, triangle2.getB());
        assertEquals(3, triangle2.getC());

        assertEquals(356.2, triangle3.getA());
        assertEquals(343.5, triangle3.getB());
        assertEquals(34.9, triangle3.getC());

        assertThrows(ZeroValueException.class, () -> new Triangle(0, 42.6, 12));
        assertThrows(ZeroValueException.class, () -> new Triangle(3.3, 0, 12));
        assertThrows(ZeroValueException.class, () -> new Triangle(3.3, 42.6, 0));
        assertThrows(ZeroValueException.class, () -> new Triangle(0, 42.6, 0));

        assertThrows(NegativeValueException.class, () -> new Triangle(-3.3, 42.6, 12));
        assertThrows(NegativeValueException.class, () -> new Triangle(3.3, -42.6, 12));
        assertThrows(NegativeValueException.class, () -> new Triangle(3.3, 42.6, -12));
        assertThrows(InvalidFigureException.class, () -> new Triangle(3.3, 42.6, 234.9));
    }

    @Test
    void aSetterGetterTest() throws FigureException {
        triangle.setA(5.3);
        assertEquals(5.3, triangle.getA());
        triangle.setA(6.5);
        assertEquals(6.5, triangle.getA());
        triangle.setA(5.4);
        assertEquals(5.4, triangle.getA());
        triangle.setA(7.1);
        assertEquals(7.1, triangle.getA());

        assertThrows(ZeroValueException.class, () -> triangle.setA(0));
        assertThrows(NegativeValueException.class, () -> triangle.setA(-2));
        assertThrows(InvalidFigureException.class, () -> triangle.setA(21341));
    }

    @Test
    void bSetterGetterTest() throws FigureException {
        triangle.setB(5.3);
        assertEquals(5.3, triangle.getB());
        triangle.setB(6.5);
        assertEquals(6.5, triangle.getB());
        triangle.setB(5.4);
        assertEquals(5.4, triangle.getB());
        triangle.setB(7.1);
        assertEquals(7.1, triangle.getB());

        assertThrows(ZeroValueException.class, () -> triangle.setB(0));
        assertThrows(NegativeValueException.class, () -> triangle.setB(-2));
        assertThrows(InvalidFigureException.class, () -> triangle.setB(21341));
    }

    @Test
    void cSetterGetterTest() throws FigureException {
        triangle.setC(5.3);
        assertEquals(5.3, triangle.getC());
        triangle.setC(3.5);
        assertEquals(3.5, triangle.getC());
        triangle.setC(5.4);
        assertEquals(5.4, triangle.getC());
        triangle.setC(4.2);
        assertEquals(4.2, triangle.getC());

        assertThrows(ZeroValueException.class, () -> triangle.setC(0));
        assertThrows(NegativeValueException.class, () -> triangle.setC(-2));
        assertThrows(InvalidFigureException.class, () -> triangle.setC(21341));
    }

    @Test
    void areaTest() throws FigureException {
        triangle = new Triangle(3.3, 22.6, 24);
        boolean isEq = false;
        if (Math.abs(34.726 - triangle.area()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);

        triangle = new Triangle(11, 12, 3);
        isEq = false;
        if (Math.abs(16.124 - triangle.area()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);

        triangle = new Triangle(356.2, 343.5, 34.9);
        isEq = false;
        if (Math.abs(5679.249 - triangle.area()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);
    }

    @Test
    void perimeterTest() throws FigureException {
        triangle = new Triangle(3.3, 22.6, 24);
        boolean isEq = false;
        if (Math.abs(49.9 - triangle.perimeter()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);

        triangle = new Triangle(11, 12, 3);
        isEq = false;
        if (Math.abs(26 - triangle.perimeter()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);

        triangle = new Triangle(356.2, 343.5, 34.9);
        isEq = false;
        if (Math.abs(734.6 - triangle.perimeter()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);
    }
}