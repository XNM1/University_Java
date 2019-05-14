package ua.edu.chmnu.fks.oop.Lab08;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.*;

public class PalindromeUtils {

    static public Collection<String> getPolindromeFromCollection(Collection<String> strings, boolean case_sensitive, boolean withSpace) {
        return strings.stream().filter(s -> isPalindrome(s, case_sensitive, withSpace)).collect(Collectors.toList());
    }

    static public Stream<String> getPolindromeFromStream(Stream<String> strings, boolean case_sensitive, boolean withSpace) {
        return strings.filter(s -> isPalindrome(s, case_sensitive, withSpace));
    }

    static public boolean isPalindrome(String str, boolean case_sensitive, boolean withSpace) {
        if(!withSpace) {
            str = str.replaceAll("\\s+","");
        }
        if(!case_sensitive) {
            str = str.toLowerCase();
        }
        for (int i = 0; i < str.length() / 2; i++) {
            if(str.charAt(i) != str.charAt(str.length() - 1 - i))
                return false;
        }
        return true;
    }
}
