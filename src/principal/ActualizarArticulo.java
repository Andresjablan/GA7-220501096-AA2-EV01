package principal;

import dao.ArticuloDAO;
import modelo.Articulo;

public class ActualizarArticulo {
    public static void main(String[] args) {
        ArticuloDAO dao = new ArticuloDAO();

        // Asegúrate de que el ID exista en la base de datos
        Articulo articuloActualizado = new Articulo(
            1, // ID del artículo a actualizar
            "Teclado Gamer Pro", 
            "Teclado mecánico con reposamuñecas y luces RGB", 
            135000, 
            25, 
            1, 
            "Tecnología"
        );

        if (dao.actualizarArticulo(articuloActualizado)) {
            System.out.println("✅ Artículo actualizado correctamente.");
        } else {
            System.out.println("❌ Error al actualizar el artículo.");
        }
    }
}
