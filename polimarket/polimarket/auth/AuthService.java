package auth;

import java.util.*;

public class AuthService {
    private Map<String, Usuario> usuarios = new HashMap<>(); // correo → Usuario
    private Map<String, Rol> roles = new HashMap<>(); // nombre → Rol
    private Map<String, Privilegio> privilegios = new HashMap<>(); // metodo → Privilegio

    public void registrarPrivilegio(Privilegio p) {
        privilegios.put(p.getMetodo(), p);
    }

    public void registrarRol(Rol r) {
        roles.put(r.getNombre(), r);
    }

    public void registrarUsuario(Usuario u) {
        usuarios.put(u.getCorreo(), u);
    }

    public Usuario autenticar(String correo, String clave) {
        Usuario u = usuarios.get(correo);
        if (u != null && u.getClave().equals(clave) && u.isActivo()) {
            return u;
        }
        return null;
    }

    public boolean tienePrivilegio(Usuario usuario, String metodoBuscado) {
        for (Rol rol : usuario.getRoles()) {
            for (Privilegio priv : rol.getPrivilegios()) {
                if (priv.getMetodo().equalsIgnoreCase(metodoBuscado) && priv.isActivo()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void imprimirRoles() {
        for (Rol r : roles.values()) {
            System.out.println(r);
            for (Privilegio p : r.getPrivilegios()) {
                System.out.println("   - " + p);
            }
        }
    }

    public void imprimirUsuarios() {
        for (Usuario u : usuarios.values()) {
            System.out.println(u);
        }
    }
}
