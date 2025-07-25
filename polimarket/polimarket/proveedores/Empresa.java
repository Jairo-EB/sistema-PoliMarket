package proveedores;

public class Empresa {
    private String id;
    private String nombre;

    public Empresa(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }

    @Override
    public String toString() {
        return nombre + " (ID: " + id + ")";
    }
}
