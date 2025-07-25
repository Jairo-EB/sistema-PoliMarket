package auth;

public class Privilegio {
    private int id;
    private String nombre;
    private String metodo;
    private boolean estado;

    public Privilegio(int id, String nombre, String metodo, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.metodo = metodo;
        this.estado = estado;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getMetodo() { return metodo; }
    public boolean isActivo() { return estado; }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Privilegio: " + nombre + " [" + metodo + "] - Activo: " + estado;
    }
}
