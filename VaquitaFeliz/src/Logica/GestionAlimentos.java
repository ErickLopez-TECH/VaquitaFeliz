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
    
    //Areglo de objetos - 50 espacios - todos inician en null
    static Alimento[] inventario = new Alimento[50];
    
    //--cracion de la array 

    static int[] codigoAlimento = new int [100];
    static String[] nombreAlimento = new String [100];
    static String[] tipoAlimento = new String [100];
    static int[] coscoAlimento = new int [100];
    static float[] cantidadAlimento = new float [100];
    private static float nuevaCantidad;
    
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
                case 1: registrarAlimentos();
                    
                    break;
                case 2:modificarAlimentos();
                    
                    break;
                    
                case 3:eliminarAlimento();
                    
                    break;
                    
                case 4:consultarAlimentos();
                    
                    break;
                    
                case 5:System.out.println("Regresando...");
                    
                    break;
                default : System.out.println("Opcion no valida");
                    
                                 
            }
            
        } while (opcion != 5);
        
    }
    
    public static void registrarAlimentos(){
        //buscar espacio vacio en el areglo
        int indice = -1;
        for (int i = 0; i < inventario.length; i++){
            if (inventario[1] == null){
                indice = i;
                break;
            }
        }
        
        // si no hay espacio salir 
        if (indice == -1){
            System.out.println("Inventario lleno.");
            return;
        }
        
        System.out.println("-----------------------------------------");
        System.out.println("|        REGISTRO DE ALIMENTOS          |");
        System.out.println("-----------------------------------------");
        
        leer.nextLine();
         System.out.print("Codigo: ");
        int codigo = leer.nextInt();
        
        leer.nextLine();
        System.out.print("Nombre: ");
        
        String nombre = leer.nextLine();
        System.out.print("Tipo (Concentrado, Forraje...): ");
        
        String tipo = leer.nextLine();
        // Validar costo positivo
        int costo = 0;
        
        do{
            System.out.println("Costo por Kg: ");
            costo = leer.nextInt();
            if (costo <= 0) System.out.println("Debe ser mayor a 0.");
        } while (costo <= 0);
        // Validar cantidad no negativa 
        float cantidad = -1;
        do{
            System.out.print("Costo por kg: ");
            cantidad = leer.nextFloat();
            if (cantidad < 0) System.out.println("no puede ser negativa.");
            
        } while (cantidad < 0);
        
        //Guardar el objeto en el areglo
        inventario[indice] = new Alimento(codigo, nombre, tipo, costo, cantidad);
        System.out.println("Registrado en posicion " + (indice + 1));
        
        
    }
    
    public static void modificarAlimentos(){
        System.out.println("-----------------------------------------");
        System.out.println("|        MODIFICAR ALIMENTO             |");
        System.out.println("-----------------------------------------");
        System.out.print("Codigo a modificar: ");
        int codigo = leer.nextInt();
        boolean encontrado = false;
        for (int i = 0; i < inventario.length; i++){
        if (inventario[i] != null && inventario[i].codigo == codigo){
            int nuevoCosto = 0;  
            do{
                System.out.print("Nueva cantidad en Kg: ");
                nuevaCantidad = leer.nextFloat();
                if (nuevaCantidad < 0) System.out.println("no puede ser negativa.");

            } while (nuevaCantidad < 0);
            inventario[i].costoKg = nuevoCosto;
            inventario[i].cantidadDisponible = nuevaCantidad;
            System.out.println("Actualizado exitosamente");
            encontrado = true;
            break;
            
        }
        if (!encontrado) System.out.println("No se encontro ese codigo.");
        
    }
            
        
    }
    public static void eliminarAlimento(){
        System.out.println("-----------------------------------------");
        System.out.println("|         ELIMINAR ALIMENTO             |");
        System.out.println("-----------------------------------------");
        System.out.print("Codigo a eliminar: ");
        int codigo = leer.nextInt();
        boolean encontrado = false;
        for (int i = 0;  i < inventario.length; i++){
            if(inventario [i] != null && inventario[i].codigo == codigo){
               inventario[i] = null;
               System.out.println("eliminado exitosamente.");
               encontrado = true;
               break;
            }
            if (!encontrado) System.out.println("No se encontro ese codigo");
            
        }     
        
    }
    
    public static void consultarAlimentos(){
         System.out.println("------------------------------------------------------------------");
        System.out.println("|                INVENTARIO DE ALIMENTOS                        |");
        System.out.println("------------------------------------------------------------------");
        System.out.printf("%-8s %-20s %-15s %-12s %-12s%n",
                "Codigo","Nombre","Tipo","Costo/Kg","Cantidad(Kg)");
        System.out.println("------------------------------------------------------------------");
        boolean hayDatos = false;
        for (int i = 0; i < inventario.length; i++){
            if(inventario[i] != null){
                System.out.print("%-8d %-20s %-15s %-12d %-12.2f%n",
                        inventario[i].codigo,
                        inventario[i].nombre,
                        inventario[i].tipo,
                        inventario[i].costoPorkg,
                        inventario[i].cantidadDisponible);
                hayDatos = true;
            }
        }
          if (!hayDatos) System.out.println("No hay alimentos registrados.");
        System.out.println("------------------------------------------------------------------");
    }
    
    
}
