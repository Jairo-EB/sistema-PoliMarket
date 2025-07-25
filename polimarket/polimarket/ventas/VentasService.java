package ventas;

import bodega.BodegaService;
import bodega.Producto;

import java.util.*;

public class VentasService {
    private Map<String, OrdenVenta> ordenes = new HashMap<>();
    private Map<String, Cliente> clientes = new HashMap<>();
    private Map<String, Vendedor> vendedores = new HashMap<>();
    private BodegaService bodegaService;

    public VentasService(BodegaService bodegaService) {
        this.bodegaService = bodegaService;
    }

    public void registrarCliente(Cliente cliente) {
        clientes.put(cliente.getId(), cliente);
    }

    public void registrarVendedor(Vendedor vendedor) {
        vendedores.put(vendedor.getId(), vendedor);
    }

    public boolean crearOrden(String idOrden, String idCliente, String idVendedor, String idProducto, int cantidad) {
        Vendedor vendedor = vendedores.get(idVendedor);
        if (vendedor == null || !vendedor.estaAutorizado()) {
            System.out.println("Vendedor no autorizado.");
            return false;
        }

        Cliente cliente = clientes.get(idCliente);
        Producto producto = bodegaService.listarProductos()
                                         .stream()
                                         .filter(p -> p.getId().equals(idProducto))
                                         .findFirst()
                                         .orElse(null);

        if (cliente == null || producto == null) {
            System.out.println("Cliente o producto no encontrado.");
            return false;
        }

        if (!bodegaService.verificarDisponibilidad(idProducto, cantidad)) {
            System.out.println("No hay stock suficiente.");
            return false;
        }

        bodegaService.reducirStock(idProducto, cantidad);
        OrdenVenta orden = new OrdenVenta(idOrden, cliente, producto, cantidad);
        ordenes.put(idOrden, orden);
        System.out.println("Orden creada exitosamente.");
        return true;
    }

    public Collection<OrdenVenta> listarOrdenes() {
        return ordenes.values();
    }

    public Map<String, Cliente> getClientes() {
        return clientes;
    }

    public Map<String, Vendedor> getVendedores() {
        return vendedores;
    }
}
