/*
 * 2 clases de producto y categoria 
 */

package miespe.p1supermercado;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author espe
 */
public class P1Supermercado {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Categoria> categorias = new HashMap<>();
        int opcion = 0;

        do {
            System.out.println("\n=== MENU SUPERMERCADO ===");
            System.out.println("1. Agregar categoria");
            System.out.println("2. Agregar producto a una categoria");
            System.out.println("3. Ver categorias y productos");
            System.out.println("4. Salir");

            // Validar solo que la opcion del menu sea numero entero
            while (true) {
                System.out.print("Elige una opcion: ");
                String input = scanner.nextLine();
                try {
                    opcion = Integer.parseInt(input);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Por favor ingresa un numero valido.");
                }
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el nombre de la categoria: ");
                    String nombreCat = scanner.nextLine().trim().toLowerCase();

                    if (nombreCat.isEmpty()) {
                        System.out.println("La categoria no puede estar vacia.");
                    } else if (categorias.containsKey(nombreCat)) {
                        System.out.println("Esa categoria ya existe.");
                    } else {
                        categorias.put(nombreCat, new Categoria(nombreCat));
                        System.out.println("Categoria agregada correctamente.");
                    }
                    break;

                case 2:
                    if (categorias.isEmpty()) {
                        System.out.println("Primero debes agregar una categoria.");
                        break;
                    }

                    System.out.println("Categorias disponibles:");
                    for (String cat : categorias.keySet()) {
                        System.out.println("- " + cat);
                    }

                    System.out.print("A que categoria quieres agregar el producto? ");
                    String catElegida = scanner.nextLine().trim().toLowerCase();

                    if (!categorias.containsKey(catElegida)) {
                        System.out.println("Esa categoria no existe.");
                        break;
                    }

                    System.out.print("Nombre del producto: ");
                    String nombreProd = scanner.nextLine().trim();

                    if (nombreProd.isEmpty()) {
                        System.out.println("El nombre no puede estar vacio.");
                        break;
                    }

                    // Pedimos el precio (permitimos fallos si mete letras)
                    System.out.print("Precio del producto (usa coma si tiene decimales): ");
                    float precioProd = scanner.nextFloat();
                    scanner.nextLine(); // limpiar buffer

                    if (precioProd <= 0) {
                        System.out.println("El precio debe ser mayor que 0.");
                        break;
                    }

                    Producto nuevoProd = new Producto(nombreProd, precioProd);
                    categorias.get(catElegida).agregarProducto(nuevoProd);
                    System.out.println("Producto agregado correctamente.");
                    break;

                case 3:
                    if (categorias.isEmpty()) {
                        System.out.println("No hay categorias registradas.");
                    } else {
                        for (Categoria cat : categorias.values()) {
                            System.out.println(cat);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Saliendo del sistema... 👋");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 4);
    }
}
