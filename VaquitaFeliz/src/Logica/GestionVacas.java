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
public class GestionVacas {
    
    //variables globales 
    public static String[][] listaVacas = new String[100][5];
    
    static {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 5; j++) {
                listaVacas[i][j] = "";
            }
        }
    }
    
    private  static Scanner leer = new Scanner(System.in);
    
   
    
  //  static int[] comparacionDatos = new int[100];
    
    static int numeroPosicion ;
    
    
    
    
    
    
    
    
    
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
                case 3: eliminarVacas();
                    break;
                case 4: consultarVacas();
                    break;
                case 5: VaquitaFeliz.menuPrincipal();
                    
            }
            
            if((opcion <1) || (opcion >5)){
                System.out.println("[!] error: Ingrese una opcion valida entre 1-5");
            }
            
            
        } while ((opcion <5 )|| (opcion >5));
        
        
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
    System.out.println("|            REGISTRO VACAS             |");
    System.out.println("-----------------------------------------");
    leer.nextLine();
    
    System.out.println("");
    System.out.println("Digite nombre de la vaca: ");
    String nombre = leer.nextLine();
     
    //comparacion con los datos ya guardados
    for (int i = 0; i < 100; i++) {
        if ((listaVacas[i][1].equals(nombre))) {
            System.out.println("[!] Nombre existente en el registro");
            return;
        }
        
    }
    
    System.out.println("");
    System.out.println("Digite el codigo: ");
    String codigo = leer.nextLine();
     
    
    
    //int duplicado = 0;
     
  //comparacion con el codigo
    for (int i = 0; i < 100; i++) {
        
        if ( listaVacas[i][0].equals(codigo)) {
        
            System.out.println("[!] Codigo existente en el registro");
            return;
        
       // if (comparacionDatos[i] == codigo) {
           // duplicado = 1; // si existe
       // }
    }
     
    }
   /* if (duplicado == 1) {
        System.out.println("\n[!] Error: El código de la vaca ya existe.");
        return; // termina el proceso de una vez
    }*/
    // --------------------------------------------------------
     
    System.out.println("");
    System.out.println("Digite la edad: ");
    int edad = leer.nextInt();
     
    System.out.println("");
    System.out.println("Digite el peso: ");
    double peso = leer.nextDouble();
    
    //Inicializacion de variables
    int estadoProductivo = 0;
    String estadoVaca   = "";
    
    
    do { 
        
        leer.nextLine(); 
        System.out.println("");
      /*  System.out.println("Digite el estado productivo: ");*/
        System.out.println("Digite el estado productivo al cual se muestra: ");
        System.out.println("1. Secas");
        System.out.println("2. Lactancia");
        System.out.println("3.Otro");
        estadoProductivo = leer.nextInt();


        if(estadoProductivo != 1 && estadoProductivo !=2 && estadoProductivo !=3){
        System.out.println("\n[!] Opcion incorrecta, vuelva a intentar");
        }
    
    } while (estadoProductivo !=1 && estadoProductivo !=2 && estadoProductivo !=3);
    
    
     
    if(estadoProductivo == 1){
       estadoVaca   = "Secas";
      
    }
     if(estadoProductivo == 2){
       estadoVaca   = "Lactancia";
      
    }
    
     String otroEstado = "";
     if(estadoProductivo ==3){
         System.out.println("Ingrese otro tipo: ");
         leer.nextLine();
         otroEstado = leer.nextLine();
         estadoVaca = otroEstado;
     }
     
     
     
     
     
    
    
     
   
    listaVacas[fila][0] = codigo;
    listaVacas[fila][1] = nombre;
    listaVacas[fila][2] = String.valueOf(edad);
    listaVacas[fila][3] = String.valueOf(peso);
    listaVacas[fila][4] = estadoVaca;
    
    
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
        leer.nextLine(); // Limpiar 
        
    } while ((indice > 100) || (indice < 1));
    
    
    int fila = indice - 1;
    
    // 2. Si la posición no está vacía, permite modificar
    if (listaVacas[fila][0] !="") {
        
        System.out.println("-----------Datos Actuales--------------------------");
        System.out.println("Codigo\tNombre\tEdad\tPeso\tEstado Productivo");
        System.out.println("---------------------------------------------------");
        

        System.out.print(listaVacas[fila][0] + "\t");
        System.out.print(listaVacas[fila][1] + "\t");
        System.out.print(listaVacas[fila][2] + "\t");
        System.out.print(listaVacas[fila][3] + "\t");
        System.out.print(listaVacas[fila][4] + "\t");
        System.out.println("\n---------------------------------------------------");
        System.out.println("");
        
        
        
        
        System.out.println("Digite la NUEVA edad: ");
        int edad = leer.nextInt();
        
        System.out.println("Digite el NUEVO peso: ");
        double peso = leer.nextDouble();
        
        
        
         int estadoProductivo = 0;
        String estadoVaca   = "";
    
    
    do { 
        
        leer.nextLine(); 
        System.out.println("");
      /*  System.out.println("Digite el estado productivo: ");*/
        System.out.println("Digite el estado productivo al cual se muestra: ");
        System.out.println("1. Seca");
        System.out.println("2. Lactancia");
        System.out.println("3.Otro");
        estadoProductivo = leer.nextInt();


        if(estadoProductivo != 1 && estadoProductivo !=2 && estadoProductivo !=3){
        System.out.println("\n[!] Opcion incorrecta, vuelva a intentar");
        }
    
    } while (estadoProductivo !=1 && estadoProductivo !=2 && estadoProductivo !=3);
    
    
     
    if(estadoProductivo == 1){
       estadoVaca   = "Seca";
      
    }
     if(estadoProductivo == 2){
       estadoVaca   = "Lactancia";
      
    }
    
     String otroEstado = "";
     if(estadoProductivo ==3){
         System.out.println("Ingrese otro tipo: ");
         leer.nextLine();
         otroEstado = leer.nextLine();
         estadoVaca = otroEstado;
     }
        
        // Se guardan los nuevos datos
        
        listaVacas[fila][4] = estadoVaca;
        listaVacas[fila][2] = String.valueOf(edad);
        listaVacas[fila][3] = String.valueOf(peso);
        
        
        System.out.println("\n[+] ¡Vaca modificada con éxito en el índice " + indice + "!");
        
    } else {
        // Si el código o el nombre estaban vacíos
        System.out.println("\n[!] La posición " + indice + " está vacía. No se puede modificar.");
    }
}
public static void eliminarVacas() {
    int indice;

    do {
        System.out.println("--------------------------------------------------");
        System.out.println("|                 Eliminar Vacas                 |");
        System.out.println("--------------------------------------------------");
        System.out.println("Digite el índice a eliminar (1-100): ");
        
        indice = leer.nextInt();
        leer.nextLine(); // Limpiar
        
    } while (indice > 100 || indice < 1); 

    int fila = indice - 1;

    
    if (listaVacas[fila][0] !="") { 
        
        System.out.println("\n--- Datos del Animal a Eliminar ---");
        System.out.println("Código: " + listaVacas[fila][0]);
        System.out.println("Nombre: " + listaVacas[fila][1]);
        System.out.println("-----------------------------------\n");
        
        // Se vacían todas las columnas de esa fila
        listaVacas[fila][0] = ""; // Código
        listaVacas[fila][1] = ""; // Nombre
        listaVacas[fila][2] = ""; // Edad
        listaVacas[fila][3] = ""; // Peso
        listaVacas[fila][4] = ""; // Estado Productivo

        System.out.println("\n[+] ¡Vaca eliminada con éxito en el índice " + indice + "!");

    } else {
        System.out.println("\n[!] La posición " + indice + " ya está vacía. No se puede eliminar.");
    }
}

public static void consultarVacas() {
    System.out.println("-----------------------------------------------------");
    System.out.println("|                LISTA DE VACAS                     |");
    System.out.println("-----------------------------------------------------");
    
    // Encabezados de la tabla separados  (\t)
    System.out.println("ÍNDICE\tCÓDIGO\tNOMBRE\tEDAD\tPESO\tESTADO PRODUCTIVO");
    System.out.println("-----------------------------------------------------");
    
/*ideal para establecer un limite de x en esa columna
System.out.printf("%-10s%-16s%-15s%-8s%-8s%-20s%n", "ÍNDICE", "CÓDIGO", "NOMBRE", "EDAD", "PESO", "ESTADO PRODUCTIVO");
System.out.println("-----------------------------------------------------------------------------------------");
for (int i = 0; i < 100; i++) {
    if (listaVacas[i][0] != "") {
        numeroPosicion = i + 1; // Índice 1 no 0
        
        // Creamos el formato del índice con sus llaves como lo tenías:, [2], etc.
        String indiceFormateado = "[" + numeroPosicion + "]";
        
        // Imprimimos la fila con columnas alineadas usando tamaños fijos
        System.out.printf("%-10s%-16s%-15s%-8s%-8s%-20s%n", 
            indiceFormateado,
            listaVacas[i][0], // Código (Soporta los 14 dígitos sin mover nada)
            listaVacas[i][1], // Nombre
            listaVacas[i][2], // Edad
            listaVacas[i][3], // Peso
            listaVacas[i][4]  // Estado Productivo
        );
    }
}
*/
   
    for (int i = 0; i < 100; i++) {
        
        
        if (listaVacas[i][0] != "") {
            
             numeroPosicion = i + 1; // Índice 1 no 0
            
            // Imprimimos la fila usando \t para separar cada columna
            System.out.println("[" + numeroPosicion + "]\t" +
                               listaVacas[i][0] + "\t" +
                               listaVacas[i][1] + "\t" +
                               listaVacas[i][2] + "\t" +
                               listaVacas[i][3] + "\t" +
                               listaVacas[i][4]);
        }
    }
    System.out.println("-----------------------------------------------------");
}
    
    


}

