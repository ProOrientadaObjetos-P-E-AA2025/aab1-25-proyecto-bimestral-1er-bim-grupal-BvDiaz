package controlador;

import modelo.Bus;
import java.io.*;
import java.util.ArrayList;

public class ManejadorArchivoBus {
    private String archivo = "buses.data";
    private ArrayList<Bus> lista;

    public ManejadorArchivoBus() {
        cargarBuses();
    }

    public void cargarBuses() {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(archivo))) {
            lista = (ArrayList<Bus>) entrada.readObject();
        } catch (IOException | ClassNotFoundException e) {
            lista = new ArrayList<>();
        }
    }

    public void guardarBuses() {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(archivo))) {
            salida.writeObject(lista);
        } catch (IOException e) {
            System.out.println("Error al guardar los buses.");
        }
    }

    public void agregarBus(Bus b) {
        lista.add(b);
        guardarBuses();
    }

    public ArrayList<Bus> obtenerLista() {
        return lista;
    }

    public Bus buscarBus(String id) {
        for (Bus b : lista) {
            if (b.obtenerId().equals(id)) return b;
        }
        return null;
    }
}
