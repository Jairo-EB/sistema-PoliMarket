package rrhh;

public class AutorizacionVendedor {
    private String idEmpleado;
    private boolean autorizado;

    public AutorizacionVendedor(String idEmpleado, boolean autorizado) {
        this.idEmpleado = idEmpleado;
        this.autorizado = autorizado;
    }

    public String getIdEmpleado() { return idEmpleado; }
    public boolean isAutorizado() { return autorizado; }

    public void setAutorizado(boolean autorizado) {
        this.autorizado = autorizado;
    }

    @Override
    public String toString() {
        return "Empleado ID: " + idEmpleado + " - Autorizado: " + autorizado;
    }
}
