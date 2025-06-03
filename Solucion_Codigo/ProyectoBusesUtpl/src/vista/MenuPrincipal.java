package vista;

import modelo.Bus;
import modelo.Parada;
import controlador.ManejadorArchivoBus;

import java.util.Scanner;

public class MenuPrincipal {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        ManejadorArchivoBus manejador = new ManejadorArchivoBus();

        boolean salir = false;

        while (!salir) {
            System.out.println("=== MENU PRINCIPAL ===");
            System.out.println("1. Registrar nuevo bus");
            System.out.println("2. Ver detalles de un bus");
            System.out.println("0. Salir");
            System.out.print("Opcion:\n");
            int opcion = leer.nextInt();
            leer.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("ID del bus:\n");
                    String id = leer.nextLine();

                    if (manejador.buscarBus(id) != null) {
                        System.out.println("Error: Ya existe un bus con ese ID.");
                    } else {
                        Bus nuevo = new Bus(id);

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
                            nuevo.agregarParada(p);
                        }

                        manejador.agregarBus(nuevo);
                        System.out.println("Bus registrado con exito.");
                    }
                    break;

                case 2:
                    System.out.print("ID del bus: ");
                    String busId = leer.nextLine();
                    Bus buscado = manejador.buscarBus(busId);
                    if (buscado != null) {
                        System.out.println(buscado);
                    } else {
                        System.out.println("Bus no encontrado.");
                    }
                    break;

                case 0:
                    salir = true;
                    break;

                default:
                    System.out.println("Opción invalida.");
            }
        }
    }
}
