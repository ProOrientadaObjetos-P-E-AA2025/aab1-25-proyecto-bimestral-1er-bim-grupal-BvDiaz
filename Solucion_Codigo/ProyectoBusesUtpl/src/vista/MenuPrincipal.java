package vista;

import modelo.Parada;
import modelo.Rutas;
import controlador.ManejadorArchivoRutas;

import java.util.Scanner;

public class MenuPrincipal {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        ManejadorArchivoRutas manejador = new ManejadorArchivoRutas();

        boolean salir = false;

        while (!salir) {
            System.out.println("=== MENU PRINCIPAL ===");
            System.out.println("1. Registrar nueva ruta");
            System.out.println("2. Ver detalles de una ruta");
            System.out.println("0. Salir");
            System.out.print("Opcion:\n");
            int opcion = leer.nextInt();
            leer.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("ID del bus:\n");
                    String id = leer.nextLine();

                    if (manejador.buscarRutaPorId(id) != null) {
                        System.out.println("Error: Ya existe una ruta registrada para este bus.");
                    } else {
                        Rutas nueva = new Rutas(id);

                        System.out.print("Cantidad de paradas:\n");
                        int n = leer.nextInt();
                        leer.nextLine();

                        for (int i = 0; i < n; i++) {
                            System.out.println("Parada #" + (i + 1));
                            System.out.print("Nombre: ");
                            String nombre = leer.nextLine();
                            System.out.print("Ubicacion: ");
                            String ubic = leer.nextLine();
                            System.out.print("Direccion: ");
                            String dir = leer.nextLine();
                            System.out.print("Hora: ");
                            String hora = leer.nextLine();

                            Parada p = new Parada(nombre, ubic, dir, hora);
                            nueva.agregarParada(p);
                        }

                        manejador.agregarRuta(nueva);
                        System.out.println("Ruta registrada con exito.");
                    }
                    break;

                case 2:
                    System.out.print("ID del bus: ");
                    String busId = leer.nextLine();
                    Rutas buscada = manejador.buscarRutaPorId(busId);
                    if (buscada != null) {
                        System.out.println(buscada);
                    } else {
                        System.out.println("Ruta no encontrada.");
                    }
                    break;

                case 0:
                    salir = true;
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }
        }
    }
}
