/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.util.Scanner;

/**
 *
 * @author esther
 */
public class Practica1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double res = 0;
        String operacion;
        boolean comprobar;


        do {

            String numero1;
            do {
                System.out.println("\n Introdueix el primer numero. ");
                numero1 = sc.nextLine();
            } while (!numero1.matches("[+-]?[\\d]*[.]?[\\d]+"));
            // Cambio: Utilizar nume1 en lugar de n1
            double nume1 = Double.parseDouble(numero1);

            // Menú de opciones
            System.out.println("\n--- Calculadora ---");
            System.out.println("Selecciona la operación:");
            System.out.println("1. Suma (+)");
            System.out.println("2. Resta (-)");
            System.out.println("3. Multiplicación (x)");
            System.out.println("4. División (/)");
            System.out.println("5. Potencia (^)");
            System.out.println("6. Resto (%)");
            System.out.println("7. Salir");

            int opcion = 0;
            do {
                // Validación de la entrada del usuario para elegir una opción del menú
                System.out.print("Elija una opción: ");
                while (!sc.hasNextInt()) {
                    System.out.println("Por favor, ingrese un número válido.");
                    System.out.print("Elija una opción: ");
                    sc.next();
                }

                opcion = sc.nextInt();
            } while (opcion < 1 || opcion > 7); // Verificar si la opción es válida

            if (opcion == 7) {
                // Salir del programa si se selecciona la opción 7
                System.out.println("¡Hasta luego!");
                break;
            }
            String numero2;
            do {
                System.out.println("\n Introdueix el segon numero.");
                numero2 = sc.nextLine();
            } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
            // Cambio: Utilizar nume2 en lugar de n2
            double nume2 = Double.parseDouble(numero2); 

            do {
                comprobar = true;
                switch (opcion) {
                    case 1:
                         res = nume1 + nume2; // Cambio: Utilizar nume1 y nume2 en lugar de n1 y n2
                        operacion = "+";
                        break;
                    case 2:
                       res = nume1 - nume2; // Cambio: Utilizar nume1 y nume2 en lugar de n1 y n2
                        operacion = "-";
                        break;

                    case 3:
                 res = nume1 * nume2; // Cambio: Utilizar nume1 y nume2 en lugar de n1 y n2
                        operacion = "x";
                        break;
                    case 4:
                        while (nume2 == 0) {
                            do {
                                System.err.println(" Al denominador hi ha un zero \n"
                                        + "per a  evitar errors coloca un altre valor.");
                                numero2 = sc.nextLine();
                            } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));

                            nume2 = Double.parseDouble(numero2);
                        }
                     
                    res = nume1 / nume2; // Cambio: Utilizar nume1 y nume2 en lugar de n1 y n2
                        break;
                       
                    case 5:
                        res = Math.pow(n1, n1);
                        operacion = "^";
                        break;
                    case 6:
                        while (n2 == 0) {
                            do {
                                System.err.println(" Al denominador hi ha un zero \n"
                                        + "per a  evitar errors coloca un altre valor.");
                                numero2 = sc.nextLine();
                            } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
                            nume2 = Double.parseDouble(numero2);
                        }

                        res = nume1 % nume2; // Cambio: Utilizar nume1 y nume2 en lugar de n1 y n2
                        operacion = "%";

                        break;
                }
            } while (!comprobar);

            System.out.println("(" + numero1 + ") " + operacion + " (" + numero2 + ")" + " = " + res);
            System.out.println("\n Vols continuar operant? \n");
            System.out.println(" [s/n]");
            do {
                comprobar = true;
                operacion = sc.nextLine();

                switch (operacion) {
                    case "s":
                    case "S":
                    case "n":
                    case "N":
                        break;
                    default:
                        System.err.println("\n Error, posa un valor vàlid. \n");
                        comprobar = false;
                }
            } while (!comprobar);
        } while (operacion.equals("s") || operacion.equals("S"));
    }
}
