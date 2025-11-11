package backend.Modelo;

import java.time.LocalDate;

public class Venta {
    private int id;
    private Producto producto;
    private Vendedor vendedor;
    private int cantidad;
    private double total;
    private LocalDate fecha;

    public Venta(int id, Producto producto, Vendedor vendedor, int cantidad, double total, LocalDate fecha) {
        this.id = id;
        this.producto = producto;
        this.vendedor = vendedor;
        this.cantidad = cantidad;
        this.total = total;
        this.fecha = fecha;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }

    public Vendedor getVendedor() { return vendedor; }
    public void setVendedor(Vendedor vendedor) { this.vendedor = vendedor; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    @Override
    public String toString() {
        return "Venta [id=" + id + ", producto=" + producto.getNombre() + ", vendedor=" + vendedor.getNombre() +
                ", cantidad=" + cantidad + ", total=" + total + ", fecha=" + fecha + "]";
    }
}
