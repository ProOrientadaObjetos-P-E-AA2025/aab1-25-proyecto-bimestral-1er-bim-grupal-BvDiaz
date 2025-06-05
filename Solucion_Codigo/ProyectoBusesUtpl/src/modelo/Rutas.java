package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Rutas implements Serializable {
    private String idBus;
    private ArrayList<Parada> paradas;

    public Rutas(String idBus) {
        this.idBus = idBus;
        this.paradas = new ArrayList<>();
    }

    public void agregarParada(Parada p) {
        paradas.add(p);
    }

    public String obtenerIdBus() {
        return idBus;
    }

    public ArrayList<Parada> obtenerParadas() {
        return paradas;
    }

    @Override
    public String toString() {
        String resultado = "Bus: " + idBus + "\nParadas:\n";
        for (int i = 0; i < paradas.size(); i++) {
            Parada p = paradas.get(i);
            resultado = resultado + (i + 1) + ". " + p.toString() + "\n";
        }
        return resultado;
    }
}