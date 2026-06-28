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
    
    static int[] comparacionDatos = new int[100];
    
    
    
    
    
    
    
    
    
    
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
                case 2: modificarVacas();
                    break;
                case 3: 
                    break;
                case 4: consultarVacas();
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
     
     
// OJO: Debes declarar este arreglo de números arriba en tu clase, 
// a la par de donde creaste 'listaVacas'. Por ejemplo:
// static int[] codigosVacas = new int[100]; 

public static void registrarVacas(){
    int fila = siguienteVaca();
    
    System.out.println("-----------------------------------------");
    System.out.println("|            REGISTRO VACAS             |");
    System.out.println("-----------------------------------------");
    leer.nextLine();
    
    System.out.println("");
    System.out.println("Digite nombre de la vaca: ");
    String nombre = leer.nextLine();
     
    System.out.println("");
    System.out.println("Digite el codigo: ");
    int codigo = leer.nextInt();
     
    
    int duplicado = 0;
     
  
    for (int i = 0; i < 100; i++) {
        
        if ( listaVacas[i][0] != "") {
        
        // Segundo: Si hay datos, comparamos el código del arreglo con el que digitó el usuario
       
        if (comparacionDatos[i] == codigo) {
            duplicado = 1; // si existe
        }
    }
     
    }
    if (duplicado == 1) {
        System.out.println("\n[!] Error: El código de la vaca ya existe.");
        return; // termina el proceso de una vez
    }
    // --------------------------------------------------------
     
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
     
    // Guardamos en tu matriz normal de Strings
    listaVacas[fila][0] = String.valueOf(codigo);
    listaVacas[fila][1] = nombre;
    listaVacas[fila][2] = String.valueOf(edad);
    listaVacas[fila][3] = String.valueOf(peso);
    listaVacas[fila][4] = estadoProductivo;
    
    // Guardamos el código en el arreglo de números para la próxima validación
    comparacionDatos[fila] = codigo;
    
    System.out.println("\n[+] Vaca registrada con éxito.");
}

public static void modificarVacas() {
    int indice;
    
   
    do {           
        System.out.println("-----------------------------------------");
        System.out.println("|           Modificar Vacas             |");
        System.out.println("-----------------------------------------");
        System.out.println("Digite el índice a modificar (1-100): ");
      
        indice = leer.nextInt();
        leer.nextLine(); // Limpiar el buffer 
       
    } while ((indice > 100) || (indice < 1));
    
    
    int fila = indice - 1;
    
    // 2. Si la posición no está vacía, permite modificar
    if (listaVacas[fila][0] != null && !listaVacas[fila][0].equals("")) {
        
        System.out.println("\n--- Datos Actuales ---");
        System.out.println("Código: " + listaVacas[fila][0]);
        System.out.println("Nombre: " + listaVacas[fila][1]);
        System.out.println("-----------------------\n");

        System.out.println("Digite el NUEVO nombre de la vaca: ");
        String nombre = leer.nextLine();
        
        System.out.println("Digite el NUEVO código: ");
        int codigo = leer.nextInt();
        
        System.out.println("Digite la NUEVA edad: ");
        int edad = leer.nextInt();
        
        System.out.println("Digite el NUEVO peso: ");
        double peso = leer.nextDouble();
        
        leer.nextLine(); // Limpiar buffer del double
        System.out.println("Digite el NUEVO estado productivo: ");
        String estadoProductivo = leer.nextLine();
        
        // 3. Se guardan los nuevos datos
        listaVacas[fila][0] = String.valueOf(codigo);
        listaVacas[fila][1] = nombre;
        listaVacas[fila][2] = String.valueOf(edad);
        listaVacas[fila][3] = String.valueOf(peso);
        listaVacas[fila][4] = estadoProductivo;
        
        System.out.println("\n[+] ¡Vaca modificada con éxito en el índice " + indice + "!");
        
    } else {
        // Si el código o el nombre estaban vacíos
        System.out.println("\n[!] La posición " + indice + " está vacía. No se puede modificar.");
    }
}

public static void consultarVacas() {
    System.out.println("---------------------------------------------------------------------------------------------");
    System.out.println("|                                      LISTA DE VACAS                                       |");
    System.out.println("---------------------------------------------------------------------------------------------");
    
    // Encabezados de la tabla separados  (\t)
    System.out.println("ÍNDICE\tCÓDIGO\tNOMBRE\tEDAD\tPESO\tESTADO PRODUCTIVO");
    System.out.println("---------------------------------------------------------------------------------------------");
    
   
    for (int i = 0; i < 100; i++) {
        
        
        if (listaVacas[i][0] != null && listaVacas[i][0] != "") {
            
            int numeroPosicion = i + 1; // Índice 1 no 0
            
            // Imprimimos la fila usando \t para separar cada columna
            System.out.println("[" + numeroPosicion + "]\t" +
                               listaVacas[i][0] + "\t" +
                               listaVacas[i][1] + "\t" +
                               listaVacas[i][2] + "\t" +
                               listaVacas[i][3] + "\t" +
                               listaVacas[i][4]);
        }
    }
    System.out.println("---------------------------------------------------------------------------------------------");
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

