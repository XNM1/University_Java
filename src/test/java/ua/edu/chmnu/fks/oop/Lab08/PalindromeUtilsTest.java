package ua.edu.chmnu.fks.oop.Lab08;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeUtilsTest {

    @Test
    void getPolindromeFromCollectionTest() {
        String[] params1 = new String[]{ "asd", "00100", "abccba", "127849sad", "f0f", "а роза упала на лапу Азора", "а роза упала на лапу азора" };
        String[] excpected11 = new String[]{ "00100", "abccba", "f0f"};
        String[] excpected12 = new String[]{ "00100", "abccba", "f0f", "а роза упала на лапу азора"};
        String[] excpected13 = new String[]{ "00100", "abccba", "f0f", "а роза упала на лапу Азора", "а роза упала на лапу азора"};

        String[] params2 = new String[]{ "kek", "asjdkas", "lol", "Lol", "Sum summus mus" };
        String[] excpected21 = new String[]{ "kek", "lol"};
        String[] excpected22 = new String[]{ "kek", "lol", "Lol", "Sum summus mus"};

        String[] params3 = new String[]{ "11111", "sfa893", "hello", "Saippuakivikauppias", "saippuakivikauppias" };
        String[] excpected31 = new String[]{ "11111", "saippuakivikauppias"};
        String[] excpected32 = new String[]{ "11111", "Saippuakivikauppias", "saippuakivikauppias", };

        assertArrayEquals(excpected11, PalindromeUtils.getPolindromeFromCollection(Arrays.asList(params1), true, true).toArray());
        assertArrayEquals(excpected11, PalindromeUtils.getPolindromeFromCollection(Arrays.asList(params1), false, true).toArray());
        assertArrayEquals(excpected12, PalindromeUtils.getPolindromeFromCollection(Arrays.asList(params1), true, false).toArray());
        assertArrayEquals(excpected13, PalindromeUtils.getPolindromeFromCollection(Arrays.asList(params1), false, false).toArray());

        assertArrayEquals(excpected21, PalindromeUtils.getPolindromeFromCollection(Arrays.asList(params2), true, true).toArray());
        assertArrayEquals(excpected22, PalindromeUtils.getPolindromeFromCollection(Arrays.asList(params2), false, true).toArray());
        assertArrayEquals(excpected21, PalindromeUtils.getPolindromeFromCollection(Arrays.asList(params2), true, false).toArray());
        assertArrayEquals(excpected22, PalindromeUtils.getPolindromeFromCollection(Arrays.asList(params2), false, false).toArray());

        assertArrayEquals(excpected31, PalindromeUtils.getPolindromeFromCollection(Arrays.asList(params3), true, true).toArray());
        assertArrayEquals(excpected32, PalindromeUtils.getPolindromeFromCollection(Arrays.asList(params3), false, true).toArray());
        assertArrayEquals(excpected31, PalindromeUtils.getPolindromeFromCollection(Arrays.asList(params3), true, false).toArray());
        assertArrayEquals(excpected32, PalindromeUtils.getPolindromeFromCollection(Arrays.asList(params3), false, false).toArray());
    }

    @Test
    void getPolindromeFromStreamTest() {
        String[] params1 = new String[]{ "asd", "00100", "abccba", "127849sad", "f0f", "а роза упала на лапу Азора", "а роза упала на лапу азора" };
        String[] excpected11 = new String[]{ "00100", "abccba", "f0f"};
        String[] excpected12 = new String[]{ "00100", "abccba", "f0f", "а роза упала на лапу азора"};
        String[] excpected13 = new String[]{ "00100", "abccba", "f0f", "а роза упала на лапу Азора", "а роза упала на лапу азора"};

        String[] params2 = new String[]{ "kek", "asjdkas", "lol", "Lol", "Sum summus mus" };
        String[] excpected21 = new String[]{ "kek", "lol"};
        String[] excpected22 = new String[]{ "kek", "lol", "Lol", "Sum summus mus"};

        String[] params3 = new String[]{ "11111", "sfa893", "hello", "Saippuakivikauppias", "saippuakivikauppias" };
        String[] excpected31 = new String[]{ "11111", "saippuakivikauppias"};
        String[] excpected32 = new String[]{ "11111", "Saippuakivikauppias", "saippuakivikauppias", };

        assertArrayEquals(excpected11, PalindromeUtils.getPolindromeFromStream(Arrays.stream(params1), true, true).toArray());
        assertArrayEquals(excpected11, PalindromeUtils.getPolindromeFromStream(Arrays.stream(params1), false, true).toArray());
        assertArrayEquals(excpected12, PalindromeUtils.getPolindromeFromStream(Arrays.stream(params1), true, false).toArray());
        assertArrayEquals(excpected13, PalindromeUtils.getPolindromeFromStream(Arrays.stream(params1), false, false).toArray());

        assertArrayEquals(excpected21, PalindromeUtils.getPolindromeFromStream(Arrays.stream(params2), true, true).toArray());
        assertArrayEquals(excpected22, PalindromeUtils.getPolindromeFromStream(Arrays.stream(params2), false, true).toArray());
        assertArrayEquals(excpected21, PalindromeUtils.getPolindromeFromStream(Arrays.stream(params2), true, false).toArray());
        assertArrayEquals(excpected22, PalindromeUtils.getPolindromeFromStream(Arrays.stream(params2), false, false).toArray());

        assertArrayEquals(excpected31, PalindromeUtils.getPolindromeFromStream(Arrays.stream(params3), true, true).toArray());
        assertArrayEquals(excpected32, PalindromeUtils.getPolindromeFromStream(Arrays.stream(params3), false, true).toArray());
        assertArrayEquals(excpected31, PalindromeUtils.getPolindromeFromStream(Arrays.stream(params3), true, false).toArray());
        assertArrayEquals(excpected32, PalindromeUtils.getPolindromeFromStream(Arrays.stream(params3), false, false).toArray());
    }

    @Test
    void isPalindromeTest() {
        String[] params = new String[]{ "kek", "asjdkas", "lol", "Lol", "Sum summus mus", "а роза упала на лапу Азора" };

        assertEquals(true, PalindromeUtils.isPalindrome(params[0], true, true));

        assertEquals(false, PalindromeUtils.isPalindrome(params[1], true, true));

        assertEquals(true, PalindromeUtils.isPalindrome(params[2], true, true));

        assertEquals(false, PalindromeUtils.isPalindrome(params[3], true, true));
        assertEquals(true, PalindromeUtils.isPalindrome(params[3], false, true));

        assertEquals(false, PalindromeUtils.isPalindrome(params[4], true, true));
        assertEquals(true, PalindromeUtils.isPalindrome(params[4], false, true));
        assertEquals(true, PalindromeUtils.isPalindrome(params[4], false, false));

        assertEquals(false, PalindromeUtils.isPalindrome(params[5], true, true));
        assertEquals(false, PalindromeUtils.isPalindrome(params[5], false, true));
        assertEquals(true, PalindromeUtils.isPalindrome(params[5], false, false));
    }
}