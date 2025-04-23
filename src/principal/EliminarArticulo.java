package principal;

import dao.ArticuloDAO;

public class EliminarArticulo {
    public static void main(String[] args) {
        ArticuloDAO dao = new ArticuloDAO();

        int idAEliminar = 3; // Cambia por un ID válido en tu tabla

        if (dao.eliminarArticulo(idAEliminar)) {
            System.out.println("🗑️ Artículo eliminado correctamente (ID: " + idAEliminar + ").");
        } else {
            System.out.println("❌ Error al eliminar el artículo (ID: " + idAEliminar + ").");
        }
    }
}
