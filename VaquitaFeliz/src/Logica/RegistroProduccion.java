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
    static String[][] produccionSemanal = new String[100][4];
    private static Scanner leer = new Scanner(System.in);
 
    static double[][] listaProduccion = new double[100][52];
    
    
    public static void gestionProdu(){
        
        int opcion = 0;
        
        
        do {            
            System.out.println("-----------------------------------------");
            System.out.println("|       GESTION DE LA PRODUCCION        |");
            System.out.println("-----------------------------------------");
            System.out.println("Ingrese una opcion(1-5), luego presione");
            System.out.println("la tecla enter.");
            System.out.println("1.Registrar");
            System.out.println("2.Modificar");
            System.out.println("3.Eliminar");
            System.out.println("4.Consultar");
            System.out.println("5.Buscar");
            System.out.println("6.Regresar");
           
            opcion = leer.nextInt();
            
            switch (opcion) {
                case 1:registrarProduccion();
                    
                    break;
                case 2: ;
                    break;
                case 3: ;
                    break;
                case 4: consultarProduccion();
                        
                    break;
                case 5: consultarProduccionPorCodigo();;
                    break; 
                case 6: VaquitaFeliz.menuPrincipal();
                    break;
            }
            
            if((opcion >6) || (opcion <0)){
                System.out.println("-----------------------------------------");
                System.out.println("|  [!] DIGITE UNA OPCION CORRECTA(1-6)  |");
                System.out.println("-----------------------------------------");
            }
            
            
        } while (opcion <7 && opcion >0);
        
        
    }
    
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
   public static void registrarProduccion() {
    System.out.print("Ingrese el código de la vaca: ");
    String codigo = leer.next();
    
    int fila = buscarFila(codigo);
    
    if (fila != -1) {
        System.out.print("Ingrese la semana (1-52): ");
        int semana = leer.nextInt();
        
        if (semana >= 1 && semana <= 52) {
            System.out.print("Ingrese cantidad de litros a sumar: ");
            double litrosIngresados = leer.nextDouble();
            
            if(litrosIngresados <0){
                System.out.println("-----------------------------------------");
                System.out.println("| [!] Valores - quizas quisiste decir|" + litrosIngresados * -1+"|");
                System.out.println("|  Vuelva a ingresar el codigo    ");
                System.out.println("-----------------------------------------");
                litrosIngresados = 0;
                registrarProduccion();
            }
            
            if(litrosIngresados >0){
                
            
            // La columna es (semana - 1) para que 1 sea la columna 0, 
            listaProduccion[fila][semana - 1] += litrosIngresados;
            
            
            
            
            System.out.println("[^] Producción registrada en semana " + semana);
            System.out.println("[^] Total acumulado para esa semana: " + listaProduccion[fila][semana - 1]);
            }
        } else {
            System.out.println("[!] Semana inválida (solo 1 a 52).");
        }
        
    } else {
        System.out.println("Vaca no encontrada.");
    }
    
    
    
}
   
  public static void consultarProduccionPorCodigo() {
    System.out.print("Ingrese el código de la vaca a consultar: ");
    String codigoBuscado = leer.next();
    
    int fila = buscarFila(codigoBuscado);
    
    if (fila != -1) {
        String nombre = GestionVacas.listaVacas[fila][1];
        
        System.out.println("\n--- DETALLE SEMANAL DE LA VACA: " + codigoBuscado + " ---");
        System.out.println("NOMBRE: " + nombre);
        System.out.println("SEMANA\tPRODUCCIÓN (Litros)");
        System.out.println("----------------------------");
        
        // RECORREMOS LAS 52 SEMANAS
        for (int sem = 0; sem < 52; sem++) {
            // Solo mostramos si la semana tiene producción mayor a 0
            if (listaProduccion[fila][sem] > 0) {
                System.out.println("SEM " + (sem + 1) + "\t" + listaProduccion[fila][sem] + " L");
            }
        }
        System.out.println("----------------------------\n");
        
    } else {
        System.out.println("Error: No existe ninguna vaca con ese código.");
    }
}
  
  public static void consultarProduccion() {
      
      for (int i = 0; i < 100; i++) {
          
      
    if (listaProduccion[i][0] > 0) {
        String nombre = GestionVacas.listaVacas[i][1];
        String codigo = GestionVacas.listaVacas[i][0];
        System.out.println("\n--- DETALLE SEMANAL DE LA VACA: " + codigo + " ---");
        System.out.println("NOMBRE: " + nombre);
        System.out.println("SEMANA\tNOMBRE\tCODIGO\tPRODUCCIÓN (Litros)");
        System.out.println("----------------------------");
        
        // RECORREMOS LAS 52 SEMANAS
        for (int sem = 0; sem < 52; sem++) {
            // Solo mostramos si la semana tiene producción mayor a 0
            if (listaProduccion[i][sem] > 0) {
                System.out.println("SEM " + (sem + 1) + "\t"+nombre+"\t"+codigo+"\t"+ listaProduccion[i][sem] + " L");
            }
        }
        System.out.println("----------------------------\n");
        
    }
      }
    System.out.println("-----------------------------------------------------");
}
    
    
  /*
    public static void mostrarReportesMensuales() {
    // Recorremos los 13 meses (o 12)
    for (int mes = 0; mes < 12; mes++) {
        
        // 1. Calculamos dónde empieza este mes en la lista de 52 semanas
        int inicio = mes * 4; 
        
        // 2. Revisamos si en estas 4 casillas hay algo guardado
        double totalMes = 0;
        for (int i = 0; i < 100; i++) { // Por cada vaca
            for (int s = inicio; s < inicio + 4; s++) {
                totalMes += listaProduccion[i][s];
            }
        }

        // 3. Si alguien produjo algo en este mes, mostramos el reporte
        if (totalMes > 0) {
            System.out.println("--- REPORTE MES " + (mes + 1) + " ---");
            
            // 3. Si alguien produjo algo en este mes, mostramos el reporte
if (totalMes > 0) {
    System.out.println("--- REPORTE MES " + (mes + 1) + " ---");
    System.out.println("CÓDIGO\tSEM" + (inicio+1) + "\tSEM" + (inicio+2) + "\tSEM" + (inicio+3) + "\tSEM" + (inicio+4));

    // CICLO PARA IMPRIMIR LAS VACAS
    for (int i = 0; i < 100; i++) {
        // Primero, verificamos si esta vaca tiene datos en este bloque de 4 semanas
        double sumaVacaMes = 0;
        for (int s = inicio; s < inicio + 4; s++) {
            sumaVacaMes += listaProduccion[i][s];
        }

        // Si la vaca tuvo producción en este mes, la imprimimos
        if (sumaVacaMes > 0) {
            String codigo = GestionVacas.listaVacas[i][0]; // Obtenemos el código
            System.out.print(codigo + "\t");
            
            // Imprimimos sus 4 semanas
            for (int s = inicio; s < inicio + 4; s++) {
                System.out.printf("%.1f\t", listaProduccion[i][s]);
            }
            System.out.println(); // Salto de línea para la siguiente vaca
        }
    }
}
            
        }
    }
}*/
}