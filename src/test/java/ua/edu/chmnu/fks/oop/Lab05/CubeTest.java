package ua.edu.chmnu.fks.oop.Lab05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CubeTest {

    final double accuracy = 0.001;

    @Test
    void cubeConstructorTest1() {
        Cube cobe = new Cube();
        assertEquals(0, cobe.getEdge());
    }

    @Test
    void cubeConstructorTest2() throws Cube.NegativeEdgeException {
        Cube cobe = new Cube(2.5);
        assertEquals(2.5, cobe.getEdge());
    }

    @Test //ExceptionCase
    void cubeConstructorTest3() {
        assertThrows(Cube.NegativeEdgeException.class, () -> new Cube(-5.));
    }

    @Test
    void edgeGetterSetterTest1() throws Cube.NegativeEdgeException {
        Cube cobe = new Cube();
        cobe.setEdge(3.22);
        assertEquals(3.22, cobe.getEdge());
    }

    @Test
    void edgeGetterSetterTest2() throws Cube.NegativeEdgeException {
        Cube cobe = new Cube();
        cobe.setEdge(1.);
        assertEquals(1., cobe.getEdge());
    }

    @Test //ExceptionCase
    void edgeGetterSetterTest3() {
        Cube cobe = new Cube();
        assertThrows(Cube.NegativeEdgeException.class, () -> cobe.setEdge(-2.));
    }

    @Test
    void getVolumeTest1() throws Cube.NegativeEdgeException {
        Cube cobe = new Cube(2.4);
        boolean isEq = false;
        if (Math.abs(34.56 - cobe.getVolume()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);
    }

    @Test
    void getVolumeTest2() throws Cube.NegativeEdgeException {
        Cube cobe = new Cube(33.7);
        boolean isEq = false;
        if (Math.abs(6814.14 - cobe.getVolume()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);
    }

    @Test
    void getVolumeTest3() throws Cube.NegativeEdgeException {
        Cube cobe = new Cube(8);
        boolean isEq = false;
        if (Math.abs(384 - cobe.getVolume()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);
    }

    @Test
    void getDiagonalTest1() throws Cube.NegativeEdgeException {
        Cube cobe = new Cube(3);
        boolean isEq = false;
        if (Math.abs(5.196 - cobe.getDiagonal()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);
    }

    @Test
    void getDiagonalTest2() throws Cube.NegativeEdgeException {
        Cube cobe = new Cube(4.9);
        boolean isEq = false;
        if (Math.abs(8.487 - cobe.getDiagonal()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);
    }

    @Test
    void getDiagonalTest3() throws Cube.NegativeEdgeException {
        Cube cobe = new Cube(212.4);
        boolean isEq = false;
        if (Math.abs(367.887 - cobe.getDiagonal()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);
    }
}