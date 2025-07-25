package rrhh;

import ventas.Vendedor;

import java.util.*;

public class RRHHService {
    private Map<String, Empleado> empleados = new HashMap<>();
    private Map<String, AutorizacionVendedor> autorizaciones = new HashMap<>();

    public void registrarEmpleado(Empleado empleado) {
        empleados.put(empleado.getId(), empleado);
    }

    public void autorizarVendedor(String idEmpleado, Vendedor vendedor) {
        AutorizacionVendedor autorizacion = new AutorizacionVendedor(idEmpleado, true);
        autorizaciones.put(idEmpleado, autorizacion);
        vendedor.autorizar();
    }

    public boolean estaAutorizado(String idEmpleado) {
        AutorizacionVendedor autorizacion = autorizaciones.get(idEmpleado);
        return autorizacion != null && autorizacion.isAutorizado();
    }

    public Collection<AutorizacionVendedor> listarAutorizaciones() {
        return autorizaciones.values();
    }
}
