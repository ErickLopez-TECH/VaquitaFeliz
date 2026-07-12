package Logica;

import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//--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
/**
 *
 * @author hiro
 */
public class GestionAlimentos { 
    private static Scanner leer = new Scanner(System.in);
    
    //--cracion de la array 

    public static String[][] inventario = new String[100][5];
    
    static {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 5; j++) {
                inventario[i][j] = "";
            }
        }
    }
    
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
                    
                case 5:VaquitaFeliz.menuPrincipal();
                    
                    break;
                    
                    
                                 
            }
            
        } while (opcion < 6);
        
    }
    
    
    
    public static void registrarAlimento(){
        
        int indice = 0;
        
            System.out.println("-----------------------------------------");
            System.out.println("|          REGISTRO DE ALIMENTOS        |");
            System.out.println("-----------------------------------------");
            
    
// 1. Buscar la primera posicion "" (libre) en el arreglo
        int fila = -1;
        for (int i = 0; i < 100; i++) {
            if (inventario[i][0] == "") {
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
 
        // Validacion de codigo duplicado (recorre solo posiciones no llenas)
        for (int i = 0; i <100; i++) {
            if (inventario[i][0] != "" && inventario[i][0].equals(codigo)) {
                System.out.println("[!] Codigo existente en el registro");
                return;
            }
        }
        
        int opcionTipo = 0;
        String tipo = "";
        
        do{System.out.println("Digite el tipo de alimento: ");
        System.out.println("1. Concentrado");
        System.out.println("2. Pastos");
        System.out.println("3. Otro");
        opcionTipo = leer.nextInt();

        if (opcionTipo != 1 && opcionTipo != 2 && opcionTipo != 3) {
            System.out.println("[!] Opcion incorrecta, vuelva a intentar");
        }

    } while (opcionTipo != 1 && opcionTipo != 2 && opcionTipo != 3);

    if (opcionTipo == 1) {
        tipo = "Concentrado";
    }
    if (opcionTipo == 2) {
        tipo = "Pastos";
    }

    String otroTipo = "";
    if (opcionTipo == 3) {
        System.out.println("Ingrese otro tipo: ");
        leer.nextLine();
        otroTipo = leer.nextLine();
        tipo = otroTipo;
            
        }
        
 //-----------------------------------------------------
        System.out.println("");
        System.out.println("Digite el nombre del alimento: ");
        String nombre = leer.nextLine();
 
        // Validacion de nombre duplicado usando equals()
        for (int i = 0; i < 100; i++) {
            if (inventario[i][1] != "" && inventario[i][1].equals(nombre)) {
                System.out.println("[!] Nombre existente en el registro");
                return;
            }
        }
 
        
 
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
        for (int i = 0; i < 100; i++) {
            if (inventario[i][0] != "" && inventario[i][0].equals(codigoBuscado)) {
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
        for (int i = 0; i < 100; i++) {
            if (inventario[i][0] != "" && inventario[i][0].equals(codigoBuscado)) {
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
 
        // Se establecen todas las columnas de la fila en vacio, liberando el espacio
        for (int j = 0; j < 5; j++) {
            inventario[encontrado][j] = "";
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
    System.out.println("---------------------------------------------------------");
    System.out.println("|                  LISTA DE ALIMENTOS                   |");
    System.out.println("---------------------------------------------------------");
    // Encabezado: Asegúrate de tener un \t por cada dato que imprimirás abajo
    System.out.println("INDICE\tCODIGO\tNOMBRE\tTIPO\tCOSTO\tCANTIDAD/KG");
    System.out.println("---------------------------------------------------------");

    for (int i = 0; i < 100; i++) {
        if (inventario[i][0] != "") {
            // Imprimimos la fila. 
           
            System.out.print((i + 1) + "\t");          // INDICE
            System.out.print(inventario[i][0] + "\t"); // CODIGO
            System.out.print(inventario[i][1] + "\t"); // NOMBRE
            System.out.print(inventario[i][2] + "\t"); // TIPO
            System.out.print(inventario[i][3] + "\t"); // COSTO
            System.out.print(inventario[i][4] + "\t");  
            System.out.println();
        }
    }
    System.out.println("---------------------------------------------------------");
}
}