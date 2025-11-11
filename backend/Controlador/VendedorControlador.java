package backend.Controlador;

import backend.Modelo.Vendedor;
import java.util.ArrayList;
import java.util.List;

public class VendedorControlador {
    private List<Vendedor> vendedores = new ArrayList<>();

    public void agregarVendedor(Vendedor v) {
        vendedores.add(v);
    }

    public List<Vendedor> listarVendedores() {
        return vendedores;
    }
}
