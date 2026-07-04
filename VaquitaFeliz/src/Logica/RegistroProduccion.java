package Logica;

import static Logica.GestionVacas.listaVacas;
import static Logica.GestionVacas.numeroPosicion;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author triamus
 */
public class RegistroProduccion {
    
    //Globales
    
    private static Scanner leer = new Scanner(System.in);
 
    static String[][] listaProduccion = new String[100][11];
    
    
            
    
    public static void gestionProdu(){
        
        int opcion = 0;
        
        
        do {            
            System.out.println("-----------------------------------------");
            System.out.println("|       GESTION DE LA PRODUCCION        |");
            System.out.println("-----------------------------------------");
            System.out.println("Ingrese una opcion(1-5), luego presione");
            System.out.println("la tecla enter.");
            System.out.println("1.Registrar");//listo
            System.out.println("2.Modificar");//listo
            System.out.println("3.Eliminar");
            System.out.println("4.Consultar");//listo
            System.out.println("5.Buscar");//listo
            System.out.println("6.Regresar");
           
            opcion = leer.nextInt();
            
            switch (opcion) {
                case 1:registrarProduccion();
                    
                    break;
                case 2: modificaProduccion();
                    break;
                case 3: borrarProduccion();
                    break;
               case 4: mostrarProduccion();
                        
                    break;
               case 5:  consultarCodigo();
                    break; 
                case 6: VaquitaFeliz.menuPrincipal();
                    break;
            }
            
            if((opcion >6) || (opcion <0)){
                System.out.println("-----------------------------------------");
                System.out.println("|  [!] DIGITE UNA OPCION CORRECTA(1-6)  |");
                System.out.println("-----------------------------------------");
            }
            
            
        } while (opcion <0 || opcion >6);
        
        
    }
    
    /*
      ---------------------------------------
     |      buscarFila que es el codigo     |
      ---------------------------------------*/
    public static int buscarFila(String codigoBuscado) {
    for (int i = 0; i < 100; i++) {
        // Comparamos el código (usando .equals para Strings)
        if (GestionVacas.listaVacas[i][0].equals(codigoBuscado)) {
            return i; //  posición real (0-99)
            
        }
    }
    return -1; // No se encontró
}
    /*Debe contener al menos los valores para: Número de Semana del Año, Código d
    e Vaca, cantidad producida cada día de la semana (expresada en Litros, Lunes-Domingo).*/
    /*
      ---------------------------------------
     |      Metodo de registro #1    |
      ---------------------------------------*/
public static void registrarProduccion() {
    System.out.println("---------------------------------------");
    System.out.println("|      REGISTRO DE PRODUCCION         |");
    System.out.println("---------------------------------------");

    System.out.print("Codigo de la vaca: ");
    String codigo = leer.next();

    // 1. extraccion del metodo buscarfila con parametros
    int filaC = buscarFila(codigo);
    
    
    //valor qu edevuelve el metodo de fila
    if (filaC == -1) {
        System.out.println("[!] ERROR: Vaca no registrada en el sistema.");
        return;//retornamos al menu produccion 
    }

    // 2. VALIDACIÓN DE SEMANA (do-while)
    int semana = 0;

    do {
        System.out.print("Ingrese la semana (1-52): ");
        semana = leer.nextInt();
        if (semana < 1 || semana > 52) {
            System.out.println("[!] Error: La semana debe estar entre 1 y 52.");
        }
        
    } while (semana < 1 || semana > 52);

    
    // 3. VALIDACIÓN DE DIA (do-while) 
    int dia = 0;
    do {
        System.out.println("Ingrese la opcion del (1-7) segun corresponda el dia:");
        System.out.println("1. Lunes");
        System.out.println("2. Martes");
        System.out.println("3. Miercoles");
        System.out.println("4. Jueves");
        System.out.println("5. Viernes");
        System.out.println("6. Sabado");
        System.out.println("7. Domingo");
        dia = leer.nextInt();
        if (dia < 1 || dia > 7) {
            System.out.println("[!] Error: El dia debe estar entre 1 y 7.");
        }
    } while (dia < 1 || dia > 7);

    //usuario ingresa lo litros con ciertas resticciones
     double nuevosLitros = 0; 
    do {  
        System.out.print("Ingrese la cantidad litros: ");
        leer.nextLine();
        nuevosLitros = leer.nextDouble();
        
        if(nuevosLitros < 0){
            System.out.println("[!]Error: Los litros no pueden ser negativos");
            System.out.println("Valores negativos no permitidos");
            System.out.println("Intentas escribir"+"("+(nuevosLitros * -1)+")?");
        }
    } while (nuevosLitros <0);
    

    

    //ocupamos traer ese dato hacia aqui nombre de la vaca
    String nombreVaca = ""; 
for (int i = 0; i < 100; i++) {
    if (GestionVacas.listaVacas[i][0].equals(codigo)) {
        nombreVaca = GestionVacas.listaVacas[i][1];
        break; //ya lo encontramos
    }
}
 
    // Convertimos semana(vienene en entero) a String para la comparación
    String semanaStr = String.valueOf(semana);
    int fila = -1;
    // 4. BUSCAR SI YA EXISTE REGISTRO
    for (int i = 0; i < 100; i++) {
        if (listaProduccion[i][0] != "" && listaProduccion[i][0].equals(codigo) && listaProduccion[i][2].equals(semanaStr)) {
            fila = i;
            break;
        }
    }

    // 5. SI NO EXISTE, BUSCAR FILA VACÍA
    if (fila == -1) {
        for (int i = 0; i < 100; i++) {
            if (listaProduccion[i][0] == "") {
                fila = i;
                listaProduccion[fila][0] = codigo;
                listaProduccion[fila][1] = nombreVaca;
                listaProduccion[fila][2] = semanaStr;
                for (int j = 3; j <= 10; j++) { 
                    listaProduccion[fila][j] = "0";
                
                }
            }
            break;
        }
    }

  
    // 6. GUARDAR DATOS
    int colDia = 2 + dia; 
    
    //esta en String se parsea a double por ejemplo 2 en estring !=  2 int
    double litrosActuales = Double.parseDouble(listaProduccion[fila][colDia]);
    //antes de pasarlos se hace la suma y si e snueva fila seria 0 + ingresados
    listaProduccion[fila][colDia] = String.valueOf(litrosActuales + nuevosLitros);

    //lo parseamos de strin a numero
    double totalActual = Double.parseDouble(listaProduccion[fila][10]);
    //no sumamos cada dia de una vez se suma lo que hay + lo nuevo
    listaProduccion[fila][10] = String.valueOf(totalActual + nuevosLitros);

    System.out.println("Registro exitoso. Total semanal: " + listaProduccion[fila][10]);
}
/*
  ---------------------------------------
     |      Metodo de modificar- #2    |
      ---------------------------------------*/
 
public static void modificaProduccion() {
    System.out.println("---------------------------------------");
    System.out.println("|         EDICION DE PRODUCCION       |");
    System.out.println("---------------------------------------");
    
    System.out.print("Digite el codigo de vaca a modificar: ");
    leer.nextLine(); 
    String buscaCodigo = leer.nextLine();

    System.out.print("Digite la semana a modificar (1-52): ");
    String buscaSemana = leer.nextLine();

    int encontrado = 0;

    for (int i = 0; i < 100; i++) {
        // Buscamos coincidencia de código y semana
        if (listaProduccion[i][0].equals(buscaCodigo) && listaProduccion[i][2].equals(buscaSemana)) {
            encontrado = 1;
            
            int semana;

            
            
            int dia;
            do {
                
                
                System.out.println("Ingrese la opcion del (1-7) segun corresponda el dia:");
                System.out.println("1. Lunes");
                System.out.println("2. Martes");
                System.out.println("3. Miercoles");
                System.out.println("4. Jueves");
                System.out.println("5. Viernes");
                System.out.println("6. Sabado");
                System.out.println("7. Domingo");
                dia = leer.nextInt();
            } while (dia < 1 || dia > 7);

            double nuevosLitros = 0;
            do {  
                System.out.print("Nuevos litros para ese dia: ");
                nuevosLitros = leer.nextDouble();
                
            } while (nuevosLitros <0);
            

            // 1. Reemplazar el dato viejo por el nuevo
            int colDia = 2 + dia; 
            listaProduccion[i][colDia] = String.valueOf(nuevosLitros);

            // 2. Recalcular el total sumando todas las columnas de dia [3] hasta [9]
            double nuevoTotal = 0;
            for (int j = 3; j <10; j++) {
                nuevoTotal += Double.parseDouble(listaProduccion[i][j]);
            }

            // 3. Guardar el nuevo total calculado
            listaProduccion[i][10] = String.valueOf(nuevoTotal);

            System.out.println("Modificación exitosa. Total semanal recalculado: " + nuevoTotal);
            break; 
        }
    }

    if ( encontrado ==0) {
        System.out.println("[!] No se encontró un registro para esa vaca y semana.");
    }
}

/*-------------------------------------------------------------
|               Consultar  #4
--------------------------------------------------------------*/


public static void mostrarProduccion() {
    System.out.println("----------------------------------------------------------------------------------------------------");
    System.out.println("COD\tNOMBRE\tSEM\tLUN\tMAR\tMIE\tJUE\tVIE\tSAB\tDOM\tTOTAL");
    System.out.println("----------------------------------------------------------------------------------------------------");

    for (int i = 0; i < 100; i++) {
        if (listaProduccion[i][0] != "") {
            // Imprimimos los campos básicos
            System.out.print(listaProduccion[i][0] + "\t");
            
            // Si el nombre es corto, usamos dos tabs para compensar
            System.out.print(listaProduccion[i][1] + "\t");
            
            System.out.print(listaProduccion[i][2] + "\t");
            
            // Imprimimos los días (columna 3 a 10, que es el total)
            for (int j = 3; j <= 10; j++) {
                System.out.print(listaProduccion[i][j] + "\t");
            }
            System.out.println(""); // Salto de línea al terminar la fila
        }
    }
    System.out.println("----------------------------------------------------------------------------------------------------");
}
  
/*-------------------------------------------------------------
|                 Consultar por codigo(buscador)
--------------------------------------------------------------*/   


 public static void consultarCodigo(){
        System.out.println("---------------------------------------");
        System.out.println("|        BUSQUEDA DE PRODUCCION       |");
        System.out.println("---------------------------------------");
        System.out.println("");
        System.out.println("Digite el nombre del cliente a buscar: ");
        leer.nextLine();//manejo de errores de lectura
        String buscarCodigo = leer.nextLine();
        
        
        
        for (int i = 0; i < 100; i++) {
        if (listaProduccion[i][0].equals(buscarCodigo)) {
            
            System.out.println("----------------------------------------------------------------------------------------------------");
            System.out.println("COD\tNOMBRE\tSEM\tLUN\tMAR\tMIE\tJUE\tVIE\tSAB\tDOM\tTOTAL");
            System.out.println("----------------------------------------------------------------------------------------------------");

            // Imprimimos los campos básicos
            System.out.print(listaProduccion[i][0] + "\t");
            
            // Si el nombre es corto, usamos dos tabs para compensar
            System.out.print(listaProduccion[i][1] + "\t");
            
            System.out.print(listaProduccion[i][2] + "\t");
            
            // Imprimimos los días (columna 3 a 10, que es el total)
            for (int j = 3; j <= 10; j++) {
                System.out.print(listaProduccion[i][j] + "\t");
            }
            System.out.println(""); // Salto de línea al terminar la fila
        }
        
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("[!] Digite un codigo previamente registrado en produccion");
        return;    
    }
        
 }
   
 /*------------------------------------
 |    Borrar Produccion #3
 --------------------------------------*/

public static void borrarProduccion(){
        System.out.println("---------------------------------------");
        System.out.println("|       BORRADO DE PRODUCCION         |");
        System.out.println("---------------------------------------");
        System.out.println("");
        System.out.println("Digite el numero de codigo de vaca borrar ");
        leer.nextLine();//manejo de errores de lectura
        String codigoVaca = leer.nextLine();
        for (int i = 0; i < 100; i++){         
            if ( codigoVaca.equals( listaProduccion[i][0] )  ){
                for (int j = 0; j < 10; j++) {
                    listaProduccion[i][j] = "";
                }
            }
        }
    } 
}