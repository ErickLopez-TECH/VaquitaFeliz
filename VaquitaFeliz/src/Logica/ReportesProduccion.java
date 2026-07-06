/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author triamus
 */
public class ReportesProduccion {
    public static void mostrarProduccion() {
    System.out.println("-----------------------");
    System.out.println("SEM\tNOMBRE\tTOTAL");
    System.out.println("-----------------------");

    for (int i = 0; i < 100; i++) {
        if (RegistroProduccion.listaProduccion[i][0] != "") {
            // Imprimimos los campos básicos
            
            
            // Si el nombre es corto, usamos dos tabs para compensar
            System.out.print(RegistroProduccion.listaProduccion[i][2] + "\t");
            
            System.out.print(RegistroProduccion.listaProduccion[i][1] + "\t");
            
            System.out.print(RegistroProduccion.listaProduccion[i][10] + "\t");
            
            
        }
    }
    System.out.println("\n-----------------------");
}
}
