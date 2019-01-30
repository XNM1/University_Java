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
        System.out.println("1.Розрахувати функцію з випадковими параметрами\nОберіть варіант: ");
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
                } while((x - a) < 0 || (c * x) < 0 || (b * Math.pow(x, 3) - 3) < 0);
                y = function(x, a, b, c);
                break;
        }
        System.out.println("y = " + y);
    }
    
    public static double function(double x, double a, double b, double c) {
        return (a * Math.log((c * x)/(b * Math.pow(x, 3) - 3)))/(Math.pow(Math.E, a * x) + c * Math.log(x - a));
    }
}
