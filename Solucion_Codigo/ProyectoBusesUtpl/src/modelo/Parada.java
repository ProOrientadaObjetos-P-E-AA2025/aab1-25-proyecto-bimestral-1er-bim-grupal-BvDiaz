package modelo;

import java.io.Serializable;

public class Parada implements Serializable {
    private String nombre;
    private String ubicacion;
    private String direccion;
    private String horaLlegada;
    private String horaSalida;

    public Parada(String nombre, String ubicacion, String direccion, String horaLlegada, String horaSalida) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.direccion = direccion;
        this.horaLlegada = horaLlegada;
        this.horaSalida = horaSalida;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    @Override
    public String toString() {
        return nombre + " | " + ubicacion + " | " + direccion + " | Llegada: " + horaLlegada + " | Salida: " + horaSalida;
    }
}

