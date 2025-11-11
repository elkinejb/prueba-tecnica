package backend.Modelo;

public class Vendedor {
    private int id;
    private String nombre;
    private String identificacion;
    private String telefono;

    public Vendedor(int id, String nombre, String identificacion, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.telefono = telefono;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getIdentificacion() { return identificacion; }
    public void setIdentificacion(String identificacion) { this.identificacion = identificacion; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    @Override
    public String toString() {
        return "Vendedor [id=" + id + ", nombre=" + nombre + ", identificacion=" + identificacion + ", telefono=" + telefono + "]";
    }
}
