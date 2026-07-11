/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author Erick
 */

//Crud de reportes produccion
public class ReportesProduccion {
    public static void mostrarProduccion() {
    System.out.println("-----------------------");
    System.out.println("SEM\tNOMBRE\tTOTAL");
    System.out.println("-----------------------");

    for (int i = 0; i < 100; i++) {
        if (RegistroProduccion.listaProduccion[i][0] != "") {
        
            
            
            //cada system me muestra un dato guardadoapartir de cata for
            System.out.print(RegistroProduccion.listaProduccion[i][2] + "\t");
            
            System.out.print(RegistroProduccion.listaProduccion[i][1] + "\t");
            
            System.out.print(RegistroProduccion.listaProduccion[i][10] + "\t");
            
            System.out.println("");
            
        }
    }
    System.out.println("\n-----------------------");
}
}
