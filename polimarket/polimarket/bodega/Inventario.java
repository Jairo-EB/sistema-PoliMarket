package bodega;

import java.util.*;

public class Inventario {
    private Map<String, Producto> productos = new HashMap<>();

    public void agregarProducto(Producto producto) {
        productos.put(producto.getId(), producto);
    }

    public Producto buscarProducto(String id) {
        return productos.get(id);
    }

    public boolean hayStock(String id, int cantidad) {
        Producto producto = productos.get(id);
        return producto != null && producto.getCantidad() >= cantidad;
    }

    public void reducirStock(String id, int cantidad) {
        Producto producto = productos.get(id);
        if (producto != null && producto.getCantidad() >= cantidad) {
            producto.setCantidad(producto.getCantidad() - cantidad);
        }
    }

    public Collection<Producto> getProductos() {
        return productos.values();
    }
}
