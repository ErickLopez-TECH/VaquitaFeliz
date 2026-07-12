/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author triamus
 */
public class ReportesAlimentacion {
    
    public static void reportesInsumos(){
      
        System.out.println("-----------------------------------");
        System.out.println("SEM\tVACA\tALIMENTO\tCANTIDAD");
        System.out.println("-----------------------------------");

        for (int i = 0; i < 100; i++) {
            if (!RegistroAlimentacion.registroAlimentacion[i][0].equals("")) {

                double total = Double.parseDouble(RegistroAlimentacion.registroAlimentacion[i][10]);

                if (total > 0) {

                    String codigoVaca = RegistroAlimentacion.registroAlimentacion[i][1];
                    String codigoAlimento = RegistroAlimentacion.registroAlimentacion[i][2];

                    String nombreVaca = "";
                    for (int j = 0; j < 100; j++) {
                        if (GestionVacas.listaVacas[j][0].equals(codigoVaca)) {
                            nombreVaca = GestionVacas.listaVacas[j][1];
                        }
                    }

                    String nombreAlimento = "";
                    for (int j = 0; j < 100; j++) {
                        if (GestionAlimentos.inventario[j][0].equals(codigoAlimento)) {
                            nombreAlimento = GestionAlimentos.inventario[j][1];
                        }
                    }

                    System.out.print(RegistroAlimentacion.registroAlimentacion[i][0] + "\t");

                    System.out.print(nombreVaca + "\t");

                    System.out.print(nombreAlimento + "\t");

                    System.out.print(total + "\t");

                }
            }
        }
        System.out.println("\n-----------------------------------");
    }
}