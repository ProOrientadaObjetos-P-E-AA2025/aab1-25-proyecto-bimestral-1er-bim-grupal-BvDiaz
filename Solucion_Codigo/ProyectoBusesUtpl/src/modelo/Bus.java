package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Bus implements Serializable {

    private String id;
    private ArrayList<Parada> paradas;

    public Bus(String id) {
        this.id = id;
        this.paradas = new ArrayList<>();
    }

    public void agregarParada(Parada p) {
        paradas.add(p);
    }

    public String obtenerId() {
        return id;
    }

    public ArrayList<Parada> obtenerParadas() {
        return paradas;
    }

    @Override
    public String toString() {
        String resultado = String.format("Bus %s%n", id);
        for (Parada p : paradas) {
            resultado = String.format("%s - %s%n", resultado, p);
        }
        return resultado;
    }
}
