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
    //--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
    private static Scanner leer = new Scanner(System.in);
    
    //--cracion de la array 

    static int[] codigoAlimento = new int [100];
    static String[] nombreAlimento = new String [100];
    static String[] tipoAlimento = new String [100];
    static int[] coscoAlimento = new int [100];
    static float[] cantidadAlimento = new float [100];
    public static String[][] inventario = new String[50][5];
    
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
                case 1:registrarAlimento();
                    
                    break;
                case 2:modificarAlimento();
                    
                    break;
                    
                case 3:eliminarAlimento();
                    
                    break;
                    
                case 4:consultarAlimentos();
                    
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
            
    
// 1. Buscar la primera posicion null (libre) en el arreglo
        int fila = -1;
        for (int i = 0; i < 50; i++) {
            if (inventario[i][0] == null) {
                fila = i;
                break;
            }
        }
 
        if (fila == -1) {
            System.out.println("[!] Error: El inventario esta lleno.");
            return;
        }
 
        leer.nextLine();
 
        System.out.println("");
        System.out.println("Digite el codigo del alimento: ");
        String codigo = leer.nextLine();
 
        // Validacion de codigo duplicado (recorre solo posiciones no nulas)
        for (int i = 0; i < 50; i++) {
            if (inventario[i][0] != null && inventario[i][0].equals(codigo)) {
                System.out.println("[!] Codigo existente en el registro");
                return;
            }
        }
 
        System.out.println("");
        System.out.println("Digite el nombre del alimento: ");
        String nombre = leer.nextLine();
 
        // Validacion de nombre duplicado usando equals()
        for (int i = 0; i < 50; i++) {
            if (inventario[i][1] != null && inventario[i][1].equals(nombre)) {
                System.out.println("[!] Nombre existente en el registro");
                return;
            }
        }
 
        System.out.println("");
        System.out.println("Digite el tipo de alimento: ");
        String tipo = leer.nextLine();
 
        // Validacion: el costo por Kg debe ser un valor positivo
        int costoPorKg;
        do {
            System.out.println("");
            System.out.println("Digite el costo por Kg: ");
            costoPorKg = leer.nextInt();
 
            if (costoPorKg <= 0) {
                System.out.println("[!] Error: El costo debe ser un valor positivo");
            }
        } while (costoPorKg <= 0);
 
        // Validacion: la cantidad disponible no puede ser negativa
        float cantidadDisponible;
        do {
            System.out.println("");
            System.out.println("Digite la cantidad disponible (Kg): ");
            cantidadDisponible = leer.nextFloat();
 
            if (cantidadDisponible < 0) {
                System.out.println("[!] Error: La cantidad no puede ser negativa");
            }
        } while (cantidadDisponible < 0);
 
        // Se guardan los datos en la fila libre encontrada
        inventario[fila][0] = codigo;
        inventario[fila][1] = nombre;
        inventario[fila][2] = tipo;
        inventario[fila][3] = String.valueOf(costoPorKg);
        inventario[fila][4] = String.valueOf(cantidadDisponible);
 
        System.out.println("\n[+] Alimento registrado con exito.");
    }
 
 
 
 
    /*
      -----------------------------------------------------------
     |   modificarAlimento() - Actualizacion                       |
     |   Busca por codigo dentro del arreglo. Al encontrar         |
     |   coincidencia, solicita los nuevos valores para actualizar  |
     |   el costo y la cantidad disponible del insumo.             |
      -----------------------------------------------------------*/
    public static void modificarAlimento() {
 
        System.out.println("-----------------------------------------");
        System.out.println("|          Modificar Alimento            |");
        System.out.println("-----------------------------------------");
        leer.nextLine();
        System.out.println("Digite el codigo del alimento a modificar: ");
        String codigoBuscado = leer.nextLine();
 
        int encontrado = -1;
        for (int i = 0; i < 50; i++) {
            if (inventario[i][0] != null && inventario[i][0].equals(codigoBuscado)) {
                encontrado = i;
                break;
            }
        }
 
        if (encontrado == -1) {
            System.out.println("\n[!] No se encontro un alimento con ese codigo.");
            return;
        }
 
        System.out.println("-----------Datos Actuales--------------------------");
        System.out.println("Codigo\tNombre\tTipo\tCostoKg\tCantidad");
        System.out.println("---------------------------------------------------");
        System.out.println(inventario[encontrado][0] + "\t" +
                inventario[encontrado][1] + "\t" +
                inventario[encontrado][2] + "\t" +
                inventario[encontrado][3] + "\t" +
                inventario[encontrado][4]);
        System.out.println("---------------------------------------------------");
 
        // Solo se actualizan costo y cantidad disponible (codigo, nombre y tipo no cambian)
        int nuevoCosto;
        do {
            System.out.println("Digite el NUEVO costo por Kg: ");
            nuevoCosto = leer.nextInt();
 
            if (nuevoCosto <= 0) {
                System.out.println("[!] Error: El costo debe ser un valor positivo");
            }
        } while (nuevoCosto <= 0);
 
        float nuevaCantidad;
        do {
            System.out.println("Digite la NUEVA cantidad disponible (Kg): ");
            nuevaCantidad = leer.nextFloat();
 
            if (nuevaCantidad < 0) {
                System.out.println("[!] Error: La cantidad no puede ser negativa");
            }
        } while (nuevaCantidad < 0);
 
        inventario[encontrado][3] = String.valueOf(nuevoCosto);
        inventario[encontrado][4] = String.valueOf(nuevaCantidad);
 
        System.out.println("\n[+] Alimento modificado con exito.");
    }
 
 
 
 
    /*
      -----------------------------------------------------------
     |   eliminarAlimento() - Depuracion                           |
     |   Localiza el alimento por codigo y establece el indice      |
     |   correspondiente a null, liberando el espacio en el         |
     |   arreglo.                                                    |
      -----------------------------------------------------------*/
    public static void eliminarAlimento() {
 
        System.out.println("--------------------------------------------------");
        System.out.println("|              Eliminar Alimento                 |");
        System.out.println("--------------------------------------------------");
        leer.nextLine();
        System.out.println("Digite el codigo del alimento a eliminar: ");
        String codigoBuscado = leer.nextLine();
 
        int encontrado = -1;
        for (int i = 0; i < 50; i++) {
            if (inventario[i][0] != null && inventario[i][0].equals(codigoBuscado)) {
                encontrado = i;
                break;
            }
        }
 
        if (encontrado == -1) {
            System.out.println("\n[!] No se encontro un alimento con ese codigo.");
            return;
        }
 
        System.out.println("\n--- Datos del Alimento a Eliminar ---");
        System.out.println("Codigo: " + inventario[encontrado][0]);
        System.out.println("Nombre: " + inventario[encontrado][1]);
        System.out.println("-----------------------------------\n");
 
        // Se establecen todas las columnas de la fila en null, liberando el espacio
        for (int j = 0; j < 5; j++) {
            inventario[encontrado][j] = null;
        }
 
        System.out.println("[+] Alimento eliminado con exito.");
    }
 
 
 
 
    /*
      -----------------------------------------------------------
     |   consultarAlimentos() - Visualizacion                      |
     |   Itera sobre el arreglo, validando if (inventario[i][0] !=  |
     |   null) para mostrar unicamente los registros existentes.    |
      -----------------------------------------------------------*/
    public static void consultarAlimentos() {
 
        System.out.println("-----------------------------------------------------");
        System.out.println("|              LISTA DE ALIMENTOS                   |");
        System.out.println("-----------------------------------------------------");
        System.out.println("INDICE\tCODIGO\tNOMBRE\tTIPO\tCOSTO/KG\tCANTIDAD");
        System.out.println("-----------------------------------------------------");
 
        for (int i = 0; i < 50; i++) {
 
            // Filtro de nulos: solo se muestran los registros existentes
            if (inventario[i][0] != null) {
 
                System.out.println("[" + (i + 1) + "]\t" +
                        inventario[i][0] + "\t" +
                        inventario[i][1] + "\t" +
                        inventario[i][2] + "\t" +
                        inventario[i][3] + "\t" +
                        inventario[i][4]);
            }
        }
        System.out.println("-----------------------------------------------------");
    }
 
}