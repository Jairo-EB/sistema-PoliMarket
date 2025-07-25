package auth;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private int id;
    private String nombre;
    private String correo;
    private String clave;
    private boolean estado;
    private List<Rol> roles;

    public Usuario(int id, String nombre, String correo, String clave, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.clave = clave;
        this.estado = estado;
        this.roles = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public String getClave() { return clave; }
    public boolean isActivo() { return estado; }

    public List<Rol> getRoles() { return roles; }

    public void agregarRol(Rol rol) {
        roles.add(rol);
    }

    @Override
    public String toString() {
        return "Usuario: " + nombre + " (" + correo + ")";
    }
}
