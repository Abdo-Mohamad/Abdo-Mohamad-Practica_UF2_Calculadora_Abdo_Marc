/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.util.Scanner;

public class Practica1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double res = 0;
        String operacion;
        boolean comprobar;

        do {
            // Pedir el primer número
            String numero1;
            do {
                System.out.println("\n Introduce el primer número: ");
                numero1 = sc.nextLine();
            } while (!numero1.matches("[+-]?[\\d]*[.]?[\\d]+"));
            double nume1 = Double.parseDouble(numero1);

            // Pedir la operación
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

            // Pedir el segundo número
            String numero2;
            do {
                System.out.println("\n Introduce el segundo número: ");
                numero2 = sc.nextLine();
            } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
            double nume2 = Double.parseDouble(numero2);

            // Realizar la operación seleccionada
            switch (operacion) {
                case "+":
                    res = nume1 + nume2;
                    break;
                case "-":
                    res = nume1 - nume2;
                    break;
                case "x":
                case "X":
                    res = nume1 * nume2;
                    break;
                case "/":
                    while (nume2 == 0) {
                        System.err.println("El denominador no puede ser cero. Introduce otro valor: ");
                        numero2 = sc.nextLine();
                        nume2 = Double.parseDouble(numero2);
                    }
                    res = nume1 / nume2;
                    break;
                case "*":
                    res = Math.pow(nume1, nume2);
                    break;
                case "%":
                    while (nume2 == 0) {
                        System.err.println("El denominador no puede ser cero. Introduce otro valor: ");
                        numero2 = sc.nextLine();
                        nume2 = Double.parseDouble(numero2);
                    }
                    res = nume1 % nume2;
                    break;
            }

            // Mostrar el resultado en formato de calculadora
            System.out.println("\n*******************************");
            System.out.println("Resultado: " + nume1 + " " + operacion + " " + nume2 + " = (" + res + ")");
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
