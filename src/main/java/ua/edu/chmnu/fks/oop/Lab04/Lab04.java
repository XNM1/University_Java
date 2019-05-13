package ua.edu.chmnu.fks.oop.Lab04;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Lab04 {
    public static void main(String[] args) {
        ArrayList<Integer> arrParams = new ArrayList<Integer>();
        Integer[] param = {1, 0, -7, -6};
        arrParams.addAll(Arrays.asList(param));
        try {
            Lab04.schemeGornger(arrParams).toArray();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static ArrayList<Integer> getDels(int n) throws Exception {
        ArrayList<Integer> dels = new ArrayList<Integer>();
        if(n == 0) {
            throw new Exception("Zero have infinity dividers");
        }
        if (n < 0) {
            n = Math.abs(n);
        }
        if (n == 1) {
            dels.add(1);
            return dels;
        }
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

    public static ArrayList<Double> getProbableRoots(Object[] delsq, Object[] delsp) {
        ArrayList<Double> pr = new ArrayList<Double>();
        for (int i = 0; i < delsq.length; i++) {
            for (int j = 0; j < delsp.length; j++) {
                int delspInt = (int)delsp[j];
                int delsqInt = (int)delsq[i];
                if (delspInt != 0) {
                    double d = (double)delsqInt/delspInt;
                    if(!pr.contains(d)) {
                        pr.add(d);
                        pr.add(d * -1.);
                    }
                }
            }
        }
        return pr;
    }

    private static void schemeGornerRec(ArrayList<Integer> cof, ArrayList<Double> pr, ArrayList<Double> roots, Integer indexRoot) {
        if (cof.size() == 1) {
            return;
        }
        ArrayList<Integer> newCof;
        double newc = 0;
        do {
            if (indexRoot == pr.size())
            {
                return;
            }
            newCof = new ArrayList<Integer>();
            newCof.add(cof.get(0));
            for (int i = 1; i < cof.size(); i++) {
                newc = (int)newCof.get(i - 1) * (double)pr.get(indexRoot) + (int)cof.get(i);
                if (i == cof.size() - 1 && newc != 0) {
                    indexRoot++;
                }
                else if (i == cof.size() - 1 && newc == 0) {
                    roots.add(pr.get(indexRoot));
                    indexRoot++;
                }
                else {
                    newCof.add((int)newc);
                }
            }
        } while (newc != 0);
        schemeGornerRec(newCof, pr, roots, indexRoot);
    }

    public static ArrayList<Double> schemeGornger(ArrayList<Integer> cof) throws Exception {
        if (cof.size() > 1) {
            ArrayList<Double> roots = new ArrayList<Double>();
            ArrayList<Integer> dp = getDels(cof.get(0));
            ArrayList<Integer> dq = getDels(cof.get(cof.size() - 1));
            ArrayList<Double> pr = getProbableRoots(dq.toArray(), dp.toArray());
            schemeGornerRec(cof, pr, roots, 0);
            return roots;
        }
        else {
            throw new Exception("Incorrect polinome");
        }
    }
}
