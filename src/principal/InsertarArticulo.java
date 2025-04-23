package principal;

import dao.ArticuloDAO;
import modelo.Articulo;

public class InsertarArticulo {
    public static void main(String[] args) {
        ArticuloDAO dao = new ArticuloDAO();

        // Crear un nuevo artículo
        Articulo nuevoArticulo = new Articulo(
            "Teclado Mecánico", 
            "Teclado RGB con switches rojos", 
            120000, 
            20, 
            1, 
            "Tecnología"
        );

        // Intentar insertar el artículo
        if (dao.insertarArticulo(nuevoArticulo)) {
            System.out.println("✅ Artículo insertado correctamente.");
        } else {
            System.out.println("❌ Error al insertar el artículo.");
        }
    }
}

