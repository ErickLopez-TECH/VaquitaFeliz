package Logica;

import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author triamus
 */
public class GestionAlimentos {
    
    private static Scanner leer = new Scanner(System.in);
    
    //--cracion de la array 

    static int[] codigoAlimento = new int [100];
    static String[] nombreAlimento = new String [100];
    static String[] tipoAlimento = new String [100];
    static int[] coscoAlimento = new int [100];
    static float[] cantidadAlimento = new float [100];
    
    public static void  gestionAlimentos(){
     int opcion = 0;
        do {            
            System.out.println("-----------------------------------------");
            System.out.println("|          GESTION DE ALIMENTOS         |");
            System.out.println("-----------------------------------------");
            System.out.println("Ingrese una opcion(1-5), luego presione");
            System.out.println("la tecla enter.");
            System.out.println("1.Regristrar alimento");
            System.out.println("2.Modificar alimento");
            System.out.println("3.Eliminar de alimentacion");
            System.out.println("4.Consultar de produccion");
            System.out.println("5.Regresar al menu principal");
            
            opcion = leer.nextInt();
            
            switch (opcion) {
                case 1: 
                    
                    break;
                case 2:   
                    
                    break;
                    
                case 3:
                    
                    break;
                    
                case 4:
                    
                    break;
                    
                case 5:
                    
                    break;
                    
                    
                                 
            }
            
        } while (opcion < 6);
        
    }
    
    
    
    public static void registrarAlimento(){
        
        int indice = 0;
        
            System.out.println("-----------------------------------------");
            System.out.println("|          REGISTRO DE ALIMENTOS        |");
            System.out.println("-----------------------------------------");
            
            
            leer.nextLine();
            nombreAlimento[indice] = leer.nextLine();
    }
    
    
    
    
}