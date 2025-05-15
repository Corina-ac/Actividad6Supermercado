/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miespe.p1supermercado;

/**
 *
 * @author espe
 */
public class Producto {
    private static int contadorId = 1; // ID autoincremental
    private int id;
    private String nombre;
    private float precio;

    public Producto(String nombre, float precio) {
        this.id = contadorId++;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "ID: " + id + " - " + nombre + " - $" + precio;
    }
}