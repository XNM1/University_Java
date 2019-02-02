/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.edu.chmnu.fks.oop.Lab02;

import java.util.Scanner;

/**
 *
 * @author 1710533
 */
public class Lab02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double y = 0;
        System.out.println("1.Розрахувати функцію з заданими параметрами");
        System.out.print("2.Розрахувати функцію з випадковими параметрами\nОберіть варіант: ");
        switch(scan.nextInt()) {
            case 1:
                y = function(-2, -1.1, -2.14, 6.3);
                break;
            case 2:
                double x, a, b, c;
                do {
                    x = Math.random() * 10;
                    a = Math.random() * 10;
                    b = Math.random() * 10;
                    c = Math.random() * 10;
                } while((x - a) < 0 || (c * x) < 0 || (b * Math.pow(x, 3) - 3) <= 0);
                y = function(x, a, b, c);
                break;
        }
        System.out.println("y = " + y);
        //----------------------extremums-----------------------------------------
        int N = 500;
        double xl = -3.3, xr = 1.1, h = (xr - xl) / N, a = -1.1, b = -2.14, c = 6.3;
        for (int i = 1; i < N; ++i) {
            double x = xl + i * h;
            double y1 = function(x - h, a, b, c), y2 = function(x + h, a, b, c);
                    y = function(x, a, b, c);
            double dy1 = y - y1, dy2 = y2 - y;
            if (Math.signum(dy1) != Math.signum(dy2)) {
                if (dy1 < 0 && dy2 > 0) {
                    System.out.printf("Min (%.3f, %.3f)\n", x, y);
                } else if (dy1 > 0 && dy2 < 0) {

                    System.out.printf("Max (%.3f, %.3f)\n", x, y);
                }
            }
        }
    }
    
    private static double function(double x, double a, double b, double c) {
        return (a * Math.log((c * x)/(b * Math.pow(x, 3) - 3)))/(Math.pow(Math.E, a * x) + c * Math.log(x - a));
    }
}
