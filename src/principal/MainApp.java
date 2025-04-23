package principal;

import dao.ArticuloDAO;
import modelo.Articulo;

import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArticuloDAO dao = new ArticuloDAO();
        int opcion;

        do {
            System.out.println("\n=== MENU DE INVENTARIO ===");
            System.out.println("1. Insertar articulo");
            System.out.println("2. Consultar articulos");
            System.out.println("3. Actualizar articulo");
            System.out.println("4. Eliminar articulo");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Descripcion: ");
                    String descripcion = sc.nextLine();
                    System.out.print("Precio unitario: ");
                    double precio = sc.nextDouble();
                    System.out.print("Stock actual: ");
                    int stock = sc.nextInt();
                    System.out.print("ID proveedor: ");
                    int proveedor = sc.nextInt();
                    sc.nextLine(); // limpiar buffer
                    System.out.print("Categoria: ");
                    String categoria = sc.nextLine();

                    Articulo nuevo = new Articulo(nombre, descripcion, precio, stock, proveedor, categoria);
                    if (dao.insertarArticulo(nuevo)) {
                        System.out.println("✅ Articulo insertado correctamente.");
                    }
                }
                case 2 -> {
                    List<Articulo> articulos = dao.consultarArticulos();
                    System.out.println("\n📦 Lista de articulos:");
                    for (Articulo art : articulos) {
                        System.out.println("ID: " + art.getId() + " | Nombre: " + art.getNombre() + " | Stock: " + art.getStockActual());
                    }
                }
                case 3 -> {
                    System.out.print("ID del articulo a actualizar: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // limpiar buffer
                    System.out.print("Nuevo nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Nueva descripcion: ");
                    String descripcion = sc.nextLine();
                    System.out.print("Nuevo precio unitario: ");
                    double precio = sc.nextDouble();
                    System.out.print("Nuevo stock: ");
                    int stock = sc.nextInt();
                    System.out.print("Nuevo ID proveedor: ");
                    int proveedor = sc.nextInt();
                    sc.nextLine(); // limpiar buffer
                    System.out.print("Nueva categoria: ");
                    String categoria = sc.nextLine();

                    Articulo actualizado = new Articulo(id, nombre, descripcion, precio, stock, proveedor, categoria);
                    if (dao.actualizarArticulo(actualizado)) {
                        System.out.println("✅ Articulo actualizado correctamente.");
                    }
                }
                case 4 -> {
                    System.out.print("ID del artículo a eliminar: ");
                    int idEliminar = sc.nextInt();
                    if (dao.eliminarArticulo(idEliminar)) {
                        System.out.println("🗑️ Articulo eliminado correctamente.");
                    }
                }
                case 5 -> System.out.println("👋 Saliendo del sistema...");
                default -> System.out.println("⚠️ Opcion no válida.");
            }

        } while (opcion != 5);
    }
}
