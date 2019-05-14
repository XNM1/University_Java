package ua.edu.chmnu.fks.oop.Lab09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileSameDoubleSearcherTest {

    FileSameDoubleSearcher fileSameDoubleSearcher;

    {
        try {
            fileSameDoubleSearcher = new FileSameDoubleSearcher("src\\test\\java\\ua\\edu\\chmnu\\fks\\oop\\Lab09\\numbers.txt", "target\\test-classes\\ua\\edu\\chmnu\\fks\\oop\\Lab09\\result.txt", 8);
        }
        catch (Exception ex) {}
    }

    @Test
    public void constructorTest() throws Exception {
        FileSameDoubleSearcher fileSameDoubleSearcher = new FileSameDoubleSearcher("E:\\Работы\\Программирование\\University\\Java University\\a.txt", "E:\\Работы\\Программирование\\University\\Java University\\result.txt", 8, 0.001);
    }

    @Test
    void searchTest() throws Exception {
        assertDoesNotThrow(() -> fileSameDoubleSearcher.search());
    }

    @Test
    void fileWritePathSetterGetterTest() throws Exception {
        fileSameDoubleSearcher.setFileWritePath("asd.txt");
        assertEquals("asd.txt", fileSameDoubleSearcher.getFileWritePath());
        fileSameDoubleSearcher.setFileWritePath("a.txt");
        assertEquals("a.txt", fileSameDoubleSearcher.getFileWritePath());
        fileSameDoubleSearcher.setFileWritePath("fff.txt");
        assertEquals("fff.txt", fileSameDoubleSearcher.getFileWritePath());
        fileSameDoubleSearcher.setFileWritePath("double.txt");
        assertEquals("double.txt", fileSameDoubleSearcher.getFileWritePath());
    }

    @Test
    void fileReadPathSetterGetterTest() throws Exception {
        fileSameDoubleSearcher.setFileReadPath("asd.txt");
        assertEquals("asd.txt", fileSameDoubleSearcher.getFileReadPath());
        fileSameDoubleSearcher.setFileReadPath("a.txt");
        assertEquals("a.txt", fileSameDoubleSearcher.getFileReadPath());
        fileSameDoubleSearcher.setFileReadPath("fff.txt");
        assertEquals("fff.txt", fileSameDoubleSearcher.getFileReadPath());
        fileSameDoubleSearcher.setFileReadPath("double.txt");
        assertEquals("double.txt", fileSameDoubleSearcher.getFileReadPath());
    }

    @Test
    void accuracySetterGetterTest() throws Exception {
        fileSameDoubleSearcher.setAccuracy(2.3);
        assertEquals(2.3, fileSameDoubleSearcher.getAccuracy());
        fileSameDoubleSearcher.setAccuracy(3);
        assertEquals(3, fileSameDoubleSearcher.getAccuracy());
        fileSameDoubleSearcher.setAccuracy(1.5);
        assertEquals(1.5, fileSameDoubleSearcher.getAccuracy());
        fileSameDoubleSearcher.setAccuracy(1);
        assertEquals(1, fileSameDoubleSearcher.getAccuracy());

        assertThrows(Exception.class, () -> fileSameDoubleSearcher.setAccuracy(-3.8));
        assertThrows(Exception.class, () -> fileSameDoubleSearcher.setAccuracy(0));
    }

    @Test
    void countOfSymbInLineSetterGetterTest() throws Exception {
        fileSameDoubleSearcher.setCountOfSymbInLine(2);
        assertEquals(2, fileSameDoubleSearcher.getCountOfSymbInLine());
        fileSameDoubleSearcher.setCountOfSymbInLine(9);
        assertEquals(9, fileSameDoubleSearcher.getCountOfSymbInLine());
        fileSameDoubleSearcher.setCountOfSymbInLine(3);
        assertEquals(3, fileSameDoubleSearcher.getCountOfSymbInLine());
        fileSameDoubleSearcher.setCountOfSymbInLine(4);
        assertEquals(4, fileSameDoubleSearcher.getCountOfSymbInLine());

        assertThrows(Exception.class, () -> fileSameDoubleSearcher.setCountOfSymbInLine(-3));
        assertThrows(Exception.class, () -> fileSameDoubleSearcher.setCountOfSymbInLine(0));
    }
}