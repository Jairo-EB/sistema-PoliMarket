package auth;

import java.util.ArrayList;
import java.util.List;

public class Rol {
    private int id;
    private String nombre;
    private List<Privilegio> privilegios;

    public Rol(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.privilegios = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public List<Privilegio> getPrivilegios() { return privilegios; }

    public void agregarPrivilegio(Privilegio p) {
        privilegios.add(p);
    }

    @Override
    public String toString() {
        return "Rol: " + nombre + " - Privilegios: " + privilegios.size();
    }
}
