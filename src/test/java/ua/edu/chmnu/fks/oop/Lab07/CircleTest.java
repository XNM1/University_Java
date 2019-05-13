package ua.edu.chmnu.fks.oop.Lab07;

import org.junit.jupiter.api.Test;
import ua.edu.chmnu.fks.oop.Lab07.Exceptions.*;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    private final double accuracy = 0.001;
    private Circle circle;

    {
        try {
            circle = new Circle(3.3);
        }
        catch (Exception ex){}
    }

    @Test
    void constructorTest() throws InvalidValueException  {
        Circle circle1 = new Circle(1);
        Circle circle2 = new Circle(33.4);
        Circle circle3 = new Circle(27.1);

        assertEquals(1, circle1.getRadius());
        assertEquals(33.4, circle2.getRadius());
        assertEquals(27.1, circle3.getRadius());

        assertThrows(NegativeValueException.class, () -> new Circle(-1));
        assertThrows(ZeroValueException.class, () -> new Circle(0));
    }

    @Test
    void radiusSetterGetterTest() throws InvalidValueException {
        circle.setRadius(2.3);
        assertEquals(2.3, circle.getRadius());
        circle.setRadius(4.5);
        assertEquals(4.5, circle.getRadius());
        circle.setRadius(33.9);
        assertEquals(33.9, circle.getRadius());
        circle.setRadius(1.7);
        assertEquals(1.7, circle.getRadius());

        assertThrows(ZeroValueException.class, () -> circle.setRadius(0));
        assertThrows(NegativeValueException.class, () -> circle.setRadius(-2));
    }

    @Test
    void areaTest() throws InvalidValueException {
        circle.setRadius(2);
        boolean isEq = false;
        if (Math.abs(12.566 - circle.area()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);

        circle.setRadius(22.3);
        isEq = false;
        if (Math.abs(1562.2826 - circle.area()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);

        circle.setRadius(1.8);
        isEq = false;
        if (Math.abs(10.178 - circle.area()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);
    }

    @Test
    void perimeterTest() throws InvalidValueException {
        circle.setRadius(2);
        boolean isEq = false;
        if (Math.abs(12.566 - circle.perimeter()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);

        circle.setRadius(22.3);
        isEq = false;
        if (Math.abs(140.115 - circle.perimeter()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);

        circle.setRadius(1.8);
        isEq = false;
        if (Math.abs(11.309 - circle.perimeter()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);
    }

}