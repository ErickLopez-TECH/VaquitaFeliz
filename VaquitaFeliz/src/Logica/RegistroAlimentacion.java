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
    static String[][] registroAlimentacion = new String[100][13];
    static Scanner leer = new Scanner(System.in);
    
    static {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 11; j++) {
                registroAlimentacion[i][j]= "";
                
            }
            
        }
    }
    
      public static void RegistroAlimentacion(){
        
        int opcion = 0;
        
        
        do {            
            System.out.println("-----------------------------------------");
            System.out.println("|           Registro Alimentacion       |");
            System.out.println("-----------------------------------------");
            System.out.println("Ingrese una opcion(1-5), luego presione");
            System.out.println("la tecla enter.");
            System.out.println("1.Registrar");//listo
            System.out.println("2.Modificar");//listo
            System.out.println("3.Eliminar");
            System.out.println("4.Consultar");//listo
            System.out.println("5.Regresar");
            System.out.println("");
            System.out.print("Opcion: ");
            opcion = leer.nextInt();
            
            switch (opcion) {
                case 1: registrarAlimentacion();
                    
                    break;
                case 2: modificarAlimentacion() ;
                    break;
                case 3: borrarAlimentacion();
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
    System.out.println("|      REGISTRO DE ALIMENTACION         |");
    System.out.println("---------------------------------------");

    System.out.print("Digite el codigo de la vaca: ");
    String codigo = leer.next();

    int filaVaca = -1;
    for (int i = 0; i < 100; i++) {
        if(GestionVacas.listaVacas[i][0].equals(codigo)){
            filaVaca = i;
        }
    }

    if(filaVaca == -1){
        System.out.println("[!] Lo Sentimos este codigo de vaca no esta registrado");
        return;
    }

    System.out.print("Digite el codigo del alimento: ");
    String codigoAlimento = leer.next();

    int filaAlimento = -1;
    for (int i = 0; i < 100; i++) {
        if (GestionAlimentos.inventario[i][0].equals(codigoAlimento)) {
            filaAlimento = i;
        }
    }

    if(filaAlimento == -1){
        System.out.println("[!] este codigo de alimento no existe en el registro");
        return;
    }

    int semana = 0;
    do {
        System.out.print("Ingrese la semana (1-52): ");
        semana = leer.nextInt();
        if (semana < 1 || semana > 52) {
            System.out.println("[!] Error: La semana debe estar entre 1 y 52.");
        }
    } while (semana < 1 || semana > 52);

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
    } while (nuevosGastos < 0);

    double inventarioCal = Double.parseDouble(GestionAlimentos.inventario[filaAlimento][4]);
    if(inventarioCal < nuevosGastos){
        System.out.println("[!] En su inventario de alimentacion no hay insumos suficientes");
        System.out.println("para abarcar la cantidad digitada, Inventario disponible: " + inventarioCal);
        return;
    } else {
        inventarioCal = inventarioCal - nuevosGastos;
        GestionAlimentos.inventario[filaAlimento][4] = String.valueOf(inventarioCal);
    }

    int colDia = 2 + dia;
    String semanaStr = String.valueOf(semana);
    int fila = -1;

    // 4. BUSCAR SI YA EXISTE REGISTRO (misma vaca + alimento + semana)
    for (int i = 0; i < 100; i++) {
        if (registroAlimentacion[i][1].equals(codigo)
                && registroAlimentacion[i][2].equals(codigoAlimento)
                && registroAlimentacion[i][0].equals(semanaStr)) {
            fila = i;
            break;
        }
    }

    // 5. SI NO EXISTE, BUSCAR FILA VACIA Y CREAR EL REGISTRO
    if (fila == -1) {
        for (int i = 0; i < 100; i++) {
            if (registroAlimentacion[i][1].equals("")) {
                fila = i;
                registroAlimentacion[fila][0] = semanaStr;
                registroAlimentacion[fila][1] = codigo;
                registroAlimentacion[fila][2] = codigoAlimento;
                for (int j = 3; j <= 10; j++) {
                    registroAlimentacion[fila][j] = "0";
                }
                
                // para usarlos en reportes ya los tenemos conservados nombre alimento y vaca
                registroAlimentacion[fila][11] = GestionVacas.listaVacas[filaVaca][1];
                registroAlimentacion[fila][12] = GestionAlimentos.inventario[filaAlimento][1];
                break;
            }
        }
    }

    if (!registroAlimentacion[fila][colDia].equals("0")) {
        System.out.println("-------------------------------------------------------");
        System.out.println("[!] Ya existe alimentacion registrada para este dia.");
        System.out.println("Use la opcion 'Modificar' si desea corregir el valor.");
        System.out.println("-------------------------------------------------------");
        return;
    }

    registroAlimentacion[fila][colDia] = String.valueOf(nuevosGastos);

    double totalSemanal = Double.parseDouble(registroAlimentacion[fila][10]);
    totalSemanal = totalSemanal + nuevosGastos;
    registroAlimentacion[fila][10] = String.valueOf(totalSemanal);

    System.out.println("[~] Registro exitoso, cantidad semanal Gastada: " + registroAlimentacion[fila][10]);
}
      
    public static void borrarAlimentacion(){
        System.out.println("---------------------------------------");
        System.out.println("|       BORRADO DE Alimentos         |");
        System.out.println("---------------------------------------");
        System.out.println("");
        System.out.println("Digite el numero de codigo de vaca borrar ");
        leer.nextLine();//manejo de errores de lectura
        String codigoVaca = leer.nextLine();
        for (int i = 0; i < 100; i++){         
            if ( codigoVaca.equals( registroAlimentacion[i][1] )  ){
                for (int j = 0; j < 11; j++) {
                    registroAlimentacion[i][j] = "";
                }
            }
        }
    } 
    
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
    
      
     public static void modificarAlimentacion() {
    System.out.println("---------------------------------------");
    System.out.println("|       MODIFICAR ALIMENTACION         |");
    System.out.println("---------------------------------------");

    System.out.print("Digite el codigo de la vaca: ");
    String codigo = leer.next();

    System.out.print("Digite el codigo del alimento: ");
    String codigoAlimento = leer.next();

    int indiceAlimento = -1;
    for (int i = 0; i < 100; i++) {
        if (GestionAlimentos.inventario[i][0].equals(codigoAlimento)) {
            indiceAlimento = i;
        }
    }

    if (indiceAlimento == -1) {
        System.out.println("[!] Este codigo de alimento no existe en el registro");
        return;
    }

    int semana = 0;
    do {
        System.out.print("Ingrese la semana a modificar (1-52): ");
        semana = leer.nextInt();
        if (semana < 1 || semana > 52) {
            System.out.println("[!] Error: La semana debe estar entre 1 y 52.");
        }
    } while (semana < 1 || semana > 52);

    String semanaStr = String.valueOf(semana);
    int fila = -1;

    for (int i = 0; i < 100; i++) {
        if (registroAlimentacion[i][0].equals(semanaStr)
                && registroAlimentacion[i][1].equals(codigo)
                && registroAlimentacion[i][2].equals(codigoAlimento)) {
            fila = i;
        }
    }

    if (fila == -1) {
        System.out.println("[!] No se encontro un registro para esa vaca, alimento y semana.");
        return;
    }
/*
    System.out.println("-----------Datos Actuales-------------------------------------------------------");
    System.out.printf("%-15s %-15s %-15s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s%n",
            "SEMANA", "VACA", "ALIMENTO", "LUN", "MAR", "MIE", "JUE", "VIE", "SAB", "DOM", "TOTAL");
    System.out.printf("%-15s %-15s %-15s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s%n",
            registroAlimentacion[fila][0], registroAlimentacion[fila][1], registroAlimentacion[fila][2],
            registroAlimentacion[fila][3], registroAlimentacion[fila][4], registroAlimentacion[fila][5],
            registroAlimentacion[fila][6], registroAlimentacion[fila][7], registroAlimentacion[fila][8],
            registroAlimentacion[fila][9], registroAlimentacion[fila][10]);
    System.out.println("----------------------------------------------------------------------------------");
*/

System.out.println("-----------Datos Actuales-------------------------------------------------------");
System.out.println("SEMANA\tVACA\tALIMENTO\tLUN\tMAR\tMIE\tJUE\tVIE\tSAB\tDOM\tTOTAL");
System.out.println(registroAlimentacion[fila][0] + "\t" +
        registroAlimentacion[fila][1] + "\t" +
        registroAlimentacion[fila][2] + "\t" +
        registroAlimentacion[fila][3] + "\t" +
        registroAlimentacion[fila][4] + "\t" +
        registroAlimentacion[fila][5] + "\t" +
        registroAlimentacion[fila][6] + "\t" +
        registroAlimentacion[fila][7] + "\t" +
        registroAlimentacion[fila][8] + "\t" +
        registroAlimentacion[fila][9] + "\t" +
        registroAlimentacion[fila][10]);
System.out.println("----------------------------------------------------------------------------------");


    String continuar;
    do {
        int dia = 0;
        do {
            System.out.println("Ingrese la opcion del (1-7) segun el dia que desea corregir:");
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

        int colDia = 2 + dia;
        double valorAnterior = Double.parseDouble(registroAlimentacion[fila][colDia]);

        double nuevoValor = 0;
        do {
            System.out.print("Digite la NUEVA cantidad consumida ese dia: ");
            nuevoValor = leer.nextDouble();

            if (nuevoValor < 0) {
                System.out.println("[!] Error: La cantidad no puede ser negativa");
            }
        } while (nuevoValor < 0);

        double diferencia = nuevoValor - valorAnterior;
        double inventarioCal = Double.parseDouble(GestionAlimentos.inventario[indiceAlimento][4]);

        if (diferencia > 0 && inventarioCal < diferencia) {
            System.out.println("[!] En su inventario de alimentacion no hay insumos suficientes");
            System.out.println("para abarcar el aumento digitado, Inventario disponible: " + inventarioCal);
            return;
        }

        inventarioCal = inventarioCal - diferencia;
        GestionAlimentos.inventario[indiceAlimento][4] = String.valueOf(inventarioCal);

        registroAlimentacion[fila][colDia] = String.valueOf(nuevoValor);

        double nuevoTotal = 0;
        for (int j = 3; j <= 9; j++) {
            nuevoTotal += Double.parseDouble(registroAlimentacion[fila][j]);
        }
        registroAlimentacion[fila][10] = String.valueOf(nuevoTotal);

        System.out.println("[+] Dia actualizado. Total semanal recalculado: " + nuevoTotal);
        System.out.println("[+] Inventario actualizado. Disponible: " + inventarioCal);

        leer.nextLine();
        continuar = "";
        do {
            System.out.print("¿Desea modificar otro dia de este mismo registro? (S/N): ");
            continuar = leer.nextLine();
            if (!continuar.equals("S") && !continuar.equals("N")) {
                System.out.println("[!] Error: digite S o N");
            }
        } while (!continuar.equals("S") && !continuar.equals("N"));

    } while (continuar.equals("S"));

    System.out.println("\n[+] Modificacion finalizada con exito.");
}
      
}
