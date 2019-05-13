package ua.edu.chmnu.fks.oop.Lab05;

import org.junit.jupiter.api.Test;
import ua.edu.chmnu.fks.oop.Lab05.Exceptions.*;

import static org.junit.jupiter.api.Assertions.*;

class CubeTest {

    final double accuracy = 0.001;

    @Test
    void cubeConstructorTest1() {
        Cube cube = new Cube();
        assertEquals(0, cube.getEdge());
    }

    @Test
    void cubeConstructorTest2() throws NegativeEdgeException {
        Cube cube = new Cube(2.5);
        assertEquals(2.5, cube.getEdge());
    }

    @Test //ExceptionCase
    void cubeConstructorTest3() {
        assertThrows(NegativeEdgeException.class, () -> new Cube(-5.));
    }

    @Test
    void edgeGetterSetterTest1() throws NegativeEdgeException {
        Cube cube = new Cube();
        cube.setEdge(3.22);
        assertEquals(3.22, cube.getEdge());
    }

    @Test
    void edgeGetterSetterTest2() throws NegativeEdgeException {
        Cube cube = new Cube();
        cube.setEdge(1.);
        assertEquals(1., cube.getEdge());
    }

    @Test //ExceptionCase
    void edgeGetterSetterTest3() {
        Cube cube = new Cube();
        assertThrows(NegativeEdgeException.class, () -> cube.setEdge(-2.));
    }

    @Test
    void getVolumeTest1() throws NegativeEdgeException {
        Cube cube = new Cube(2.4);
        boolean isEq = false;
        if (Math.abs(34.56 - cube.getVolume()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);
    }

    @Test
    void getVolumeTest2() throws NegativeEdgeException {
        Cube cube = new Cube(33.7);
        boolean isEq = false;
        if (Math.abs(6814.14 - cube.getVolume()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);
    }

    @Test
    void getVolumeTest3() throws NegativeEdgeException {
        Cube cube = new Cube(8);
        boolean isEq = false;
        if (Math.abs(384 - cube.getVolume()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);
    }

    @Test
    void getDiagonalTest1() throws NegativeEdgeException {
        Cube cube = new Cube(3);
        boolean isEq = false;
        if (Math.abs(5.196 - cube.getDiagonal()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);
    }

    @Test
    void getDiagonalTest2() throws NegativeEdgeException {
        Cube cube = new Cube(4.9);
        boolean isEq = false;
        if (Math.abs(8.487 - cube.getDiagonal()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);
    }

    @Test
    void getDiagonalTest3() throws NegativeEdgeException {
        Cube cube = new Cube(212.4);
        boolean isEq = false;
        if (Math.abs(367.887 - cube.getDiagonal()) < accuracy) {
            isEq = true;
        }
        assertEquals(true, isEq);
    }
}