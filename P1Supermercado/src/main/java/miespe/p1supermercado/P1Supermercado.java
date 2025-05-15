package miespe.p1supermercado;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class P1Supermercado {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Categoria> categorias = new HashMap<>();
        int opcion;

        do {
            System.out.println("\n=== MENU SUPERMERCADO ===");
            System.out.println("1. Agregar categoria");
            System.out.println("2. Agregar producto a una categoria");
            System.out.println("3. Ver categorias y productos");
            System.out.println("4. Salir");

            opcion = Validador.leerEntero(scanner, "Elige una opcion: ");

            switch (opcion) {
                case 1:
                    String nombreCat = Validador.leerTextoNoVacio(scanner, "Ingresa el nombre de la categoria: ")
                            .toLowerCase();

                    if (categorias.containsKey(nombreCat)) {
                        System.out.println("❗ Esa categoria ya existe.");
                    } else {
                        categorias.put(nombreCat, new Categoria(nombreCat));
                        System.out.println("✔️ Categoria agregada correctamente.");
                    }
                    break;

                case 2:
                    if (categorias.isEmpty()) {
                        System.out.println("️ Primero debes agregar una categoria.");
                        break;
                    }

                            System.out.println("Categorias disponibles:");
                            int i = 1;
                            List<String> listaCategorias = new ArrayList<>(categorias.keySet());
                            for (String cat : listaCategorias) {
                                System.out.println(i + ". " + cat);
                                i++;
                            }

                            int indice = Validador.leerEntero(scanner, "¿A que categoria quieres agregar el producto? (numero): ");
                            if (indice < 1 || indice > listaCategorias.size()) {
                                System.out.println("❗ Numero de categoría invalido.");
                                break;
                            }

                    String catElegida = listaCategorias.get(indice - 1);


                    if (!categorias.containsKey(catElegida)) {
                        System.out.println("❗ Esa categoria no existe.");
                        break;
                    }

                    String nombreProd = Validador.leerTextoNoVacio(scanner, "Nombre del producto: ");
                    float precioProd = Validador.leerFloatPositivo(scanner, "Precio del producto (usa punto para decimales): ");

                    Producto nuevoProd = new Producto(nombreProd, precioProd);
                    categorias.get(catElegida).agregarProducto(nuevoProd);

                    System.out.println("✔️ Producto agregado correctamente.");

                    // Guardar datos
                    ArchivoUtil.guardarComoCSV(categorias);
                    ArchivoUtil.guardarComoJSON(categorias);
                    break;

                case 3:
                    if (categorias.isEmpty()) {
                        System.out.println("️ No hay categorias registradas.");
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
                    System.out.println("❗ Opcion invalida.");
            }

        } while (opcion != 4);
    }
}
