package principal;

import dao.ArticuloDAO;
import modelo.Articulo;
import java.util.List;

public class ConsultarArticulos {
    public static void main(String[] args) {
        ArticuloDAO dao = new ArticuloDAO();

        List<Articulo> articulos = dao.consultarArticulos();

        System.out.println("📦 Lista de artículos:");
        for (Articulo art : articulos) {
            System.out.println("ID: " + art.getId() + " | Nombre: " + art.getNombre() +
                               " | Stock: " + art.getStockActual() +
                               " | Precio: $" + art.getPrecioUnitario());
        }
    }
}

