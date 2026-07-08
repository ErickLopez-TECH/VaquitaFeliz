/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.Scanner;

/**
 *
 * @author Erick
 */
public class MenuReportes {
    
    static Scanner leer = new Scanner(System.in);
    
     public static void menuPrincipal(){
        int opciones= 0;
    
        
      
        
        do {            
            System.out.println("-----------------------------------------");
            System.out.println("|    REPORTES ALIMENTACION/PRODUCCION   |");
            System.out.println("-----------------------------------------");
            System.out.println("Ingrese una opcion(1-2), luego presione");
            System.out.println("la tecla enter.");
            System.out.println("1.Reportes Alimentacion");
            System.out.println("2.Reportes Produccion");
            System.out.println("3.Regresar");
            opciones = leer.nextInt();
            
            
            //Estructura de control y decision
            switch(opciones){
                case 1:;
                    break;
                case 2: ReportesProduccion.mostrarProduccion();
                    break;
                case 3: return;
                    
              
            }
            
            
            if((opciones >3) || (opciones <1)){
                System.out.println("-----------------------------------------");
                System.out.println("|             OPCION INCORRECTA         |");
                System.out.println("-----------------------------------------");
                menuPrincipal();
            }
        } while ((opciones <1) || (opciones > 3));
    }
    
   


   
    
}
    

