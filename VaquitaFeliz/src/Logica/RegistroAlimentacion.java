/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.Scanner;

/**
 *
 * @author triamus
 */

public class RegistroAlimentacion {
    static String[][] registroAlimentacion = new String[100][11];
    static Scanner leer = new Scanner(System.in);
    
    static {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 10; j++) {
                registroAlimentacion[i][j]= "";
                
            }
            
        }
    }
    
      public static void RegistroAlimentacion(){
        
        int opcion = 0;
        
        
        do {            
            System.out.println("-----------------------------------------");
            System.out.println("|           Gestion Alimentacion        |");
            System.out.println("-----------------------------------------");
            System.out.println("Ingrese una opcion(1-5), luego presione");
            System.out.println("la tecla enter.");
            System.out.println("1.Registrar");//listo
            System.out.println("2.Modificar");//listo
            System.out.println("3.Eliminar");
            System.out.println("4.Consultar");//listo
            System.out.println("5.Regresar");
           
            opcion = leer.nextInt();
            
            switch (opcion) {
                case 1: registrarAlimentacion();
                    
                    break;
                case 2: ;
                    break;
                case 3: ;
                    break;
               case 4: mostrarAlimentacion();
                        
                    break;
               
                case 5: VaquitaFeliz.menuPrincipal();
                    break;
            }
            
                if(opcion <1 || opcion >5){
                System.out.println("-----------------------------------------");
                System.out.println("|  [!] DIGITE UNA OPCION CORRECTA(1-6)  |");
                System.out.println("-----------------------------------------");
                
                }
            
            
        } while (opcion != 5);
      }        
        
    
      
      
      
      public static void registrarAlimentacion(){
            System.out.println("---------------------------------------");
            System.out.println("|      REGISTRO DE PRODUCCION         |");
            System.out.println("---------------------------------------");

            System.out.print("Digite el codigo de la vaca: ");
            String codigo = leer.next();
            
            
            int existencia = -1;
            for (int i = 0; i < 100; i++) {
                //codigo de vaca
                if(GestionVacas.listaVacas[i][0].equals(codigo)){
                    
                    existencia = i;
                }
            }
            
            if(existencia == -1){
                System.out.println("[!] Lo Sentimos este codigo de vaca no esta registrado");
                return;
            }
            
            
            System.out.print("Digite el codigo del alimento: ");
            String codigoAlimento = leer.next();
            
            existencia = -1;
             for (int i = 0; i < 100; i++) {
                if (GestionAlimentos.inventario[i][0].equals(codigoAlimento)) {
                    existencia = i;
               
            }
            if(existencia == -1){
                System.out.println("[!] este codigo de alimento no existe en el registro");
                return;
            }
    }
             
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
      
    //usuario ingresa lo gastos  con ciertas resticciones
     double nuevosGastos = 0; 
    do {  
        System.out.print("Ingrese la cantidad consumida: ");
        leer.nextLine();
        nuevosGastos = leer.nextDouble();
        
        if(nuevosGastos < 0){
            System.out.println("[!]Error: la cantidad no pueden ser negativos");
            System.out.println("Valores negativos no permitidos");
            System.out.println("Intentas escribir"+"("+(nuevosGastos * -1)+")?");
        }
        
        
    } while (nuevosGastos <0);
    
    double inventarioCal = Double.parseDouble(GestionAlimentos.inventario[existencia][4]);
        if(inventarioCal < nuevosGastos){
            System.out.println("[!] En su inventario de alimentacion no hay insumos suficientes");
            System.out.println("para abarcar la cantidad digitada, Inventario disponible: " + inventarioCal);
            return;
        }
        
        
    
    int colDia = 2 + dia;
    
    String semanaStr = String.valueOf(semana);
    int fila = -1;
    // 4. BUSCAR SI YA EXISTE REGISTRO
    for (int i = 0; i < 100; i++) {
        if (GestionVacas.listaVacas[i][0].equals(codigo) 
                && GestionAlimentos.inventario[i][0].equals(codigoAlimento) 
                && registroAlimentacion[i][0].equals(semanaStr)) {
            fila = i;
            break;
        }
    }
       // 5. SI NO EXISTE, BUSCAR FILA VACÍA
    if (fila == -1) {
        for (int i = 0; i < 100; i++) {
            if (registroAlimentacion[i][1] == "") {
                fila = i;
                registroAlimentacion[fila][0] = semanaStr;
                registroAlimentacion[fila][1] = codigo;
                registroAlimentacion[fila][2] = codigoAlimento;
                for (int j = 3; j <= 10; j++) { 
                    registroAlimentacion[fila][j] = "0";
                }
                break;
            }
        }
    }
    
    if (!registroAlimentacion[fila][colDia].equals("0")) {
    System.out.println("-------------------------------------------------------");
    System.out.println("[!] Ya existe produccion registrada para este dia.");
    System.out.println("Use la opcion 'Modificar' si desea corregir el valor.");
    System.out.println("-------------------------------------------------------");
    return;
    }
    
    
    
 
    
    double cantidadGastada= Double.parseDouble(registroAlimentacion[fila][colDia]);
    registroAlimentacion[fila][colDia] = String.valueOf(nuevosGastos);
    
    double totalSemanal = Double.parseDouble(registroAlimentacion[fila][10]);
    totalSemanal = totalSemanal + nuevosGastos;
    registroAlimentacion[fila][10] = String.valueOf(totalSemanal);
    
    System.out.println("[~] Registro exitoso, cantidad semanal Gastada: "+ registroAlimentacion[fila][10]);
    
    
      }
      
      
      // Este método añade espacios al principio hasta que el dato tenga un tamaño predecible.

    
      public static void mostrarAlimentacion() {
    

    System.out.println("---------------------------------------------------------------------------------------");
System.out.println("  SEM\t  Vaca\t  Alim\t   LUN\t   MAR\t   MIE\t   JUE\t   VIE\t   SAB\t   DOM\t TOTAL");
System.out.println("---------------------------------------------------------------------------------------");

for (int i = 0; i < 100; i++) {
    if (!registroAlimentacion[i][0].equals("")) {
        
        // 2. Imprime cada dato concatenando espacios fijos (ejemplo: "   " + dato)
        // El \t buscará la siguiente parada, y como todos tienen los mismos espacios, alinearán
        System.out.print("   " + registroAlimentacion[i][0] + "\t");
        System.out.print("   " + registroAlimentacion[i][1] + "\t");
        System.out.print("   " + registroAlimentacion[i][2] + "\t");
        
        for (int j = 3; j <= 10; j++) {
            System.out.print("   " + registroAlimentacion[i][j] + "\t");
        }
        System.out.println("");
    }
}
    System.out.println("-----------------------------------------------------------------");
}
    
}
