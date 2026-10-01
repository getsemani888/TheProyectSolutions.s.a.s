package com.theprojectsolutions.vista;

import com.theprojectsolutions.dao.ProyectoDAO;
import com.theprojectsolutions.modelo.Proyecto;
import java.util.List;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProyectoDAO dao = new ProyectoDAO();
        int opcion;

        do {
            System.out.println("\n===== THEPROJECTSOLUTIONS S.A.S. =====");
            System.out.println("1. Insertar proyecto");
            System.out.println("2. Listar proyectos");
            System.out.println("3. Actualizar proyecto");
            System.out.println("4. Eliminar proyecto");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    Proyecto nuevo = new Proyecto();
                    System.out.print("Nombre: ");
                    nuevo.setNombre(sc.nextLine());
                    System.out.print("Cliente: ");
                    nuevo.setCliente(sc.nextLine());
                    System.out.print("Fecha inicio (YYYY-MM-DD): ");
                    nuevo.setFechaInicio(sc.nextLine());
                    System.out.print("Fecha fin (YYYY-MM-DD): ");
                    nuevo.setFechaFin(sc.nextLine());
                    System.out.print("Estado: ");
                    nuevo.setEstado(sc.nextLine());
                    System.out.print("Presupuesto: ");
                    nuevo.setPresupuesto(sc.nextDouble());
                    if (dao.insertar(nuevo)) {
                        System.out.println("✅ Proyecto insertado correctamente");
                    } else {
                        System.out.println("❌ Error al insertar");
                    }
                    break;

                case 2:
                    List<Proyecto> lista = dao.listar();
                    if (lista.isEmpty()) {
                        System.out.println("No hay proyectos registrados");
                    } else {
                        System.out.println("\n--- LISTA DE PROYECTOS ---");
                        for (Proyecto p : lista) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 3:
                    System.out.print("ID del proyecto a actualizar: ");
                    int idAct = sc.nextInt();
                    sc.nextLine();
                    Proyecto act = new Proyecto();
                    act.setIdProyecto(idAct);
                    System.out.print("Nuevo nombre: ");
                    act.setNombre(sc.nextLine());
                    System.out.print("Nuevo cliente: ");
                    act.setCliente(sc.nextLine());
                    System.out.print("Nueva fecha inicio: ");
                    act.setFechaInicio(sc.nextLine());
                    System.out.print("Nueva fecha fin: ");
                    act.setFechaFin(sc.nextLine());
                    System.out.print("Nuevo estado: ");
                    act.setEstado(sc.nextLine());
                    System.out.print("Nuevo presupuesto: ");
                    act.setPresupuesto(sc.nextDouble());
                    if (dao.actualizar(act)) {
                        System.out.println("✅ Proyecto actualizado");
                    } else {
                        System.out.println("❌ Error al actualizar");
                    }
                    break;

                case 4:
                    System.out.print("ID del proyecto a eliminar: ");
                    int idEli = sc.nextInt();
                    if (dao.eliminar(idEli)) {
                        System.out.println("✅ Proyecto eliminado");
                    } else {
                        System.out.println("❌ Error al eliminar");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 5);

        sc.close();
    }
}