/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miespe.p1supermercado;

/**
 *
 * @author caaco
 */

import java.util.Scanner;

public class Validador {

    public static int leerEntero(Scanner scanner, String mensaje) {
        int numero;
        while (true) {
            System.out.print(mensaje);
            String input = scanner.nextLine().trim();
            try {
                numero = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("❗ Por favor ingresa un numero entero valido.");
            }
        }
        return numero;
    }

    public static float leerFloatPositivo(Scanner scanner, String mensaje) {
        float numero;
        while (true) {
            System.out.print(mensaje);
            String input = scanner.nextLine().trim();
            try {
                numero = Float.parseFloat(input);
                if (numero <= 0) {
                    System.out.println("❗ El numero debe ser mayor a 0.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("❗ Por favor ingresa un numero decimal valido (usa punto).");
            }
        }
        return numero;
    }

    public static String leerTextoNoVacio(Scanner scanner, String mensaje) {
        String texto;
        while (true) {
            System.out.print(mensaje);
            texto = scanner.nextLine().trim();
            if (texto.isEmpty()) {
                System.out.println("❗ El texto no puede estar vacio.");
            } else {
                break;
            }
        }
        return texto;
    }
}
