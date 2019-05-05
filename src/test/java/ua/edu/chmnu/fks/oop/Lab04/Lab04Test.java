package ua.edu.chmnu.fks.oop.Lab04;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;

import java.lang.reflect.Array;
import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Lab04Test {

    @Test
    public void schemeGorngerTest1() throws Exception {
        ArrayList<Double> arrExpected = new ArrayList<Double>();
        arrExpected.add(1.5);
        ArrayList<Integer> arrParams = new ArrayList<Integer>();
        Integer[] param = {8, -36, 54, -27};
        arrParams.addAll(Arrays.asList(param));
        assertArrayEquals(arrExpected.toArray(), Lab04.schemeGornger(arrParams).toArray());
    }

    @Test
    public void schemeGorngerTest2() throws Exception {
        ArrayList<Double> arrExpected = new ArrayList<Double>();
        Double[] expected = {-1., 3., -2.};
        arrExpected.addAll(Arrays.asList(expected));
        ArrayList<Integer> arrParams = new ArrayList<Integer>();
        Integer[] param = {1, 0, -7, -6};
        arrParams.addAll(Arrays.asList(param));
        assertArrayEquals(arrExpected.toArray(), Lab04.schemeGornger(arrParams).toArray());
    }

    @Test
    public void schemeGorngerTest3() throws Exception {
        ArrayList<Double> arrExpected = new ArrayList<Double>();
        Double[] expected = {2., 3., 4.};
        arrExpected.addAll(Arrays.asList(expected));
        ArrayList<Integer> arrParams = new ArrayList<Integer>();
        Integer[] param = {1, -9, 26, -24};
        arrParams.addAll(Arrays.asList(param));
        assertArrayEquals(arrExpected.toArray(), Lab04.schemeGornger(arrParams).toArray());
    }

    @Test
    public void schemeGorngerTest4() throws Exception {
        ArrayList<Double> arrExpected = new ArrayList<Double>();
        Double[] expected = {1., -1., 2., 0.5};
        arrExpected.addAll(Arrays.asList(expected));
        ArrayList<Integer> arrParams = new ArrayList<Integer>();
        Integer[] param = {2, -5, 0, 5, -2};
        arrParams.addAll(Arrays.asList(param));
        assertArrayEquals(arrExpected.toArray(), Lab04.schemeGornger(arrParams).toArray());
    }

    @Test
    public void schemeGorngerTest5() throws Exception {
        ArrayList<Double> arrExpected = new ArrayList<Double>();
        Double[] expected = {-0.5};
        arrExpected.addAll(Arrays.asList(expected));
        ArrayList<Integer> arrParams = new ArrayList<Integer>();
        Integer[] param = {8, 12, 6, 1};
        arrParams.addAll(Arrays.asList(param));
        assertArrayEquals(arrExpected.toArray(), Lab04.schemeGornger(arrParams).toArray());
    }

    @Test
    void getDelsTest1() throws Exception {
        ArrayList<Integer> arrExpected = new ArrayList<Integer>();
        Integer[] param = {27, 1, 9, 3};
        arrExpected.addAll(Arrays.asList(param));
        assertArrayEquals(arrExpected.toArray(), Lab04.getDels(27).toArray());
    }

    @Test
    void getDelsTest2() throws Exception {
        ArrayList<Integer> arrExpected = new ArrayList<Integer>();
        Integer[] param = {8, 1, 4, 2};
        arrExpected.addAll(Arrays.asList(param));
        assertArrayEquals(arrExpected.toArray(), Lab04.getDels(8).toArray());
    }

    @Test
    void getDelsTest3() throws Exception {
        ArrayList<Integer> arrExpected = new ArrayList<Integer>();
        Integer[] param = {27, 1, 9, 3};
        arrExpected.addAll(Arrays.asList(param));
        assertArrayEquals(arrExpected.toArray(), Lab04.getDels(-27).toArray());
    }

    @Test
    void getDelsTest4() throws Exception {
        ArrayList<Integer> arrExpected = new ArrayList<Integer>();
        Integer[] param = {1};
        arrExpected.addAll(Arrays.asList(param));
        assertArrayEquals(arrExpected.toArray(), Lab04.getDels(1).toArray());
    }

    @Test //ExceptionCase
    void getDelsTest5() {
        assertThrows(Exception.class, () -> Lab04.getDels(0) );
    }

    @Test
    void getProbableRootsTest1() {
        ArrayList<Double> arrExpected = new ArrayList<Double>();
        Double[] param = {1., -1., 0.25, -0.25, 2., -2., 0.5, -0.5};
        arrExpected.addAll(Arrays.asList(param));
        Object[] param1 = {1, 2};
        Object[] param2 = {1, 4};
        assertArrayEquals(arrExpected.toArray(), Lab04.getProbableRoots(param1, param2).toArray());
    }

    @Test
    void getProbableRootsTest2() {
        ArrayList<Double> arrExpected = new ArrayList<Double>();
        Double[] param = {2., -2., 1.5, -1.5};
        arrExpected.addAll(Arrays.asList(param));
        Object[] param1 = {4, 3};
        Object[] param2 = {2, 2};
        assertArrayEquals(arrExpected.toArray(), Lab04.getProbableRoots(param1, param2).toArray());
    }
}