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

            do {
                System.out.println("\n Operació? (Indica el signe)");
                System.out.println("+ = sumar \n - = restar \n"
                        + " x = multiplicar \n / = dividir \n * = elevar primer num al segon num."
                        + "\n % = residu");
                operacion = sc.nextLine();
                if (operacion.equals("+") || operacion.equals("-") || operacion.equals("x")
                        || operacion.equals("X") || operacion.equals("/") || operacion.equals("%")
                        || operacion.equals("*")) {
                    comprobar = true;
                } else {
                    comprobar = false;
                }
                //cambio de boleano
            } while (!comprobar);

            String numero2;
            do {
                System.out.println("\n Introdueix el segon numero.");
                numero2 = sc.nextLine();
            } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
            // Cambio: Utilizar nume2 en lugar de n2
            double nume2 = Double.parseDouble(numero2); 

            do {
                comprobar = true;
                switch (operacion) {
                    case "+":
                        res = nume1 + nume2; // Cambio: Utilizar nume1 y nume2 en lugar de n1 y n2
                        break;
                    case "-":
                        res = nume1 - nume2; // Cambio: Utilizar nume1 y nume2 en lugar de n1 y n2
                        break;
                    case "x":
                    case "X":
                        res = nume1 * nume2; // Cambio: Utilizar nume1 y nume2 en lugar de n1 y n2
                        break;
                    case "/":
                        while (nume2 == 0) {
                            System.err.println(" Al denominador hi ha un zero \n"
                                    + "per a evitar errors coloca un altre valor.");
                            numero2 = sc.nextLine();
                            nume2 = Double.parseDouble(numero2);
                        }
                        res = nume1 / nume2; // Cambio: Utilizar nume1 y nume2 en lugar de n1 y n2
                        break;
                    case "*":
                        res = Math.pow(nume1, nume2); // Cambio: Utilizar nume1 y nume2 en lugar de n1 y n2
                        break;
                    case "%":
                        while (nume2 == 0) {
                            System.err.println(" Al denominador hi ha un zero \n"
                                    + "per a evitar errors coloca un altre valor.");
                            numero2 = sc.nextLine();
                            nume2 = Double.parseDouble(numero2);
                        }
                        res = nume1 % nume2; // Cambio: Utilizar nume1 y nume2 en lugar de n1 y n2
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
