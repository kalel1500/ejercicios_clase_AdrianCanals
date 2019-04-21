/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package n15_vector2_funcion;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class N15_vector2_funcion {

    /**
     * @param args the command line arguments
     */
    static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Double> lista=new ArrayList<Double>();
        ArrayList<M_Media> listaMediaTotal = new ArrayList<M_Media>();
        String nombreMateria;
        
        // Bucle que va pidiendo materias hasta que recive una q
        do {
            System.out.println("Introduce el nombre de la materia");
            nombreMateria = teclado.next();
            //calcularMedia(lista, nombreMateria);
            if (!nombreMateria.equals("q")) {
                calcularMedia(lista, nombreMateria, listaMediaTotal);
            } else {
                break;
            }
        } while (nombreMateria != "q");
        System.out.println("-------------------");
        System.out.println("RESUMEN");
        for (M_Media a:listaMediaTotal) {
            System.out.println(a.getNombre() + ": " + a.getNotaMedia());
        }
        
        // Se establecen las materias manualmente
        /*System.out.println("Introduce el nombre de la materia1");
        String nombreMateria1 = teclado.next();
        System.out.println("Introduce el nombre de la materia2");
        String nombreMateria2 = teclado.next();
        
        calcularMedia(lista, nombreMateria1);
        calcularMedia(lista, nombreMateria2);*/
    }
    
    public static void calcularMedia (ArrayList<Double> lista, String materia, ArrayList<M_Media> listaMediaTotal) {
        double nota;
        double media = 0;
        System.out.println("Escribe las notas de " + materia + " (pulse -1 para salir)");
        lista.clear();
        do {
            System.out.println("Escribe la nota " + (lista.size()+1));
            nota = teclado.nextDouble();
            if (nota>=0) {
                lista.add(nota);
            }
        } while (nota>=0);
        
        for (Double a:lista) {
            media = media + a;
        }
        media = media/(lista.size());
        System.out.println("La media es de " + materia + " es: " + media);
        /*M_Media juntar = new M_Media();
        juntar.setNombre(materia);
        juntar.setNotaMedia(media);*/
        M_Media juntar = new M_Media(materia,media);
        listaMediaTotal.add(juntar);
        System.out.println("----");
    }
    
}
