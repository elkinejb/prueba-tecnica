package backend.Controlador;

import backend.Modelo.*;
import java.util.ArrayList;
import java.util.List;

public class VentaControlador {
    private List<Venta> ventas = new ArrayList<>();

    public void registrarVenta(Venta v) {
        ventas.add(v);
    }

    public List<Venta> listarVentas() {
        return ventas;
    }
}
