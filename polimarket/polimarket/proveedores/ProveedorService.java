package proveedores;

import bodega.Producto;
import java.util.*;

public class ProveedorService {
    private List<Proveedor> proveedores = new ArrayList<>();

    public void registrarProveedor(Empresa empresa, Producto producto, int cantidad) {
        proveedores.add(new Proveedor(empresa, producto, cantidad));
    }

    public List<Proveedor> listarProveedores() {
        return proveedores;
    }

    public List<Proveedor> buscarProveedoresPorProducto(String idProducto) {
        List<Proveedor> resultado = new ArrayList<>();
        for (Proveedor p : proveedores) {
            if (p.getProducto().getId().equals(idProducto)) {
                resultado.add(p);
            }
        }
        return resultado;
    }
}
