/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Usuario
 */
final public class Soleqsegongraucompl extends Soleqsegongrau {
    int numsolu;
    double sol1;
    double sol2;
    
    public Soleqsegongraucompl() {
    }

    public Soleqsegongraucompl(double coeficiente1, double coeficiente2, double coeficiente3) {
        super(coeficiente1, coeficiente2, coeficiente3);
    }

    public int getNumsolu() {
        return numsolu;
    }

    public double getSol1() {
        return sol1;
    }

    public double getSol2() {
        return sol2;
    }

    public void setNumsolu(int numsolu) {
        this.numsolu = numsolu;
    }

    public void setSol1(double sol1) {
        this.sol1 = sol1;
    }

    public void setSol2(double sol2) {
        this.sol2 = sol2;
    }
    
    
    public void eqsegongraucompl (double coeficiente1, double coeficiente2, double coeficiente3) {
        int dircriminante = discriminant (coeficiente1, coeficiente2, coeficiente3);
        if (dircriminante == 1) {
            double res = -coeficiente2 / (2*coeficiente1);
            // System.out.println("Tiene una solucion, y es: " + res);
            this.numsolu = 1;
            this.sol1 = res;
        }
        if (dircriminante == 0) {
            this.numsolu = 0;
            // System.out.println("No tiene soluciones");
        }
        if (dircriminante == 2) {
            double a = coeficiente1;
            double b = coeficiente2;
            double c = coeficiente3;
            double raiz = Math.sqrt(b*b-(4*a*c));
            double res1 = (-b + raiz)/(2*a);
            double res2 = (-b - raiz)/(2*a);
            /*System.out.println("Tiene dos soluciones: ");
            System.out.println("X1: " + res1);
            System.out.println("X2: " + res2);*/
            this.numsolu = 2;
            this.sol1 = res1;
            this.sol2 = res2;
        }
    }
}
