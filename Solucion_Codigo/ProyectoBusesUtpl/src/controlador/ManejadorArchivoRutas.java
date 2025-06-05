package controlador;

import modelo.Rutas;
import java.io.*;
import java.util.ArrayList;

public class ManejadorArchivoRutas {
    private String archivo = "rutas.data";
    private ArrayList<Rutas> lista;

    public ManejadorArchivoRutas() {
        cargarRutas();
    }

    public void cargarRutas() {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(archivo))) {
            lista = (ArrayList<Rutas>) entrada.readObject();
        } catch (IOException | ClassNotFoundException e) {
            lista = new ArrayList<>();
        }
    }

    public void guardarRutas() {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(archivo))) {
            salida.writeObject(lista);
        } catch (IOException e) {
            System.out.println("Error al guardar las rutas.");
        }
    }

    public void agregarRuta(Rutas r) {
        lista.add(r);
        guardarRutas();
    }

    public Rutas buscarRutaPorId(String idBus) {
        for (Rutas r : lista) {
            if (r.obtenerIdBus().equals(idBus)) return r;
        }
        return null;
    }

    public ArrayList<Rutas> obtenerLista() {
        return lista;
    }
}
