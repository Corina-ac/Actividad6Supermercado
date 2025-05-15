/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miespe.p1supermercado;

/**
 *
 * @author espe
 */
import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private String nombre;
    private List<Producto> productos;

    public Categoria(String nombre) {
        this.nombre = nombre.toLowerCase().trim();
        this.productos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Categoria: " + nombre + "\n");
        if (productos.isEmpty()) {
            sb.append("  (sin productos)");
        } else {
            for (Producto p : productos) {
                sb.append("  - ").append(p).append("\n");
            }
        }
        return sb.toString();
    }
}
