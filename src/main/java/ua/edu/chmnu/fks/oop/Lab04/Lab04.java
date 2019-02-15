package ua.edu.chmnu.fks.oop.Lab04;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Lab04 {
    public static void main(String[] args) {

    }

    public static ArrayList getDels(int n) {
        ArrayList dels = new ArrayList();
        int l = n;
        for (int i = 1; i < l; i++) {
            if(n % i == 0) {
                l = n / i;
                dels.add(l);
                dels.add(i);
            }
        }
        return dels;
    }

    public static ArrayList getProbableRoots(Object[] delsq, Object[] delsp) {
        ArrayList pr = new ArrayList();
        for (int i = 0; i < delsq.length; i++) {
            for (int j = 0; j < delsp.length; j++) {
                int delspInt = (int)delsp[j];
                int delsqInt = (int)delsq[i];
                if (delspInt != 0) {
                    double d = (double)delsqInt/delspInt;
                    if(!pr.contains(d)) {
                        pr.add(d);
                    }
                }
            }
        }
        return pr;
    }

    public static void schemeGornerRec(ArrayList roots, int[] cof, ArrayList pr) {

    }

    public static ArrayList schemeGornger(int[] cof) {
        ArrayList roots = new ArrayList();
        if (cof.length > 1) {
            ArrayList dp = getDels(cof[0]);
            ArrayList dq = getDels(cof[cof.length - 1]);
            ArrayList pr = getProbableRoots(dq.toArray(), dp.toArray());
            schemeGornerRec(roots, cof, pr);
            return roots;
        }
        else {
            return null;
        }
    }
}
