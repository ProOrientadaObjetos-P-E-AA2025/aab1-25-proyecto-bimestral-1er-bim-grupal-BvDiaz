package modelo;

import java.io.Serializable;

public class Parada implements Serializable {
    private String nombre;
    private String ubicacion;
    private String direccion;
    private String hora;

    public Parada(String nombre, String ubicacion, String direccion, String hora) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.direccion = direccion;
        this.hora = hora;
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %s | %s", nombre, ubicacion, direccion, hora);
    }
}
