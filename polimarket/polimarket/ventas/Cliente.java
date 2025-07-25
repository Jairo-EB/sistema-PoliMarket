package ventas;

public class Cliente {
    private String id;
    private String nombre;
    private String direccion;

    public Cliente(String id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDireccion() { return direccion; }

    @Override
    public String toString() {
        return nombre + " (ID: " + id + ", Dirección: " + direccion + ")";
    }
}
