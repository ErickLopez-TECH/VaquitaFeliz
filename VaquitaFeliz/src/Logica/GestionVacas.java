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
    
    //variables globales 
    
    private  static Scanner leer = new Scanner(System.in);
    
    static int[] codigoVaca = new int[100];
    static String[] nombreVaca = new String[100];
    static String[] nombreVacas = new String[100];
    static int[] edadVaca = new int[100];
    static float[] pesoVaca = new float[100];
    static String[] estadoProductivo = new String[100];
    
    
    
    
    
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
                case 4: mostrarVacas();
                    break;
                case 5:
                    break; 
            }
            
            
            
            
        } while (opcion < 6);
        
        
    }
     public  static int siguienteVaca(){
           //-1 porque el rango de trabajo es 0 - 199
           int indice = -1;
           for(int i= 0; i<100; i++){
               if(nombreVaca[i] == ""){
                   indice = i;
                   
                   //en el momento que usted encuentre ese espacio vacio termine el proceso
                   break;
                   
               }
           }
        return indice;
       }
     
     
    public static void registrarVacas(){
        int indice = siguienteVaca();
        
        System.out.println("-----------------------------------------");
        System.out.println("|             REGISTRO VACAS             |");
        System.out.println("-----------------------------------------");
        
        leer.nextLine();
        
        System.out.println("Digite el nombre de la vaca");
        nombreVaca[indice] = leer.nextLine();
      
       
        
    }
    
     public static void mostrarVacas(){
            //con el ciclo for mostramos los datos
            
            //no mostrar loq ue esta vacio
                for(int i = 0; i <200; i++){
                    
                  /*  if(nombreHabitaciones[i]!= null){
                       System.out.println("Habitaciones "+ (i+1) + " :"+ nombreHabitaciones[i]); 
                    }*/
                    
                      if((nombreVaca[i]!= "")){
                       System.out.println("Nombre de vaca:  "+ (i+1) + " :"+ nombreVaca[i]); 
                    }
                  
                }
       }
    
    
}
