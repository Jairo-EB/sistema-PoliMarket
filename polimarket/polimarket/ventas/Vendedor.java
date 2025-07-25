package ventas;

public class Vendedor {
    private String id;
    private String nombre;
    private boolean autorizado;

    public Vendedor(String id, String nombre, boolean autorizado) {
        this.id = id;
        this.nombre = nombre;
        this.autorizado = autorizado;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public boolean estaAutorizado() { return autorizado; }
    public void autorizar() { this.autorizado = true; }

    @Override
    public String toString() {
        return nombre + " (ID: " + id + ", Autorizado: " + autorizado + ")";
    }
}
