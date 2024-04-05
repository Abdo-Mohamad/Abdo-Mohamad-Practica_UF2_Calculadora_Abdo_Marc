/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.util.Scanner;

public class Practica1 {

    // Método para solicitar un número al usuario
    private static double solicitarNumero(Scanner sc, String mensaje) {
        String input;
        do {
            System.out.println(mensaje);
            input = sc.nextLine();
        } while (!input.matches("[+-]?[\\d]*[.]?[\\d]+")); // Comprueba si es un número válido
        return Double.parseDouble(input);
    }

    // Método para solicitar una operación válida al usuario
    private static String solicitarOperacion(Scanner sc) {
        String operacion;
        boolean comprobar;
        do {
            System.out.println("\n Operación? (Indica el signo)");
            System.out.println("+ = sumar \n - = restar \n"
                    + " x = multiplicar \n / = dividir \n * = elevar primer num al segon num."
                    + "\n % = residuo");
            operacion = sc.nextLine();
            // Comprueba si la operación es válida
            if (operacion.matches("[+\\-xX/*%]")) {
                comprobar = true;
            } else {
                comprobar = false;
            }
        } while (!comprobar);
        return operacion;
    }

    // Método para realizar una operación aritmética
    private static double realizarOperacion(double nume1, double nume2, String operacion) {
        double resultado = 0;
        switch (operacion) {
            case "+":
                resultado = nume1 + nume2;
                break;
            case "-":
                resultado = nume1 - nume2;
                break;
            case "x":
            case "X":
                resultado = nume1 * nume2;
                break;
            case "/":
                resultado = nume1 / nume2;
                break;
            case "*":
                resultado = Math.pow(nume1, nume2);
                break;
            case "%":
                resultado = nume1 % nume2;
                break;
        }
        return resultado;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double resultado = 0;
        String operacion;

        do {
            double nume1 = solicitarNumero(sc, "\n Introduce el primer número: ");
            String operacionSeleccionada = solicitarOperacion(sc);
            double nume2 = solicitarNumero(sc, "\n Introduce el segundo número: ");
            resultado = realizarOperacion(nume1, nume2, operacionSeleccionada);

            // Mostrar el resultado en formato de calculadora
            System.out.println("\n*******************************");
            System.out.println("Resultado: " + nume1 + " " + operacionSeleccionada + " " + nume2 + " = (" + resultado + ")");
            System.out.println("*******************************");

            // Preguntar si desea continuar operando
            System.out.println("\n ¿Deseas realizar otra operación? \n [s/n]");
            do {
                operacion = sc.nextLine();
                // Comprobar si la respuesta es válida
                if (!operacion.matches("[sSnN]")) {
                    System.err.println("\n Error, por favor ingresa 's' para sí o 'n' para no. \n");
                }
            } while (!operacion.matches("[sSnN]"));

        } while (operacion.equalsIgnoreCase("s"));
    }
}
