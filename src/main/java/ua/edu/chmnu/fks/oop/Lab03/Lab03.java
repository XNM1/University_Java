/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.edu.chmnu.fks.oop.Lab03;

import java.util.Scanner;

/**
 *
 * @author 1710533
 */
public class Lab03 {
    public static void main(String[] args) {
        //---------------------1---------------------
        int n = (int)(Math.random() * 100);
        double[] mas = new double[n];
        for(int i = 0; i < n; i++) {
            mas[i] = Math.random() * 100;
        }
        for(int i = 0; i < n; i++) {
            System.out.println(mas[i]);
        }
        System.out.println("-----------------");
        double l = 0;
        for (int i = 0; i < n - 1; i++) {
            l += mas[i] * mas[i];
        }
        l = Math.sqrt(l);
        for(int i = 0; i < n; i++) {
            mas[i] = mas[i]/l;
        }
        for(int i = 0; i < n; i++) {
            System.out.println(mas[i]);
        }

        //---------------------2---------------------
        
        n = (int)(Math.random() * 100);
        int m = (int)(Math.random() * 100);
        double[][] matrx = new double[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrx[i][j] = (Math.random() * 100);
            }
        }
        boolean isDiag = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i != j && Math.abs(matrx[i][j]) > 0.000001)
                {
                    isDiag = false;
                    break;
                }
            }
        }
        System.out.println("Is diagonal: " + isDiag);
    }
}
