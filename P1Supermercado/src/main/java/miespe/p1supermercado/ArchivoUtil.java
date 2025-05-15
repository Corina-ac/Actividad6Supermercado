/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miespe.p1supermercado;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
//import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ArchivoUtil {

    public static void guardarComoCSV(Map<String, Categoria> categorias) {
        try (FileWriter writer = new FileWriter("productos.csv")) {
            writer.write("Categoria,ID,Nombre,Precio\n");
            for (Categoria cat : categorias.values()) {
                for (Producto prod : cat.getProductos()) {
                    writer.write(cat.getNombre() + "," + prod.getId() + "," + prod.getNombre() + "," + prod.getPrecio() + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Error escribiendo archivo CSV: " + e.getMessage());
        }
    }

    public static void guardarComoJSON(Map<String, Categoria> categorias) {
        try (FileWriter writer = new FileWriter("productos.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            writer.write(gson.toJson(categorias));
        } catch (IOException e) {
            System.out.println("Error escribiendo archivo JSON: " + e.getMessage());
        }
    }
}
