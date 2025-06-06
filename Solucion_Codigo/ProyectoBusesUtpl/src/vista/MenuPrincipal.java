package vista;

import modelo.Parada;
import modelo.Rutas;
import controlador.ManejadorArchivoRutas;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuPrincipal {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        ManejadorArchivoRutas manejador = new ManejadorArchivoRutas();
        boolean salir = false;

        while (!salir) {
            System.out.println("=== MENU PRINCIPAL ===");
            System.out.println("1. Registrar nueva ruta / Eliminar paradas");
            System.out.println("2. Ver detalles de una ruta");
            System.out.println("0. Salir");
            System.out.print("Opcion:\n");
            int opcion = leer.nextInt();
            leer.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("ID del bus:\n");
                    String id = leer.nextLine();
                    Rutas existente = manejador.buscarRutaPorId(id);

                    if (existente != null) {
                        System.out.println("=== GESTOR DE PARADAS ===");
                        System.out.println("1. Ver paradas");
                        System.out.println("2. Eliminar una parada");
                        System.out.println("3. Cancelar");
                        int subop = leer.nextInt();
                        leer.nextLine();

                        switch (subop) {
                            case 1:
                                System.out.println(existente);
                                break;
                            case 2:
                                ArrayList<Parada> paradas = existente.obtenerParadas();
                                if (paradas.isEmpty()) {
                                    System.out.println("No hay paradas para eliminar.");
                                    break;
                                }
                                for (int i = 0; i < paradas.size(); i++) {
                                    System.out.println((i + 1) + ". " + paradas.get(i));
                                }
                                System.out.print("Seleccione el numero de la parada a eliminar: ");
                                int eliminarIdx = leer.nextInt() - 1;
                                leer.nextLine();
                                if (existente.eliminarParada(eliminarIdx)) {
                                    manejador.guardarRutas();
                                    System.out.println("Parada eliminada.");
                                } else {
                                    System.out.println("Indice invalido.");
                                }
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Opcion invalida.");
                        }
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
                            System.out.print("Hora de llegada (ej: 06:00): ");
                            String llegada = leer.nextLine();
                            System.out.print("Hora de salida (ej: 06:02): ");
                            String salidaParada = leer.nextLine();

                            Parada p = new Parada(nombre, ubic, dir, llegada, salidaParada);
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
                        System.out.println("Bus no registrado.");
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
