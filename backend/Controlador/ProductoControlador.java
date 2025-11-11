package backend.Controlador;

import backend.Modelo.Producto;
import java.util.ArrayList;
import java.util.List;

public class ProductoControlador {
    private List<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public List<Producto> listarProductos() {
        return productos;
    }
}
