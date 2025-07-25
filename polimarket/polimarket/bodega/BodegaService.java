package bodega;

import java.util.*;

public class BodegaService {
    private Inventario inventario = new Inventario();

    public void registrarProducto(Producto producto) {
        inventario.agregarProducto(producto);
    }

    public boolean verificarDisponibilidad(String idProducto, int cantidad) {
        return inventario.hayStock(idProducto, cantidad);
    }

    public void reducirStock(String idProducto, int cantidad) {
        inventario.reducirStock(idProducto, cantidad);
    }

    public List<SolicitudProveedor> generarSolicitudReabastecimiento() {
        List<SolicitudProveedor> solicitudes = new ArrayList<>();
        for (Producto p : inventario.getProductos()) {
            if (p.getCantidad() < 5) {
                solicitudes.add(new SolicitudProveedor(p.getId(), 20, "ProveedorGeneral"));
            }
        }
        return solicitudes;
    }

    public Collection<Producto> listarProductos() {
        return inventario.getProductos();
    }

    
}
