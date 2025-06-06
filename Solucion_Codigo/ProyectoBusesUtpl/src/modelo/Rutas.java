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

    public boolean eliminarParada(int indice) {
        if (indice >= 0 && indice < paradas.size()) {
            paradas.remove(indice);
            return true;
        }
        return false;
    }

    public String obtenerHoraInicioRuta() {
        if (!paradas.isEmpty()) {
            return paradas.get(0).getHoraLlegada();
        }
        return "N/A";
    }

    public String obtenerHoraFinRuta() {
        if (!paradas.isEmpty()) {
            return paradas.get(paradas.size() - 1).getHoraSalida();
        }
        return "N/A";
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
        resultado = resultado + "Hora inicio ruta: " + obtenerHoraInicioRuta() + "\n";
        resultado = resultado + "Hora fin ruta: " + obtenerHoraFinRuta() + "\n";
        return resultado;
    }
}