package dao;

import modelo.Articulo;
import conexion.ConexionBD;

import java.sql.*;
import java.util.ArrayList;

public class ArticuloDAO {

    public boolean insertarArticulo(Articulo art) {
        String sql = "INSERT INTO articulo (nombre, descripcion, precio_unitario, stock_actual, id_proveedor, categoria) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, art.getNombre());
            stmt.setString(2, art.getDescripcion());
            stmt.setDouble(3, art.getPrecioUnitario());
            stmt.setInt(4, art.getStockActual());
            stmt.setInt(5, art.getIdProveedor());
            stmt.setString(6, art.getCategoria());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("❌ Error al insertar artículo: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Articulo> consultarArticulos() {
        ArrayList<Articulo> lista = new ArrayList<>();
        String sql = "SELECT * FROM articulo";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Articulo art = new Articulo();
                art.setId(rs.getInt("id_articulo"));
                art.setNombre(rs.getString("nombre"));
                art.setDescripcion(rs.getString("descripcion"));
                art.setPrecioUnitario(rs.getDouble("precio_unitario"));
                art.setStockActual(rs.getInt("stock_actual"));
                art.setIdProveedor(rs.getInt("id_proveedor"));
                art.setCategoria(rs.getString("categoria"));
                lista.add(art);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al consultar artículos: " + e.getMessage());
        }

        return lista;
    }

    public boolean actualizarArticulo(Articulo art) {
        String sql = "UPDATE articulo SET nombre = ?, descripcion = ?, precio_unitario = ?, stock_actual = ?, id_proveedor = ?, categoria = ? " +
                     "WHERE id_articulo = ?";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, art.getNombre());
            stmt.setString(2, art.getDescripcion());
            stmt.setDouble(3, art.getPrecioUnitario());
            stmt.setInt(4, art.getStockActual());
            stmt.setInt(5, art.getIdProveedor());
            stmt.setString(6, art.getCategoria());
            stmt.setInt(7, art.getId());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("❌ Error al actualizar artículo: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarArticulo(int id) {
        String sql = "DELETE FROM articulo WHERE id_articulo = ?";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar artículo (ID: " + id + "): " + e.getMessage());
            return false;
        }
    }
}
