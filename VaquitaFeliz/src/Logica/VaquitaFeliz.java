/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Logica;

import java.util.Scanner;

/**
 *
 * @author triamus
 */
public class VaquitaFeliz {

    /**
     * @param args the command line arguments
     */
    /*-------------------------------------------/
    |            VARIABLES GLOBALES|
    ------------------------------------------  */
    private static Scanner leer = new Scanner(System.in);
    
    /*-------------------------------------------/
    | MENU PRINCIPAL,GESTION DE TODOS LOS MODULOS|
    ------------------------------------------  */
    public static void menuPrincipal(){
        int opciones= 0;
    
        
        for(int i = 0; i<100; i++){
            for (int j = 0; j < 5; j++) {
                GestionVacas.listaVacas[i][j]="";
                
            }
        }
        do {            
            System.out.println("-----------------------------------------");
            System.out.println("|             VAQUITA FELIZ             |");
            System.out.println("-----------------------------------------");
            System.out.println("Ingrese una opcion(1-5), luego presione");
            System.out.println("la tecla enter.");
            System.out.println("1.Gestion de vacas");
            System.out.println("2.Gestion de alimentos");
            System.out.println("3.Registro de alimentacion");
            System.out.println("4.Registro de produccion");
            System.out.println("5.Reportes produccion/Alimentacion");
            System.out.println("6.Cerrar Sistema");
            opciones = leer.nextInt();
            
            
            //Estructura de control y decision
            switch(opciones){
                case 1: GestionVacas.gestionVacas();
                    break;
                case 2:GestionAlimentos.gestionAlimentos();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
            if(opciones ==6){
                System.out.print(0);
            }
            
            if((opciones >6) || (opciones <1)){
                System.out.println("-----------------------------------------");
                System.out.println("|             OPCION INCORRECTA         |");
                System.out.println("-----------------------------------------");
                menuPrincipal();
            }
        } while (opciones <6 );
    }
    
    // Debes llamar a este método una vez al iniciar tu programa


    public static void main(String[] args) {
        // TODO code application logic here
        menuPrincipal();
       
    }
    
}
