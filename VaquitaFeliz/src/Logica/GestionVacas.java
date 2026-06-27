/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.Scanner;

/**
 *
 * @author hiro
 */
public class GestionVacas {
    //--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
    //variables globales 
    
    private  static Scanner leer = new Scanner(System.in);
    
    static String[][] listaVacas = new String[100][5];
    
    
    
    
    
    
    
    
    
    
    
    public static void gestionVacas(){
        
        int opcion = 0;
        
        do {            
            System.out.println("-----------------------------------------");
            System.out.println("|             Gestion Vacas             |");
            System.out.println("-----------------------------------------");
            System.out.println("Ingrese una opcion(1-5), luego presione");
            System.out.println("la tecla enter.");
            System.out.println("1.Registrar Vaca");
            System.out.println("2.Modificar Vaca");
            System.out.println("3.Eliminar Vaca");
            System.out.println("4.Consultar Vaca");
            System.out.println("5.Regresar");
           
            opcion = leer.nextInt();
            
            switch (opcion) {
                case 1:registrarVacas();
                    
                    break;
                case 2:
                    break;
                case 3: 
                    break;
                case 4: ;
                    break;
                case 5:
                    break; 
            }
            
            
            
            
        } while (opcion < 6);
        
        
    }
public static int siguienteVaca() {
    int indice = -1;
    for (int i = 0; i < 100; i++) {
        // Ahora acepta si es null O si es una cadena vacía
        if ( listaVacas[i][0] == "") {
            indice = i;
            break;
        }
    }
    return indice;
}
     
     
    public static void registrarVacas(){
        int fila = siguienteVaca();
       
        System.out.println("-----------------------------------------");
        System.out.println("|             REGISTRO VACAS             |");
        System.out.println("-----------------------------------------");
        leer.nextLine();
        
         System.out.println("");
         System.out.println("Digite nombre de la vaca: ");
         String nombre = leer.nextLine();
         
         System.out.println("");
         System.out.println("Digite el codigo: ");
         int codigo = leer.nextInt();
         
         System.out.println("");
         System.out.println("Digite la edad: ");
         int edad = leer.nextInt();
         
         System.out.println("");
         System.out.println("Digite el peso: ");
         double peso = leer.nextDouble();
          
         leer.nextLine();
         System.out.println("");
         System.out.println("Digite el estado productivo: ");
         String estadoProductivo = leer.nextLine();
         
        listaVacas[fila][0]= String.valueOf(codigo);
        listaVacas[fila][1]= nombre;
        listaVacas[fila][2]= String.valueOf(edad);
        listaVacas[fila][3] =String.valueOf(peso);
        listaVacas[fila][4]= estadoProductivo;
            
            
            
        }
        
    
    

    /*
public static void mostrarVacas() {
    System.out.println("--- Lista de Vacas ---");
    for (int i = 0; i < 100; i++) {
        // Solo mostramos si el valor NO es la cadena vacía que asignamos al inicio
        if (nombreVaca[i] != "") {
            System.out.println("Vaca " + (i + 1) + ": " + nombreVaca[i]);
        }
    }
}*/
}

