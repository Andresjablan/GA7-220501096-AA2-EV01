package modelo;

public class Articulo {

    private int id;
    private String nombre;
    private String descripcion;
    private double precioUnitario;
    private int stockActual;
    private int idProveedor;
    private String categoria;

    public Articulo() {
    }

    public Articulo(String nombre, String descripcion, double precioUnitario, int stockActual, int idProveedor, String categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.stockActual = stockActual;
        this.idProveedor = idProveedor;
        this.categoria = categoria;
    }

    public Articulo(int id, String nombre, String descripcion, double precioUnitario, int stockActual, int idProveedor, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.stockActual = stockActual;
        this.idProveedor = idProveedor;
        this.categoria = categoria;
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
